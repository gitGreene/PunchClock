package codemaestro.co.punchclock.Database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.Model.CategoryDao;
import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.Model.GoalDao;
import codemaestro.co.punchclock.Model.Milestone;
import codemaestro.co.punchclock.Model.MilestoneDao;
import codemaestro.co.punchclock.Model.TimeEntry;
import codemaestro.co.punchclock.Model.TimeEntryDao;
import codemaestro.co.punchclock.Model.TimerData;
import codemaestro.co.punchclock.Model.TimerDataDao;


@android.arch.persistence.room.Database(entities = {Category.class, Goal.class, Milestone.class, TimeEntry.class, TimerData.class}, version = 24, exportSchema = false)
public abstract class Database extends RoomDatabase {

    public abstract CategoryDao categoryDao();
    public abstract GoalDao goalDao();
    public abstract MilestoneDao milestoneDao();
    public abstract TimeEntryDao timeEntryDao();
    public abstract TimerDataDao timerDataDao();

    private static volatile Database INSTANCE;

    static  Database getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (Database.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "database")
                            .addCallback(populateDatabaseCallback)
                            .fallbackToDestructiveMigration()//TODO: understand migrations
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback populateDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDatabaseAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDatabaseAsync extends AsyncTask<Void, Void, Void> {
        private final CategoryDao categoryDao;
        String defaultCategoryName = "Gym";

        PopulateDatabaseAsync(Database database) {
            this.categoryDao = database.categoryDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            if(categoryDao.getAllCategories() != null) {
                Category category = new Category(defaultCategoryName, null, 0L, null, false);
                categoryDao.insertCategory(category);
            }
            return null;
        }
    }
}
