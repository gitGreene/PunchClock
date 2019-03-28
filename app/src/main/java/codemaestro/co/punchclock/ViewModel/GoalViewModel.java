package codemaestro.co.punchclock.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import codemaestro.co.punchclock.Database.Repository;
import codemaestro.co.punchclock.Model.Goal;

public class GoalViewModel extends AndroidViewModel {
    private Repository repository;

    public GoalViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    // TODO: Goal ViewModel Methods
    public LiveData<List<Goal>> getAllGoals() {
        return repository.getAllGoals();
    }

    public void insertNewGoal(Goal goal) {
        repository.insertGoal(goal);
    }

    public void updateNewGoal(Goal goal) {
        repository.updateGoal(goal);
    }

    public LiveData<List<Goal>> getGoalsByCategoryId(int parentCategoryId) {
        return repository.getAllCategoryGoals(parentCategoryId);
    }

    public LiveData<Goal> getCurrentGoal(String goalName, int parentCategoryId){
        return repository.getSpecificGoal(goalName, parentCategoryId);
    }

    public LiveData<List<Goal>> getAllRecurringGoals() {
        return repository.getAllRecurringGoals();
    }

    public LiveData<List<Goal>> getCategoryRecurringGoals(int parentGoalId) {
        return repository.getCategoryRecurringGoals(parentGoalId);
    }


}
