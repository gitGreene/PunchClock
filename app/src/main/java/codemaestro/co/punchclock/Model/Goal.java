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
        foreignKeys = @ForeignKey(entity = Category.class, parentColumns = "category_name", childColumns = "parent_category_name", onDelete = CASCADE),
        indices = @Index("parent_category_name"))

public class Goal {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "goal_id")
    private int goalId;

    @ColumnInfo(name = "parent_category_name")
    private String parentCategoryName;

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
    public Goal(int goalId, String parentCategoryName, String goalName, String startDate, String endDate, long timeCommittedThisCycle, long goalCycleValue, int timesGoalMet) {
        this.goalId = goalId;
        this.parentCategoryName = parentCategoryName;
        this.goalName = goalName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timeCommittedThisCycle = timeCommittedThisCycle;
        this.goalCycleValue = goalCycleValue;
        this.timesGoalMet = timesGoalMet;
    }

    public Goal(String goalName, String startDate, String endDate, long goalCycleValue) {
        this.goalName = goalName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.goalCycleValue = goalCycleValue;
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }

    public void setParentCategoryName(String parentCategoryName) {
        this.parentCategoryName = parentCategoryName;
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
