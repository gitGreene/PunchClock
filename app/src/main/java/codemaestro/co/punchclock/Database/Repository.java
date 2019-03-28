package codemaestro.co.punchclock.Database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.Model.CategoryDao;
import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.Model.GoalDao;
import codemaestro.co.punchclock.Model.Milestone;
import codemaestro.co.punchclock.Model.MilestoneDao;
import codemaestro.co.punchclock.Model.TimeEntry;
import codemaestro.co.punchclock.Model.TimeEntryDao;
import codemaestro.co.punchclock.Model.TimerDataDao;

public class Repository {

    // References to the DAOs
    private CategoryDao categoryDao;
    private GoalDao goalDao;
    private MilestoneDao milestoneDao;
    private TimeEntryDao timeEntryDao;
    private TimerDataDao timerDataDao;

    // Lists of LiveData
    private LiveData<Category> currentCategory;
    private LiveData<List<Category>> allCategories;


    private LiveData<Goal> currentGoal;
    private LiveData<List<Goal>> allGoals;
    private LiveData<List<Goal>> allCategoryGoals;

    private LiveData<Milestone> currentMilestone;
    private LiveData<List<Milestone>> allMilestones;
    private LiveData<List<Milestone>> allGoalMilestones;

    private LiveData<List<TimeEntry>> allGoalTimeEntries;
    private LiveData<List<TimeEntry>> allMilestoneTimeEntries;



    public Repository(Application application) {
        Database database = Database.getDatabase(application);
        categoryDao = database.categoryDao();
        goalDao = database.goalDao();
        milestoneDao = database.milestoneDao();
        timeEntryDao = database.timeEntryDao();
        timerDataDao = database.timerDataDao();

        allCategories = categoryDao.getAllCategories();
        allGoals = goalDao.getAllGoals();
        allMilestones = milestoneDao.getAllMilestones();
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


    // TODO: Goal Respository Methods
    public void insertGoal(Goal goal) {
        new InsertGoalAsync(goalDao).execute(goal);
    }

    public void updateGoal(Goal goal) {
        new UpdateGoalAsync(goalDao).execute(goal);
    }

    public LiveData<List<Goal>> getAllGoals() {
//        return allGoals;
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


    // TODO: Milestone Repository Methods
    public void insertMilestone(Milestone milestone) {
        new InsertMilestoneAsync(milestoneDao).execute(milestone);
    }

    public void updateMilestone(Milestone milestone) {
        new UpdateMilestoneAsync(milestoneDao).execute(milestone);
    }

    public LiveData<List<Milestone>> getAllMilestones() {
        return milestoneDao.getAllMilestones();
    }

    public LiveData<List<Milestone>> getMilestonesByGoalId(int parentGoalId) {
        return milestoneDao.getMilestonesByGoalId(parentGoalId);
    }

    public LiveData<Milestone> getMilestoneByName(String milestoneName, int parentGoalId) {
        return milestoneDao.getMilestoneByName(milestoneName, parentGoalId);
    }

    public LiveData<List<Milestone>> getAllRecurringMilestones() {
        return milestoneDao.getAllRecurringMilestones();
    }

    public LiveData<List<Milestone>> getAGoalsRecurringMilestones(int parentGoalId) {
        return milestoneDao.getAGoalsRecurringMilestones(parentGoalId);
    }



    // TODO: TimeEntry Repository Methods
    // TODO: Discriminate TimeEntry by Parent Goal or Parent Milestone
    public void insertTimeEntryChildOfGoal(TimeEntry timeEntry) {
        new InsertTimeEntryAsync(timeEntryDao).execute(timeEntry);
    }

    public void insertTimeEntryChildOfMilestone(TimeEntry timeEntry) {
        new InsertTimeEntryAsync(timeEntryDao).execute(timeEntry);
    }

    public void updateTimeEntry(TimeEntry timeEntry) {
        new UpdateTimeEntryAsync(timeEntryDao).execute(timeEntry);
    }

    public LiveData<List<TimeEntry>> getEntriesByGoalId(int parentGoalId) {
        return timeEntryDao.getEntriesByGoalId(parentGoalId);
    }

    public LiveData<List<TimeEntry>> getEntriesByMilestoneId(int parentMilestoneId) {
        return timeEntryDao.getEntriesByMilestoneId(parentMilestoneId);
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

    private static class InsertMilestoneAsync extends AsyncTask<Milestone, Void, Void> {
        MilestoneDao milestoneDao;

        InsertMilestoneAsync(MilestoneDao milestoneDao) {
            this.milestoneDao = milestoneDao;
        }

        @Override
        protected Void doInBackground(Milestone... milestones) {
            milestoneDao.insertMilestone(milestones[0]);
            return null;
        }
    }

    private static class UpdateMilestoneAsync extends AsyncTask<Milestone, Void, Void> {
        MilestoneDao milestoneDao;

        UpdateMilestoneAsync(MilestoneDao milestoneDao) {
            this.milestoneDao = milestoneDao;
        }

        @Override
        protected Void doInBackground(Milestone... milestones) {
            milestoneDao.updateMilestone(milestones[0]);
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


