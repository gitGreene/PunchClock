package codemaestro.co.punchclock.Fragments;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.Model.Habit;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.GoalViewModel;
import codemaestro.co.punchclock.ViewModel.HabitViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoalDetailFragment extends Fragment {

    private TextView goalId, goalName, categoryName, startDate, goalTargetDate, isGoalRecurring, isGoalTimeBased, goalGoalTime;
//    private static final String GOAL_NAME_TAG = "GOAL_NAME";

    public GoalDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_goal, container, false);
//        goalName = view.findViewById(R.id.goalName);
//        goalName.setText(getArguments().getString(GOAL_NAME_TAG));

        // TODO: Create Habit Detail Layout
        goalId = view.findViewById(R.id.goalDetailGoalIdView);
        goalName = view.findViewById(R.id.goalDetailGoalNameView);
        categoryName = view.findViewById(R.id.goalDetailCategoryView);
        startDate = view.findViewById(R.id.goalDetailStartDateView);
        goalTargetDate = view.findViewById(R.id.goalDetailGoalTargetDateView);
        isGoalRecurring = view.findViewById(R.id.goalDetailIsGoalRecurringView);
        isGoalTimeBased = view.findViewById(R.id.goalDetailIsGoalTimeBasedView);
        goalGoalTime = view.findViewById(R.id.goalDetailGoalGoalTimeView);

        GoalViewModel goalViewModel = ViewModelProviders.of(this).get(GoalViewModel.class);


        goalViewModel.getGoalByName(getArguments().getString("goal_name")).observe(this, new Observer<Goal>() {
            @Override
            public void onChanged(@Nullable Goal goal) {
                goalId.setText("Goal Id: " + goal.getGoalId());
                goalName.setText("Goal Name: " + goal.getGoalName());
                categoryName.setText("Category: " + goal.getCategoryName());
                startDate.setText("StartDate: "+goal.getStartDate());
                goalTargetDate.setText("GoalTargetDate"+goal.getGoalTargetDate());
                isGoalRecurring.setText("IsGoalRecurring: "+goal.isGoalRecurring());
                isGoalTimeBased.setText("IsGoalTimeBased: "+goal.isGoalTimeBased());
                goalGoalTime.setText("GoalGoalTime: "+goal.getGoalName());
            }
        });
        return view;
    }

}
