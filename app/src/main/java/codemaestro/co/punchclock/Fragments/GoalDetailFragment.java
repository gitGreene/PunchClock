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
public class GoalDetailFragment extends Fragment {

    private TextView goalName;
    private static final String GOAL_NAME_TAG = "GOAL_NAME";

    public GoalDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goal_detail, container, false);
        goalName = view.findViewById(R.id.goalName);
        goalName.setText(getArguments().getString(GOAL_NAME_TAG));

        // TODO: Create Habit Detail Layout

        return view;
    }

}
