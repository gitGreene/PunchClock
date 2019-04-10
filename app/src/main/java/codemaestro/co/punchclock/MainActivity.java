package codemaestro.co.punchclock;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.navigation.fragment.NavHostFragment;
import codemaestro.co.punchclock.Fragments.CreateCategoryFormFragment;
import codemaestro.co.punchclock.Fragments.GoalsFragment;
import codemaestro.co.punchclock.Fragments.HomeFragment;
import codemaestro.co.punchclock.Fragments.HabitsFragment;
import codemaestro.co.punchclock.Fragments.TimerFragment;
import codemaestro.co.punchclock.ViewModel.CategoryViewModel;
import codemaestro.co.punchclock.ViewModel.GoalViewModel;

public class MainActivity extends FragmentActivity {

    final Fragment fragmentHome = new HomeFragment();
    final Fragment fragmentGoals = new GoalsFragment();
    final Fragment fragmentHabits = new HabitsFragment();
    final Fragment fragmentTimer = new TimerFragment();
    final Fragment createCategoryForm = new CreateCategoryFormFragment();
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

                case R.id.bottom_nav_habits:
                    fm.beginTransaction().hide(activeFragment).show(fragmentHabits).commit();
                    activeFragment = fragmentHabits;
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

        CreateCategoryFormFragment fragment = new CreateCategoryFormFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();


    }


}
