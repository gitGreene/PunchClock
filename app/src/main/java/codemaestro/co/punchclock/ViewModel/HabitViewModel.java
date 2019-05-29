package codemaestro.co.punchclock.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import codemaestro.co.punchclock.Database.Repository;
import codemaestro.co.punchclock.Model.Habit;

public class HabitViewModel extends AndroidViewModel {
    private Repository repository;

    public HabitViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    // TODO: Habit ViewModel Methods
    public void insertHabit(Habit habit) {
        repository.createHabit(habit);
    }

    public void updateHabit(Habit habit) {
        repository.updateHabit(habit);
    }

    public LiveData<List<Habit>> getAllHabits() {
        return repository.getAllHabits();
    }

    public LiveData<List<Habit>> getHabitsByCategoryName(String categoryName) {
        return repository.getHabitsByCategoryName(categoryName);
    }

    public LiveData<Habit> getHabitByName(String habitName) {
        return repository.getHabitByName(habitName);
    }

}
