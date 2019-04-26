package codemaestro.co.punchclock.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.Nullable;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "habit_table",
        foreignKeys = @ForeignKey(entity = Category.class, parentColumns = "id", childColumns = "parent_category_id", onDelete = CASCADE, onUpdate = CASCADE),
        indices = @Index("parent_category_id"))

public class Habit {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "habit_id")
    private int habitId;

    @ColumnInfo(name = "parent_category_id")
    private int parentCategoryId;

    @ColumnInfo(name = "habit_name")
    private String habitName;

    @ColumnInfo(name = "start_date")
    private Date startDate;

    @ColumnInfo(name = "is_time_based")
    private boolean isTimeBased;

    @ColumnInfo(name = "habit_goal_time")
    private long habitGoalTimeInMillis;

    @ColumnInfo(name = "habit_cycle_value")
    private long habitCycleValueInMillis;

    @ColumnInfo(name = "time_scheduled")
    private long timeScheduledInMillis;

    @ColumnInfo(name = "time_committed")
    private long timeCommittedInMillis;

    @Nullable
    @ColumnInfo(name = "target_date")
    private Date targetDate;

    @ColumnInfo(name = "habit_value")
    private long habitValue;

    @ColumnInfo(name = "times_habit_completed")
    private int timesHabitReached;

    @Nullable
    @ColumnInfo(name = "habit_description")
    private String habitDescription;

    @Ignore
    public Habit(int habitId, int parentCategoryId, String habitName, Date startDate, boolean isTimeBased, long habitGoalTimeInMillis, long habitCycleValueInMillis, long timeScheduledInMillis, long timeCommittedInMillis, @Nullable Date targetDate, long habitValue, int timesHabitReached, @Nullable String habitDescription) {
        this.habitId = habitId;
        this.parentCategoryId = parentCategoryId;
        this.habitName = habitName;
        this.startDate = startDate;
        this.isTimeBased = isTimeBased;
        this.habitGoalTimeInMillis = habitGoalTimeInMillis;
        this.habitCycleValueInMillis = habitCycleValueInMillis;
        this.timeScheduledInMillis = timeScheduledInMillis;
        this.timeCommittedInMillis = timeCommittedInMillis;
        this.targetDate = targetDate;
        this.habitValue = habitValue;
        this.timesHabitReached = timesHabitReached;
        this.habitDescription = habitDescription;
    }

    public Habit(int parentCategoryId, String habitName, long habitCycleValueInMillis, Date startDate, boolean isTimeBased, long timeScheduledInMillis, @Nullable Date targetDate) {
        this.parentCategoryId = parentCategoryId;
        this.habitName = habitName;
        this.habitCycleValueInMillis = habitCycleValueInMillis;
    }

    public int getHabitId() {
        return habitId;
    }

    public void setHabitId(int habitId) {
        this.habitId = habitId;
    }

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isTimeBased() {
        return isTimeBased;
    }

    public void setTimeBased(boolean timeBased) {
        isTimeBased = timeBased;
    }

    public long getHabitGoalTimeInMillis() {
        return habitGoalTimeInMillis;
    }

    public void setHabitGoalTimeInMillis(long habitGoalTimeInMillis) {
        this.habitGoalTimeInMillis = habitGoalTimeInMillis;
    }

    public long getHabitCycleValueInMillis() {
        return habitCycleValueInMillis;
    }

    public void setHabitCycleValueInMillis(long habitCycleValueInMillis) {
        this.habitCycleValueInMillis = habitCycleValueInMillis;
    }

    public long getTimeScheduledInMillis() {
        return timeScheduledInMillis;
    }

    public void setTimeScheduledInMillis(long timeScheduledInMillis) {
        this.timeScheduledInMillis = timeScheduledInMillis;
    }

    public long getTimeCommittedInMillis() {
        return timeCommittedInMillis;
    }

    public void setTimeCommittedInMillis(long timeCommittedInMillis) {
        this.timeCommittedInMillis = timeCommittedInMillis;
    }

    @Nullable
    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(@Nullable Date targetDate) {
        this.targetDate = targetDate;
    }

    public long getHabitValue() {
        return habitValue;
    }

    public void setHabitValue(long habitValue) {
        this.habitValue = habitValue;
    }

    public int getTimesHabitReached() {
        return timesHabitReached;
    }

    public void setTimesHabitReached(int timesHabitReached) {
        this.timesHabitReached = timesHabitReached;
    }

    @Nullable
    public String getHabitDescription() {
        return habitDescription;
    }

    public void setHabitDescription(@Nullable String habitDescription) {
        this.habitDescription = habitDescription;
    }
}
