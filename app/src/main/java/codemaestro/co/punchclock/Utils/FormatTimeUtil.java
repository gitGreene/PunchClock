package codemaestro.co.punchclock.Utils;

import java.util.Locale;

public class FormatTimeUtil {

    public String FormatMillisIntoHMS(long milliseconds) {
        // Return milliseconds as hours:minutes:seconds aka 00:00:00
        return String.format(Locale.US, "%02d:%02d:%02d", milliseconds/3600000, milliseconds/60000 % 60, milliseconds/1000 % 60);
    }

    public String FormatMillisIntoDHM(long milliseconds) {
        // Return milliseconds as 00d00h00m
        return (milliseconds / 3600000 / 24)+"d"+(milliseconds/3600000 % 24)+"h"+(milliseconds/60000 % 60)+"m";
    }
}
