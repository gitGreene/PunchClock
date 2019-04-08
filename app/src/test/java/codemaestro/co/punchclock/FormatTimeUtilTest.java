package codemaestro.co.punchclock;

import org.junit.Test;

import codemaestro.co.punchclock.Utils.FormatTimeUtil;

import static org.junit.Assert.assertEquals;

public class FormatTimeUtilTest {

    private FormatTimeUtil form = new FormatTimeUtil();

    @Test
    public void formatMillisIntoHMS() {
        final String expected = "24:01:05";
        final String actual = form.FormatMillisIntoHMS(86465000L);

        assertEquals(expected, actual);
    }

    @Test
    public void formatMillisIntoDHM() {
        final String expected = "1d0h1m";
        final String actual = form.FormatMillisIntoDHM(86460000L);

        assertEquals(expected, actual);
    }
}