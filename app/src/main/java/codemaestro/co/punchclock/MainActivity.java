package codemaestro.co.punchclock;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import codemaestro.co.punchclock.Fragments.GoalsFragment;
import codemaestro.co.punchclock.Fragments.HomeFragment;
import codemaestro.co.punchclock.Fragments.MilestonesFragment;
import codemaestro.co.punchclock.Fragments.TimerFragment;
import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.Model.TimeEntry;
import codemaestro.co.punchclock.ViewModel.CategoryViewModel;
import codemaestro.co.punchclock.ViewModel.GoalViewModel;

public class MainActivity extends AppCompatActivity {

    final Fragment fragmentHome = new HomeFragment();
    final Fragment fragmentGoals = new GoalsFragment();
    final Fragment fragmentMilestones = new MilestonesFragment();
    final Fragment fragmentTimer = new TimerFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment activeFragment = fragmentHome;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.bottom_nav_home:
                    fm.beginTransaction().hide(activeFragment).show(fragmentHome).commit();
                    activeFragment = fragmentHome;
                    return true;

                case R.id.bottom_nav_goals:
                    fm.beginTransaction().hide(activeFragment).show(fragmentGoals).commit();
                    activeFragment = fragmentGoals;
                    return true;

                case R.id.bottom_nav_milestones:
                    fm.beginTransaction().hide(activeFragment).show(fragmentMilestones).commit();
                    activeFragment = fragmentMilestones;
                    return true;

                case R.id.bottom_nav_timer:
                    fm.beginTransaction().hide(activeFragment).show(fragmentTimer).commit();
                    activeFragment = fragmentTimer;
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bottom Nav
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavView);
        bottomNav.setOnNavigationItemSelectedListener(onNavItemSelectedListener);

        fm.beginTransaction().add(R.id.main_container, fragmentTimer, "4").hide(fragmentTimer).commit();
        fm.beginTransaction().add(R.id.main_container, fragmentMilestones, "3").hide(fragmentMilestones).commit();
        fm.beginTransaction().add(R.id.main_container, fragmentGoals, "2").hide(fragmentGoals).commit();
        fm.beginTransaction().add(R.id.main_container, fragmentHome, "1").commit();

        // Get Category by Name Data Stream
//        String name = "Gym";
//        categoryViewModel.getCategoryByName(name).observe(this, new Observer<Category>() {
//            @Override
//            public void onChanged(@Nullable Category category) {
//                if(category != null) {
//                    textView.setText(category.getCategoryName());
//                } else {
//                    Toast.makeText(getApplicationContext(), "There is no category created", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

        // Get All Categories Data Stream
//        categoryViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
//            @Override
//            public void onChanged(@Nullable List<Category> categories) {
//                if(categories != null) {
//                    Category category = categories.get(0);
//                    String name = category.getCategoryName();
//                    textView.setText(name);
//                } else {
//                    Toast.makeText(getApplicationContext(), "There is no category created", Toast.LENGTH_LONG).show();
//                }
//            }
//        });


        // How to create a goal
//        Goal goal = new Goal(1, "30DayChallenge", "Start Date", "End Date", 0, 24, 0);
//        goalViewModel.insertNewGoal(goal);

        // Get Specific Goal Data Stream
        // Need to search by goalName and parentCategoryName
//        goalViewModel.getCurrentGoal("30DayChallenge", 1).observe(this, new Observer<Goal>() {
//            @Override
//            public void onChanged(@Nullable Goal goal) {
//                Goal usableGoal = null;
//                if(goal != null) {
//                    usableGoal = goal;
//                    textView.setText(usableGoal.getGoalName());
//                } else {
//                    Toast.makeText(getApplicationContext(), "There is no goal created", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

        // Get All Goals of a specific Category
//        goalViewModel.getGoalsByCategoryId(1).observe(this, new Observer<List<Goal>>() {
//            @Override
//            public void onChanged(@Nullable List<Goal> goals) {
//                Goal goal = null;
//                if(goals != null) {
//                    goal = goals.get(0);
//                    textView.setText(goal.getGoalName());
//                }
//            }
//        });
//        TODO: Fix fetching the Time Entries for specific Categories
//        How to create a Time Entry
//        TimeEntry timeEntry = new TimeEntry(1, 0, "Start Date", "End Date", "Date of Entry");
//        categoryViewModel.insertNewTimeEntry(timeEntry);
//
//         How to get all Time Entries by Category ID
//        categoryViewModel.getEntriesByCategoryId(1).observe(this, new Observer<List<TimeEntry>>() {
//            @Override
//            public void onChanged(@Nullable List<TimeEntry> timeEntries) {
//                TimeEntry usableTimeEntry = null;
//                if(timeEntries != null) {
//                    usableTimeEntry = timeEntries.get(0);
//                    textView.setText(usableTimeEntry.getDateOfEntry());
//                }
//            }
//        });
    } // End onCreate
}
