package cql.ecci.ucr.ac.ej3fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import androidx.fragment.app.Fragment;

// The fragment must define a listener interface, which is then implemented within the activity
//class
public class ToolbarFragment extends Fragment implements OnSeekBarChangeListener {
    private static int seekvalue = 10;
    private static EditText edittext;
    ToolbarListener activityCallback;
//The following code declares an interface named ToolbarListener on a fragment class named
   // ToolbarFragment
    public interface ToolbarListener {
        //Implement a callback method name onButtonClick, in turn, accepts an integer and a
        //String as arguments
        public void onButtonClick(int fontsize, String text);
    }
    /**
     * This method is called automatically by the Android system when the fragment has been
     initialized and associated with an activity.
     * The method is passed a reference to the activity in which the fragment is contained.
     * The method must store a local reference to this activity and verify that it implements
     the ToolbarListener interface
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
//A reference to the activity will be stored in the local activityCallback
            //variable,
// and an exception will be thorown if that activity does not implement the
                    //ToolbarListener interface
            activityCallback = (ToolbarListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement ToolbarListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {
// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.toolbar_fragment,
                container, false);
        edittext = (EditText) view.findViewById(R.id.editText1);
        final SeekBar seekbar =
                (SeekBar) view.findViewById(R.id.seekBar1);
        seekbar.setOnSeekBarChangeListener(this);
        final Button button =
                (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        return view;
    }
    public void buttonClicked (View view) {
// Call the callback method of the activity from within the fragment.
// When and how this happens is entifely dependent on the circumstances under which the
        //activity needs to be contacted by the fragment
        activityCallback.onButtonClick(seekvalue,
                edittext.getText().toString());
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        seekvalue = progress;
    }
    @Override
    public void onStartTrackingTouch(SeekBar arg0) {
    }
    @Override
    public void onStopTrackingTouch(SeekBar arg0) {
    }
}

