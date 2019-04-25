package codemaestro.co.punchclock.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import codemaestro.co.punchclock.Adapters.GoalsSmallAdapter;
import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.GoalViewModel;

public class CategoryDetailFragment extends Fragment {

    private TextView categoryTitle;
    private GoalViewModel goalViewModel;
    private static final String TAG = "CategoryDetailFragment";

    public CategoryDetailFragment() {
        // Required empty public constructor
    }

    public static CategoryDetailFragment newInstance() {
        return new CategoryDetailFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_detail, container, false);
        goalViewModel = ViewModelProviders.of(this).get(GoalViewModel.class);
        final GoalsSmallAdapter goalsAdpater = new GoalsSmallAdapter(getActivity());

        goalViewModel.getGoalsByCategoryId(1).observe(this, new Observer<List<Goal>>() {
            @Override
            public void onChanged(@Nullable List<Goal> goals) {
                goalsAdpater.setCategoryGoals(goals);
                Log.e(TAG, "goals observers");
            }
        });

        categoryTitle = view.findViewById(R.id.categoryTitle);
        final RecyclerView goalsRecyclerView = view.findViewById(R.id.goalsRecyclerView);
        goalsRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        goalsRecyclerView.setAdapter(goalsAdpater);

//        final RecyclerView habitsRecyclerView = view.findViewById(R.id.habitsRecyclerView);

        return view;
    }



}
