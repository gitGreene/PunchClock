package codemaestro.co.punchclock;

import android.support.design.widget.BottomNavigationView;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;


@MediumTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureListViewIsPresent() throws Exception {
        MainActivity activity = rule.getActivity();
        BottomNavigationView navigationView = activity.findViewById(R.id.bottomNavView);
        assertThat(navigationView, notNullValue());
    }
}
