package com.example.tictactoe;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Display_Scores extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_scores);

        Players players = GlobalModel.getInstance().getPlayer().get(
                getIntent().getExtras().
                        getInt(MainActivity.EXTRA_USER_POS,0));

        ((TextView) findViewById(R.id.score)).setText(players.getScore());

    }
}
