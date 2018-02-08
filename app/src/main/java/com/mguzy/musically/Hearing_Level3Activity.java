package com.mguzy.musically;

import android.Manifest;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chrynan.guitartuner.Note;
import com.chrynan.guitartuner.Tuner;
import com.chrynan.guitartuner.TunerUpdate;
import com.chrynan.guitartuner.tarsos.PitchDetectionResult;

import java.util.Random;

import static com.chrynan.guitartuner.TunerFragment.AUDIO_PERMISSION_REQUEST_CODE;

public class Hearing_Level3Activity extends AppCompatActivity {

    public TextView performanceTextView;
    public EditText firstNoteET;
    public EditText secondNoteET;
    Random randomGenerator = new Random();
    int randomInt = 1;
    int exerciseCorrect = 0;
    int exerciseDone = 0;
    double percentCorrect = 0.0;
    long start = 0;
    long finish = 0;
    int numberAddedFlag = 0;
    MediaPlayer a4 = null;
    MediaPlayer a5= null;
    MediaPlayer a6= null;
    MediaPlayer ab4= null;
    MediaPlayer ab5= null;
    MediaPlayer ab6= null;
    MediaPlayer b4= null;
    MediaPlayer b5= null;
    MediaPlayer b6= null;
    MediaPlayer bb4= null;
    MediaPlayer bb5= null;
    MediaPlayer bb6= null;
    MediaPlayer c4= null;
    MediaPlayer c5= null;
    MediaPlayer c6 = null;
    MediaPlayer c7 = null;
    MediaPlayer d4= null;
    MediaPlayer d5 = null;
    MediaPlayer d6= null;
    MediaPlayer db4 = null;
    MediaPlayer db5 = null;
    MediaPlayer db6 = null;
    MediaPlayer e4 = null;
    MediaPlayer e5= null;
    MediaPlayer e6= null;
    MediaPlayer eb4= null;
    MediaPlayer eb5= null;
    MediaPlayer eb6 = null;
    MediaPlayer f4 = null;
    MediaPlayer f5= null;
    MediaPlayer f6= null;
    MediaPlayer g4 = null;
    MediaPlayer g5 = null;
    MediaPlayer g6 = null;
    MediaPlayer gb4= null;
    MediaPlayer gb5= null;
    MediaPlayer gb6 = null;
    public static int frequency = 400;
    String tone1 = "";
    String tone2 = "";
    String performance = "";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hearing__level3);
        performanceTextView = (TextView) findViewById(R.id.performanceTextView);

        sharedPreferences = getApplicationContext().getSharedPreferences("score2", MODE_PRIVATE);
        if(sharedPreferences != null) {
            exerciseCorrect = Integer.parseInt(sharedPreferences.getString("correct", "0"));
            exerciseDone = Integer.parseInt(sharedPreferences.getString("done","0"));
            percentCorrect = Double.parseDouble(sharedPreferences.getString("percent","0.0"));
        }
        performance = "Performance: " + exerciseCorrect + "/" + exerciseDone + " (" + percentCorrect + "%)";
        firstNoteET = (EditText) findViewById(R.id.firstNoteEditText);
        secondNoteET = (EditText) findViewById(R.id.secondNoteEditText);
        requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO},
                AUDIO_PERMISSION_REQUEST_CODE);
        a4 = MediaPlayer.create(getApplicationContext(), R.raw.a4);
        a5 = MediaPlayer.create(getApplicationContext(), R.raw.a5);
        a6 = MediaPlayer.create(this, R.raw.a6);
        ab4 = MediaPlayer.create(this, R.raw.ab4);
        ab5 = MediaPlayer.create(this, R.raw.ab5);
        ab6 = MediaPlayer.create(this, R.raw.ab6);
        b4 = MediaPlayer.create(this, R.raw.b4);
        b5 = MediaPlayer.create(this, R.raw.b5);
        b6 = MediaPlayer.create(this, R.raw.b6);
        bb4 = MediaPlayer.create(this, R.raw.bb4);
        bb5 = MediaPlayer.create(this, R.raw.bb5);
        bb6 = MediaPlayer.create(this, R.raw.bb6);
        c4 = MediaPlayer.create(this, R.raw.c4);
        c5 = MediaPlayer.create(this, R.raw.c5);
        c6 = MediaPlayer.create(this, R.raw.c6);
        c7 = MediaPlayer.create(this, R.raw.c7);
        d4 = MediaPlayer.create(this, R.raw.d4);
        d5 = MediaPlayer.create(this, R.raw.d5);
        d6 = MediaPlayer.create(this, R.raw.d6);
        db4 = MediaPlayer.create(this, R.raw.db4);
        db5 = MediaPlayer.create(this, R.raw.db5);
        db6 = MediaPlayer.create(this, R.raw.db6);
        e4 = MediaPlayer.create(this, R.raw.e4);
        e5 = MediaPlayer.create(this, R.raw.e5);
        e6 = MediaPlayer.create(this, R.raw.e6);
        eb4 = MediaPlayer.create(this, R.raw.eb4);
        eb5 = MediaPlayer.create(this, R.raw.eb5);
        eb6 = MediaPlayer.create(this, R.raw.eb6);
        f4 = MediaPlayer.create(this, R.raw.f4);
        f5 = MediaPlayer.create(this, R.raw.f5);
        f6 = MediaPlayer.create(this, R.raw.f6);
        g4 = MediaPlayer.create(this, R.raw.g4 );
        g5 = MediaPlayer.create(this, R.raw.g5 );
        g6 = MediaPlayer.create(this, R.raw.g6 );
        gb4 = MediaPlayer.create(this, R.raw.gb4);
        gb5 = MediaPlayer.create(this, R.raw.gb5);
        gb6 = MediaPlayer.create(this, R.raw.gb6);
        performanceTextView.setText(performance);
    }


    public void playFirstScale(View view){
        randomInt = randomGenerator.nextInt(13) + 1;
        switch (randomInt) {
            case 1:
                c4.start();
                frequency = 261;
                if(tone1 == ""){
                    tone1 = "c4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "c4";
                }
                break;
            case 2:
                db4.start();
                frequency = 277;
                if(tone1 == ""){
                    tone1 = "db4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "db4";
                }
                break;
            case 3:
                d4.start();
                frequency = 293;
                if(tone1 == ""){
                    tone1 = "e4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "e4";
                }
                break;
            case 4:
                eb4.start();
                frequency = 311;
                if(tone1 == ""){
                    tone1 = "eb4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "eb4";
                }
                break;
            case 5:
                e4.start();
                frequency = 329;
                if(tone1 == ""){
                    tone1 = "eb4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "eb4";
                }
                break;
            case 6:
                f4.start();
                frequency = 349;
                if(tone1 == ""){
                    tone1 = "f4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "f4";
                }
                break;
            case 7:
                gb4.start();
                frequency = 369;
                if(tone1 == ""){
                    tone1 = "gb4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "gb4";
                }
                break;
            case 8:
                g4.start();
                frequency = 392;
                if(tone1 == ""){
                    tone1 = "g4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "g4";
                }
                break;
            case 9:
                ab4.start();
                frequency = 415;
                if(tone1 == ""){
                    tone1 = "ab4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "ab4";
                }
                break;
            case 10:
                a4.start();
                frequency = 440;
                if(tone1 == ""){
                    tone1 = "a4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "a4";
                }
                break;
            case 11:
                bb4.start();
                frequency = 466;
                if(tone1 == ""){
                    tone1 = "bb4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "bb4";
                }
                break;
            case 12:
                b4.start();
                frequency = 493;
                if(tone1 == ""){
                    tone1 = "b4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "b4";
                }
                break;
            case 13:
                c5.start();
                frequency = 523;
                if(tone1 == ""){
                    tone1 = "c5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "c5";
                }
                break;
        }
        start = System.currentTimeMillis();
        finish = start + 5000;
        numberAddedFlag = 0;

    }

    public void playSecondScale(View view){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(13) + 1;
        switch (randomInt) {
            case 1:
                c5.start();
                frequency = 523;
                if(tone1 == ""){
                    tone1 = "c5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "c5";
                }
                break;
            case 2:
                db5.start();
                frequency = 554;
                if(tone1 == ""){
                    tone1 = "db5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "db5";
                }
                break;
            case 3:
                d5.start();
                frequency = 587;
                if(tone1 == ""){
                    tone1 = "d5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "d5";
                }
                break;
            case 4:
                eb5.start();
                frequency = 622;
                if(tone1 == ""){
                    tone1 = "eb5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "eb5";
                }
                break;
            case 5:
                e5.start();
                frequency = 659;
                if(tone1 == ""){
                    tone1 = "e5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "e5";
                }
                break;
            case 6:
                f5.start();
                frequency = 698;
                if(tone1 == ""){
                    tone1 = "f5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "f5";
                }
                break;
            case 7:
                gb5.start();
                frequency = 739;
                if(tone1 == ""){
                    tone1 = "gb5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "gb5";
                }
                break;
            case 8:
                g5.start();
                frequency = 783;
                if(tone1 == ""){
                    tone1 = "g5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "g5";
                }
                break;
            case 9:
                ab5.start();
                frequency = 830;
                if(tone1 == ""){
                    tone1 = "ab5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "ab5";
                }
                break;
            case 10:
                a5.start();
                frequency = 880;
                if(tone1 == ""){
                    tone1 = "a5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "a5";
                }
                break;
            case 11:
                bb5.start();
                frequency = 932;
                if(tone1 == ""){
                    tone1 = "bb5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "bb5";
                }
                break;
            case 12:
                b5.start();
                frequency = 987;
                if(tone1 == ""){
                    tone1 = "b5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "b5";
                }
                break;
            case 13:
                c6.start();
                frequency = 1046;
                if(tone1 == ""){
                    tone1 = "c6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "c6";
                }
                break;
        }
        start = System.currentTimeMillis();
        finish = start + 5000;
        numberAddedFlag = 0;
    }

    public void playThirdScale(View view){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(13) + 1;
        switch (randomInt) {
            case 1:
                c6.start();
                frequency = 1046;
                if(tone1 == ""){
                    tone1 = "c6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "c6";
                }
                break;
            case 2:
                db6.start();
                frequency = 1108;
                if(tone1 == ""){
                    tone1 = "db6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "db6";
                }
                break;
            case 3:
                d6.start();
                frequency = 1174;
                if(tone1 == ""){
                    tone1 = "d6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "d6";
                }
                break;
            case 4:
                eb6.start();
                frequency = 1244;
                if(tone1 == ""){
                    tone1 = "eb6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "eb6";
                }
                break;
            case 5:
                e6.start();
                frequency = 1318;
                if(tone1 == ""){
                    tone1 = "e6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "e6";
                }
                break;
            case 6:
                f6.start();
                frequency = 1396;
                if(tone1 == ""){
                    tone1 = "f6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "f6";
                }
                break;
            case 7:
                gb6.start();
                frequency = 1479;
                if(tone1 == ""){
                    tone1 = "gb6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "gb6";
                }
                break;
            case 8:
                g6.start();
                frequency = 1567;
                if(tone1 == ""){
                    tone1 = "g6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "g6";
                }
                break;
            case 9:
                ab6.start();
                frequency = 1661;
                if(tone1 == ""){
                    tone1 = "ab6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "ab6";
                }
                break;
            case 10:
                a6.start();
                frequency = 1760;
                if(tone1 == ""){
                    tone1 = "c6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "c6";
                }
                break;
            case 11:
                bb6.start();
                frequency = 1864;
                if(tone1 == ""){
                    tone1 = "bb6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "bb6";
                }
                break;
            case 12:
                b6.start();
                frequency = 1975;
                if(tone1 == ""){
                    tone1 = "b6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "b6";
                }
                break;
            case 13:
                c7.start();
                frequency = 2093;
                if(tone1 == ""){
                    tone1 = "c7";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "c7";
                }
                break;
        }
        start = System.currentTimeMillis();
        finish = start + 5000;
        numberAddedFlag = 0;
    }

    public void playAllScales(View view){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(26) + 1;
        switch (randomInt) {
            case 1:
                c4.start();
                frequency = 261;
                if(tone1 == ""){
                    tone1 = "c4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "c4";
                }
                break;
            case 2:
                db4.start();
                frequency = 277;
                if(tone1 == ""){
                    tone1 = "db4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "db4";
                }
                break;
            case 3:
                d4.start();
                frequency = 293;
                if(tone1 == ""){
                    tone1 = "e4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "e4";
                }
                break;
            case 4:
                eb4.start();
                frequency = 311;
                if(tone1 == ""){
                    tone1 = "eb4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "eb4";
                }
                break;
            case 5:
                e4.start();
                frequency = 329;
                if(tone1 == ""){
                    tone1 = "eb4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "eb4";
                }
                break;
            case 6:
                f4.start();
                frequency = 349;
                if(tone1 == ""){
                    tone1 = "f4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "f4";
                }
                break;
            case 7:
                gb4.start();
                frequency = 369;
                if(tone1 == ""){
                    tone1 = "gb4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "gb4";
                }
                break;
            case 8:
                g4.start();
                frequency = 392;
                if(tone1 == ""){
                    tone1 = "g4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "g4";
                }
                break;
            case 9:
                ab4.start();
                frequency = 415;
                if(tone1 == ""){
                    tone1 = "ab4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "ab4";
                }
                break;
            case 10:
                a4.start();
                frequency = 440;
                if(tone1 == ""){
                    tone1 = "a4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "a4";
                }
                break;
            case 11:
                bb4.start();
                frequency = 466;
                if(tone1 == ""){
                    tone1 = "bb4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "bb4";
                }
                break;
            case 12:
                b4.start();
                frequency = 493;
                if(tone1 == ""){
                    tone1 = "b4";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "b4";
                }
                break;
            case 13:
                c5.start();
                frequency = 523;
                if(tone1 == ""){
                    tone1 = "c5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "c5";
                }
                break;
            case 14:
                c5.start();
                frequency = 523;
                if(tone1 == ""){
                    tone1 = "c5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "c5";
                }
                break;
            case 15:
                db5.start();
                frequency = 554;
                if(tone1 == ""){
                    tone1 = "db5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "db5";
                }
                break;
            case 16:
                d5.start();
                frequency = 587;
                if(tone1 == ""){
                    tone1 = "d5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "d5";
                }
                break;
            case 17:
                eb5.start();
                frequency = 622;
                if(tone1 == ""){
                    tone1 = "eb5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "eb5";
                }
                break;
            case 18:
                e5.start();
                frequency = 659;
                if(tone1 == ""){
                    tone1 = "e5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "e5";
                }
                break;
            case 19:
                f5.start();
                frequency = 698;
                if(tone1 == ""){
                    tone1 = "f5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "f5";
                }
                break;
            case 20:
                gb5.start();
                frequency = 739;
                if(tone1 == ""){
                    tone1 = "gb5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "gb5";
                }
                break;
            case 21:
                g5.start();
                frequency = 783;
                if(tone1 == ""){
                    tone1 = "g5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "g5";
                }
                break;
            case 22:
                ab5.start();
                frequency = 830;
                if(tone1 == ""){
                    tone1 = "ab5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "ab5";
                }
                break;
            case 23:
                a5.start();
                frequency = 880;
                if(tone1 == ""){
                    tone1 = "a5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "a5";
                }
                break;
            case 24:
                bb5.start();
                frequency = 932;
                if(tone1 == ""){
                    tone1 = "bb5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "bb5";
                }
                break;
            case 25:
                b5.start();
                frequency = 987;
                if(tone1 == ""){
                    tone1 = "b5";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "b5";
                }
                break;
            case 26:
                c6.start();
                frequency = 1046;
                if(tone1 == ""){
                    tone1 = "c6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "c6";
                }
                break;
            case 27:
                db6.start();
                frequency = 1108;
                if(tone1 == ""){
                    tone1 = "db6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "db6";
                }
                break;
            case 28:
                d6.start();
                frequency = 1174;
                if(tone1 == ""){
                    tone1 = "d6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "d6";
                }
                break;
            case 29:
                eb6.start();
                frequency = 1244;
                if(tone1 == ""){
                    tone1 = "eb6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "eb6";
                }
                break;
            case 30:
                e6.start();
                frequency = 1318;
                if(tone1 == ""){
                    tone1 = "e6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "e6";
                }
                break;
            case 31:
                f6.start();
                frequency = 1396;
                if(tone1 == ""){
                    tone1 = "f6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "f6";
                }
                break;
            case 32:
                gb6.start();
                frequency = 1479;
                if(tone1 == ""){
                    tone1 = "gb6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "gb6";
                }
                break;
            case 33:
                g6.start();
                frequency = 1567;
                if(tone1 == ""){
                    tone1 = "g6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "g6";
                }
                break;
            case 34:
                ab6.start();
                frequency = 1661;
                if(tone1 == ""){
                    tone1 = "ab6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "ab6";
                }
                break;
            case 35:
                a6.start();
                frequency = 1760;
                if(tone1 == ""){
                    tone1 = "c6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "c6";
                }
                break;
            case 36:
                bb6.start();
                frequency = 1864;
                if(tone1 == ""){
                    tone1 = "bb6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "bb6";
                }
                break;
            case 37:
                b6.start();
                frequency = 1975;
                if(tone1 == ""){
                    tone1 = "b6";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "b6";
                }
                break;
            case 38:
                c7.start();
                frequency = 2093;
                if(tone1 == ""){
                    tone1 = "c7";
                }else if (tone1 != "" && tone2 == ""){
                    tone2 = "c7";
                }
                break;
        }
        start = System.currentTimeMillis();
        finish = start + 5000;
        numberAddedFlag = 0;
    }

    public void compareResults(View view){
        if (firstNoteET.getText().toString().toLowerCase() == tone1 && secondNoteET.getText().toString().toLowerCase() == tone2 ){
            exerciseCorrect++;
            Toast.makeText(Hearing_Level3Activity.this, "Correct! Memory cleared.", Toast.LENGTH_SHORT).show();
        }else Toast.makeText(Hearing_Level3Activity.this, "Wrong guess! Memory cleared.", Toast.LENGTH_SHORT).show();
        exerciseDone++;
        percentCorrect = (exerciseCorrect/exerciseDone)*100;
        performance = "Performance: " + exerciseCorrect+ "/" + exerciseDone + " (" +percentCorrect+"%)" ;
        performanceTextView.setText(performance);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("correct", Integer.toString(exerciseCorrect));
        editor.putString("done", Integer.toString(exerciseDone));
        editor.putString("percent", Double.toString(percentCorrect));
        editor.commit();
        tone1 = "";
        tone2 = "";
    }
}
