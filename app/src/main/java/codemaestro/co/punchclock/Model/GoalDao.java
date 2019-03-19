package codemaestro.co.punchclock.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface GoalDao {


    // New Goal must include goalName, startDate, endDate, goalCycleValue
    @Insert
    void insertGoal(Goal goal);

    @Update
    void updateGoal(Goal goal);

    @Query("SELECT * from goal_table")
    LiveData<List<Goal>> getAllGoals();

    @Query("SELECT * from goal_table WHERE parent_category_name =:parentCategoryName")
    LiveData<List<Goal>> getAllCategoryGoals(String parentCategoryName);

    @Query("SELECT * from goal_table WHERE goal_name =:goalName AND parent_category_name =:parentCategoryName")
    LiveData<Goal> getSpecificGoal(String goalName, String parentCategoryName);

}
