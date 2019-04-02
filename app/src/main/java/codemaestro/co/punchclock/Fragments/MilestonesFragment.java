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

import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.HomeRecAdapter;

public class MilestonesFragment extends Fragment {

    private HomeRecAdapter milestonesAdapter;
    String TAG = "MilestonesFragment";

    public MilestonesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_milestones, container, false);

        RecyclerView recView = view.findViewById(R.id.recyclerViewMilestones);
        recView.setLayoutManager(new LinearLayoutManager(getActivity()));
        milestonesAdapter = new HomeRecAdapter(getContext());
        recView.setAdapter(milestonesAdapter);
        return view;
    }
}
