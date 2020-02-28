package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    public Button instruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial);

        instruction = (Button) findViewById(R.id.instruction);
        instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instruction();
            }
        });
    }

    public void instruction() {
        instructions instruct = new instructions();
        instruct.show(getSupportFragmentManager(), "instructions");
    }

    public void play(View view) {
        Intent game = new Intent(this, Game.class);

        startActivity(game);
    }

    public void quit(View view) {
        Intent quit = new Intent(this, DisplayMessageActivity.class);

        startActivity(quit);
    }
}
