package codemaestro.co.punchclock.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "time_entry_table",
        foreignKeys = {@ForeignKey(entity = Habit.class,
                                   parentColumns = "habit_id",
                                   childColumns = "parent_habit_id",
                                   onDelete = CASCADE, onUpdate = CASCADE),
                       @ForeignKey(entity = Goal.class,
                                   parentColumns = "goal_id",
                                   childColumns = "parent_goal_id",
                                   onDelete = CASCADE, onUpdate = CASCADE)},
        indices = {@Index("parent_habit_id"),
                   @Index("parent_goal_id")})


public class TimeEntry{

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "time_bank_id")
    private int timeBankId;

    @ColumnInfo(name = "parent_habit_id")
    private int parentHabitId;

    @ColumnInfo(name = "parent_goal_id")
    private int parentGoalId;

    @ColumnInfo(name = "time_committed")
    private long timeCommitted;

    @ColumnInfo(name = "start_time")
    private String startTime;

    @ColumnInfo(name = "end_time")
    private String endTime;

    @ColumnInfo(name = "date_of_entry")
    private String dateOfEntry;

    public TimeEntry(int timeBankId, int parentHabitId, int parentGoalId, long timeCommitted, String startTime, String endTime, String dateOfEntry) {
        this.timeBankId = timeBankId;
        this.parentHabitId = parentHabitId;
        this.parentGoalId = parentGoalId;
        this.timeCommitted = timeCommitted;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dateOfEntry = dateOfEntry;
    }

    // TODO: Test if we can create a TimeEntry with both a Habit Id and Goal Id seperately
    @Ignore
    // TimeEntry Constructor when Creating a TimeEntry for a Habit
    public TimeEntry(int parentHabitId, long timeCommitted, String startTime, String endTime, String dateOfEntry) {
        this.parentHabitId = parentHabitId;
        this.timeCommitted = timeCommitted;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dateOfEntry = dateOfEntry;
    }

    @Ignore
    //TimeEntry Constructor when
    public TimeEntry(long timeCommitted, int parentGoalId, String startTime, String endTime, String dateOfEntry) {
        this.timeCommitted = timeCommitted;
        this.parentGoalId = parentGoalId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dateOfEntry = dateOfEntry;
    }

    public int getTimeBankId() {
        return timeBankId;
    }

    public void setTimeBankId(int timeBankId) {
        this.timeBankId = timeBankId;
    }

    public int getParentHabitId() {
        return parentHabitId;
    }

    public void setParentHabitId(int parentHabitId) {
        this.parentHabitId = parentHabitId;
    }

    public int getParentGoalId() {
        return parentGoalId;
    }

    public void setParentGoalId(int parentGoalId) {
        this.parentGoalId = parentGoalId;
    }

    public long getTimeCommitted() {
        return timeCommitted;
    }

    public void setTimeCommitted(long timeCommitted) {
        this.timeCommitted = timeCommitted;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(String dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }
}
