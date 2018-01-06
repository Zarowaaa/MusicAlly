package com.mguzy.musically;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chrynan.guitartuner.Note;
import com.chrynan.guitartuner.Tuner;
import com.chrynan.guitartuner.TunerUpdate;
import com.chrynan.guitartuner.tarsos.PitchDetectionResult;

public class Hearing_Level2Activity extends AppCompatActivity {

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
    private Note note;
    public static final int tolerance = 5;
    public static int frequency = 400;
    private PitchDetectionResult result;
    long finish = 0;
    long start = 0;
    int toneRightFlag = 0;

    Tuner tuner = new Tuner(new TunerUpdate() {
        @Override
        public void updateNote(Note newNote, PitchDetectionResult newResult) {

            note = newNote;
            result = newResult;
            Handler handler = new Handler();
            final Runnable r = new Runnable(){
                public void run() {
                    //if(note.getActualFrequency() > 1046-tolerance && note.getActualFrequency() < 1046+tolerance ){
                    if(note.getActualFrequency() > frequency-tolerance && note.getActualFrequency() < frequency+tolerance ){
                        toneRightFlag = 1;
                    }
                }
            };
            handler.postDelayed(r, 5000);

            while (System.currentTimeMillis() == finish)
            {
                if(toneRightFlag == 1){
                    Toast.makeText(Hearing_Level2Activity.this, "Well done!", Toast.LENGTH_LONG).show();
                }else if (toneRightFlag == 0){
                    Toast.makeText(Hearing_Level2Activity.this, "Try again!", Toast.LENGTH_LONG).show();
                }
                tuner.stop();
            }

        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hearing__level2);
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
    }

    public void playc4(View view) {
        playSounds(1);
    }
    public void playdb4(View view) {
        playSounds(2);
    }
    public void playd4(View view) {
        playSounds(3);
    }
    public void playeb4(View view) {
        playSounds(4);
    }
    public void playe4(View view) {
        playSounds(5);
    }
    public void playf4(View view) {
        playSounds(6);
    }
    public void playgb4(View view) {
        playSounds(7);
    }
    public void playg4(View view) {
        playSounds(8);
    }
    public void playab4(View view) {
        playSounds(9);
    }
    public void playa4(View view) {
        playSounds(10);
    }
    public void playbb4(View view) {
        playSounds(11);
    }
    public void playb4(View view) {
        playSounds(12);
    }
    public void playc5(View view) {
        playSounds(13);
    }
    public void playdb5(View view) {
        playSounds(15);
    }
    public void playd5(View view) {
        playSounds(16);
    }
    public void playeb5(View view) {
        playSounds(17);
    }
    public void playe5(View view) {
        playSounds(18);
    }
    public void playf5(View view) {
        playSounds(19);
    }
    public void playgb5(View view) {
        playSounds(20);
    }
    public void playg5(View view) {
        playSounds(21);
    }
    public void playab5(View view) {
        playSounds(22);
    }
    public void playa5(View view) {
        playSounds(23);
    }
    public void playbb5(View view) {
        playSounds(24);
    }
    public void playb5(View view) {
        playSounds(25);
    }
    public void playc6(View view) {
        playSounds(26);
    }
    public void playdb6(View view) {
        playSounds(27);
    }
    public void playd6(View view) {
        playSounds(28);
    }
    public void playeb6(View view) {
        playSounds(29);
    }
    public void playe6(View view) {
        playSounds(30);
    }
    public void playf6(View view) {
        playSounds(31);
    }
    public void playgb6(View view) {
        playSounds(32);
    }
    public void playg6(View view) {
        playSounds(33);
    }
    public void playab6(View view) {
        playSounds(34);
    }
    public void playa6(View view) {
        playSounds(35);
    }
    public void playbb6(View view) {
        playSounds(36);
    }
    public void playb6(View view) {
        playSounds(37);
    }

    public void playSounds(int sound){


        switch (sound) {
            case 1:
                c4.start();
                frequency = 261;
                break;
            case 2:
                db4.start();
                frequency = 277;
                break;
            case 3:
                d4.start();
                frequency = 293;
                break;
            case 4:
                eb4.start();
                frequency = 311;
                break;
            case 5:
                e4.start();
                frequency = 329;
                break;
            case 6:
                f4.start();
                frequency = 349;
                break;
            case 7:
                gb4.start();
                frequency = 369;
                break;
            case 8:
                g4.start();
                frequency = 392;
                break;
            case 9:
                ab4.start();
                frequency = 415;
                break;
            case 10:
                a4.start();
                frequency = 440;
                break;
            case 11:
                bb4.start();
                frequency = 466;
                break;
            case 12:
                b4.start();
                frequency = 493;
                break;
            case 13:
                c5.start();
                frequency = 523;
                break;
            case 14:
                c5.start();
                frequency = 523;
                break;
            case 15:
                db5.start();
                frequency = 554;
                break;
            case 16:
                d5.start();
                frequency = 587;
                break;
            case 17:
                eb5.start();
                frequency = 622;
                break;
            case 18:
                e5.start();
                frequency = 659;
                break;
            case 19:
                f5.start();
                frequency = 698;
                break;
            case 20:
                gb5.start();
                frequency = 739;
                break;
            case 21:
                g5.start();
                frequency = 783;
                break;
            case 22:
                ab5.start();
                frequency = 830;
                break;
            case 23:
                a5.start();
                frequency = 880;
                break;
            case 24:
                bb5.start();
                frequency = 932;
                break;
            case 25:
                b5.start();
                frequency = 987;
                break;
            case 26:
                c6.start();
                frequency = 1046;
                break;
            case 27:
                db6.start();
                frequency = 1108;
                break;
            case 28:
                d6.start();
                frequency = 1174;
                break;
            case 29:
                eb6.start();
                frequency = 1244;
                break;
            case 30:
                e6.start();
                frequency = 1318;
                break;
            case 31:
                f6.start();
                frequency = 1396;
                break;
            case 32:
                gb6.start();
                frequency = 1479;
                break;
            case 33:
                g6.start();
                frequency = 1567;
                break;
            case 34:
                ab6.start();
                frequency = 1661;
                break;
            case 35:
                a6.start();
                frequency = 1760;
                break;
            case 36:
                bb6.start();
                frequency = 1864;
                break;
            case 37:
                b6.start();
                frequency = 1975;
                break;
            case 38:
                c7.start();
                frequency = 2093;
                break;
        }

        start = System.currentTimeMillis();
        finish = start + 5000;
        tuner.start();
    }
}
