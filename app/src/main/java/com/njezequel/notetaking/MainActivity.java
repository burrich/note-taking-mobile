package com.njezequel.notetaking;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

/**
 * Main class for fragments.
 * Static layout : must extends AppCompatActivity.
 * Dynamic layout : must extends FragmentActivity.
 */
public class MainActivity
        extends FragmentActivity
        implements NotesListFragment.OnNotesListSelectedListener {

    private static final String DEBUG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
         * Static fragment process.
         * These two lines are the only lines required for a static fragment container.
         */
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        /*
         * Dynamic fragment process.
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            // Add notes list fragment
            NotesListFragment notesListFragment = new NotesListFragment();
//            notesListFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, notesListFragment)
                    .commit();
            Log.d(DEBUG_TAG, "END onCreate");
        }
    }

    @Override
    public void onNoteSelected(int position) {
        Log.d(DEBUG_TAG, "LIST POSITION : " + position);

        // Replace by note fragment
        NoteFragment noteFragment = new NoteFragment();
        Bundle args = new Bundle();
        args.putInt(NoteFragment.ARG_POSITION, position);
        noteFragment.setArguments(args);
        // nb : setArguments allow not restoring instance state of the fragment

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, noteFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
