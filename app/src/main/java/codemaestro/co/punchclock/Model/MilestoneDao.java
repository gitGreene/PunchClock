package codemaestro.co.punchclock.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MilestoneDao {

    @Insert
    void insertMilestone(Milestone milestone);

    @Update
    void updateMilestone(Milestone milestone);

    // Get all Milestones. Likely to never be used.
    @Query("SELECT * from milestone_table")
    LiveData<List<Milestone>> getAllMilestones();

    // Get Milestones by parent Goal id.
    @Query("SELECT * from milestone_table WHERE parent_goal_id =:parentGoalId")
    LiveData<List<Milestone>> getMilestonesByGoalId(int parentGoalId);

    // Get all Milestone by name
    @Query("SELECT * from milestone_table WHERE milestone_name =:milestoneName AND parent_goal_id =:parentGoalId")
    LiveData<Milestone> getMilestoneByName(String milestoneName, int parentGoalId);

    // Get all Recurring Milestones
    @Query("SELECT * from milestone_table WHERE is_milestone_recurring = 1")
    LiveData<List<Milestone>> getAllRecurringMilestones();

    // Get a Goal's recurring Milestones
    @Query("SELECT * from milestone_table WHERE is_milestone_recurring = 1 AND parent_goal_id =:parentGoalId")
    LiveData<List<Milestone>> getAGoalsRecurringMilestones(int parentGoalId);

    // TODO: Date DAO Methods Fix Date from String to Date Class
    // TODO: Milestone On or Before specific Start Date
//    @Query("SELECT * from milestone_table WHERE start_date =:startDate")
//    LiveData<List<Milestone>> getAllMilestonesWithSpecificStartDate(String startDate);

    // TODO: Milestone After a specific Start Date
//    @Query("SELECT * from milestone_table WHERE parent_goal_id =:parentGoalId AND start_date =:startDate")
//    LiveData<List<Milestone>> getAllMilestonesByGoalIdAndStartDate(int parentGoalId, String startDate);

    // TODO: On or Before specific Target Date
    // TODO: On or After specific Target Date
    // Get Milestones with specific Target Date
//    @Query("SELECT * from milestone_table WHERE target_date =:targetDate")
//    LiveData<List<Milestone>> getAllMilestonesWithSpecificTargetDate(String targetDate);

    // Get a Milestone by Goal and Target Date
//    @Query("SELECT * from milestone_table WHERE parent_goal_id =:parentGoalId AND target_date =:targetDate")
//    LiveData<List<Milestone>> getMilestonesByGoalIdAndTargetDate(int parentGoalId, String targetDate);







}
