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

@Entity(tableName = "milestone_table",
        foreignKeys = @ForeignKey(entity = Goal.class, parentColumns = "goal_id", childColumns = "parent_goal_id", onDelete = CASCADE, onUpdate = CASCADE),
        indices = @Index("parent_goal_id"))

public class Milestone {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "milestone_id")
    private int milestoneId;

    @ColumnInfo(name = "parent_goal_id")
    private int parentGoalId;

    @ColumnInfo(name = "milestone_name")
    private String milestoneName;

    @ColumnInfo(name = "start_date")
    private String startDate;

    @Nullable
    @ColumnInfo(name = "target_date")
    private String milestoneTargetDate;

    @ColumnInfo(name = "is_time_based")
    private boolean isTimeBasedMilestone;

    @ColumnInfo(name = "is_milestone_recurring")
    private boolean isMilestoneRecurring;

    @ColumnInfo(name = "milestone_goal_time")
    private long milestoneGoalTime;

    @ColumnInfo(name = "is_milestone_reached")
    private boolean isMilestoneReached;

    @ColumnInfo(name = "times_milestone_reached")
    private int timesMilestoneReached;

    @Nullable
    @ColumnInfo(name = "milestone_description")
    private String milestoneDescription;

    @ColumnInfo(name = "milestone_time_scheduled")
    private long milestoneTimeScheduled;

    @ColumnInfo(name = "milestone_time_committed")
    private long milestoneTimeCommitted;

    @Ignore
    public Milestone(int milestoneId, int parentGoalId, String milestoneName, String startDate, @Nullable String milestoneTargetDate, boolean isTimeBasedMilestone, boolean isMilestoneRecurring, long milestoneGoalTime, boolean isMilestoneReached, int timesMilestoneReached, @Nullable String milestoneDescription, long milestoneTimeScheduled, long milestoneTimeCommitted) {
        this.milestoneId = milestoneId;
        this.parentGoalId = parentGoalId;
        this.milestoneName = milestoneName;
        this.startDate = startDate;
        this.milestoneTargetDate = milestoneTargetDate;
        this.isTimeBasedMilestone = isTimeBasedMilestone;
        this.isMilestoneRecurring = isMilestoneRecurring;
        this.milestoneGoalTime = milestoneGoalTime;
        this.isMilestoneReached = isMilestoneReached;
        this.timesMilestoneReached = timesMilestoneReached;
        this.milestoneDescription = milestoneDescription;
        this.milestoneTimeScheduled = milestoneTimeScheduled;
        this.milestoneTimeCommitted = milestoneTimeCommitted;
    }

    public Milestone(int parentGoalId, String milestoneName, String startDate, @Nullable String milestoneTargetDate, boolean isTimeBasedMilestone, boolean isMilestoneRecurring, long milestoneGoalTime) {
        this.parentGoalId = parentGoalId;
        this.milestoneName = milestoneName;
        this.startDate = startDate;
        this.milestoneTargetDate = milestoneTargetDate;
        this.isTimeBasedMilestone = isTimeBasedMilestone;
        this.isMilestoneRecurring = isMilestoneRecurring;
        this.milestoneGoalTime = milestoneGoalTime;
    }

    public int getMilestoneId() {
        return milestoneId;
    }

    public void setMilestoneId(int milestoneId) {
        this.milestoneId = milestoneId;
    }

    public int getParentGoalId() {
        return parentGoalId;
    }

    public void setParentGoalId(int parentGoalId) {
        this.parentGoalId = parentGoalId;
    }

    public String getMilestoneName() {
        return milestoneName;
    }

    public void setMilestoneName(String milestoneName) {
        this.milestoneName = milestoneName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Nullable
    public String getMilestoneTargetDate() {
        return milestoneTargetDate;
    }

    public void setMilestoneTargetDate(@Nullable String milestoneTargetDate) {
        this.milestoneTargetDate = milestoneTargetDate;
    }

    public boolean isTimeBasedMilestone() {
        return isTimeBasedMilestone;
    }

    public void setTimeBasedMilestone(boolean timeBasedMilestone) {
        isTimeBasedMilestone = timeBasedMilestone;
    }

    public boolean isMilestoneRecurring() {
        return isMilestoneRecurring;
    }

    public void setMilestoneRecurring(boolean milestoneRecurring) {
        isMilestoneRecurring = milestoneRecurring;
    }

    public long getMilestoneGoalTime() {
        return milestoneGoalTime;
    }

    public void setMilestoneGoalTime(long milestoneGoalTime) {
        this.milestoneGoalTime = milestoneGoalTime;
    }

    public boolean isMilestoneReached() {
        return isMilestoneReached;
    }

    public void setMilestoneReached(boolean milestoneReached) {
        isMilestoneReached = milestoneReached;
    }

    public int getTimesMilestoneReached() {
        return timesMilestoneReached;
    }

    public void setTimesMilestoneReached(int timesMilestoneReached) {
        this.timesMilestoneReached = timesMilestoneReached;
    }

    @Nullable
    public String getMilestoneDescription() {
        return milestoneDescription;
    }

    public void setMilestoneDescription(@Nullable String milestoneDescription) {
        this.milestoneDescription = milestoneDescription;
    }

    public long getMilestoneTimeScheduled() {
        return milestoneTimeScheduled;
    }

    public void setMilestoneTimeScheduled(long milestoneTimeScheduled) {
        this.milestoneTimeScheduled = milestoneTimeScheduled;
    }

    public long getMilestoneTimeCommitted() {
        return milestoneTimeCommitted;
    }

    public void setMilestoneTimeCommitted(long milestoneTimeCommitted) {
        this.milestoneTimeCommitted = milestoneTimeCommitted;
    }
}
