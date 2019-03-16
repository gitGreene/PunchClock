package codemaestro.co.punchclock.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TimerDataDao {

    @Insert
    void insertTimerData(TimerData timerData);

    @Update
    void updateTimerData(TimerData timerData);

    @Query("SELECT * from timer_data_table")
    LiveData<List<TimerData>> getAllTimerData();
}
