package codemaestro.co.punchclock.Database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.Model.CategoryDao;
import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.Model.GoalDao;
import codemaestro.co.punchclock.Model.TimeEntry;
import codemaestro.co.punchclock.Model.TimeEntryDao;
import codemaestro.co.punchclock.Model.TimerDataDao;

public class Repository {

    // References to the DAOs
    private CategoryDao categoryDao;
    private GoalDao goalDao;
    private TimeEntryDao timeEntryDao;
    private TimerDataDao timerDataDao;

    // Lists of LiveData
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Category>> allFavoriteCategories;

    private LiveData<List<Goal>> allGoals;
    private LiveData<List<Goal>> allCategoryGoals;

    private LiveData<List<TimeEntry>> allCategoryEntries;

    // Individual LiveData holders
    private LiveData<Category> currentCategory;
    private LiveData<Goal> currentGoal;

    // TODO: LiveData for the timer?


    public Repository(Application application) {
        Database database = Database.getDatabase(application);
        categoryDao = database.categoryDao();
        goalDao = database.goalDao();
        timeEntryDao = database.timeEntryDao();
        timerDataDao = database.timerDataDao();
        allCategories = categoryDao.getAllCategories();
        allGoals = goalDao.getAllGoals();
    }

    // Category Methods

    public LiveData<List<Category>> getAllCategories() {
        return allCategories;
    }

    public LiveData<Category> getCategoryByName(String name) {
        currentCategory = categoryDao.getCategoryByName(name);
        return currentCategory;
    }

    public LiveData<List<Goal>> getAllGoals() {
        return allGoals;
    }

//    public LiveData<List<Goal>> getAllCategoryGoals(String categoryName) {
//        allCategoryGoals = goalDao.getAllCategoryGoals(categoryName);
//        return allCategoryGoals;
//    }

    public void insertCategory(Category category) {
        new InsertCategoryAsync(categoryDao).execute(category);
    }

    public void updateCategory(Category category){
        new UpdateCategoryAsync(categoryDao).execute(category);
    }

    public LiveData<List<Category>> getFavorites() {
        allFavoriteCategories = categoryDao.getFavorites();
        return allFavoriteCategories;
    }






    // Asynchronous database operations

    private static class InsertCategoryAsync extends AsyncTask<Category, Void, Void> {
        private CategoryDao categoryDao;

        public InsertCategoryAsync(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.insertCategory(categories[0]);
            return null;
        }
    }

    private static class UpdateCategoryAsync extends  AsyncTask<Category, Void, Void> {
        private CategoryDao categoryDao;

        public UpdateCategoryAsync(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.updateCategory(categories[0]);
            return null;
        }
    }
}


