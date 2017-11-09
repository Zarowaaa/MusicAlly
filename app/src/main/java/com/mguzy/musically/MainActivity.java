package com.mguzy.musically;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chrynan.guitartuner.Note;
import com.chrynan.guitartuner.Tuner;
import com.chrynan.guitartuner.TunerActivity;
import com.chrynan.guitartuner.TunerFragment;
import com.chrynan.guitartuner.TunerUpdate;
import com.chrynan.guitartuner.tarsos.PitchDetectionResult;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

import static com.chrynan.guitartuner.TunerFragment.AUDIO_PERMISSION_REQUEST_CODE;

/**
 * Created by Maciej on 15.10.2017.
 */


public class MainActivity extends Activity {

    private TextView fTextView;
    private TextView nTextView;
    private Note note;
    private String noteString;
    private PitchDetectionResult result;

    //note = new Note(Note.DEFAULT_FREQUENCY);
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        switch(requestCode) {
            case TunerFragment.AUDIO_PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    tuner.start();
                } else if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(MainActivity.this, "GuitarTuner needs access to the microphone to function.", Toast.LENGTH_LONG).show();
                    MainActivity.this.finish();
                } else
                    Toast.makeText(MainActivity.this, "tumtfqawejfgaos", Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuner_layout);
        fTextView = (TextView) findViewById(R.id.frequencyTextView);
        fTextView.setText("frequency not working");
        nTextView = (TextView) findViewById(R.id.noteTextView);
        nTextView.setText("updateNote not working");
        requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO},
                AUDIO_PERMISSION_REQUEST_CODE);

    }
    Tuner tuner = new Tuner(new TunerUpdate() {
        @Override
        public void updateNote(Note newNote, PitchDetectionResult newResult) {

            note = newNote;
            result = newResult;

            String aFreq = "N/A";
            String noteString = "N/A";

            if(newNote.getFrequency() != Note.UNKNOWN_FREQUENCY) {
                aFreq = String.valueOf(new DecimalFormat("######.##").format(note.getActualFrequency()));
                noteString = note.getNote();
            }
            fTextView.setText(aFreq);
            nTextView.setText(noteString);
        }
    });
}
