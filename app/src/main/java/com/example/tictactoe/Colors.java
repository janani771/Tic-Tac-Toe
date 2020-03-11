package com.example.tictactoe;

import android.graphics.Color;


import java.util.Random;

public class Colors {
    //generates random pastel colors
    public int randomColorLight(){
        Random randomColor = new Random(System.currentTimeMillis());
        final int white = Color.GRAY;
        final int red = Color.red(white);
        final int green = Color.green(white);
        final int blue = Color.blue(white);

        final int newRed = (white + randomColor.nextInt(256))/2;
        final int newGreen =(white + randomColor.nextInt(256))/2;
        final int newBlue = (white + randomColor.nextInt(256))/2;
        return Color.rgb(newRed,newGreen,newBlue);
    }
    //    //generates random darker colors
    public int randomColorDark(){
        Random randomColor = new Random(System.currentTimeMillis());
        final int white = Color.DKGRAY;
        final int red = Color.red(white);
        final int green = Color.green(white);
        final int blue = Color.blue(white);

        final int newRed = (white + randomColor.nextInt(256))/2;
        final int newGreen =(white + randomColor.nextInt(256))/2;
        final int newBlue = (white + randomColor.nextInt(256))/2;
        return Color.rgb(newRed,newGreen,newBlue);
    }

}
