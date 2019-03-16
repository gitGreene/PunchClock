package codemaestro.co.punchclock.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface GoalDao {

    @Insert
    void insertGoal(Goal goal);

    @Update
    void updateGoal(Goal goal);

    @Query("SELECT * from goal_table")
    LiveData<List<Goal>> getAllGoals();

    @Query("SELECT * from goal_table WHERE category_id =:categoryId")
    LiveData<List<Goal>> getAllCategoryGoals(int categoryId);

    @Query("SELECT * from goal_table WHERE goal_id =:goalId")
    LiveData<Goal> getGoalById(int goalId);

    @Query("SELECT * from goal_table WHERE goal_name =:goalName")
    LiveData<Goal> goalGoalByName(String goalName);

}
