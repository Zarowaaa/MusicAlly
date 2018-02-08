package com.mguzy.musically;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import android.widget.Toast;

import com.chrynan.guitartuner.Note;
import com.chrynan.guitartuner.Tuner;
import com.chrynan.guitartuner.TunerFragment;
import com.chrynan.guitartuner.TunerUpdate;
import com.chrynan.guitartuner.tarsos.PitchDetectionResult;

import java.text.DecimalFormat;

import static com.chrynan.guitartuner.TunerFragment.AUDIO_PERMISSION_REQUEST_CODE;

/**
 * Created by Maciej on 15.10.2017.
 */


public class TuneActivity extends Activity {

    private TextView fTextView;
    private TextView nTextView;
    private TextView probTextView;
    private Note note;
    public static final int tolerance = 3;
    public static final int RED = Color.parseColor("#c60000");
    public static final int BLUE = Color.parseColor("#0048ff");
    public static final String tuneMessage = "in tune";
    private PitchDetectionResult result;
    private SpannableStringBuilder accuracyString;
    String frequencyString = "N/A";
    String noteString = "Too quiet";

    //note = new Note(Note.DEFAULT_FREQUENCY);
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case TunerFragment.AUDIO_PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    tuner.start();
                } else if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(TuneActivity.this, "Tuner needs access to the microphone to function.", Toast.LENGTH_LONG).show();
                    TuneActivity.this.finish();
                }
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
        probTextView = (TextView) findViewById(R.id.probTextView);
        probTextView.setText("accuracy not working");
        nTextView = (TextView) findViewById(R.id.noteTextView);
        nTextView.setText("updateNote not working");
        requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO},
                AUDIO_PERMISSION_REQUEST_CODE);
        accuracyString = new SpannableStringBuilder();
    }

    Tuner tuner = new Tuner(new TunerUpdate() {
        @Override
        public void updateNote(Note newNote, PitchDetectionResult newResult) {
            note = newNote;
            result = newResult;
            accuracyString.clear();
            accuracyString.clearSpans();
            //System.out.println("NoteAbove" + note.getNoteAboveFrequency());
            //System.out.println("Difference" + note.getDifference());

            System.out.println("Actual: " + note.getActualFrequency());
            System.out.println(note.getFrequency());

            double toneBetween = note.getNoteAboveFrequency() - note.getNoteBelowFrequency();

            toneBetween = (toneBetween/50);

            if(Math.abs(note.getDifference()) < toneBetween){
                //System.out.println("ok");
            }

            if (newNote.getFrequency() != Note.UNKNOWN_FREQUENCY) {
                frequencyString = String.valueOf(new DecimalFormat("######.##").format(note.getActualFrequency())) + "hz";
                noteString = note.getNote();
            }
            if (newNote.getActualFrequency() < newNote.getFrequency() ) {
                //if (newNote.getActualFrequency() + tolerance >= newNote.getFrequency()) {
                if(Math.abs(note.getDifference()) < toneBetween && newNote.getFrequency() >= newNote.getActualFrequency()){
                    accuracyString.append(tuneMessage);
                    accuracyString.setSpan(new ForegroundColorSpan(RED), 0, tuneMessage.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                } else {
                    accuracyString.append(frequencyString);
                    accuracyString.setSpan(new ForegroundColorSpan(RED), 0, frequencyString.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    accuracyString.append(" / " + note.getFrequency());
                }
            } else {
                //if (newNote.getActualFrequency() - tolerance <= newNote.getFrequency()) {
                if(Math.abs(note.getDifference()) > toneBetween && newNote.getFrequency() < newNote.getActualFrequency()){
                    accuracyString.append(tuneMessage);
                    accuracyString.setSpan(new ForegroundColorSpan(BLUE), 0, tuneMessage.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                } else {
                    accuracyString.append(frequencyString);
                    accuracyString.setSpan(new ForegroundColorSpan(BLUE), 0, frequencyString.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    accuracyString.append(" / " + note.getFrequency());
                }
            }
            fTextView.setText(frequencyString);
            nTextView.setText(noteString);
            probTextView.setText(accuracyString);
        }
    });
}
