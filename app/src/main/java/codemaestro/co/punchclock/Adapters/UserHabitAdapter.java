package codemaestro.co.punchclock.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import codemaestro.co.punchclock.Model.Habit;

// This adapter is used in the Habits tab

public class UserHabitAdapter extends RecyclerView.Adapter {
    private List<Habit> userHabits;
    private Context context;

    public UserHabitAdapter(Context context) {
        this.context = context;
        this.userHabits = new ArrayList<>();
    }

    public void setUserHabits(final List<Habit> habits) {
        this.userHabits = habits;
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
        if (userHabits != null) {
            return userHabits.size();
        } return 0;
    }
}
