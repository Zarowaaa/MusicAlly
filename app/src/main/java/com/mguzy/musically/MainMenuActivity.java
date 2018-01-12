package com.mguzy.musically;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void openTuner(View view) {
        Intent intent = new Intent(MainMenuActivity.this, TuneActivity.class);
        startActivity(intent);
    }

    public void openMetronome(View view) {
        Intent intent = new Intent(MainMenuActivity.this, MetronomeActivity.class);
        startActivity(intent);
    }

    public void openHearing(View view) {
        Intent intent = new Intent(MainMenuActivity.this, HearingMenu.class);
        startActivity(intent);
    }

}


