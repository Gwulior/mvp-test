package ua.test.mvp.processor;

import ua.test.mvp.model.GameResultRow;
import ua.test.mvp.model.HandballResultRow;

/**
 * Created by Dreval Viacheslav on 18.08.2019.
 */

public class HandballProcessor extends AbstractGameProcessor {

    private static final int POINT_FOR_GOAL_MADE = 2;
    private static final int POINT_FOR_GOAL_RECEIVED = -1;

    @Override
    long calculateScore(GameResultRow row) {

        HandballResultRow handballResultRow = (HandballResultRow) row;

        return
                POINT_FOR_GOAL_MADE * handballResultRow.getGoalsMade() +
                        POINT_FOR_GOAL_RECEIVED * handballResultRow.getGoalsReceived();

    }

}
