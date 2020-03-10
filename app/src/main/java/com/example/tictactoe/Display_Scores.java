package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Display_Scores extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_scores);

        final Scores scores = new Scores(this);

        Players players = GlobalModel.getInstance().getPlayer().get(
                getIntent().getExtras().
                        getInt(MainActivity.EXTRA_USER_POS,0));

        ((TextView) findViewById(R.id.score)).setText(players.getScore());

        Button exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.exit(0);
            }
        });

    }

}
