package com.example.tictactoe;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class Game extends AppCompatActivity implements View.OnClickListener {

    private final Button[][] buttons = new Button[3][3];
    private boolean playerOneActive = true;
    private int numOfCount;
    private MediaPlayer myTune;

    //default text//
    private TextView p1;
    private TextView p2;

    //score that has text of zero//
    private TextView score1;
    private TextView score2;

    private Toast toast;

    //defines the score class//
    private Scores scores;

    //defines the color class//
    private Colors color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        myTune = MediaPlayer.create(this,R.raw.sample);

        scores = new Scores(this);
        color = new Colors();

        final Button reset = findViewById(R.id.resetGame);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("GAME","reset clicked?" );
                resetGridColor();
                scores.resetScore();
                updateScore();
                resetGameGrid();
            }
        });
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String message2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);

        //User input//
        p1 = findViewById(R.id.P1);
        p2 = findViewById(R.id.P2);

        //If the user doesn't input anything, then the names are set to default//
        if(TextUtils.isEmpty(message) || message.equals("Player 2")|| message.equals("player 2") || message.equals("player2")||message.equals("Player Two") ||message.equals("Player two") ||message.equals("player two") ||message.equals("PLAYER TWO")||message.equals("playertwo")||message.equals("PLAYER two")){
            p1.setText(R.string.Player_1);
        }else{
            p1.setText( message);
        }
        if(TextUtils.isEmpty(message2) || message2.equals("Player 1") || message2.equals("player 1") || message2.equals("player2")||message2.equals("Player One") ||message2.equals("Player one") ||message2.equals("player one") ||message2.equals("PLAYER ONE")||message2.equals("playerone")||message2.equals("PLAYER one") ){
            p2.setText(R.string.Player_2);
        }else{
            p2.setText( message2);
        }

        //Give each button a respective position//
        buttons[0][0] = findViewById(R.id.button_00);
        buttons[0][1] = findViewById(R.id.button_01);
        buttons[0][2] = findViewById(R.id.button_02);
        buttons[1][0] = findViewById(R.id.button_03);
        buttons[1][1] = findViewById(R.id.button_04);
        buttons[1][2] = findViewById(R.id.button_05);
        buttons[2][0] = findViewById(R.id.button_06);
        buttons[2][1] = findViewById(R.id.button_07);
        buttons[2][2] = findViewById(R.id.button_08);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                buttons[x][y].setOnClickListener(this);
            }
        }
    }
    //Plays the music when sound button is clicked//
    public void playIT(View view){
        myTune.start();
        myTune.setLooping(true);
        myTune.setVolume(5000f,5000f);
    }
    //Pauses the music when mute button is clicked//
    public void mute(View view){
        if(myTune!=null){
            myTune.pause();
        }
    }
    //Stops the music when the activity is on pause//
    @Override
    protected void onPause(){
        super.onPause();
        myTune.release();
    }
    //When activity is on stop, the game data is reset//
    @Override
    protected void onStop(){
        super.onStop();
        Log.d("GAME","Data cleared!");
        scores.resetScore();
        resetGameGrid();
        myTune.release();
        myTune=null;
    }
    //When quit button is pressed, displays the quit class activity//
    public void quit(View view){
        Intent quit = new Intent(this, Quit.class);
        startActivity(quit);
    }
    //checks if the grid button is empty or contains text//
    @Override
    public void onClick(View grid) {
        if (!((Button) grid).getText().toString().equals("")) {
            return;
        }
        if (playerOneActive) {
            p1.requestFocus();
            ((Button) grid).setText("X");
            ((Button) grid).setBackgroundColor(color.randomColorLight());
        } else {
            p2.requestFocus();
            ((Button) grid).setText("O");
            ((Button) grid).setBackgroundColor(color.randomColorLight());
        }
        numOfCount++;
        //When either player win, the game displays random win messages as toast accordingly//
        if (win()) {
             String[] randWinMess = new String[] {"Great work", "Keep it up","You got it",
                                            "Share you trick","Good job","Congratulations",
                                            "Great thinking","Awesome","Spectacular","Wonderful", "Nice move"};
            if (playerOneActive) {
                scores.playerWins(1);
                String name1 = p1.getText().toString().trim();
                 toast =Toast.makeText(getApplicationContext(),randWinMess
                        [new Random().nextInt(randWinMess.length-1)]+", " + name1 + "!",Toast.LENGTH_SHORT);
                 toastLook();
                updateScore();
                resetGameGrid();
            }else{
                scores.playerWins(2);
                String name2 = p2.getText().toString().trim();
                toast = Toast.makeText(getApplicationContext(),randWinMess
                        [new Random().nextInt(randWinMess.length-1)]+", " + name2+ "!",Toast.LENGTH_SHORT);
                toastLook();
                updateScore();
                resetGameGrid();
            }
            //when all buttons of grid if full and no winner, the game is tied//
            } else if(numOfCount==9){
                gameIsDraw();
                resetGameGrid();
            }else{
                playerOneActive = !playerOneActive;
            }
        }

        //Draw message is displayed and game grid is reset//
        private void gameIsDraw(){
            toast = Toast.makeText(this,"It's a draw!", Toast.LENGTH_SHORT);
            toastLook();
            resetGameGrid();
        }
        //custom appearance for toast messages//
        private void toastLook(){
            View view = toast.getView();
            view.setBackgroundColor(color.randomColorDark());
            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL|Gravity.LEFT,397,330);
            toast.show();
         }
         //the score is updated for every winner and every time game score is reset//
         private void updateScore(){
        score1= findViewById(R.id.score1);
        score1.setText(Integer.toString(scores.getPlayer1Score()));

        score2= findViewById(R.id.score2);
        score2.setText(Integer.toString(scores.getPlayer2Score()));
    }
    //all the buttons of the grid cleared or emptied//
    private void resetGameGrid(){
            for(int x = 0; x < 3; x++){
                for(int y = 0; y <3; y++){
                    buttons[x][y].setText("");
                }
            }
            numOfCount = 0;
            playerOneActive = true;
    }
    private void resetGridColor(){
        for(int x = 0; x < 3; x++){
            for(int y = 0; y <3; y++){
                buttons[x][y].setBackgroundResource(R.drawable.grid);
            }
        }
    }
    //checks whether there is a winner in vertical, horizontal or diagonal way with Xs and Os//
    private boolean win() {
        String[][] position = new String[3][3];
        //gets the text of the button whether X or O//
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                position[i][j] = buttons[i][j].getText().toString();
            }
        }
        //CHECKING FOR WIN VERTICALLY(UP-DOWN)//
        //first column//
         if (position[0][0].equals(position[1][0])
                && position[0][0].equals(position[2][0])
                && !position[0][0].equals("")) {
            return true;
        }
        //second column//
        if (position[0][1].equals(position[1][1])
                && position[0][1].equals(position[2][1])
                && !position[0][1].equals("")) {
            return true;
        }
        //third column//
        if (position[0][2].equals(position[1][2])
                && position[0][2].equals(position[2][2])
                && !position[0][2].equals("")) {
            return true;
        }

        //CHECKING FOR WIN HORIZONTALLY(LEFT-RIGHT)//
        //first row//
        if (position[0][0].equals(position[0][1])
                && position[0][0].equals(position[0][2])
                && !position[0][0].equals("")) {
            return true;
        }
        //second row//
        if (position[1][0].equals(position[1][1])
                && position[1][0].equals(position[1][2])
                && !position[1][0].equals("")) {
            return true;
        }
        //third row//
        else if (position[2][0].equals(position[2][1])
                && position[2][0].equals(position[2][2])
                && !position[2][0].equals("")) {
            return true;
        }

        //CHECKING FOR WIN DIAGONALLY//
        //first diagonal (left to right)//
        if (position[0][0].equals(position[1][1])
                && position[0][0].equals(position[2][2])
                && !position[0][0].equals("")) {
            return true;
        }
        //second diagonal (right to left)//
        else return position[0][2].equals(position[1][1])
                && position[0][2].equals(position[2][0])
                && !position[0][2].equals("");
    }

}

