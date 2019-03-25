package codemaestro.co.punchclock.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "goal_table",
        foreignKeys = @ForeignKey(entity = Category.class, parentColumns = "id", childColumns = "parent_category_id", onDelete = CASCADE, onUpdate = CASCADE),
        indices = @Index("parent_category_id"))

public class Goal {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "goal_id")
    private int goalId;

    @NonNull
    @ColumnInfo(name = "parent_category_id")
    private int parentCategoryId;

    @ColumnInfo(name = "goal_name")
    private String goalName;

    @ColumnInfo(name = "start_date")
    private String startDate;

    @ColumnInfo(name = "end_date")
    private String endDate;

    @ColumnInfo(name = "time_committed_this_cycle")
    private long timeCommittedThisCycle;

    @ColumnInfo(name = "goal_cycle_value")
    private long goalCycleValue;

    @ColumnInfo(name = "times_goal_was_met")
    private int timesGoalMet;

    @Ignore
    public Goal(int goalId, int parentCategoryId, String goalName, String startDate, String endDate, long timeCommittedThisCycle, long goalCycleValue, int timesGoalMet) {
        this.goalId = goalId;
        this.parentCategoryId = parentCategoryId;
        this.goalName = goalName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timeCommittedThisCycle = timeCommittedThisCycle;
        this.goalCycleValue = goalCycleValue;
        this.timesGoalMet = timesGoalMet;
    }

    public Goal(int parentCategoryId, String goalName, String startDate, String endDate, long timeCommittedThisCycle, long goalCycleValue, int timesGoalMet) {
        this.parentCategoryId = parentCategoryId;
        this.goalName = goalName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timeCommittedThisCycle = timeCommittedThisCycle;
        this.goalCycleValue = goalCycleValue;
        this.timesGoalMet = timesGoalMet;
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public long getTimeCommittedThisCycle() {
        return timeCommittedThisCycle;
    }

    public void setTimeCommittedThisCycle(long timeCommittedThisCycle) {
        this.timeCommittedThisCycle = timeCommittedThisCycle;
    }

    public long getGoalCycleValue() {
        return goalCycleValue;
    }

    public void setGoalCycleValue(long goalCycleValue) {
        this.goalCycleValue = goalCycleValue;
    }

    public int getTimesGoalMet() {
        return timesGoalMet;
    }

    public void setTimesGoalMet(int timesGoalMet) {
        this.timesGoalMet = timesGoalMet;
    }
}
