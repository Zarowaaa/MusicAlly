package com.mguzy.musically;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.chrynan.guitartuner.Note;
import com.chrynan.guitartuner.Tuner;
import com.chrynan.guitartuner.TunerFragment;
import com.chrynan.guitartuner.TunerUpdate;
import com.chrynan.guitartuner.tarsos.PitchDetectionResult;

import static com.chrynan.guitartuner.TunerFragment.AUDIO_PERMISSION_REQUEST_CODE;

public class Hearing_Level1Activity extends AppCompatActivity {

    public TextView verdictTextView;
    private Note note;
    private int toneRightFlag = 0;
    public static final int tolerance = 5;
    public static final int RED = Color.parseColor("#c60000");
    public static final int BLUE = Color.parseColor("#0048ff");
    public static final String tuneMessage = "in tune";
    private PitchDetectionResult result;
    //public static Uri tone = R.raw.g6;
    public static int frequency;

    final MediaPlayer a4 = MediaPlayer.create(this, R.raw.a4);
    final MediaPlayer a5 = MediaPlayer.create(this, R.raw.a5);
    final MediaPlayer a6 = MediaPlayer.create(this, R.raw.a6);
    final MediaPlayer ab4 = MediaPlayer.create(this, R.raw.ab4);
    final MediaPlayer ab5 = MediaPlayer.create(this, R.raw.ab5);
    final MediaPlayer ab6 = MediaPlayer.create(this, R.raw.ab6);
    final MediaPlayer b4 = MediaPlayer.create(this, R.raw.b4);
    final MediaPlayer b5 = MediaPlayer.create(this, R.raw.b5);
    final MediaPlayer bb4 = MediaPlayer.create(this, R.raw.bb4);
    final MediaPlayer bb5 = MediaPlayer.create(this, R.raw.bb5);
    final MediaPlayer c4 = MediaPlayer.create(this, R.raw.c4);
    final MediaPlayer c5 = MediaPlayer.create(this, R.raw.c5);
    final MediaPlayer c6 = MediaPlayer.create(this, R.raw.c6);
    final MediaPlayer d4 = MediaPlayer.create(this, R.raw.d4);
    final MediaPlayer d5 = MediaPlayer.create(this, R.raw.d5);
    final MediaPlayer d6 = MediaPlayer.create(this, R.raw.d6);
    final MediaPlayer db4 = MediaPlayer.create(this, R.raw.db4);
    final MediaPlayer db5 = MediaPlayer.create(this, R.raw.db5);
    final MediaPlayer db6 = MediaPlayer.create(this, R.raw.db6);
    final MediaPlayer e4 = MediaPlayer.create(this, R.raw.e4);
    final MediaPlayer e5 = MediaPlayer.create(this, R.raw.e5);
    final MediaPlayer e6 = MediaPlayer.create(this, R.raw.e6);
    final MediaPlayer eb4 = MediaPlayer.create(this, R.raw.eb4);
    final MediaPlayer eb5 = MediaPlayer.create(this, R.raw.eb5);
    final MediaPlayer eb6 = MediaPlayer.create(this, R.raw.eb6);
    final MediaPlayer f4 = MediaPlayer.create(this, R.raw.f4);
    final MediaPlayer f5 = MediaPlayer.create(this, R.raw.f5);
    final MediaPlayer f6 = MediaPlayer.create(this, R.raw.f6);
    final MediaPlayer g4 = MediaPlayer.create(this, R.raw.g4 );
    final MediaPlayer g5 = MediaPlayer.create(this, R.raw.g5 );
    final MediaPlayer g6 = MediaPlayer.create(this, R.raw.g6 );
    final MediaPlayer gb4 = MediaPlayer.create(this, R.raw.gb4);
    final MediaPlayer gb5 = MediaPlayer.create(this, R.raw.gb5);
    final MediaPlayer gb6 = MediaPlayer.create(this, R.raw.gb6);






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hearing__level1);
        verdictTextView = (TextView) findViewById(R.id.verdictTextView);
        verdictTextView.setText("NULL");
        requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO},
                AUDIO_PERMISSION_REQUEST_CODE);
/*
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.c6);
        mp.start();*/

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case TunerFragment.AUDIO_PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    tuner.start();
                    Toast.makeText(Hearing_Level1Activity.this, "Tuner started.", Toast.LENGTH_LONG).show();
                } else if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(Hearing_Level1Activity.this, "GuitarTuner needs access to the microphone to function.", Toast.LENGTH_LONG).show();
                    Hearing_Level1Activity.this.finish();
                }
                break;
        }
    }

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

            if(toneRightFlag == 1){
                verdictTextView.setText("fuck yeah");
            }else if (toneRightFlag == 0){
                verdictTextView.setText("oh noes");
            }
        }
    });


    public void playFirstScale(){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.tone);
        mp.start();
    }

    public void playSecondScale(){

    }

    public void playAllScales(){

    }

}
