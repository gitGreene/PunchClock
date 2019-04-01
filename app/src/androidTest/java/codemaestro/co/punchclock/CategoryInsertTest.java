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
public class CategoryInsertTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private Database database;
    private CategoryDao categoryDao;

    @Before
    public void initDb() throws Exception {
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), Database.class).allowMainThreadQueries().build();

        categoryDao = database.categoryDao();
        Category testCategory = new Category("Test", "Test Description", 0L, "Test Date Created", false);
        categoryDao.insertCategory(testCategory);
    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }

    @Test
    public void fetchNewlyCreatedCategory() throws InterruptedException {
        List<Category> allCategories = LiveDataTestUtil.getValue(categoryDao.getAllCategories());
        assertEquals("Test", allCategories.get(0).getCategoryName());
    }
}
