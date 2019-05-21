package codemaestro.co.punchclock.Database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.Model.CategoryDao;
import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.Model.GoalDao;
import codemaestro.co.punchclock.Model.Habit;
import codemaestro.co.punchclock.Model.HabitDao;
import codemaestro.co.punchclock.Model.TimeEntry;
import codemaestro.co.punchclock.Model.TimeEntryDao;
import codemaestro.co.punchclock.Model.TimerDataDao;

public class Repository {

    // References to the DAOs
    private CategoryDao categoryDao;
    private GoalDao goalDao;
    private HabitDao habitDao;
    private TimeEntryDao timeEntryDao;
    private TimerDataDao timerDataDao;

    // Lists of LiveData
    private LiveData<Category> currentCategory;
    private LiveData<List<Category>> allCategories;
    private static Category createCategoryTest;

    private LiveData<Goal> currentGoal;
    private LiveData<List<Goal>> allGoals;
    private LiveData<List<Goal>> allCategoryGoals;

    private LiveData<Habit> currentHabit;
    private LiveData<List<Habit>> allHabits;
    private LiveData<List<Habit>> allCategoryHabits;

    private LiveData<List<TimeEntry>> allGoalTimeEntries;
    private LiveData<List<TimeEntry>> allHabitTimeEntries;


    // TODO: We pass the application parameter to the Repository class to get an instance of the database
    // TODO: This can be done another way
    // TODO: Mediator Live Data object for observables?
    public Repository(Application application) {
        Database database = Database.getDatabase(application);
        categoryDao = database.categoryDao();
        goalDao = database.goalDao();
        habitDao = database.habitDao();
        timeEntryDao = database.timeEntryDao();
        timerDataDao = database.timerDataDao();

        allCategories = categoryDao.getAllCategories();
        allGoals = goalDao.getAllGoals();
        allHabits = habitDao.getAllHabits();
    }

    // TODO: Category Repository Methods
    public void insertCategory(Category category) {
        new InsertCategoryAsync(categoryDao).execute(category);
    }

    public void updateCategory(Category category) {
        new UpdateCategoryAsync(categoryDao).execute(category);
    }

    public LiveData<List<Category>> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    public LiveData<Category> getCurrentCategory(String categoryName) {
        return categoryDao.getCategoryByName(categoryName);
    }

    public LiveData<List<Category>> getFavoriteCategories() {
        return categoryDao.getFavorites();
    }






    public Category getCategoryByNameTest(String categoryName) {
        new TemplateCategoryTestAsync(categoryDao).execute(categoryName);
        return createCategoryTest;
    }

    private static void returnCategoryByNameTest(Category category) {
        createCategoryTest = category;
    }

    private static class TemplateCategoryTestAsync extends AsyncTask<String, Void, Category> {
        private CategoryDao categoryDao;

        TemplateCategoryTestAsync(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Category doInBackground(String... strings) {
            return categoryDao.getCategoryByNameTest(strings[0]);
        }

        @Override
        protected void onPostExecute(Category category) {
            super.onPostExecute(category);
            returnCategoryByNameTest(category);
        }
    }









    // TODO: Goal Respository Methods
    public void insertGoal(Goal goal) {
        new InsertGoalAsync(goalDao).execute(goal);
    }

    public void updateGoal(Goal goal) {
        new UpdateGoalAsync(goalDao).execute(goal);
    }

    public LiveData<List<Goal>> getAllGoals() {
        return goalDao.getAllGoals();
    }

    public LiveData<List<Goal>> getAllCategoryGoals(int parentCategoryId) {
        return goalDao.getAllCategoryGoals(parentCategoryId);
    }

    public LiveData<Goal> getSpecificGoal(String goalName, int parentCategoryId) {
        return goalDao.getSpecificGoal(goalName, parentCategoryId);
    }

    public LiveData<List<Goal>> getAllRecurringGoals() {
        return goalDao.getAllRecurringGoals();
    }

    public LiveData<List<Goal>> getCategoryRecurringGoals(int parentCategoryId) {
        return goalDao.getCategoryRecurringGoals(parentCategoryId);
    }


    // TODO: Habit Repository Methods
    public void createHabit(Habit habit) {
        new CreateHabitAsync(habitDao).execute(habit);
    }

    public void updateHabit(Habit habit) {
        new UpdateHabitAsync(habitDao).execute(habit);
    }

