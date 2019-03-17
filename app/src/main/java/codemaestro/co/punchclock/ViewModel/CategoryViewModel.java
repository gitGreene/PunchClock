package codemaestro.co.punchclock.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import codemaestro.co.punchclock.Database.Repository;
import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.Model.CategoryDao;
import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.Model.GoalDao;
import codemaestro.co.punchclock.Model.TimeEntry;
import codemaestro.co.punchclock.Model.TimeEntryDao;
import codemaestro.co.punchclock.Model.TimerDataDao;

public class CategoryViewModel extends AndroidViewModel {
    private Repository repository;

    // References to the DAOs
    private CategoryDao categoryDao;
    private GoalDao goalDao;
    private TimeEntryDao timeEntryDao;
    private TimerDataDao timerDataDao;

    // Lists of LiveData
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Category>> allFavoriteCategories;

    private LiveData<List<TimeEntry>> allCategoryEntries;

    // Individual LiveData holders
    private LiveData<Category> currentCategory;


    public CategoryViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        allCategories = repository.getAllCategories();
    }

    public LiveData<List<Category>> getAllCategories() {
        return allCategories;
    }

    public LiveData<Category> getCategoryByName(String name) {
        currentCategory = repository.getCategoryByName(name);
        return currentCategory;
    }







}
