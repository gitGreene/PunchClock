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


import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity {
    private NavController navController;
    private BottomNavigationView bottomNav;
    private int selectedItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottom_nav_view);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //Set to -1 as a flag to go to HomeFragment with  no transition
        selectedItem = -1;
//        NavigationUI.setupWithNavController(bottomNav, navController);

        //Todo: Add animations
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                navigateToFragment(menuItem);
                return false;
            }
        });
    }

    private void navigateToFragment(MenuItem menuItem) {

        if (selectedItem == -1) {
            navController.navigate(menuItem.getItemId());
        } else {
            switch (menuItem.getItemId()) {
                case R.id.homeFragment:
                    if (selectedItem == R.id.goalsFragment) {
                        navController.navigate(R.id.action_goalsFragment_to_homeFragment);
                    } else if (selectedItem == R.id.habitsFragment) {
                        navController.navigate(R.id.action_habitsFragment_to_homeFragment);
                    } else if (selectedItem == R.id.timerFragment) {
                        navController.navigate(R.id.action_timerFragment_to_homeFragment);
                    }
                    break;
                case R.id.goalsFragment:
                    if (selectedItem == R.id.homeFragment) {
                        navController.navigate(R.id.action_homeFragment_to_goalsFragment);
                    } else if (selectedItem == R.id.habitsFragment) {
                        navController.navigate(R.id.action_habitsFragment_to_goalsFragment);
                    } else if (selectedItem == R.id.timerFragment) {
                        navController.navigate(R.id.action_timerFragment_to_goalsFragment);
                    }
                    break;
                case R.id.habitsFragment:
                    if (selectedItem == R.id.homeFragment) {
                        navController.navigate(R.id.action_homeFragment_to_habitsFragment);
                    } else if (selectedItem == R.id.goalsFragment) {
                        navController.navigate(R.id.action_goalsFragment_to_habitsFragment);
                    } else if (selectedItem == R.id.timerFragment) {
                        navController.navigate(R.id.action_timerFragment_to_habitsFragment);
                    }
                    break;
                case R.id.timerFragment:
                    if (selectedItem == R.id.homeFragment) {
                        navController.navigate(R.id.action_homeFragment_to_timerFragment);
                    } else if (selectedItem == R.id.goalsFragment) {
                        navController.navigate(R.id.action_goalsFragment_to_timerFragment);
                    } else if (selectedItem == R.id.habitsFragment) {
                        navController.navigate(R.id.action_habitsFragment_to_timerFragment);
                    }
                    break;
            }
        }
        selectedItem = menuItem.getItemId();


        //TODO: Fix the bottom nav item selected not changing on navigation
        // uncheck the other items.
        for (int i = 0; i < bottomNav.getMenu().size(); i++) {
            MenuItem item = bottomNav.getMenu().getItem(i);
            if (item.getItemId() == menuItem.getItemId()) {
                item.isChecked();
            }
        }
    }
}

//// uncheck the other items.
//    for (i in 0 until bottomNav!!.menu.size()) {
//            val menuItem = bottomNav!!.menu.getItem(i)
//            if (menuItem.itemId == item.itemId) menuItem.isChecked = true
//            }