package in.kpsoft.bkcalender;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;

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

    //==============================================================================================
    //==============================================================================================

    public static DatePickerDialog datePickerDialog(Context context, String inputDate, String inputFormat, DatePickerDialog.OnDateSetListener listener) {
        try {
            String date = BKCalender.convertFormat(inputFormat, "yyyyMMdd", inputDate);
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(4, 6));
            int day = Integer.parseInt(date.substring(6, 8));
            return new DatePickerDialog(context, listener, year, month - 1, day);
        } catch (Exception e) {
            e.printStackTrace();
            return new DatePickerDialog(context, listener, 2021, 2 - 1, 1);
        }
    }

    public static TimePickerDialog timePickerDialog(Context context, String inputTime, String inputFormat, TimePickerDialog.OnTimeSetListener listener) {
        try {
            String time = BKCalender.convertFormat(inputFormat, "HHmmss", inputTime);
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(2, 4));
            int second = Integer.parseInt(time.substring(4, 6));
            return new TimePickerDialog(context, listener, hour, minute, false);
        } catch (Exception e) {
            e.printStackTrace();
            return new TimePickerDialog(context, listener, 12, 0, false);
        }
    }
}
