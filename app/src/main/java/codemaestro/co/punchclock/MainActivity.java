package codemaestro.co.punchclock;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import codemaestro.co.punchclock.Fragments.GoalsFragment;
import codemaestro.co.punchclock.Fragments.HomeFragment;
import codemaestro.co.punchclock.Fragments.MilestonesFragment;
import codemaestro.co.punchclock.Fragments.TimerFragment;
import codemaestro.co.punchclock.ViewModel.CategoryViewModel;
import codemaestro.co.punchclock.ViewModel.GoalViewModel;

public class MainActivity extends AppCompatActivity {

    final Fragment fragmentHome = new HomeFragment();
    final Fragment fragmentGoals = new GoalsFragment();
    final Fragment fragmentMilestones = new MilestonesFragment();
    final Fragment fragmentTimer = new TimerFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment activeFragment = fragmentHome;


    //TODO: Add animations
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


        // TODO: Pull-to-refresh
//        SwipeRefreshLayout swipeRefreshLayout =
//                (SwipeRefreshLayout) root.findViewById(R.id.refresh_layout);
//        swipeRefreshLayout.setColorSchemeColors(
//                ContextCompat.getColor(getActivity(), R.color.colorPrimary),
//                ContextCompat.getColor(getActivity(), R.color.colorAccent),
//                ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark));
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                
//            }
//        });

    } // End onCreate

    public String getHelloWorldString() {
        String test = "Hello World";
        return test;
    }



}
