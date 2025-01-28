package laffy.tasklist;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class TaskDateAPITest {

    @Test
    public void parseDateTime_validDate_success() {
        assertEquals("2048-01-24T00:00", TaskDateAPI.parseDateTime("24-01-48").toString());
    }

    @Test
    public void parseDateTime_validDateTime_success() {
        assertEquals("2048-01-24T12:34", TaskDateAPI.parseDateTime("24-01-48 1234").toString());
    }

    @Test
    public void formatDateTime_validDateTime_success() {
        LocalDateTime dateTime = LocalDateTime.parse("2048-01-24T12:34");
        assertEquals("Friday, 24/01/2048, 12:34pm", TaskDateAPI.formatDateTime(dateTime));
    }

    @Test
    public void isValidDateTime_validDateTime_success() {
        assertTrue(TaskDateAPI.isValidDateTime("24-01-48 1234"));
        assertTrue(TaskDateAPI.isValidDateTime("24-01-48"));
    }

    @Test
    public void isValidDateTime_invalidDateTime_success() {
        assertFalse(TaskDateAPI.isValidDateTime("24-01-48 123"));
        assertFalse(TaskDateAPI.isValidDateTime("24-01-48 12345"));
        assertFalse(TaskDateAPI.isValidDateTime("24-01-48 12345a"));
    }

    @Test
    public void formatForStorage_validDateTime_success() {
        LocalDateTime dateTime = LocalDateTime.parse("2048-01-24T12:34");
        assertEquals("2048-01-24T12:34:00", TaskDateAPI.formatForStorage(dateTime));
    }

    @Test
    public void parseFromStorage_validDateTime_success() {
        assertEquals("2048-01-24T12:34", TaskDateAPI.parseFromStorage("2048-01-24T12:34:00").toString());
    }

    @Test
    public void formatDateTime_validDateTimeWithYear_success() {
        LocalDateTime dateTime = LocalDateTime.parse("2048-01-24T12:34");
        assertEquals("Friday, 24/01/2048, 12:34pm", TaskDateAPI.formatDateTime(dateTime));
    }

    @Test
    public void formatDateTime_validDateTimeWithoutYear_success() {
        String currentYear = String.valueOf(LocalDateTime.now().getYear());
        LocalDateTime dateTime = LocalDateTime.parse(currentYear + "-01-24T12:34");
        String day = dateTime.format(DateTimeFormatter.ofPattern("EEEE"));
        assertEquals(day + ", 24/01, 12:34pm", TaskDateAPI.formatDateTime(dateTime));
    }
}
