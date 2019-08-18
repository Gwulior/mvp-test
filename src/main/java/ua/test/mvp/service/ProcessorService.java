package ua.test.mvp.service;

import ua.test.mvp.model.Game;
import ua.test.mvp.model.GameResultRow;
import ua.test.mvp.model.MostValuablePlayer;
import ua.test.mvp.processor.BasketballProcessor;
import ua.test.mvp.processor.HandballProcessor;

import java.util.*;

/**
 * Created by Dreval Viacheslav on 18.08.2019.
 */

public class ProcessorService {

    public MostValuablePlayer calculateMVP(List<Game> games) {

        HashMap<String, Long> summaryPlayerScore = new HashMap<>();
        List<GameResultRow> processedGamesRows = new ArrayList<>();

        for (Game game : games) {

            switch (game.getGameType()) {

                case BASKETBALL: {
                    BasketballProcessor processor = new BasketballProcessor();
                    processedGamesRows.addAll(processor.processGame(game.getResultRecords()));
                    break;
                }

                case HANDBALL: {
                    HandballProcessor processor = new HandballProcessor();
                    processedGamesRows.addAll(processor.processGame(game.getResultRecords()));
                    break;
                }

            }

        }

        //Calculating player's summary score
        processedGamesRows
                .forEach(grr -> {
                    if (summaryPlayerScore.containsKey(grr.getNickName())) {
                        Long oldValue = summaryPlayerScore.get(grr.getNickName());
                        summaryPlayerScore.put(grr.getNickName(), oldValue + grr.getCalculatedScore());
                    } else {
                        summaryPlayerScore.put(grr.getNickName(), grr.getCalculatedScore());
                    }
                });

        //Searching for player with highest score
        Map.Entry<String, Long> mostValuablePlayerEntry = summaryPlayerScore.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElseThrow();

        return new MostValuablePlayer(mostValuablePlayerEntry.getKey(), mostValuablePlayerEntry.getValue());

    }

}
