package codemaestro.co.punchclock.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.List;

import codemaestro.co.punchclock.Adapters.UserCategoryAdapter;
import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.CategoryViewModel;
import codemaestro.co.punchclock.ViewModel.GoalViewModel;

public class HomeFragment extends Fragment {

    private CategoryViewModel categoryViewModel;
    String TAG = "HomeFragment";

    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        // VM setup and View references
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        RecyclerView recView = view.findViewById(R.id.category_recycler_view);

        // Setup RecView/Adapter
        recView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        final UserCategoryAdapter adapter = new UserCategoryAdapter(getActivity());
        recView.setAdapter(adapter);

        // Observe AllCategories
        categoryViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable List<Category> categories) {
                adapter.setUserCategories(categories);
            }
        });
        // onClick for adding new category
        return view;
    }
}
