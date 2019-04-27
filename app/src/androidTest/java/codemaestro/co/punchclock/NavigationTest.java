package codemaestro.co.punchclock;

import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@MediumTest
@RunWith(AndroidJUnit4.class)
public class NavigationTest {

    @Rule
    public ActivityTestRule<MainActivity> mainRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void init() {
        mainRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    //Todo: Get this to actually work
    @Test
    public void BottomNavigationTest() throws Exception {
        onView(withText("Home")).perform(click());
        onView(withText("Goals")).perform(click());
        onView(withText("Habits")).perform(click());
        onView(withText("Timer")).perform(click());
    }
}

