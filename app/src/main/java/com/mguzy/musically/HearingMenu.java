package com.mguzy.musically;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HearingMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hearing_menu);
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
