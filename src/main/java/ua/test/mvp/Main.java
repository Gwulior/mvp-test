package ua.test.mvp;

import ua.test.mvp.model.Game;
import ua.test.mvp.model.MostValuablePlayer;
import ua.test.mvp.service.DataService;
import ua.test.mvp.service.ProcessorService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Dreval Viacheslav on 18.08.2019.
 */

public class Main {

    private static final String RESOURCE_CSV_FOLDER = "/example/csv";

    public static void main(String[] args) throws URISyntaxException, IOException {

        Path path;

        if (args.length > 0) {
            path = Paths.get(args[0]);
        } else {
            path = Paths.get(Main.class.getResource(RESOURCE_CSV_FOLDER).toURI());
        }

        List<Game> games = new DataService().readCSVData(path);
        MostValuablePlayer result = new ProcessorService().calculateMVP(games);

        System.out.println(String.format("The most valuable player is \"%s\" with score - \"%s\"", result.getNickName(), result.getCalculatedScore()));

    }

}
