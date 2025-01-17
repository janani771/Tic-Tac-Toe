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
    public static final String EXTRA_USER_POS = "pos_in_list";
    public Button instruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        instruction = findViewById(R.id.instruction);
        instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instruction();
            }
        });
    }
    //When instruction box is clicked, alert box with instructions appear//
    public void instruction() {
        Instructions instruct = new Instructions();
        instruct.show(getSupportFragmentManager(), "instructions");
    }
    //When play button is pressed, game class is display//
    public void play(View view) {
        Intent game = new Intent(this, Game.class);

        EditText nameOne = findViewById(R.id.player1name);
        String message = nameOne.getText().toString();
        game.putExtra(EXTRA_MESSAGE, message);

        EditText nameTwo = findViewById(R.id.player2name);
        String message2 = nameTwo.getText().toString();
        game.putExtra(EXTRA_MESSAGE2, message2);

        startActivity(game);
    }
    public void quit(View view) {
        Intent intent = new Intent(this, Quit.class);
        startActivity(intent);
    }

}
