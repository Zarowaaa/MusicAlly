package com.mguzy.musically;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HearingMenu extends AppCompatActivity {

    TextView score1;
    TextView score2;
    SharedPreferences sharedPreferences;

    int exerciseCorrect1 = 0;
    int exerciseDone1 = 0;
    double percentCorrect1 = 0.0;
    String performance1 = "";

    int exerciseCorrect2 = 0;
    int exerciseDone2 = 0;
    double percentCorrect2 = 0.0;
    String performance2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hearing_menu);
        score1 = (TextView) findViewById(R.id.module1ScoreTV);
        score2 = (TextView) findViewById(R.id.module2ScoreTV);

        sharedPreferences = getApplicationContext().getSharedPreferences("score1", MODE_PRIVATE);
        if(sharedPreferences != null) {
            exerciseCorrect1 = Integer.parseInt(sharedPreferences.getString("correct", "0"));
            exerciseDone1 = Integer.parseInt(sharedPreferences.getString("done","0"));
            percentCorrect1 = Double.parseDouble(sharedPreferences.getString("percent","0.0"));
        }
        performance1 = "Module 1: " + exerciseCorrect1 + "/" + exerciseDone1 + " (" + percentCorrect1 + "%)";

        sharedPreferences = getApplicationContext().getSharedPreferences("score2", MODE_PRIVATE);
        if(sharedPreferences != null) {
            exerciseCorrect2 = Integer.parseInt(sharedPreferences.getString("correct", "0"));
            exerciseDone2 = Integer.parseInt(sharedPreferences.getString("done","0"));
            percentCorrect2 = Double.parseDouble(sharedPreferences.getString("percent","0.0"));
        }
        performance2 = "Module 2: " + exerciseCorrect2 + "/" + exerciseDone2 + " (" + percentCorrect2 + "%)";

        score1.setText(performance1);
        score2.setText(performance2);

        if(percentCorrect1 > 50){
            score1.setTextColor(Color.GREEN);
        }else score1.setTextColor(Color.RED);

        if(percentCorrect2 > 50){
            score2.setTextColor(Color.GREEN);
        }else score2.setTextColor(Color.RED);
    }

    public void openHowTo(View view)
    {
        Intent intent = new Intent(HearingMenu.this, HowTo.class);
        startActivity(intent);
    }

    public void openLevel1(View view)
    {
        Intent intent = new Intent(HearingMenu.this, Hearing_Level1Activity.class);
        startActivity(intent);
    }
    public void openLevel2(View view)
    {
        Intent intent = new Intent(HearingMenu.this, Hearing_Level2Activity.class);
        startActivity(intent);
    }
    public void openLevel3(View view)
    {
        Intent intent = new Intent(HearingMenu.this, Hearing_Level3Activity.class);
        startActivity(intent);
    }
}
