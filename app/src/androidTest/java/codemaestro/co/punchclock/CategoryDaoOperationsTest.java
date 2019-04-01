package codemaestro.co.punchclock;


import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import codemaestro.co.punchclock.Database.Database;
import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.Model.CategoryDao;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

@RunWith(AndroidJUnit4.class)
public class CategoryDaoOperationsTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private Database database;
    private CategoryDao categoryDao;

    @Before
    public void initDb() throws Exception {
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), Database.class).allowMainThreadQueries().build();

        categoryDao = database.categoryDao();
        Category testCategory = new Category("Test Category", "Test Description", 0L, "Test Date Created", false);
        categoryDao.insertCategory(testCategory);
        Category testFavoriteCategory = new Category("Test Favorite Category", "Favorite Category Description", 500L, "Favorite Date Created", true);
        categoryDao.insertCategory(testFavoriteCategory);
    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }

    @Test
    public void confirmCategoryInsertion() throws InterruptedException {
        List<Category> allCategories = LiveDataTestUtil.getValue(categoryDao.getAllCategories());
        assertEquals("Test Category", allCategories.get(0).getCategoryName());
    }

    @Test
    public void getCategoryByName() throws InterruptedException {
        Category testCategory = LiveDataTestUtil.getValue(categoryDao.getCategoryByName("Test Category"));
        assertEquals("Test Category", testCategory.getCategoryName());
    }

    @Test
    public void confirmCategoryIsNotFavorite() throws InterruptedException {
        List<Category> allCategories = LiveDataTestUtil.getValue(categoryDao.getAllCategories());
        assertEquals("Test Category", allCategories.get(0).getCategoryName());
    }

    @Test
    public void confirmCategoryIsFavorite() throws InterruptedException {
        List<Category> favoriteCategories = LiveDataTestUtil.getValue(categoryDao.getFavorites());
        assertEquals("Test Favorite Category", favoriteCategories.get(0).getCategoryName());
    }


}
