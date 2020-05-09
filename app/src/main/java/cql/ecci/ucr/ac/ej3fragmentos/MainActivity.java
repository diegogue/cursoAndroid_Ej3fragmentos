package cql.ecci.ucr.ac.ej3fragmentos;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;


//The main class extends of FragmentActivity
//This class implements ToolbarFragment.ToolbarListener
public class MainActivity extends FragmentActivity implements
        ToolbarFragment.ToolbarListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onButtonClick(int fontsize, String text) {
//Adds a fragment defined by the TextFragment class so that it appears in the container
        //view with and ID of LinearLayout
        TextFragment textFragment = (TextFragment)
                getSupportFragmentManager().findFragmentById(R.id.text_fragment);
        textFragment.changeTextProperties(fontsize, text);
    }
}