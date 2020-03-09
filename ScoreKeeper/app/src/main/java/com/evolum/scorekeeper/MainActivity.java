package com.evolum.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    int scoreTeamA = 0;
    int foultTeamA = 0;

    int scoreTeamB = 0;
    int foultTeamB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void touchdownForTeamA(View view)
    {
        scoreTeamA = scoreTeamA + 6;
        displayScoreForTeamA(scoreTeamA);
    }

    public void fieldGoalForTeamA(View view)
    {
        scoreTeamA = scoreTeamA + 3;
        displayScoreForTeamA(scoreTeamA);
    }

    public void peOrSafetyForTeamA(View view)
    {
        scoreTeamA = scoreTeamA + 2;
        displayScoreForTeamA(scoreTeamA);
    }

    public void fiveYardsForTeamA(View view)
    {
        foultTeamA = foultTeamA + 5;
        displayFoulForTeamA(foultTeamA);
    }

    public void tenYardsForTeamA(View view)
    {
        foultTeamA = foultTeamA + 10;
        displayFoulForTeamA(foultTeamA);
    }

    public void fifteenYardsForTeamA(View view)
    {
        foultTeamA = foultTeamA + 15;
        displayFoulForTeamA(foultTeamA);
    }

    public void touchdownForTeamB(View view)
    {
        scoreTeamB = scoreTeamB + 6;
        displayScoreForTeamB(scoreTeamB);
    }

    public void fieldGoalForTeamB(View view)
    {
        scoreTeamB = scoreTeamB + 3;
        displayScoreForTeamB(scoreTeamB);
    }

    public void peOrSafetyForTeamB(View view)
    {
        scoreTeamB = scoreTeamB + 2;
        displayScoreForTeamB(scoreTeamB);
    }

    public void fiveYardsForTeamB(View view)
    {
        foultTeamB = foultTeamB + 5;
        displayFoulForTeamB(foultTeamB);
    }

    public void tenYardsForTeamB(View view)
    {
        foultTeamB = foultTeamB + 10;
        displayFoulForTeamB(foultTeamB);
    }

    public void fifteenYardsForTeamB(View view)
    {
        foultTeamB = foultTeamB + 15;
        displayFoulForTeamB(foultTeamB);
    }

    public void displayScoreForTeamA(int score)
    {
        TextView tviScoreTeamA = findViewById(R.id.score_a_text_view);
        tviScoreTeamA.setText(String.valueOf(score));
    }

    public void displayFoulForTeamA(int foul)
    {
        TextView tviScoreTeamA = findViewById(R.id.foul_a_text_view);
        tviScoreTeamA.setText(String.valueOf(foul));
    }

    public void displayScoreForTeamB(int score)
    {
        TextView tviScoreTeamA = findViewById(R.id.score_b_text_view);
        tviScoreTeamA.setText(String.valueOf(score));
    }

    public void displayFoulForTeamB(int foul)
    {
        TextView tviScoreTeamA = findViewById(R.id.foul_b_text_view);
        tviScoreTeamA.setText(String.valueOf(foul));
    }

    public void resetAll(View view)
    {
        scoreTeamA = 0;
        foultTeamA = 0;

        scoreTeamB = 0;
        foultTeamB = 0;

        displayScoreForTeamA(scoreTeamA);
        displayFoulForTeamA(foultTeamA);
        displayScoreForTeamB(scoreTeamB);
        displayFoulForTeamB(foultTeamB);
    }
}
