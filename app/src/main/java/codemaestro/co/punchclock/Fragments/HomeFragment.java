package codemaestro.co.punchclock.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

import codemaestro.co.punchclock.Adapters.CreateCategoryAdapter;
import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.Adapters.HomeRecAdapter;
import codemaestro.co.punchclock.ViewModel.CategoryViewModel;
import codemaestro.co.punchclock.ViewModel.GoalViewModel;

public class HomeFragment extends Fragment {

    private CategoryViewModel categoryViewModel;
    private GoalViewModel goalViewModel;
    private TextView textView;

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
        final CreateCategoryAdapter adapter = new CreateCategoryAdapter(getActivity(), getResources());
        recView.setAdapter(adapter);

        // Observe AllCategories
        categoryViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable List<Category> categories) {
                adapter.showDefaultCategories();
            }
        });
        // onClick for adding new category
        return view;
    }
}
