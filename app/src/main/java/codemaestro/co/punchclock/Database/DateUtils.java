package codemaestro.co.punchclock.Database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateUtils {

    // Convert a Date to a Long for storage
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    // Convert a Long to a Date for display
    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
