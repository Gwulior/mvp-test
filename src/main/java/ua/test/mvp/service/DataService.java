package ua.test.mvp.service;

import ua.test.mvp.model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Dreval Viacheslav on 18.08.2019.
 */

public class DataService {

    private final String FILE_CSV_DELIMITER = ";";

    public List<Game> readCSVData(Path path) throws IOException {

        List<Game> parsedGames = new ArrayList<>();

        if (Files.isRegularFile(path)) {
            parseGames(parsedGames, path);
        } else {
            Files.walk(path, 1)
                    .filter(Files::isRegularFile)
                    .forEach(p -> parseGames(parsedGames, p));
        }

        return parsedGames;

    }

    private void parseGames(List<Game> parsedGames, Path p) {
        try {

            List<String[]> csvLines = Files.readAllLines(p, StandardCharsets.UTF_8).stream()
                    .map(line -> line.split(FILE_CSV_DELIMITER))
                    .collect(Collectors.toList());

            GameType gameType = GameType.valueOf(csvLines.get(0)[0].trim().toUpperCase());
            List<GameResultRow> gameRows = new ArrayList<>();

            for (String[] record : csvLines.subList(1, csvLines.size())) {

                String playerName = record[0];
                String nickName = record[1];
                String number = record[2];
                String teamName = record[3];

                GameResultRow row;

                if (GameType.BASKETBALL == gameType) {

                    long scoredPoints = Long.parseLong(record[4]);
                    long rebounds = Long.parseLong(record[5]);
                    long assists = Long.parseLong(record[6]);

                    row = new BasketballResultRow(playerName, nickName, number, teamName, scoredPoints, rebounds, assists);

                } else if (GameType.HANDBALL == gameType) {

                    long goalsMade = Long.parseLong(record[4]);
                    long goalsReceived = Long.parseLong(record[5]);

                    row = new HandballResultRow(playerName, nickName, number, teamName, goalsMade, goalsReceived);

                } else {

                    throw new IllegalStateException(String.format("There is no reader for this \"%s\" type of game ", gameType.toString()));

                }

                gameRows.add(row);
            }

            Game game = new Game(gameType, gameRows);
            parsedGames.add(game);

        } catch (IOException e) {

            throw new IllegalStateException(e);

        }
    }

}
