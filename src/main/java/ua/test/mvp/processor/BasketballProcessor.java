package ua.test.mvp.processor;

import ua.test.mvp.model.BasketballResultRow;
import ua.test.mvp.model.GameResultRow;

/**
 * Created by Dreval Viacheslav on 18.08.2019.
 */

public class BasketballProcessor extends AbstractGameProcessor {

    private static final int POINT_FOR_SCORE = 2;
    private static final int POINT_FOR_REBOUND = 1;
    private static final int POINT_FOR_ASSIST = 1;

    @Override
    long calculateScore(GameResultRow row) {

        BasketballResultRow basketballResultRow = (BasketballResultRow) row;

        return
                POINT_FOR_SCORE * basketballResultRow.getScoredPoints() +
                        POINT_FOR_REBOUND * basketballResultRow.getRebounds() +
                        POINT_FOR_ASSIST * basketballResultRow.getAssists();

    }


}
