package codemaestro.co.punchclock;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import codemaestro.co.punchclock.Adapters.CategoryTemplateViewHolder;
import codemaestro.co.punchclock.ViewModel.CreateCategoryViewModel;

public class MainActivity extends AppCompatActivity implements CategoryTemplateViewHolder.TemplateCardListener {
    private NavController navController;
    private BottomNavigationView bottomNav;
    private FloatingActionButton fab;
    private CreateCategoryViewModel createCategoryViewModel;
    private int selectedItem;
    public static final String TAG = "MainActivity: ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createCategoryViewModel = ViewModelProviders.of(this).get(CreateCategoryViewModel.class);




        bottomNav = findViewById(R.id.bottom_nav_view);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNav, navController);
    }

    @Override
    public void onCreateButtonClicked(String categoryTitle) {
        createCategoryViewModel.triggerCategoryWizard(categoryTitle);
        Log.e(TAG, "Create Button MainActivity Listener");
    }
}
