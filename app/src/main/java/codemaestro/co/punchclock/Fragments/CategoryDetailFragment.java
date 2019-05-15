package codemaestro.co.punchclock.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.NavHostFragment;

import java.util.List;

import codemaestro.co.punchclock.Adapters.GoalsSmallAdapter;
import codemaestro.co.punchclock.Adapters.HabitsSmallAdapter;
import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.Model.Habit;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.GoalViewModel;
import codemaestro.co.punchclock.ViewModel.HabitViewModel;

public class CategoryDetailFragment extends Fragment {

    private TextView categoryTitle;
    private GoalViewModel goalViewModel;
    private HabitViewModel habitViewModel;
    private FrameLayout goalsContainer, habitsContainer;
    private static final String TAG = "CategoryDetailFragment";
    private NavController navController;

    public CategoryDetailFragment() {
        // Required empty public constructor
    }

    public static CategoryDetailFragment newInstance() {
        return new CategoryDetailFragment();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        goalViewModel = ViewModelProviders.of(this).get(GoalViewModel.class);
        habitViewModel = ViewModelProviders.of(this).get(HabitViewModel.class);
        //TODO: Fix this senseless violence against my eyes
//        goalViewModel.getAllCategoryGoals(1).observe(this, new Observer<List<Goal>>() {
//            @Override
//            public void onChanged(@Nullable List<Goal> goals) {
//                goalsAdpater.setCategoryGoals(goals);
//                Log.e(TAG, "goals observers");
//            }
//        });
//        habitViewModel.getHabitsByCategoryId(1).observe(this, new Observer<List<Habit>>() {
//            @Override
//            public void onChanged(@Nullable List<Habit> habits) {
//                habitsAdapter.setHabits(habits);
//                Log.e(TAG, "habits observer");
//            }
//        });

        //TODO: Code that checks to see whether this category has any Goals or Habits
        //TODO: If not, then the create Goals Dialog will appear, then create Habits dialog will appear in that order


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category_detail, container, false);


        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        categoryTitle = view.findViewById(R.id.categoryTitle);
        categoryTitle.setText(getArguments().getString("Category Title"));

        final GoalsSmallAdapter goalsAdpater = new GoalsSmallAdapter(getActivity());

        final RecyclerView goalsRecyclerView = view.findViewById(R.id.goalsRecyclerView);
        goalsRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        goalsRecyclerView.setHasFixedSize(true);
        goalsRecyclerView.setAdapter(goalsAdpater);

        ViewGroup.LayoutParams goalsParams = goalsRecyclerView.getLayoutParams();
        goalsParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        goalsParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        goalsRecyclerView.setLayoutParams(goalsParams);

        final HabitsSmallAdapter habitsAdapter = new HabitsSmallAdapter(getActivity());

        final RecyclerView habitsRecyclerView = view.findViewById(R.id.habitsRecyclerView);
        habitsRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        habitsRecyclerView.setHasFixedSize(true);
        habitsRecyclerView.setAdapter(habitsAdapter);

        ViewGroup.LayoutParams habitsParams = habitsRecyclerView.getLayoutParams();
        goalsParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        habitsParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        habitsRecyclerView.setLayoutParams(habitsParams);







        return view;
    }


}
