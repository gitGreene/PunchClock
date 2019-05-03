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
import java.util.List;
import java.util.concurrent.Executors;

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



@android.arch.persistence.room.Database(entities = {Category.class, Goal.class, Habit.class, TimeEntry.class, TimerData.class}, version = 40, exportSchema = false)
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
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    if(INSTANCE.categoryDao().getCategoriesForDB().isEmpty()) {
                        INSTANCE.categoryDao().insertCategory(new Category("Health", "Health Description", 0L, Calendar.getInstance().getTime(), false));
                        INSTANCE.categoryDao().insertCategory(new Category("Family", "Family Description", 0L, Calendar.getInstance().getTime(), false));
                        INSTANCE.categoryDao().insertCategory(new Category("Career", "Career Description", 0L, Calendar.getInstance().getTime(), false));
                        INSTANCE.categoryDao().insertCategory(new Category("Hobby", "Hobby Description", 0L, Calendar.getInstance().getTime(), false));
                        INSTANCE.categoryDao().insertCategory(new Category("Skill", "Skill Description", 0L, Calendar.getInstance().getTime(), false));
                        INSTANCE.goalDao().insertGoal(new Goal(1, "Workout 1", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
                        INSTANCE.goalDao().insertGoal(new Goal(1, "Workout 2", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
                        INSTANCE.goalDao().insertGoal(new Goal(2, "Quality time 1", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
                        INSTANCE.goalDao().insertGoal(new Goal(2, "Quality time 2", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
                        INSTANCE.goalDao().insertGoal(new Goal(3, "Game plan 1", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
                        INSTANCE.goalDao().insertGoal(new Goal(3, "Game plan 2", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
                        INSTANCE.goalDao().insertGoal(new Goal(4, "Hobby goal 1", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
                        INSTANCE.goalDao().insertGoal(new Goal(4, "Hobby goal 2", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
                        INSTANCE.goalDao().insertGoal(new Goal(5, "Get better 1", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
                        INSTANCE.goalDao().insertGoal(new Goal(5, "Get better 2", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
                        INSTANCE.habitDao().createHabit(new Habit(1, "Walk EveryDay",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
                        INSTANCE.habitDao().createHabit(new Habit(1, "Gym 5 times a week",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
                        INSTANCE.habitDao().createHabit(new Habit(1, "Get good sleep",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
                        INSTANCE.habitDao().createHabit(new Habit(2, "Talk to loved ones",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
                        INSTANCE.habitDao().createHabit(new Habit(2, "Text Grandma",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));                        INSTANCE.habitDao().createHabit(new Habit(1, "Walk Every Day",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
                        INSTANCE.habitDao().createHabit(new Habit(2, "Date Night",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
                        INSTANCE.habitDao().createHabit(new Habit(3, "Arrive 15 mins early",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
                        INSTANCE.habitDao().createHabit(new Habit(3, "Track spending",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
                        INSTANCE.habitDao().createHabit(new Habit(3, "Write down opportunities",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));                        INSTANCE.habitDao().createHabit(new Habit(1, "Walk Every Day",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
                        INSTANCE.habitDao().createHabit(new Habit(4, "Hobby habit 1",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
                        INSTANCE.habitDao().createHabit(new Habit(4, "Hobby habit 2",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
                        INSTANCE.habitDao().createHabit(new Habit(4, "Hobby habit 3",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
                        INSTANCE.habitDao().createHabit(new Habit(5, "Skill habit 1",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
                        INSTANCE.habitDao().createHabit(new Habit(5, "Skill habit 2",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
                        INSTANCE.habitDao().createHabit(new Habit(5, "Skill habit 3",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
                    }
//                    if(INSTANCE.goalDao().getAllCategoryGoalsForDB(1).isEmpty()) {
//                        INSTANCE.goalDao().insertGoal(new Goal(1, "Workout 1", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
//                        INSTANCE.goalDao().insertGoal(new Goal(1, "Workout 2", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
//                        INSTANCE.goalDao().insertGoal(new Goal(2, "Quality time 1", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
//                        INSTANCE.goalDao().insertGoal(new Goal(2, "Quality time 2", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
//                        INSTANCE.goalDao().insertGoal(new Goal(3, "Game plan 1", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
//                        INSTANCE.goalDao().insertGoal(new Goal(3, "Game plan 2", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
//                        INSTANCE.goalDao().insertGoal(new Goal(4, "Hobby goal 1", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
//                        INSTANCE.goalDao().insertGoal(new Goal(4, "Hobby goal 2", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
//                        INSTANCE.goalDao().insertGoal(new Goal(5, "Get better 1", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
//                        INSTANCE.goalDao().insertGoal(new Goal(5, "Get better 2", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, 0L));
//                    }
//                    if(INSTANCE.habitDao().getHabitsByCategoryIdForDB(1).isEmpty()) {
//                        INSTANCE.habitDao().createHabit(new Habit(1, "Walk Every Day",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
//                        INSTANCE.habitDao().createHabit(new Habit(1, "Gym 5 times a week",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
//                        INSTANCE.habitDao().createHabit(new Habit(1, "Get good sleep",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
//                        INSTANCE.habitDao().createHabit(new Habit(2, "Talk to loved ones",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
//                        INSTANCE.habitDao().createHabit(new Habit(2, "Text Grandma",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));                        INSTANCE.habitDao().createHabit(new Habit(1, "Walk Every Day",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
//                        INSTANCE.habitDao().createHabit(new Habit(2, "Date Night",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
//                        INSTANCE.habitDao().createHabit(new Habit(3, "Arrive 15 mins early",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
//                        INSTANCE.habitDao().createHabit(new Habit(3, "Track spending",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
//                        INSTANCE.habitDao().createHabit(new Habit(3, "Write down opportunities",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));                        INSTANCE.habitDao().createHabit(new Habit(1, "Walk Every Day",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
//                        INSTANCE.habitDao().createHabit(new Habit(4, "Hobby habit 1",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
//                        INSTANCE.habitDao().createHabit(new Habit(4, "Hobby habit 2",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
//                        INSTANCE.habitDao().createHabit(new Habit(4, "Hobby habit 3",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
//                        INSTANCE.habitDao().createHabit(new Habit(5, "Skill habit 1",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
//                        INSTANCE.habitDao().createHabit(new Habit(5, "Skill habit 2",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
//                        INSTANCE.habitDao().createHabit(new Habit(5, "Skill habit 3",86400000, Calendar.getInstance().getTime(), true, 0L, Calendar.getInstance().getTime()));
//                    }
                }
            });
        }
    };
}
