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

@RunWith(AndroidJUnit4.class)
public class CategoryDaoOperationsTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private Database database;
    private CategoryDao categoryDao;

    // To experiment with different amounts of fake categories, increment/decrement these variables
    static final int FAKE_CATEGORIES = 5;
    static final int FAKE_FAVORITES = 5;

    private static final int TOTAL_FAKE_CATEGORIES = FAKE_CATEGORIES + FAKE_FAVORITES;

    @Before
    public void initDb() throws Exception {
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), Database.class).allowMainThreadQueries().build();

        categoryDao = database.categoryDao();
        List<Category> fakeCategories = FakeEntityCreator.getFakeCategories(FAKE_CATEGORIES);
        for(int i = 0; i < fakeCategories.size(); i++) {
            categoryDao.insertCategory(fakeCategories.get(i));
        }
        List<Category> fakeFavoriteCategories = FakeEntityCreator.getFakeFavoriteCategories(FAKE_FAVORITES);
        for(int i = 0; i < fakeFavoriteCategories.size(); i++) {
            categoryDao.insertCategory(fakeFavoriteCategories.get(i));
        }
    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }

    @Test
    public void confirmCategoryInsertion() throws InterruptedException {
        List<Category> allCategories = LiveDataTestUtil.getValue(categoryDao.getAllCategories());
        assertEquals(FakeEntityCreator.ALL_FAKE_CATEGORIES.get(0).getCategoryName(), allCategories.get(0).getCategoryName());
        assertEquals(FakeEntityCreator.ALL_FAKE_FAVORITE_CATEGORIES.get(0).getCategoryName(), allCategories.get(FAKE_CATEGORIES).getCategoryName());
    }

    @Test
    public void confirmCategoryUpdated() throws InterruptedException {
        Category category = LiveDataTestUtil.getValue(categoryDao.getCategoryByName(FakeEntityCreator.ALL_FAKE_CATEGORIES.get(0).getCategoryName()));
        category.setCategoryName("Fake Category 1 Updated");
        categoryDao.updateCategory(category);
        assertEquals("Fake Category 1 Updated", LiveDataTestUtil.getValue(categoryDao.getAllCategories()).get(0).getCategoryName());
    }

    @Test
    public void getAllCategories_ConfirmListSizeIsCorrect_AllFakeCategoriesEntered() throws InterruptedException {
        List<Category> allCategories = LiveDataTestUtil.getValue(categoryDao.getAllCategories());
        assertEquals(TOTAL_FAKE_CATEGORIES, allCategories.size());
    }

    @Test
    public void getCategoryByName() throws InterruptedException {
        Category testCategory = LiveDataTestUtil.getValue(categoryDao.getCategoryByName(FakeEntityCreator.ALL_FAKE_CATEGORIES.get(0).getCategoryName()));
        assertEquals(FakeEntityCreator.ALL_FAKE_CATEGORIES.get(0).getCategoryName(), testCategory.getCategoryName());
    }

    @Test
    public void getAllFavoriteCategories_SizeExpected() throws InterruptedException {
        List<Category> favoriteCategories = LiveDataTestUtil.getValue(categoryDao.getFavorites());
        assertEquals(FAKE_CATEGORIES, favoriteCategories.size());

//        Log.d("Cat Dao Test Get All Favorites", favoriteCategories.get(0).getCategoryName());
    }

}
