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

    private static final int CATEGORY_1_ID = 1;
    private static final String CATEGORY_1_NAME = "Category 1";
    private static final String CATEGORY_1_DESC = "Category 1 Description";
    private static final long CATEGORY_1_TOTALTIME = 0L;
    private static final String CATEGORY_1_DATECREATED = "Category 1 Date Created";
    private static final boolean CATEGORY_1_ISFAVORITE = false;


    private static final int CATEGORY_2_ID = 2;
    private static final String CATEGORY_2_NAME = "Category 2";
    private static final String CATEGORY_2_DESC = "Category 2 Description";
    private static final long CATEGORY_2_TOTALTIME = 1000L;
    private static final String CATEGORY_2_DATECREATED = "Category 2 Date Created";
    private static final boolean CATEGORY_2_ISFAVORITE = true;

    @Before
    public void initDb() throws Exception {
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), Database.class).allowMainThreadQueries().build();

        categoryDao = database.categoryDao();
        Category testCategory = new Category(CATEGORY_1_NAME, CATEGORY_1_DESC, CATEGORY_1_TOTALTIME, CATEGORY_1_DATECREATED, CATEGORY_1_ISFAVORITE);
        categoryDao.insertCategory(testCategory);
        Category favoriteTestCategory = new Category(CATEGORY_2_NAME, CATEGORY_2_DESC, CATEGORY_2_TOTALTIME, CATEGORY_2_DATECREATED, CATEGORY_2_ISFAVORITE);
        categoryDao.insertCategory(favoriteTestCategory);
    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }

    @Test
    public void confirmCategoryInsertion() throws InterruptedException {
        List<Category> allCategories = LiveDataTestUtil.getValue(categoryDao.getAllCategories());
        assertEquals(CATEGORY_1_NAME, allCategories.get(0).getCategoryName());
    }

    @Test
    public void getAllCategories_SizeExpected_2() throws InterruptedException {
        List<Category> allCategories = LiveDataTestUtil.getValue(categoryDao.getAllCategories());
        assertEquals(2, allCategories.size());
    }

    @Test
    public void getCategoryByName() throws InterruptedException {
        Category testCategory = LiveDataTestUtil.getValue(categoryDao.getCategoryByName(CATEGORY_1_NAME));
        assertEquals(CATEGORY_1_NAME, testCategory.getCategoryName());
    }

    @Test
    public void getAllFavoriteCategories_SizeExpected_1() throws InterruptedException {
        List<Category> favoriteCategories = LiveDataTestUtil.getValue(categoryDao.getFavorites());
        assertEquals(1, favoriteCategories.size());
    }

}
