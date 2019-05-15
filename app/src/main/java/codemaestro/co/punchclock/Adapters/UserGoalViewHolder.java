package codemaestro.co.punchclock.Adapters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import androidx.navigation.Navigation;

import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.R;

class UserGoalViewHolder extends RecyclerView.ViewHolder {
    private TextView goalCardTitle;
    private TextView goalCardCategoryName;

    UserGoalViewHolder(@NonNull View itemView) {
        super(itemView);
        goalCardTitle = itemView.findViewById(R.id.goalCardTitle);
        goalCardCategoryName = itemView.findViewById(R.id.goalCardCategoryName);
    }

    void setUserGoalCard(final Goal goal) {
        goalCardTitle.setText(goal.getGoalName());
        goalCardCategoryName.setText(goal.getCategoryName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("Category Title", goal.getGoalName());
                Navigation.findNavController(view).navigate(R.id.action_goalsFragment_to_goalDetailFragment, bundle);
            }
        });
    }
}
