package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
int scoreTeamA = 0;
int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void driePunter(View view) {
    scoreTeamA = scoreTeamA +3;
    display1(scoreTeamA);
    }
    public void tweePunter(View view) {
        scoreTeamA = scoreTeamA +2;
        display1(scoreTeamA);
    }
    public void eenPunter(View view) {
        scoreTeamA = scoreTeamA +1;
        display1(scoreTeamA);
        // Hierna is de code voor Team B
    }
    public void eenPunterB(View view) {
        scoreTeamB = scoreTeamB +1;
        display2(scoreTeamB);
    }
    public void tweePunterB(View view) {
        scoreTeamB = scoreTeamB +2;
        display2(scoreTeamB);
    }
    public void driePunterB(View view) {
        scoreTeamB = scoreTeamB +3;
        display2(scoreTeamB);
    }
    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        display1(scoreTeamA);
        display2(scoreTeamB);

    }
    private void display1(int number){
        TextView quantityTextView = (TextView) findViewById(
                R.id.team_a_score);
        quantityTextView.setText(""+number);
    }
    private void display2(int number){
        TextView quantityTextView = (TextView) findViewById(
                R.id.team_b_score);
        quantityTextView.setText(""+number);
    }

}