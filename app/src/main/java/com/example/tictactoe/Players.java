package com.example.tictactoe;

public class Players {
    private String round;
    private int score;

    public Players(String name, int score) {
        this.round = name;
        this.score = score;
    }

    public String getRound() {
        return round;
    }

    public String getScore() {
        return Integer.toString(score);
    }
    @Override
    public String toString(){
        return round;
    }
}
