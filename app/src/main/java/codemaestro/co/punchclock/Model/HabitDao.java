package codemaestro.co.punchclock.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.Date;
import java.util.List;

@Dao
public interface HabitDao {

    @Insert
    void createHabit(Habit habit);

    @Update
    void updateHabit(Habit habit);

    // Get all habits
    @Query("SELECT * from habit_table")
    LiveData<List<Habit>> getAllHabits();

    // Get all Habits due today for daily checklist
    // TODO: Get All Habits due today Test
//    @Query("SELECT * from habit_table WHERE target_date = getDate()")
//    LiveData<List<Habit>> getAllHabitsDueToday();

    //TODO: Does this really work the way you think it does mitch?
    @Query("SELECT * from habit_table WHERE target_date <:targetDate")
    LiveData<List<Habit>> getAllHabitsBeforeDate(Date targetDate);

    //TODO: Does this really work the way you think it does mitch?
    @Query("SELECT * from habit_table WHERE target_date >:targetDate")
    LiveData<List<Habit>> getAllHabitsAfterDate(Date targetDate);

    // Get all Habits by Category
    @Query("SELECT * from habit_table WHERE parent_category_id =:parentCategoryId")
    LiveData<List<Habit>> getHabitsByCategoryId(int parentCategoryId);

    // Get a Habit by name
    @Query("SELECT * from habit_table WHERE habit_name =:habitName AND parent_category_id =:parentCategoryId")
    LiveData<Habit> getHabitByName(String habitName, int parentCategoryId);


}
