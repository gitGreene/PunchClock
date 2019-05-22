package codemaestro.co.punchclock.Fragments;


import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Observable;

import codemaestro.co.punchclock.Model.Habit;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.HabitViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class HabitDetailFragment extends Fragment {

    private TextView habitId, habitName, categoryName, habitCycleValueInMillis,
            startDate, isTimeBased, timeScheduledInMillis, targetDate;
    HabitViewModel habitViewModel;

    public HabitDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_habit, container, false);

        // TODO: Create Habit Detail Layout
        //TODO: Get args?
        habitId = view.findViewById(R.id.habitDetailHabitIdView);
        habitName = view.findViewById(R.id.habitDetailHabitNameView);
        categoryName = view.findViewById(R.id.habitDetailCategoryNameView);
        habitCycleValueInMillis = view.findViewById(R.id.habitDetailHabitCycleValueInMillisView);
        startDate = view.findViewById(R.id.habitDetailStartDateView);
        isTimeBased = view.findViewById(R.id.habitDetailIsTimeBasedView);
        timeScheduledInMillis = view.findViewById(R.id.habitDetailTimeScheduledInMillisView);
        targetDate = view.findViewById(R.id.habitDetailTargetDate);

        habitViewModel = ViewModelProviders.of(this).get(HabitViewModel.class);

        habitViewModel.getHabitByName(getArguments().getString("habit_name")).observe(this, new Observer<Habit>() {
            @Override
            public void onChanged(@Nullable Habit habit) {
                if (habit != null) {
                    habitId.setText("Habit Id: " + habit.getHabitId());
                    habitName.setText("Habit name: " + habit.getHabitName());
                    categoryName.setText("Category name: " + habit.getCategoryName());
                    habitCycleValueInMillis.setText("HabitCycleValueInMillis: " + habit.getHabitCycleValueInMillis());
                    startDate.setText("Start date: " + habit.getStartDate());
                    isTimeBased.setText("IsTimeBased: " + habit.isTimeBased());
                    timeScheduledInMillis.setText("TimeScheduledInMillis: " + habit.getTimeScheduledInMillis());
                    targetDate.setText("Target date: " + habit.getTargetDate());
                }
            }
        });
        return view;
    }

}
