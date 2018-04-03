package com.example.android.twoplayercribbagecounter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.twoplayercribbagecounter.R;

public class MainActivity extends AppCompatActivity {

    int scorePlayerOne = 0;
    int scorePlayerTwo = 0;
    int lastPlayerScored;
    int lastPlayerScoreValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForPlayerOne(0);
    }

    /**
     * Add One Point to Player One ( Run, Go, Nob )
     */
    public void addOnePlayerOne(View view) {
        lastPlayerScored = 1;
        lastPlayerScoreValue = 1;
        scorePlayerOne = scorePlayerOne + 1;
        displayForPlayerOne(scorePlayerOne);
        checkWinner();
    }

    /**
     * Add Two Points to Player One ( 15, 31, Pair )
     */
    public void addTwoPlayerOne(View view) {
        lastPlayerScored = 1;
        lastPlayerScoreValue = 2;
        scorePlayerOne = scorePlayerOne + 2;
        displayForPlayerOne(scorePlayerOne);
        checkWinner();
    }

    /**
     * Add Four Points to Player One ( Four Card Flush )
     */
    public void addFourPlayerOne(View view) {
        lastPlayerScored = 1;
        lastPlayerScoreValue = 4;
        scorePlayerOne = scorePlayerOne + 4;
        displayForPlayerOne(scorePlayerOne);
        checkWinner();
    }

    /**
     * Add Five Points to Player One ( Five Card Flush )
     */
    public void addFivePlayerOne(View view) {
        lastPlayerScored = 1;
        lastPlayerScoreValue = 5;
        scorePlayerOne = scorePlayerOne + 5;
        displayForPlayerOne(scorePlayerOne);
        checkWinner();
    }

    /**
     * Add Six Points to Player One ( Pair Royal )
     */
    public void addSixPlayerOne(View view) {
        lastPlayerScored = 1;
        lastPlayerScoreValue = 6;
        scorePlayerOne = scorePlayerOne + 6;
        displayForPlayerOne(scorePlayerOne);
        checkWinner();
    }

    /**
     * Add Twelve Points to Player One ( Double Pair Royal )
     */
    public void addTwelvePlayerOne(View view) {
        lastPlayerScored = 1;
        lastPlayerScoreValue = 12;
        scorePlayerOne = scorePlayerOne + 12;
        displayForPlayerOne(scorePlayerOne);
        checkWinner();
    }

    /**
     * Add One Point to Player Two ( Run, Go, Nob )
     */
    public void addOnePlayerTwo(View view) {
        lastPlayerScored = 2;
        lastPlayerScoreValue = 1;
        scorePlayerTwo = scorePlayerTwo + 1;
        displayForPlayerTwo(scorePlayerTwo);
        checkWinner();
    }

    /**
     * Add Two Points to Player Two ( 15, 31, Pair )
     */
    public void addTwoPlayerTwo(View view) {
        lastPlayerScored = 2;
        lastPlayerScoreValue = 2;
        scorePlayerTwo = scorePlayerTwo + 2;
        displayForPlayerTwo(scorePlayerTwo);
        checkWinner();
    }

    /**
     * Add Four Points to Player Two ( Four Card Flush )
     */
    public void addFourPlayerTwo(View view) {
        lastPlayerScored = 2;
        lastPlayerScoreValue = 4;
        scorePlayerTwo = scorePlayerTwo + 4;
        displayForPlayerTwo(scorePlayerTwo);
        checkWinner();
    }

    /**
     * Add Five Points to Player Two ( Five Card Flush )
     */
    public void addFivePlayerTwo(View view) {
        lastPlayerScored = 2;
        lastPlayerScoreValue = 5;
        scorePlayerTwo = scorePlayerTwo + 5;
        displayForPlayerTwo(scorePlayerTwo);
        checkWinner();
    }

    /**
     * Add Six Points to Player Two ( Pair Royal )
     */
    public void addSixPlayerTwo(View view) {
        lastPlayerScored = 2;
        lastPlayerScoreValue = 6;
        scorePlayerTwo = scorePlayerTwo + 6;
        displayForPlayerTwo(scorePlayerTwo);
        checkWinner();
    }

    /**
     * Add Twelve Points to Player Two ( Double Pair Royal )
     */
    public void addTwelvePlayerTwo(View view) {
        lastPlayerScored = 2;
        lastPlayerScoreValue = 12;
        scorePlayerTwo = scorePlayerTwo + 12;
        displayForPlayerTwo(scorePlayerTwo);
        checkWinner();
    }

    /**
     * Undo Last Score awarded
     */
    public void undoScore(View view) {
        if(lastPlayerScored == 1) {
            lastPlayerScored = 0;
            scorePlayerOne = scorePlayerOne - lastPlayerScoreValue;
            displayForPlayerOne(scorePlayerOne);
        } else if(lastPlayerScored == 2) {
            lastPlayerScored = 0;
            scorePlayerTwo = scorePlayerTwo - lastPlayerScoreValue;
            displayForPlayerTwo(scorePlayerTwo);
        }
    }

    /**
     * Reset Player label textview, score textview and Background Colors for Player One and Two
     */
    public void resetScore(View view) {
        /**
         * Reset Score Values
         */
        scorePlayerOne = 0;
        scorePlayerTwo = 0;
        displayForPlayerOne(scorePlayerOne);
        displayForPlayerTwo(scorePlayerTwo);
        /**
         * Return player_one_textview back to default string value
         */
        TextView resetView = (TextView) findViewById(R.id.player_one_textview);
        resetView.setText(String.valueOf("Player One"));
        resetView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        /**
         * Return player_one_score textview background color to default
         */
        resetView = (TextView) findViewById(R.id.player_one_score);
        resetView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        /**
         * Return player_two_textview back to default string value
         */
        resetView = (TextView) findViewById(R.id.player_two_textview);
        resetView.setText(String.valueOf("Player Two"));
        resetView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        /**
         * Return player_two_score textview background color to default
         */
        resetView = (TextView) findViewById(R.id.player_two_score);
        resetView.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForPlayerOne(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_one_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForPlayerTwo(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_two_score);
        scoreView.setText(String.valueOf(score));
    }

    public void checkWinner() {
        if(scorePlayerOne >= 121 && scorePlayerTwo < 91) {
            displayPlayerOneWinner();
            displayPlayerTwoSkunked();
        } else if (scorePlayerOne >= 121) {
            displayPlayerOneWinner();
        } else if (scorePlayerTwo >= 121 && scorePlayerOne < 91) {
            displayPlayerTwoWinner();
            displayPlayerOneSkunked();
        } else if (scorePlayerTwo >= 121) {
            displayPlayerTwoWinner();
        }
    }

    public void displayPlayerOneWinner() {
        TextView winnerView = (TextView) findViewById(R.id.player_one_textview);
        winnerView.setText(String.valueOf("Player One Winner!"));
        winnerView.setBackgroundColor(Color.parseColor("#00FF00"));
        winnerView = (TextView) findViewById(R.id.player_one_score);
        winnerView.setBackgroundColor(Color.parseColor("#00FF00"));
    }

    public void displayPlayerOneSkunked() {
        TextView skunkedView = (TextView) findViewById(R.id.player_one_textview);
        skunkedView.setText(String.valueOf("Player One Skunked!"));
        skunkedView.setBackgroundColor(Color.parseColor("#FF0000"));
        skunkedView = (TextView) findViewById(R.id.player_one_score);
        skunkedView.setBackgroundColor(Color.parseColor("#FF0000"));
    }

    public void displayPlayerTwoWinner() {
        TextView winnerView = (TextView) findViewById(R.id.player_two_textview);
        winnerView.setText(String.valueOf("Player Two Winner!"));
        winnerView.setBackgroundColor(Color.parseColor("#00FF00"));
        winnerView = (TextView) findViewById(R.id.player_two_score);
        winnerView.setBackgroundColor(Color.parseColor("#00FF00"));
    }

    public void displayPlayerTwoSkunked() {
        TextView skunkedView = (TextView) findViewById(R.id.player_two_textview);
        skunkedView.setText(String.valueOf("Player Two Skunked!"));
        skunkedView.setBackgroundColor(Color.parseColor("#FF0000"));
        skunkedView = (TextView) findViewById(R.id.player_two_score);
        skunkedView.setBackgroundColor(Color.parseColor("#FF0000"));
    }
}

