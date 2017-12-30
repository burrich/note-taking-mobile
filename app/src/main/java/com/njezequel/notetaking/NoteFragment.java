package com.njezequel.notetaking;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteFragment extends Fragment {

    final static String ARG_POSITION = "position";

    public NoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args != null) {
            updateNoteView(args.getInt(ARG_POSITION));
        }
    }

    private void updateNoteView(int position) {
        TextView note = getActivity().findViewById(R.id.note);
        note.setText(Data.notes[position]);
    }
}
