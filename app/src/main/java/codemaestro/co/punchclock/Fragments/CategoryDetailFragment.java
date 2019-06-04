package codemaestro.co.punchclock.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.navigation.NavController;

import java.util.ArrayList;
import java.util.List;

import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.CategoryViewModel;
import codemaestro.co.punchclock.ViewModel.GoalViewModel;
import codemaestro.co.punchclock.ViewModel.HabitViewModel;

public class CategoryDetailFragment extends Fragment {

    private TextView categoryTitle, categoryDescription, goalOneView, goalTwoView, goalThreeView, habitOneView, habitTwoView, habitThreeView;
    private GoalViewModel goalViewModel;
    private HabitViewModel habitViewModel;
    private FrameLayout goalsContainer, habitsContainer;
    private static final String TAG = "CategoryDetailFragment";
    private NavController navController;

    private ViewPager categoryDetailViewPager;
    private TabLayout tabLayout;
    View view;
    DetailAdapter adapter;

    public CategoryDetailFragment() {
        // Required empty public constructor
    }

    public static CategoryDetailFragment newInstance() {
        return new CategoryDetailFragment();
    }

    private void setupViewPager(ViewPager viewPager) {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_category, container, false);
        CategoryViewModel categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        GoalViewModel goalViewModel = ViewModelProviders.of(this).get(GoalViewModel.class);
        HabitViewModel habitViewModel = ViewModelProviders.of(this).get(HabitViewModel.class);
        categoryTitle = view.findViewById(R.id.categoryTitle);

        categoryDetailViewPager = view.findViewById(R.id.categoryDetailViewPager);
        tabLayout = view.findViewById(R.id.categoryDetailTabLayout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


        //Here we have to pass ChildFragmentManager instead of FragmentManager.
        adapter = new DetailAdapter(getChildFragmentManager());
        adapter.addFragment(new CategoryDetailGoalTab(), "Goals");
        adapter.addFragment(new CategoryDetailHabitTab(), "Habits");
        adapter.addFragment(new CategoryDetailJournalTab(), "Journal");
        categoryDetailViewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(categoryDetailViewPager);


        String money = getArguments().getString("category_title");
        categoryViewModel.getCurrentCategory(money).observe(this, new Observer<Category>() {
            @Override
            public void onChanged(@Nullable Category category) {
                categoryTitle.setText(category.getCategoryName());
            }
        });

        return view;
    }

    static class DetailAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragments = new ArrayList<>();
        private final List<String> fragmentTitles = new ArrayList<>();

        DetailAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            fragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitles.get(position);
        }
    }


}


// To go in onCreateView

//categoryDescription = view.findViewById(R.id.categoryDescription);
//        goalOneView = view.findViewById(R.id.categoryDetailGoalOne);
//        goalTwoView = view.findViewById(R.id.categoryDetailGoalTwo);
//        habitOneView = view.findViewById(R.id.categoryDetailHabitOne);
//        habitTwoView = view.findViewById(R.id.categoryDetailHabitTwo);
//goalViewModel.getAllCategoryGoals(money).observe(this, new Observer<List<Goal>>() {
//            @Override
//            public void onChanged(@Nullable List<Goal> goals) {
//                if (goals != null) {
//                    Goal goalOne = goals.get(0);
//                    goalOneView.setText(goalOne.getGoalName());
//                    goalTwoView.setText(goals.get(1).getGoalName());
////                goalOneView.setText(""+goals.get(3));
//                }
//            }
//        });
//
//        habitViewModel.getHabitsByCategoryName(money).observe(this, new Observer<List<Habit>>() {
//            @Override
//            public void onChanged(@Nullable List<Habit> habits) {
//                if (habits != null) {
//                    habitOneView.setText(habits.get(0).getHabitName());
//                    habitTwoView.setText(habits.get(1).getHabitName());
//                }
//            }
//        });

//
// To go in onCreateView
//        final GoalsSmallAdapter goalsAdpater = new GoalsSmallAdapter(getActivity());

//        final RecyclerView goalsRecyclerView = view.findViewById(R.id.goalsRecyclerView);
//        goalsRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
//        goalsRecyclerView.setHasFixedSize(true);
//        goalsRecyclerView.setAdapter(goalsAdpater);

//        ViewGroup.LayoutParams goalsParams = goalsRecyclerView.getLayoutParams();
//        goalsParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//        goalsParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
//        goalsRecyclerView.setLayoutParams(goalsParams);

//        final HabitsSmallAdapter habitsAdapter = new HabitsSmallAdapter(getActivity());
//
//        final RecyclerView habitsRecyclerView = view.findViewById(R.id.habitsRecyclerView);
//        habitsRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
//        habitsRecyclerView.setHasFixedSize(true);
//        habitsRecyclerView.setAdapter(habitsAdapter);
//
//        ViewGroup.LayoutParams habitsParams = habitsRecyclerView.getLayoutParams();
//        goalsParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//        habitsParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
//        habitsRecyclerView.setLayoutParams(habitsParams);