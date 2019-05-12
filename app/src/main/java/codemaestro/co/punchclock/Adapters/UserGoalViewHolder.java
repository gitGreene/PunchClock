package codemaestro.co.punchclock.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import codemaestro.co.punchclock.Model.Goal;

public class UserGoalViewHolder extends RecyclerView.ViewHolder {
    private TextView goalNameView;

    public UserGoalViewHolder(@NonNull View itemView) {
        super(itemView);
        //goalNameView = itemView.findViewById(R.id.);
    }

    public void setUserGoalCard(final Goal goal) {
        goalNameView.setText(goal.getGoalName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
