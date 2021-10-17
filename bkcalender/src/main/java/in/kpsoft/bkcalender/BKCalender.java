package in.kpsoft.bkcalender;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class BKCalender {

    public static String getCurrentDate(String dateFormat) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Instant instant = Instant.now();
            ZoneId zoneId = ZoneId.of("Asia/Kolkata");
            ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId);
            return zonedDateTime.format(DateTimeFormatter.ofPattern(dateFormat));
        } else {
            TimeZone timeZone = TimeZone.getTimeZone("GMT+05:30");
            TimeZone.setDefault(timeZone); //Not Working
            return new SimpleDateFormat(dateFormat, Locale.US).format(Calendar.getInstance(timeZone).getTime());
        }
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
            String date = (inputDate != null && inputDate.length() > 0)
                    ? BKCalender.convertFormat(inputFormat, "yyyyMMdd", inputDate)
                    : BKCalender.getCurrentDate("yyyyMMdd");
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(4, 6));
            int day = Integer.parseInt(date.substring(6, 8));
            return new DatePickerDialog(context, listener, year, month - 1, day);
        } catch (Exception e) {
            e.printStackTrace();
            return new DatePickerDialog(context, listener, 2021, 0, 1);
        }
    }

    public static TimePickerDialog timePickerDialog(Context context, String inputTime, String inputFormat, TimePickerDialog.OnTimeSetListener listener) {
        try {
            String time = (inputTime != null && inputTime.length() > 0)
                    ? BKCalender.convertFormat(inputFormat, "HHmmss", inputTime)
                    : BKCalender.getCurrentDate("HHmmss");
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
