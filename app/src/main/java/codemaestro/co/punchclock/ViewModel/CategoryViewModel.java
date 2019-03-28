package codemaestro.co.punchclock.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import codemaestro.co.punchclock.Database.Repository;
import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.Model.TimeEntry;

public class CategoryViewModel extends AndroidViewModel {
    private Repository repository;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    // TODO: Category ViewModel Methods
    public void insertCategory(Category category) {
        repository.insertCategory(category);
    }

    public void updateCategory(Category category) {
        repository.updateCategory(category);
    }

    public LiveData<List<Category>> getAllCategories() {
        return repository.getAllCategories();
    }

    public LiveData<Category> getCurrentCategory(String categoryName) {
        return repository.getCurrentCategory(categoryName);
    }

    public LiveData<List<Category>> getFavoriteCategories() {
        return repository.getFavoriteCategories();
    }

    //TODO: TimeEntry ViewModel Methods
    public void insertTimeEntryChildOfGoal(TimeEntry timeEntry) {
        repository.insertTimeEntryChildOfGoal(timeEntry);
    }

    public void insertTimeEntryChildOfMilestone(TimeEntry timeEntry) {
        repository.insertTimeEntryChildOfMilestone(timeEntry);
    }

    public void updateTimeEntry(TimeEntry timeEntry) {
        repository.updateTimeEntry(timeEntry);
    }

    public LiveData<List<TimeEntry>> getEntriesByGoalId(int parentGoalId) {
        return repository.getEntriesByGoalId(parentGoalId);
    }

    public LiveData<List<TimeEntry>> getEntriesByMilestoneId(int parentMilestoneId) {
        return repository.getEntriesByMilestoneId(parentMilestoneId);
    }

    // TODO: TimerData ViewModel Methods








}
