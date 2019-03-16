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
        foreignKeys = @ForeignKey(entity = Category.class, parentColumns = "id", childColumns = "category_id", onDelete = CASCADE),
        indices = @Index("category_id"))
public class TimeEntry{

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "time_bank_id")
    private int timeBankId;

    @ColumnInfo(name = "time_committed")
    private long timeCommitted;

    @ColumnInfo(name = "start_date")
    private String startDate;

    @ColumnInfo(name = "end_time")
    private String endDate;

    @ColumnInfo(name = "date_of_entry")
    private String dateOfEntry;

    @ColumnInfo(name = "category_id")
    private int categoryId;

    @Ignore
    public TimeEntry(int timeBankId, long timeCommitted, String startDate, String endDate, String dateOfEntry, int categoryId) {
        this.timeBankId = timeBankId;
        this.timeCommitted = timeCommitted;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dateOfEntry = dateOfEntry;
        this.categoryId = categoryId;
    }

    public TimeEntry(long timeCommitted, String startDate, String endDate, String dateOfEntry) {
        this.timeCommitted = timeCommitted;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dateOfEntry = dateOfEntry;
    }


    public int getTimeBankId() {
        return timeBankId;
    }

    public void setTimeBankId(int timeBankId) {
        this.timeBankId = timeBankId;
    }

    public long getTimeCommitted() {
        return timeCommitted;
    }

    public void setTimeCommitted(long timeCommitted) {
        this.timeCommitted = timeCommitted;
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

    public String getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(String dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}