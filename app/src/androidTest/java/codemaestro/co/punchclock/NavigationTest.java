package codemaestro.co.punchclock;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import codemaestro.co.punchclock.Fragments.HomeFragment;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.mock;

@RunWith(AndroidJUnit4.class)
public class NavigationTest {

    @Test
    public void testNavigationToInGameScreen() {

        // Create a mock NavController
        NavController mockNavController = mock(NavController.class);

//        // Create a graphical FragmentScenario for the TitleScreen
//        FuiydfghjragmentScenario<HomeFragment> titleScenario = FragmentScenario.launchInContainer(HomeFragment.class);
//
//        // Set the NavController property on the fragment
//        titleScenario.onFragment(fragment ->
//                Navigation.setViewNavController(fragment.requireView(), mockNavController)
//        );
//
//        // Verify that performing a click prompts the correct Navigation action
//        onView(ViewMatchers.withId(R.id.play_btn)).perform(ViewActions.click());
//        verify(mockNavController).navigate(R.id.action_title_screen_to_in_game);
    }
}


//@MediumTest
//@RunWith(AndroidJUnit4.class)
//public class NavigationTest {
//
//    @Rule
//    public ActivityTestRule<MainActivity> mainRule = new ActivityTestRule<>(MainActivity.class);
//
//    @Before
//    public void init() {
//        mainRule.getActivity().getSupportFragmentManager().beginTransaction();
//    }
//
//    //Todo: Get this to actually work
//    @Test
//    public void BottomNavigationTest() throws Exception {
//        onView(withText("Home")).perform(click());
//        onView(withText("Goals")).perform(click());
//        onView(withText("Habits")).perform(click());
//        onView(withText("Timer")).perform(click());
//    }
//
//
//}

