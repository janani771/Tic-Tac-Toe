package com.example.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Singleton class for scores of players//
public class GlobalModel {
    private final List<Players> GlobalModel;
    private static final GlobalModel ourInstance = new GlobalModel();

    public static GlobalModel getInstance() {
        return ourInstance;
    }

    private GlobalModel() {
        GlobalModel = new ArrayList<>(Collections.singletonList(
                new Players("Scores of Player One " +
                        "and Two every round", 0)));
    }
    public List<Players> getPlayer(){
        return GlobalModel;
    }
}
