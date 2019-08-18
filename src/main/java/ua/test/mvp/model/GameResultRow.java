package ua.test.mvp.model;

import java.util.Objects;

/**
 * Created by Dreval Viacheslav on 18.08.2019.
 */

public abstract class GameResultRow {

    private final String playerName;
    private final String nickName;
    private final String number;
    private final String teamName;
    private long calculatedScore;

    GameResultRow(String playerName, String nickName, String number, String teamName) {
        this.playerName = playerName;
        this.nickName = nickName;
        this.number = number;
        this.teamName = teamName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getNumber() {
        return number;
    }

    public String getTeamName() {
        return teamName;
    }

    public long getCalculatedScore() {
        return calculatedScore;
    }

    public void setCalculatedScore(long calculatedScore) {
        this.calculatedScore = calculatedScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResultRow that = (GameResultRow) o;
        return Objects.equals(playerName, that.playerName) &&
                Objects.equals(nickName, that.nickName) &&
                Objects.equals(number, that.number) &&
                Objects.equals(teamName, that.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, nickName, number, teamName);
    }
}
