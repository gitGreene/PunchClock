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

    private static final String GOAL_1_NAME = "Goal 1";
    private static final String GOAL_1_STARTDATE = "Goal 1 Start Date";
    private static final String GOAL_1_TARGETDATE = "goal 1 Target Date";
    private static final boolean GOAL_1_RECURRING = false;
    private static final boolean GOAL_1_TIMEBASED = false;
    private static final long GOAL_1_TOTALTIME = 0L;

    private static final String GOAL_2_NAME = "Goal 2";
    private static final String GOAL_2_STARTDATE = "Goal 2 Start Date";
    private static final String GOAL_2_TARGETDATE = "goal 2 Target Date";
    private static final boolean GOAL_2_RECURRING = true;
    private static final boolean GOAL_2_TIMEBASED = true;
    private static final long GOAL_2_TOTALTIME = 1000L;


    @Before
    public void initDb() throws Exception {
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), Database.class).allowMainThreadQueries().build();

        categoryDao = database.categoryDao();
        Category testCategory = new Category(CATEGORY_1_NAME, CATEGORY_1_DESC, CATEGORY_1_TOTALTIME, CATEGORY_1_DATECREATED, CATEGORY_1_ISFAVORITE);
        categoryDao.insertCategory(testCategory);
        testCategory = new Category(CATEGORY_2_NAME, CATEGORY_2_DESC, CATEGORY_2_TOTALTIME, CATEGORY_2_DATECREATED, CATEGORY_2_ISFAVORITE);
        categoryDao.insertCategory(testCategory);

        goalDao = database.goalDao();
        Goal testGoal = new Goal(CATEGORY_1_ID, GOAL_1_NAME, GOAL_1_STARTDATE, GOAL_1_TARGETDATE, GOAL_1_RECURRING, GOAL_1_TIMEBASED, GOAL_1_TOTALTIME);
        goalDao.insertGoal(testGoal);
        testGoal = new Goal(CATEGORY_2_ID, GOAL_2_NAME, GOAL_2_STARTDATE, GOAL_2_TARGETDATE, GOAL_2_RECURRING, GOAL_2_TIMEBASED, GOAL_2_TOTALTIME);
        goalDao.insertGoal(testGoal);
    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }

    @Test
    public void confirmGoalInsertion() throws InterruptedException {
        List<Goal> allGoals = LiveDataTestUtil.getValue(goalDao.getAllGoals());
        assertEquals(GOAL_1_NAME, allGoals.get(0).getGoalName());
    }

    @Test
    public void getAllGoalsBySpecificCategoryId_SizeExpected_1() throws InterruptedException {
        List<Goal> allCategoryGoals = LiveDataTestUtil.getValue(goalDao.getAllCategoryGoals(CATEGORY_1_ID));
        assertEquals(1, allCategoryGoals.size());
    }

    @Test
    public void getTestGoalByNameAndCategoryId() throws InterruptedException {
        Goal testGoal = LiveDataTestUtil.getValue(goalDao.getSpecificGoal(GOAL_1_NAME, CATEGORY_1_ID));
        assertEquals(GOAL_1_NAME, testGoal.getGoalName());
    }

    @Test
    public void getAllRecurringGoals_SizeExpected_1() throws InterruptedException {
        List<Goal> allRecurringGoals = LiveDataTestUtil.getValue(goalDao.getAllRecurringGoals());
        assertEquals(1, allRecurringGoals.size());
    }

    @Test
    public void getSpecificRecurringGoalsByCategoryId_SizeExpected_1() throws InterruptedException {
        List<Goal> allCategoryRecurringGoals = LiveDataTestUtil.getValue(goalDao.getCategoryRecurringGoals(CATEGORY_2_ID));
        assertEquals(1, allCategoryRecurringGoals.size());
    }

}
