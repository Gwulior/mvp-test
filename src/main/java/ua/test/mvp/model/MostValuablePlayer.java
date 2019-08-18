package ua.test.mvp.model;

import java.util.Objects;

/**
 * Created by Dreval Viacheslav on 18.08.2019.
 */

public class MostValuablePlayer {

    private final String nickName;
    private final Long calculatedScore;

    public MostValuablePlayer(String nickName, Long calculatedScore) {
        this.nickName = nickName;
        this.calculatedScore = calculatedScore;
    }

    public String getNickName() {
        return nickName;
    }

    public Long getCalculatedScore() {
        return calculatedScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MostValuablePlayer that = (MostValuablePlayer) o;
        return Objects.equals(nickName, that.nickName) &&
                Objects.equals(calculatedScore, that.calculatedScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName, calculatedScore);
    }
}
