package com.example.tictactoe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

public class Instructions extends AppCompatDialogFragment {
    //creates an alert box with list of instructions//
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder instruct = new AlertDialog.Builder(getActivity());
        instruct.setTitle("How to play the game?")
                .setMessage("-This game is played on a 3X3 grid. \n\n-Player one is always 'X' and Player two is always 'O' by default \n\n-The first player to mark their spaces in a row, either vertically, horizontally, or diagonally is declared the winner. \n\n-If all the nine square are full and no player has three marks in a row, then the game is tied.\n\n")
                .setPositiveButton("Got it!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return instruct.create();

    }
}
