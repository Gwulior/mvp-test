package ua.test.mvp.processor;

import ua.test.mvp.model.GameResultRow;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dreval Viacheslav on 18.08.2019.
 */

public abstract class AbstractGameProcessor {

    public List<GameResultRow> processGame(List<GameResultRow> resultRows) {

        HashMap<String, Long> teamScore = new HashMap<>();

        for (GameResultRow row : resultRows) {

            long calculatedScore = calculateScore(row);
            row.setCalculatedScore(calculatedScore);

            if (teamScore.containsKey(row.getTeamName())) {
                Long oldScore = teamScore.get(row.getTeamName());
                teamScore.put(row.getTeamName(), oldScore + calculatedScore);
            } else {
                teamScore.put(row.getTeamName(), calculatedScore);
            }
        }

        //apply winner bonus
        String teamName = teamScore.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElseThrow()
                .getKey();

        resultRows.forEach(player -> {
            if (teamName.equals(player.getTeamName())) {
                player.setCalculatedScore(player.getCalculatedScore() + 10);
            }
        });

        return resultRows;

    }

    abstract long calculateScore(GameResultRow row);

}
