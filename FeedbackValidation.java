package app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FeedbackValidation {


    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }


    public static boolean isValidLength(String input, int minLength, int maxLength) {
        return input != null && input.length() >= minLength && input.length() <= maxLength;
    }


    public static boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
