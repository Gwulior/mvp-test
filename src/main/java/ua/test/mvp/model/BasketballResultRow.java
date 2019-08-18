package ua.test.mvp.model;

/**
 * Created by Dreval Viacheslav on 18.08.2019.
 */

public class BasketballResultRow extends GameResultRow {

    private final long scoredPoints;
    private final long rebounds;
    private final long assists;

    public BasketballResultRow(String playerName, String nickName, String number, String teamName, long scoredPoints, long rebounds, long assists) {
        super(playerName, nickName, number, teamName);
        this.scoredPoints = scoredPoints;
        this.rebounds = rebounds;
        this.assists = assists;
    }

    public long getScoredPoints() {
        return scoredPoints;
    }

    public long getRebounds() {
        return rebounds;
    }

    public long getAssists() {
        return assists;
    }

}
