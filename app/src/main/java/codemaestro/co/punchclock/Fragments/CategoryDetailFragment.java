package codemaestro.co.punchclock.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.List;

import codemaestro.co.punchclock.Adapters.GoalsSmallAdapter;
import codemaestro.co.punchclock.Adapters.HabitsSmallAdapter;
import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.Model.Habit;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.CategoryViewModel;
import codemaestro.co.punchclock.ViewModel.GoalViewModel;
import codemaestro.co.punchclock.ViewModel.HabitViewModel;

public class CategoryDetailFragment extends Fragment {

    private TextView categoryTitle, goalOneView, goalTwoView, goalThreeView, habitOneView, habitTwoView, habitThreeView;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_category, container, false);
        CategoryViewModel categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        GoalViewModel goalViewModel = ViewModelProviders.of(this).get(GoalViewModel.class);
        HabitViewModel habitViewModel = ViewModelProviders.of(this).get(HabitViewModel.class);
        categoryTitle = view.findViewById(R.id.categoryTitle);

        categoryViewModel.getCurrentCategory(getArguments().getString("category_title")).observe(this, new Observer<Category>() {
            @Override
            public void onChanged(@Nullable Category category) {
                if(category != null) {
                    categoryTitle.setText(category.getCategoryName());
                } else {
                    categoryTitle.setText("Ya stupid fuck it didn't work");
                }


            }
        });

        goalViewModel.getAllCategoryGoals(1).observe(this, new Observer<List<Goal>>() {
            @Override
            public void onChanged(@Nullable List<Goal> goals) {
//                goalOneView.setText(""+goals.get(1));
//                goalOneView.setText(""+goals.get(2));
//                goalOneView.setText(""+goals.get(3));
            }
        });

        //Todo: Habit



        return view;
    }


}
