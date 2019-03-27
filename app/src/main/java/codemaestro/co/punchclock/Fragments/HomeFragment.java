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
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import codemaestro.co.punchclock.MainActivity;
import codemaestro.co.punchclock.Model.TimeEntry;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.RecViewAdapter;
import codemaestro.co.punchclock.ViewModel.CategoryViewModel;
import codemaestro.co.punchclock.ViewModel.GoalViewModel;

public class HomeFragment extends Fragment {

    private CategoryViewModel categoryViewModel;
    private GoalViewModel goalViewModel;
    private TextView textView;
    private RecViewAdapter adapter;

    String TAG = "HomeFragment";

    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        goalViewModel = ViewModelProviders.of(this).get(GoalViewModel.class);

        textView = view.findViewById(R.id.text);
        Button addButton = view.findViewById(R.id.addButton);
        RecyclerView recView = view.findViewById(R.id.recyclerViewTimer);

        recView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecViewAdapter(getContext());
        recView.setAdapter(adapter);

        categoryViewModel.getEntriesByCategoryId(1).observe(this, new Observer<List<TimeEntry>>() {
            @Override
            public void onChanged(@Nullable List<TimeEntry> timeEntries) {
                if(timeEntries != null) {
                    adapter.setTimeEntries(timeEntries);
                }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1 is Gym's ID
                TimeEntry newEntry = new TimeEntry(1, 0, "00:00:00", "23:59:59", "06/26/91");
                categoryViewModel.insertNewTimeEntry(newEntry);
            }
        });

        return view;
    }
}
