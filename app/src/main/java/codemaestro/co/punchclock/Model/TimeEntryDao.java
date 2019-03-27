package codemaestro.co.punchclock.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TimeEntryDao {

    @Insert
    void insertTimeEntry(TimeEntry timeEntry);

    @Update
    void updateTimeEntry(TimeEntry timeEntry);

    @Query("SELECT * from time_entry_table WHERE parent_goal_id =:parentGoalId")
    LiveData<List<TimeEntry>> getEntriesByGoalId(int parentGoalId);

    @Query("SELECT * from time_entry_table WHERE parent_milestone_id =:parentMilestoneId")
    LiveData<List<TimeEntry>> getEntriesByMilestoneId(int parentMilestoneId);

    // TODO: Create DAO methods that get Time Entries by parent Milestone or parent Goal
}
