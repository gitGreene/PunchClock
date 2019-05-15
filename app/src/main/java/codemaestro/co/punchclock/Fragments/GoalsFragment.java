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

import codemaestro.co.punchclock.Adapters.UserCategoryAdapter;
import codemaestro.co.punchclock.Adapters.UserGoalAdapter;
import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.GoalViewModel;

public class GoalsFragment extends Fragment {
    String TAG = "GoalsFragment";

    public GoalsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_goals, container, false);

        GoalViewModel goalViewModel = ViewModelProviders.of(this).get(GoalViewModel.class);

        RecyclerView recView = view.findViewById(R.id.goal_recycler_view);
        recView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        final UserGoalAdapter adapter = new UserGoalAdapter(getActivity());
        recView.setAdapter(adapter);

        goalViewModel.getAllGoals().observe(this, new Observer<List<Goal>>() {
            @Override
            public void onChanged(@Nullable List<Goal> goals) {
                adapter.setUserGoals(goals);
            }
        });
        return view;
    }
}
