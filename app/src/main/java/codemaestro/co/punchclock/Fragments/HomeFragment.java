package codemaestro.co.punchclock.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.Adapters.HomeRecAdapter;
import codemaestro.co.punchclock.ViewModel.CategoryViewModel;
import codemaestro.co.punchclock.ViewModel.GoalViewModel;

public class HomeFragment extends Fragment {

    private CategoryViewModel categoryViewModel;
    private GoalViewModel goalViewModel;
    private TextView textView;
    private HomeRecAdapter homeAdapter;

    String TAG = "HomeFragment";

    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        // VM setup and View references
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        final EditText addCategoryEditText = view.findViewById(R.id.addCategoryEditText);
        Button addCategoryButton = view.findViewById(R.id.addCategoryButton);
        RecyclerView recView = view.findViewById(R.id.homeRecyclerView);

        // Setup RecView/Adapter
        recView.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeAdapter = new HomeRecAdapter(getContext());
        recView.setAdapter(homeAdapter);

        // Observe AllCategories
        categoryViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable List<Category> categories) {
                homeAdapter.setCategories(categories);
            }
        });

        // onClick for adding new category
        addCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Category newCategory = new Category(addCategoryEditText.getText().toString(), "blank", 0, Calendar.getInstance().getTime(), false);
                categoryViewModel.insertCategory(newCategory);
            }
        });

        return view;
    }
}
