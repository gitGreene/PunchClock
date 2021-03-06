package codemaestro.co.punchclock.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Date;

@Entity(tableName = "category_table")
public class Category {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "category_name")
    private String categoryName;

    @Nullable
    @ColumnInfo(name = "description")
    private String categoryDescription;

    @ColumnInfo(name = "total_time_committed")
    private long categoryTotalTime;

    @Nullable
    @ColumnInfo(name = "date_started")
    private Date dateCreated;

    @ColumnInfo(name = "is_favorite")
    private boolean isFavorite;

    @Ignore
    public Category(int id, @NonNull String categoryName, @Nullable String categoryDescription, long categoryTotalTime, @Nullable Date dateCreated, boolean isFavorite) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryTotalTime = categoryTotalTime;
        this.dateCreated = dateCreated;
        this.isFavorite = isFavorite;
    }

    public Category(@NonNull String categoryName, @Nullable String categoryDescription, long categoryTotalTime, @Nullable Date dateCreated, boolean isFavorite) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryTotalTime = categoryTotalTime;
        this.dateCreated = dateCreated;
        this.isFavorite = isFavorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(@NonNull String categoryName) {
        this.categoryName = categoryName;
    }

    @Nullable
    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(@Nullable String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public long getCategoryTotalTime() {
        return categoryTotalTime;
    }

    public void setCategoryTotalTime(long categoryTotalTime) {
        this.categoryTotalTime = categoryTotalTime;
    }

    @Nullable
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(@Nullable Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
