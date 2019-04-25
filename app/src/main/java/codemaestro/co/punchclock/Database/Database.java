package codemaestro.co.punchclock.Database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Calendar;

import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.Model.CategoryDao;
import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.Model.GoalDao;
import codemaestro.co.punchclock.Model.Habit;
import codemaestro.co.punchclock.Model.HabitDao;
import codemaestro.co.punchclock.Model.TimeEntry;
import codemaestro.co.punchclock.Model.TimeEntryDao;
import codemaestro.co.punchclock.Model.TimerData;
import codemaestro.co.punchclock.Model.TimerDataDao;



@android.arch.persistence.room.Database(entities = {Category.class, Goal.class, Habit.class, TimeEntry.class, TimerData.class}, version = 29, exportSchema = false)
@TypeConverters({DateUtils.class})
public abstract class Database extends RoomDatabase {

    public abstract CategoryDao categoryDao();
    public abstract GoalDao goalDao();
    public abstract HabitDao habitDao();
    public abstract TimeEntryDao timeEntryDao();
    public abstract TimerDataDao timerDataDao();

    private static final String TAG = "Database:";

    private static volatile Database INSTANCE;

    static  Database getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (Database.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "database")
                            .addCallback(populateCategoriesCallback)
                            .addCallback(populateGoalsCallback)
                            .fallbackToDestructiveMigration()//TODO: understand migrations
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback populateCategoriesCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateCategoriesAsync(INSTANCE).execute();
        }
    };

    private static RoomDatabase.Callback populateGoalsCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateGoalsAsync(INSTANCE).execute();
        }
    };

    private static class PopulateCategoriesAsync extends AsyncTask<Void, Void, Void> {
        private final CategoryDao categoryDao;
        String defaultCategoryName = "Gym";

        PopulateCategoriesAsync(Database database) {
            this.categoryDao = database.categoryDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            if(categoryDao.getAllCategories() != null) {
                Category category = new Category(defaultCategoryName, null, 0L, null, false);
                categoryDao.insertCategory(category);
                Log.e(TAG, "Default Category Created");
            }
            return null;
        }
    }

    private static class PopulateGoalsAsync extends AsyncTask<Void, Void, Void> {
        private final GoalDao goalDao;

        PopulateGoalsAsync(Database database) {
            this.goalDao = database.goalDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            if(goalDao.getAllCategoryGoals(1) != null) {
                Goal goal = new Goal(1, "Work Out", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L);
                goalDao.insertGoal(goal);
                Log.e(TAG, "Default Goal Created");
            }
            return null;
        }
    }
}
