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

    // Get all Goals
    @Query("SELECT * from goal_table")
    LiveData<List<Goal>> getAllGoals();

    // Get all of a Category's Goals
    @Query("SELECT * from goal_table WHERE category_name = :categoryName")
    LiveData<List<Goal>> getAllCategoryGoals(String categoryName);

    @Query("SELECT * from goal_table WHERE parent_category_id =:parentCategoryId")
    List<Goal> getAllCategoryGoalsForDB(int parentCategoryId);

    // Get specific goal by Name and Parent Category Id
    @Query("SELECT * from goal_table WHERE goal_name =:goalName")
    LiveData<Goal> getGoalByName(String goalName);

    // TODO: Get all goals On or Before specific Start Date
    // TODO: Get all goals After specific Start Date
    // TODO: Get all goals On or Before specific Target Date
    // TODO: Get all goals After specific Target Date

    // Get all Recurring Goals
    @Query("SELECT * from goal_table WHERE is_goal_recurring = 1")
    LiveData<List<Goal>> getAllRecurringGoals();

    // Get all recurring Goals for a specific Category
    @Query("SELECT * from goal_table WHERE is_goal_recurring = 1 AND parent_category_id =:parentCategoryId")
    LiveData<List<Goal>> getCategoryRecurringGoals(int parentCategoryId);

}
