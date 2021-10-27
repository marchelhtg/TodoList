package TIM3.DGBA.IP.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * @project TodoList
 */
public class Utility {
    public static boolean isDateValid(String format, String value) {
        DateTimeFormatter formations = DateTimeFormatter.ofPattern(format);
        try {
            LocalDate localDate = LocalDate.parse(value, formations);

            String result = localDate.format(formations);

            return result.equals(value);
        } catch (DateTimeParseException ignored) {

        }
        return false;
    }

    public static String convertDateToString(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String result = null;
        try {
            result = date.format(formatter);

        } catch (DateTimeParseException ignored) {

        }
        return result;
    }

    public static LocalDate parseDate(String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(value, formatter);
    }
}
