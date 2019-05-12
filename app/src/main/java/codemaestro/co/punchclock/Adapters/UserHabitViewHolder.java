package codemaestro.co.punchclock.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.Model.Habit;

public class UserHabitViewHolder extends RecyclerView.ViewHolder {
    private TextView habitNameView;

    public UserHabitViewHolder(@NonNull View itemView) {
        super(itemView);
        //habitNameView = itemView.findViewById(R.id.);
    }

    public void setUserHabitCard(final Habit habit) {
        habitNameView.setText(habit.getHabitName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
