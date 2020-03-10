package com.example.tictactoe;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class Quit extends AppCompatActivity {
    private static final String EXTRA_USER_POS = "pos_in_list";
    private static final String TAG = "quit";

    private Scores scores;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quit);
        scores = new Scores(this);
        Intent intent = getIntent();

        //Displays the scores stored//
        GlobalModel.getInstance().getPlayer().add(new Players("Player 1", scores.getScore(1)));
        GlobalModel.getInstance().getPlayer().add(new Players("Player 2", scores.getScore(2)));

        //Creates a simple list for displaying player 1 and player 2//
        ListView list = findViewById(R.id.playerList);
        list.setAdapter(new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        GlobalModel.getInstance().getPlayer())
                );
        //reacts to list//
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
