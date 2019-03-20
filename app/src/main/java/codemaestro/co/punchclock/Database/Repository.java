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


    // Goal Methods
    public LiveData<List<Goal>> getAllGoals() {
        return allGoals;
    }

    public void insertGoal(Goal goal) {
        new InsertGoalAsync(goalDao).execute(goal);
    }

    public LiveData<List<Goal>> getGoalsByCategoryId(int parentCategoryId) {
        allCategoryGoals = goalDao.getAllCategoryGoals(parentCategoryId);
        return allCategoryGoals;
    }

    public LiveData<Goal> getCurrentGoal(String goalName, int parentCategoryId){
        currentGoal = goalDao.getSpecificGoal(goalName, parentCategoryId);
        return currentGoal;
    }

    // Time Entry Methods
    public LiveData<List<TimeEntry>> getEntriesByCategoryId(int parentCategoryId) {
        allCategoryEntries = timeEntryDao.getEntriesByCategoryId(parentCategoryId);
        return allCategoryEntries;
    }

    public void insertNewTimeEntry(TimeEntry timeEntry) {
        new InsertTimeEntryAsync(timeEntryDao).execute(timeEntry);
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


    private static class InsertGoalAsync extends AsyncTask<Goal, Void, Void> {
        private GoalDao goalDao;

        public InsertGoalAsync(GoalDao goalDao) {
            this.goalDao = goalDao;
        }

        @Override
        protected Void doInBackground(Goal... goals) {
            goalDao.insertGoal(goals[0]);
            return null;
        }
    }

    private static class InsertTimeEntryAsync extends AsyncTask<TimeEntry, Void, Void> {
        private TimeEntryDao timeEntryDao;

        public InsertTimeEntryAsync(TimeEntryDao timeEntryDao) {
            this.timeEntryDao = timeEntryDao;
        }

        @Override
        protected Void doInBackground(TimeEntry... timeEntries) {
            timeEntryDao.insertTimeEntry(timeEntries[0]);
            return null;
        }
    }
}


