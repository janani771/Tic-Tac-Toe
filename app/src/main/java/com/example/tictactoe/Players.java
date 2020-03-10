package com.example.tictactoe;


import androidx.annotation.NonNull;

class Players {
    private final String round;
    private final int score;

    //constructor for players//
    public Players(String name, int score) {
        this.round = name;
        this.score = score;
    }
    public String getScore() {
        return Integer.toString(score);
    }
    @NonNull
    @Override
    public String toString(){
        return round;
    }
}
