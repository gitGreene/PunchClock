package codemaestro.co.punchclock.Adapters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.Navigation;

import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.Model.Habit;
import codemaestro.co.punchclock.R;

class UserHabitViewHolder extends RecyclerView.ViewHolder {
    private TextView habitNameView, categoryNameView;

    UserHabitViewHolder(@NonNull View itemView) {
        super(itemView);
        habitNameView = itemView.findViewById(R.id.habitCardTitle);
        categoryNameView = itemView.findViewById(R.id.habitCardCategoryName);
    }

    void setUserHabitCard(final Habit habit) {
        habitNameView.setText(habit.getHabitName());
        categoryNameView.setText(habit.getCategoryName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("Category Title", habit.getHabitName());
                Navigation.findNavController(view).navigate(R.id.action_habitsFragment_to_habitDetailFragment, bundle);
            }
        });
    }
}
