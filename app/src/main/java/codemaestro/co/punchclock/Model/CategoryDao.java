package codemaestro.co.punchclock.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CategoryDao {

    @Insert
    void insertCategory(Category category);

    @Update
    void updateCategory(Category category);

    @Query("SELECT * from category_table")
    LiveData<List<Category>> getAllCategories();

    @Query("SELECT * from category_table WHERE id = :categoryId")
    LiveData<Category> getCategoryById(int categoryId);

    @Query("SELECT * from category_table WHERE category_name = :categoryName")
    LiveData<Category> getCategoryByName(String categoryName);

    @Query("SELECT * from category_table WHERE is_favorite")
    LiveData<List<Category>> getFavorites();

}
