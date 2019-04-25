package codemaestro.co.punchclock.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.R;

public class GoalsSmallAdapter extends RecyclerView.Adapter {

    private LayoutInflater inflater;
    private List<Goal> goals;
    private Context context;

    public GoalsSmallAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public void setCategoryGoals(List<Goal> goals) {
        this.goals = goals;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = inflater.inflate(R.layout.goal_small_card, viewGroup, false);
        return new GoalsSmallViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        GoalsSmallViewHolder viewHolder1 = (GoalsSmallViewHolder) viewHolder;
        viewHolder1.setSmallGoalCard(goals.get(position));
    }

    @Override
    public int getItemCount() {
        return goals.size();
    }


    private static class GoalsSmallViewHolder extends RecyclerView.ViewHolder {

        private TextView goalName;

        public GoalsSmallViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            goalName = itemView.findViewById(R.id.goalName);
        }

        public void setSmallGoalCard(Goal goal) {
            goalName.setText(goal.getGoalName());
        }
    }
}
