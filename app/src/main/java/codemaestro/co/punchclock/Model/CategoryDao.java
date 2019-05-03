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
    List<Category> getCategoriesForDB();

    // Get all Categories
    @Query("SELECT * from category_table")
    LiveData<List<Category>> getAllCategories();

    // Get specific Category by Name
    @Query("SELECT * from category_table WHERE category_name = :categoryName")
    LiveData<Category> getCategoryByName(String categoryName);

    @Query("SELECT * from category_table WHERE category_name = :categoryName")
    Category getCategoryByNameTest(String categoryName);

    // get all Favorite Categories
    @Query("SELECT * from category_table WHERE is_favorite")
    LiveData<List<Category>> getFavorites();

    // TODO: Date Class
    // TODO: On or Before a specific createdDate
    // TODO: After a specific createdDate
//    @Query("SELECT * from category_table WHERE date_started =:dateStarted")
//    LiveData<List<Category>> getAllCategoriesByCreatedDate(String dateStarted);

}
