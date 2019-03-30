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

@RunWith(AndroidJUnit4.class)
public class CategoryDatabaseInteractionTest {
    private Database database;
    private CategoryDao categoryDao;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
        Database.class).allowMainThreadQueries().build();

        categoryDao = database.categoryDao();
    }

    @After
    public void breakDown() throws Exception {
        database.close();
    }

    @Test
    public void onFetchingCategories_shouldGetEmptyList_IfTable_IsEmpty() throws InterruptedException {
//        List<Category> categoryList = LiveDataTestUtil
    }
}
