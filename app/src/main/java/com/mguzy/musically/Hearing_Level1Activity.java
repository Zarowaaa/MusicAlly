package com.mguzy.musically;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.MediaPlayer;
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

    private TextView resultTextView;
    public TextView verdictTextView;
    private Note note;
    public static final int tolerance = 5;
    public static final int RED = Color.parseColor("#c60000");
    public static final int BLUE = Color.parseColor("#0048ff");
    public static final String tuneMessage = "in tune";
    private PitchDetectionResult result;


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

            if(note.getActualFrequency() > 1046-tolerance && note.getActualFrequency() < 1046+tolerance ){
                verdictTextView.setText("fuck yeah");
                resultTextView.setText("fuck yeah");
            }else verdictTextView.setText("oh noes");


            /*Handler handler = new Handler();
            final Runnable r = new Runnable(){
                public void run() {
                    if(note.getActualFrequency() > 1046+tolerance || note.getActualFrequency() < 1046+tolerance ){
                        verdictTextView.setText("fuck yeah");
                        resultTextView.setText("fuck yeah");
                    }else verdictTextView.setText("oh noes");
                }
            };
            handler.postDelayed(r, 5000);*/
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hearing__level1);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        resultTextView.setText("NULL");
        verdictTextView = (TextView) findViewById(R.id.verdictTextView);
        verdictTextView.setText("NULL");
        requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO},
                AUDIO_PERMISSION_REQUEST_CODE);

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.c6);
        mp.start();

    }


}
