package ua.test.mvp.model;

/**
 * Created by Dreval Viacheslav on 18.08.2019.
 */

public class HandballResultRow extends GameResultRow {

    private final long goalsMade;
    private final long goalsReceived;


    public HandballResultRow(String playerName, String nickName, String number, String teamName, long goalsMade, long goalsReceived) {
        super(playerName, nickName, number, teamName);
        this.goalsMade = goalsMade;
        this.goalsReceived = goalsReceived;
    }

    public long getGoalsMade() {
        return goalsMade;
    }

    public long getGoalsReceived() {
        return goalsReceived;
    }

}
