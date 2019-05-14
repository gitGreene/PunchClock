package codemaestro.co.punchclock.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.R;

// This adapter is used in the Goals tab

public class UserGoalAdapter extends RecyclerView.Adapter {
    private List<Goal> userGoals;
    private LayoutInflater inflater;
    private Context context;

    public UserGoalAdapter(Context context) {
        this.context = context;
        this.userGoals = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
    }

    public void setUserGoals(final List<Goal> goals) {
        this.userGoals = goals;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.user_goal_card, viewGroup, false);
        return new UserGoalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        UserGoalViewHolder goalViewHolder = (UserGoalViewHolder) viewHolder;
        goalViewHolder.setUserGoalCard(userGoals.get(position));
    }

    @Override
    public int getItemCount() {
        if (userGoals != null){
            return userGoals.size();
        } else return 0;
    }
}
