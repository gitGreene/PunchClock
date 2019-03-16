package codemaestro.co.punchclock.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "timer_data_table",
        foreignKeys = @ForeignKey(entity = Category.class, parentColumns = "id", childColumns = "category_id", onDelete = CASCADE),
        indices = @Index("category_id"))
public class TimerData {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "timer_id")
    private int timerId;

    @ColumnInfo(name = "category_id")
    private int categoryId;

    @ColumnInfo(name = "start_time")
    private String startTime;

    @ColumnInfo(name = "display_time")
    private long displayTime;

    @ColumnInfo(name = "time_at_death")
    private long timeAtDeath;

    @ColumnInfo(name = "is_running")
    private boolean isRunning;

    public TimerData(String startTime, long displayTime, long timeAtDeath, boolean isRunning) {
        this.startTime = startTime;
        this.displayTime = displayTime;
        this.timeAtDeath = timeAtDeath;
        this.isRunning = isRunning;
    }


    public int getTimerId() {
        return timerId;
    }

    public void setTimerId(int timerId) {
        this.timerId = timerId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public long getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(long displayTime) {
        this.displayTime = displayTime;
    }

    public long getTimeAtDeath() {
        return timeAtDeath;
    }

    public void setTimeAtDeath(long timeAtDeath) {
        this.timeAtDeath = timeAtDeath;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