    public LiveData<List<Habit>> getAllHabits() {
        return habitDao.getAllHabits();
    }

    //TODO: Get all Habits due today
//    public LiveData<List<Habit>> getHabitsDueToday() {
//        return habitDao.getAllHabitsDueToday();
//    }

    public LiveData<Habit> getHabitByCategoryId(int parentCategoryId) {
        return habitDao.getHabitByCategoryId(parentCategoryId);
    }
    public LiveData<Habit> getHabitByName(String habitName, int parentGoalId) {
        return habitDao.getHabitByName(habitName, parentGoalId);
    }


    // TODO: TimeEntry Repository Methods
    // TODO: Discriminate TimeEntry by Parent Goal or Parent Habit
    public void insertTimeEntryChildOfGoal(TimeEntry timeEntry) {
        new InsertTimeEntryAsync(timeEntryDao).execute(timeEntry);
    }

    public void insertTimeEntryChildOfHabit(TimeEntry timeEntry) {
        new InsertTimeEntryAsync(timeEntryDao).execute(timeEntry);
    }

    public void updateTimeEntry(TimeEntry timeEntry) {
        new UpdateTimeEntryAsync(timeEntryDao).execute(timeEntry);
    }

    public LiveData<List<TimeEntry>> getEntriesByGoalId(int parentGoalId) {
        return timeEntryDao.getEntriesByGoalId(parentGoalId);
    }

    public LiveData<List<TimeEntry>> getEntriesByHabitId(int parentHabitId) {
        return timeEntryDao.getEntriesByHabitId(parentHabitId);
    }


    // Insert and Update Async Tasks
    private static class InsertCategoryAsync extends AsyncTask<Category, Void, Void> {
         CategoryDao categoryDao;

        InsertCategoryAsync(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.insertCategory(categories[0]);
            return null;
        }
    }

    private static class UpdateCategoryAsync extends AsyncTask<Category, Void, Void> {
        CategoryDao categoryDao;

        UpdateCategoryAsync(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categoryDao.updateCategory(categories[0]);
            return null;
        }
    }



    private static class InsertGoalAsync extends AsyncTask<Goal, Void, Void> {
        GoalDao goalDao;

        InsertGoalAsync(GoalDao goalDao) {
            this.goalDao = goalDao;
        }

        @Override
        protected Void doInBackground(Goal... goals) {
            goalDao.insertGoal(goals[0]);
            return null;
        }
    }

    private static class UpdateGoalAsync extends AsyncTask<Goal, Void, Void> {
        GoalDao goalDao;

        UpdateGoalAsync(GoalDao goalDao) {
            this.goalDao = goalDao;
        }

        @Override
        protected Void doInBackground(Goal... goals) {
            goalDao.updateGoal(goals[0]);
            return null;
        }
    }

    private static class CreateHabitAsync extends AsyncTask<Habit, Void, Void> {
        HabitDao habitDao;

        CreateHabitAsync(HabitDao habitDao) {
            this.habitDao = habitDao;
        }

        @Override
        protected Void doInBackground(Habit... habits) {
            habitDao.createHabit(habits[0]);
            return null;
        }
    }

    private static class UpdateHabitAsync extends AsyncTask<Habit, Void, Void> {
        HabitDao habitDao;

        UpdateHabitAsync(HabitDao habitDao) {
            this.habitDao = habitDao;
        }

        @Override
        protected Void doInBackground(Habit... habits) {
            habitDao.updateHabit(habits[0]);
            return null;
        }
    }

    private static class InsertTimeEntryAsync extends AsyncTask<TimeEntry, Void, Void> {
        TimeEntryDao timeEntryDao;

        InsertTimeEntryAsync(TimeEntryDao timeEntryDao) {
            this.timeEntryDao = timeEntryDao;
        }

        @Override
        protected Void doInBackground(TimeEntry... timeEntries) {
            timeEntryDao.insertTimeEntry(timeEntries[0]);
            return null;
        }
    }

    private static class UpdateTimeEntryAsync extends AsyncTask<TimeEntry, Void, Void> {
        TimeEntryDao timeEntryDao;

        UpdateTimeEntryAsync(TimeEntryDao timeEntryDao) {
            this.timeEntryDao = timeEntryDao;
        }

        @Override
        protected Void doInBackground(TimeEntry... timeEntries) {
            timeEntryDao.updateTimeEntry(timeEntries[0]);
            return null;
        }
    }








}


