package laffy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class TaskDateAPI {
    private static final DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(
            "dd-MM-yy HHmm");

    // outputFormats
    private static final DateTimeFormatter outputNoYearFormatter = DateTimeFormatter.ofPattern(
            "EEEE, dd/MM, hh:mma");
    private static final DateTimeFormatter outputWithYearFormatter = DateTimeFormatter.ofPattern(
            "EEEE, dd/MM/yyyy, hh:mma");



    public static LocalDateTime parseDateTime(String dateTime) {
        if (dateTime.split(" ").length != 2) {
            dateTime += " 0000";
        }
        return LocalDateTime.parse(dateTime, inputFormatter);
    }

    public static boolean isValidDateTime(String dateTime) {
        try {
            parseDateTime(dateTime);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime.getYear() != LocalDateTime.now().getYear()) {
            return dateTime.format(outputWithYearFormatter);
        }
        return dateTime.format(outputNoYearFormatter);
    }

    public static String formatForStorage(LocalDateTime dateTime) {
        return dateTime.format(ISO_LOCAL_DATE_TIME);
    }

    public static LocalDateTime parseFromStorage(String dateTime) {
        return LocalDateTime.parse(dateTime, ISO_LOCAL_DATE_TIME);
    }
}
