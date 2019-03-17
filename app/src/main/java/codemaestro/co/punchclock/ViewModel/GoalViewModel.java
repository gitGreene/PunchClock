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
        allGoals = repository.getAllGoals();
    }

    public LiveData<List<Goal>> getAllGoals() {
        return allGoals;
    }

//    public LiveData<List<Goal>> getCurrentCategoryGoals(String categoryName) {
//        allCategoryGoals = repository.getCategoryGoals(categoryName);
//        return allCategoryGoals;
//    }
}
