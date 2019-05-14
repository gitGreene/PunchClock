package codemaestro.co.punchclock.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import codemaestro.co.punchclock.Model.Habit;
import codemaestro.co.punchclock.R;

// This adapter is used in the Habits tab

public class UserHabitAdapter extends RecyclerView.Adapter {
    private List<Habit> userHabits;
    private LayoutInflater inflater;
    private Context context;

    public UserHabitAdapter(Context context) {
        this.context = context;
        this.userHabits = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
    }

    public void setUserHabits(final List<Habit> habits) {
        this.userHabits = habits;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.user_habit_card, viewGroup, false);
        return new UserHabitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        UserHabitViewHolder habitViewHolder = (UserHabitViewHolder) viewHolder;
        habitViewHolder.setUserHabitCard(userHabits.get(position));
    }

    @Override
    public int getItemCount() {
        if (userHabits != null) {
            return userHabits.size();
        } return 0;
    }
}
