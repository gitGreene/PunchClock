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
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import codemaestro.co.punchclock.Fragments.CreateCategoryFormFragment;
import codemaestro.co.punchclock.Fragments.GoalsFragment;
import codemaestro.co.punchclock.Fragments.HomeFragment;
import codemaestro.co.punchclock.Fragments.HabitsFragment;
import codemaestro.co.punchclock.Fragments.TimerFragment;
import codemaestro.co.punchclock.ViewModel.CategoryViewModel;
import codemaestro.co.punchclock.ViewModel.GoalViewModel;

public class MainActivity extends FragmentActivity {
    private NavController navController;
    private BottomNavigationView bottomNav;
    private int selectedItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottom_nav_view);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNav, navController);

        //Todo: Add animations
//        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                navigateToFragment(menuItem);
//                return false;
//            }
//        });



    }

    private void navigateToFragment(MenuItem menuItem) {
//        if (selectedItem == -1) {
//            navController.navigate(menuItem.getItemId());
//        } else {
//            switch(menuItem.getItemId()) {
//                case R.id.homeFragment:
//                    if (selectedItem == R.id.goalsFragment) {
//                        navController.navigate(R.id.action_homeFragment_to_goalsFragment);
//                    } else if (selectedItem == R.id.habitsFragment) {
//                        navController.navigate(R.id.action_homeFragment_to_habitsFragment);
//                    } else if (selectedItem == R.id.timerFragment) {
//                        navController.navigate(R.id.action_homeFragment_to_timerFragment);
//                    }
//                    break;
//                case R.id.goalsFragment:
//                    if (selectedItem == R.id.homeFragment) {
//                        navController.navigate(R.id.action_goalsFragment_to_homeFragment);
//                    } else if (selectedItem == R.id.habitsFragment) {
//                        navController.navigate(R.id.action_goalsFragment_to_habitsFragment);
//                    } else if (selectedItem == R.id.timerFragment) {
//                        navController.navigate(R.id.action_homeFragment_to_timerFragment);
//                     }
//                    break;
////                case R.id.habitsFragment: navController.navigate(R.id.action_homeFragment_to_habitsFragment);
////                    break;
////                case R.id.timerFragment: navController.navigate(R.id.action_homeFragment_to_timerFragment);
////                    break;
//            }
//
//            selectedItem = menuItem.getItemId();
//
//        }
    }


}
