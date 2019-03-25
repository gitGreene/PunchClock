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
        foreignKeys = @ForeignKey(entity = Milestone.class, parentColumns = "milestone_id", childColumns = "parent_milestone_id", onDelete = CASCADE, onUpdate = CASCADE),
        indices = @Index("parent_milestone_id"))

public class TimeEntry{

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "time_bank_id")
    private int timeBankId;

    @ColumnInfo(name = "parent_milestone_id")
    private int parentMilestoneId;

    @ColumnInfo(name = "time_committed")
    private long timeCommitted;

    @ColumnInfo(name = "start_time")
    private String startTime;

    @ColumnInfo(name = "end_time")
    private String endTime;

    @ColumnInfo(name = "date_of_entry")
    private String dateOfEntry;

    @Ignore
    public TimeEntry(int timeBankId, int parentMilestoneId, long timeCommitted, String startTime, String endTime, String dateOfEntry) {
        this.timeBankId = timeBankId;
        this.parentMilestoneId = parentMilestoneId;
        this.timeCommitted = timeCommitted;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dateOfEntry = dateOfEntry;
    }

    public TimeEntry(int parentMilestoneId, long timeCommitted, String startTime, String endTime, String dateOfEntry) {
        this.parentMilestoneId = parentMilestoneId;
        this.timeCommitted = timeCommitted;
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

    public int getParentMilestoneId() {
        return parentMilestoneId;
    }

    public void setParentMilestoneId(int parentMilestoneId) {
        this.parentMilestoneId = parentMilestoneId;
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
