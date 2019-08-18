package ua.test.mvp.model;

import java.util.List;

/**
 * Created by Dreval Viacheslav on 18.08.2019.
 */

public class Game {

    private final GameType gameType;
    private final List<GameResultRow> resultRecords;

    public Game(GameType gameType, List<GameResultRow> resultRecords) {
        this.gameType = gameType;
        this.resultRecords = resultRecords;
    }

    public GameType getGameType() {
        return gameType;
    }

    public List<GameResultRow> getResultRecords() {
        return resultRecords;
    }
}
