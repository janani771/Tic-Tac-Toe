package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String message2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);


        TextView playerOneName = findViewById(R.id.P1);
        playerOneName.setText(message + ":   ");

        TextView playerTwoName = findViewById(R.id.P2);
        playerTwoName.setText(message2 + ":   ");

    }
    public void quit(View view){
        Intent quit = new Intent(this, quit.class);

        startActivity(quit);
    }

}
