package codemaestro.co.punchclock.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import codemaestro.co.punchclock.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HabitDetailFragment extends Fragment {

    private TextView habitName;


    public HabitDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_habit_detail, container, false);


        // TODO: Create Habit Detail Layout

        return view;
    }

}
