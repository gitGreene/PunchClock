package codemaestro.co.punchclock.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import codemaestro.co.punchclock.HomeRecAdapter;
import codemaestro.co.punchclock.R;

public class HabitsFragment extends Fragment {
    private HomeRecAdapter habitsAdapter;
    String TAG = "HabitsFragment";

    public HabitsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_habits, container, false);

        RecyclerView recView = view.findViewById(R.id.recyclerViewHabits);
        recView.setLayoutManager(new LinearLayoutManager(getActivity()));
        habitsAdapter = new HomeRecAdapter(getContext());
        recView.setAdapter(habitsAdapter);
        return view;
    }
}
