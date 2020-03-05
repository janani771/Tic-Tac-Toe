package com.example.tictactoe;
import android.content.Context;
import android.content.SharedPreferences;

public class Scores {
    private static final String P1_SCORE = "scoreOfPlayer1";
    private static final String P2_SCORE = "scoreOfPlayer2";
    private static final String PREF_FILE = "Scores";

    private int player1Score;
    private int player2Score;

    private Context context;
    private SharedPreferences myScores;

    public Scores(Context context){
        myScores = context.getSharedPreferences(PREF_FILE,Context.MODE_PRIVATE);
        this.player1Score = myScores.getInt(P1_SCORE,0);
        this.player2Score = myScores.getInt(P2_SCORE,0);
        this.context = context;
    }
    public void playerWins(int who){
        if(who ==1){
            player1Score++;
            editPref(P1_SCORE, player1Score);
        }else{
            player2Score++;
            editPref(P2_SCORE, player2Score);
        }
    }
    public int getScore(int who){
        return who == 1 ? player1Score : player2Score;
    }
    public int getPlayer1Score() {
        return player1Score;
    }
    public int getPlayer2Score() {
        return player2Score;
    }
    public void resetScore(){
        player1Score=0;
        player2Score=0;
        editPref(P1_SCORE,0);
        editPref(P2_SCORE,0);
    }

    private void editPref(String key, int val){
        SharedPreferences.Editor editor = myScores.edit();
        editor.putInt(key,val);
        editor.apply();
    }


}
