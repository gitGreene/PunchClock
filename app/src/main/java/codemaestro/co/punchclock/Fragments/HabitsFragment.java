package codemaestro.co.punchclock.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import codemaestro.co.punchclock.Adapters.UserHabitAdapter;
import codemaestro.co.punchclock.Model.Habit;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.HabitViewModel;

public class HabitsFragment extends Fragment {
    String TAG = "HabitsFragment";

    public HabitsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_habits, container, false);

        HabitViewModel habitViewModel = ViewModelProviders.of(this).get(HabitViewModel.class);

        RecyclerView recView = view.findViewById(R.id.habit_recycler_view);
        recView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        final UserHabitAdapter adapter = new UserHabitAdapter(getContext());
        recView.setAdapter(adapter);

        habitViewModel.getAllHabits().observe(this, new Observer<List<Habit>>() {
            @Override
            public void onChanged(@Nullable List<Habit> habits) {
                adapter.setUserHabits(habits);
            }
        });
        return view;
    }
}
