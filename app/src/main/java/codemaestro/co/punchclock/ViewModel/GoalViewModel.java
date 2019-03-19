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

    private LiveData<List<Goal>> allGoals;
    private LiveData<List<Goal>> allCategoryGoals;
    private LiveData<Goal> currentGoal;

    public GoalViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
//        allGoals = repository.getAllGoals();
    }

    public LiveData<List<Goal>> getAllGoals() {
        return allGoals;
    }

    public void insertNewGoal(Goal goal) {
        repository.insertGoal(goal);
    }

    public LiveData<List<Goal>> getGoalsByCategoryName(String categoryName) {
        allCategoryGoals = repository.getGoalsByCategoryName(categoryName);
        return allCategoryGoals;
    }

    public LiveData<Goal> getCurrentGoal(String goalName, String parentCategoryName){
        currentGoal = repository.getCurrentGoal(goalName, parentCategoryName);
        return currentGoal;
    }
}
