package com.mguzy.musically.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chrynan.guitartuner.Note;
import com.chrynan.guitartuner.Tuner;
import com.chrynan.guitartuner.TunerUpdate;
import com.chrynan.guitartuner.tarsos.PitchDetectionResult;

import java.text.DecimalFormat;

/**
 * Created by Maciej on 09.11.2017.
 */

/*public class TunerView extends LinearLayout {

    private TextView fTextView;
    private TextView pTextView;
    private Note note;
    private PitchDetectionResult result;

    public TunerView(Context context) {
        super(context);
        //init(context, null);
    }

    Tuner tuner = new Tuner(new TunerUpdate() {
        @Override
        public void updateNote(Note newNote, PitchDetectionResult newResult) {

            tuner.start();
            note = newNote;
            result = newResult;
            String aFreq = "setFreq not working";

            if(newNote.getFrequency() != Note.UNKNOWN_FREQUENCY) {
                aFreq = String.valueOf(new DecimalFormat("######.##").format(note.getActualFrequency()));
            }

            //fTextView.setText(aFreq);
        }


    }
}
        */
