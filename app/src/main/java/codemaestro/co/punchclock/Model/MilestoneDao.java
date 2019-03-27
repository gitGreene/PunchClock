package codemaestro.co.punchclock.Model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

@Dao
public interface MilestoneDao {

    @Insert
    void insertMilestone(Milestone milestone);

    @Update
    void updateMilestone(Milestone milestone);
}
