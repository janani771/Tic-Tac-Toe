package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Quit extends AppCompatActivity {
    public static final String EXTRA_USER_POS = "pos_in_list";
    public static final String TAG = "quit";

    Scores scores;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quit);
        scores = new Scores(this);
        Intent intent = getIntent();

        GlobalModel.getInstance().getPlayer().add(new Players("Player 1", scores.player1Score));
        GlobalModel.getInstance().getPlayer().add(new Players("Player 2", scores.player2Score));

        ListView list = (ListView) findViewById(R.id.playerList);
        list.setAdapter(new ArrayAdapter<Players>(
                this,
                android.R.layout.simple_list_item_1,
                GlobalModel.getInstance().getPlayer())
                );
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l){
                Log.d(TAG,"clicked:" +i);
                Intent playerActivity = new Intent(Quit.this,Display_Scores.class);
                playerActivity.putExtra(EXTRA_USER_POS,i);
                startActivity(playerActivity);
            }
        });
    }
}
