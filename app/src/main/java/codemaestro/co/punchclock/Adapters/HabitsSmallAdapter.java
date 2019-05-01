package codemaestro.co.punchclock.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.Navigation;

import java.util.List;

import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.Model.Habit;
import codemaestro.co.punchclock.R;

public class HabitsSmallAdapter extends RecyclerView.Adapter {
    private LayoutInflater inflater;
    private List<Habit> habits;
    private Context context;


    public HabitsSmallAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public void setHabits(List<Habit> habits) {
        this.habits = habits;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = inflater.inflate(R.layout.habit_small_card, viewGroup, false);
        return new HabitSmallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        HabitSmallViewHolder viewHolder1 = (HabitSmallViewHolder) viewHolder;
        viewHolder1.setSmallHabitCard(habits.get(position));
    }

    @Override
    public int getItemCount() {
        if(habits != null) {
            return habits.size();
        } else return 0;
    }


    private static class HabitSmallViewHolder extends RecyclerView.ViewHolder {
        private TextView habitName;
        public static final String HABIT_NAME_TAG = "HABIT_NAME";

        public HabitSmallViewHolder(@NonNull View itemView) {
            super(itemView);
            habitName = itemView.findViewById(R.id.habitName);
        }

        public void setSmallHabitCard(final Habit habit) {
            habitName.setText(habit.getHabitName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString(HABIT_NAME_TAG, habit.getHabitName());
                    Navigation.findNavController(view).navigate(R.id.action_categoryDetailFragment_to_habitDetailFragment, bundle);
                }
            });
        }
    }
}
