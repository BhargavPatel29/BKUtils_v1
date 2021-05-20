package in.kpsoft.bkcalender;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BKCalender {

    public static String getCurrentDate(String dateFormat){
        return new SimpleDateFormat(dateFormat, Locale.US).format(Calendar.getInstance().getTime());
    }

    public static String convertFormat(String inputFormat, String outputFormat, String string) {
        SimpleDateFormat inputSdf = new SimpleDateFormat(inputFormat, Locale.getDefault());
        SimpleDateFormat outputSdf = new SimpleDateFormat(outputFormat, Locale.getDefault());
        try {
            if (string != null && string.length() > 0)
                string = outputSdf.format(inputSdf.parse(string));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return string;
    }
}
