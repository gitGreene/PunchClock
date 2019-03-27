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

    @Query("SELECT * from time_entry_table")
    LiveData<List<TimeEntry>> getAllTimeEntries();

//    @Query("SELECT * from time_entry_table WHERE parent_category_id =:parentCategoryId")
//    LiveData<List<TimeEntry>> getEntriesByCategoryId(int parentCategoryId);


}
