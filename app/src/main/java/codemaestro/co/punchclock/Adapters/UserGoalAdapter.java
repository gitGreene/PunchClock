package codemaestro.co.punchclock.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import codemaestro.co.punchclock.Model.Goal;

// This adapter is used in the Goals tab

public class UserGoalAdapter extends RecyclerView.Adapter {
    private List<Goal> userGoals;
    private Context context;

    public UserGoalAdapter(Context context) {
        this.context = context;
        this.userGoals = new ArrayList<>();
    }

    public void setUserGoals(final List<Goal> goals) {
        this.userGoals = goals;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Inflate view
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        // Bind the Data
    }

    @Override
    public int getItemCount() {
        if (userGoals != null){
            return userGoals.size();
        } else return 0;
    }
}
