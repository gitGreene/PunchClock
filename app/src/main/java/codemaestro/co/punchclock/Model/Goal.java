package codemaestro.co.punchclock.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "goal_table",
        foreignKeys = @ForeignKey(entity = Category.class, parentColumns = "id", childColumns = "parent_category_id", onDelete = CASCADE, onUpdate = CASCADE),
        indices = @Index("parent_category_id"))

public class Goal {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "goal_id")
    private int goalId;

    @ColumnInfo(name = "parent_category_id")
    private int parentCategoryId;

    @ColumnInfo(name = "goal_name")
    private String goalName;

    @ColumnInfo(name = "start_date")
    private String startDate;

    @ColumnInfo(name = "target_date")
    private String goalTargetDate;

    @ColumnInfo(name = "is_goal_recurring")
    private boolean isGoalRecurring;

    @ColumnInfo(name = "is_time_based")
    private boolean isGoalTimeBased;

    @ColumnInfo(name = "goal_goal_time")
    private long goalGoalTime;

    @ColumnInfo(name = "times_goal_met")
    private int timesGoalMet;

    @Nullable
    @ColumnInfo(name = "description")
    private String goalDescription;

    @Ignore
    public Goal(int goalId, int parentCategoryId, String goalName, String startDate, String goalTargetDate, boolean isGoalRecurring, boolean isGoalTimeBased, long goalGoalTime, int timesGoalMet, @Nullable String goalDescription) {
        this.goalId = goalId;
        this.parentCategoryId = parentCategoryId;
        this.goalName = goalName;
        this.startDate = startDate;
        this.goalTargetDate = goalTargetDate;
        this.isGoalRecurring = isGoalRecurring;
        this.isGoalTimeBased = isGoalTimeBased;
        this.goalGoalTime = goalGoalTime;
        this.timesGoalMet = timesGoalMet;
        this.goalDescription = goalDescription;
    }


    public Goal(int parentCategoryId, String goalName, String startDate, String goalTargetDate, boolean isGoalRecurring, boolean isGoalTimeBased, long goalGoalTime) {
        this.parentCategoryId = parentCategoryId;
        this.goalName = goalName;
        this.startDate = startDate;
        this.goalTargetDate = goalTargetDate;
        this.isGoalRecurring = isGoalRecurring;
        this.isGoalTimeBased = isGoalTimeBased;
        this.goalGoalTime = goalGoalTime;
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

    public String getGoalTargetDate() {
        return goalTargetDate;
    }

    public void setGoalTargetDate(String goalTargetDate) {
        this.goalTargetDate = goalTargetDate;
    }

    public boolean isGoalRecurring() {
        return isGoalRecurring;
    }

    public void setGoalRecurring(boolean goalRecurring) {
        isGoalRecurring = goalRecurring;
    }

    public boolean isGoalTimeBased() {
        return isGoalTimeBased;
    }

    public void setGoalTimeBased(boolean goalTimeBased) {
        isGoalTimeBased = goalTimeBased;
    }

    public long getGoalGoalTime() {
        return goalGoalTime;
    }

    public void setGoalGoalTime(long goalGoalTime) {
        this.goalGoalTime = goalGoalTime;
    }

    public int getTimesGoalMet() {
        return timesGoalMet;
    }

    public void setTimesGoalMet(int timesGoalMet) {
        this.timesGoalMet = timesGoalMet;
    }

    @Nullable
    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(@Nullable String goalDescription) {
        this.goalDescription = goalDescription;
    }
}
