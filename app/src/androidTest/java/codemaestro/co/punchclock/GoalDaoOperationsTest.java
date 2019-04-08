package codemaestro.co.punchclock;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import codemaestro.co.punchclock.Database.Database;
import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.Model.CategoryDao;
import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.Model.GoalDao;

import static junit.framework.TestCase.assertEquals;

@RunWith(AndroidJUnit4.class)
public class GoalDaoOperationsTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private Database database;
    private CategoryDao categoryDao;
    private GoalDao goalDao;

    static final int FAKE_CATEGORIES = 5;
    static final int FAKE_GOALS= 5;

    @Before
    public void initDb() throws Exception {
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), Database.class).allowMainThreadQueries().build();

        categoryDao = database.categoryDao();
        List<Category> allCategories = FakeEntityCreator.getFakeCategories(FAKE_CATEGORIES);
        for(int i = 0; i < allCategories.size(); i++) {
            categoryDao.insertCategory(allCategories.get(i));
        }

        goalDao = database.goalDao();
        List<Goal> allFakeGoals = FakeEntityCreator.getFakeGoals(FAKE_GOALS);
        for(int i = 0; i < allFakeGoals.size(); i++) {
            goalDao.insertGoal(allFakeGoals.get(i));
        }

    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }

    @Test
    public void confirmAllGoalsInserted() throws InterruptedException {
        List<Goal> allGoals = LiveDataTestUtil.getValue(goalDao.getAllGoals());
        assertEquals(FAKE_GOALS, allGoals.size());
    }

    @Test
    public void confirmGoalUpdated() throws InterruptedException {
        Goal goal = LiveDataTestUtil.getValue(goalDao.getSpecificGoal("Fake Goal 1", 1));
        goal.setGoalName("Fake Goal 1 Updated");
        goalDao.updateGoal(goal);
        assertEquals("Fake Goal 1 Updated", LiveDataTestUtil.getValue(goalDao.getSpecificGoal("Fake Goal 1", 1)).getGoalName());
//        LiveDataTestUtil.getValue(goalDao.getAllGoals()).get(0).getGoalName())
    }

    // Testing that we have created 1:1 Category to Goal
    @Test
    public void getAllGoalsBySpecificCategoryId_SizeExpected_1() throws InterruptedException {
        List<Goal> allCategoryGoals = LiveDataTestUtil.getValue(goalDao.getAllCategoryGoals(1));
        assertEquals(1, allCategoryGoals.size());
    }

    @Test
    public void getTestGoalByNameAndCategoryId() throws InterruptedException {
        Goal testGoal = LiveDataTestUtil.getValue(goalDao.getSpecificGoal(FakeEntityCreator.ALL_FAKE_GOALS.get(0).getGoalName(), 1));
        assertEquals(FakeEntityCreator.ALL_FAKE_GOALS.get(0).getGoalName(), testGoal.getGoalName());
        Log.d("get Test Goal By Name And Category Id", testGoal.getGoalName());
    }

    @Test
    public void getAllRecurringGoals_SizeExpected_0() throws InterruptedException {
        List<Goal> allRecurringGoals = LiveDataTestUtil.getValue(goalDao.getAllRecurringGoals());
        assertEquals(0, allRecurringGoals.size());
    }

    @Test
    public void getSpecificRecurringGoalsByCategoryId_SizeExpected_1() throws InterruptedException {
        List<Goal> allCategoryRecurringGoals = LiveDataTestUtil.getValue(goalDao.getCategoryRecurringGoals(1));
        assertEquals(0, allCategoryRecurringGoals.size());
    }

}
