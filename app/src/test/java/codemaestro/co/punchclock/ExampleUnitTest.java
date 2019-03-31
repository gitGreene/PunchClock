package codemaestro.co.punchclock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static com.google.common.truth.Truth.assertThat;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {
    public static final String FAKE_STRING = "Hello World";

    @Test
    public void readStringFromContext_LocalizedString() {
        MainActivity mainActivity = new MainActivity();
        String result = mainActivity.getHelloWorldString();
        assertThat(result).isEqualTo(FAKE_STRING);
    }
}