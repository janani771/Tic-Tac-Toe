package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.tictactoe2.MESSAGE";
    public  static final String EXTRA_MESSAGE2 = "com.example.tictactoe2.MESSAGE2";
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

        EditText nameOne = (EditText) findViewById(R.id.player1name);
        EditText nameTwo = (EditText) findViewById(R.id.player2name);

        String message = nameOne.getText().toString();
        String message2 = nameTwo.getText().toString();

        game.putExtra(EXTRA_MESSAGE, message);
        game.putExtra(EXTRA_MESSAGE2, message2);


        startActivity(game);
    }
    public void quit(View view) {
        Intent quit = new Intent(this, quit.class);

        startActivity(quit);
    }

}
