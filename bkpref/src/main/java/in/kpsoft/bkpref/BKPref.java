package in.kpsoft.bkpref;

import android.content.Context;
import android.content.SharedPreferences;

public class BKPref {

    private static SharedPreferences sharedPreferences = null;

    public static void openPref(Context context) {
        String prefNm = "BKPrefs";
        try {
            sharedPreferences = context.getSharedPreferences(prefNm, Context.MODE_PRIVATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteAll(Context context) {
        BKPref.openPref(context);
        BKPref.sharedPreferences.edit().clear().apply();
    }

    //==============================================================================================
    //String Values

    public static void setValue(Context context, String key, String value) {
        BKPref.openPref(context);
        SharedPreferences.Editor prefsPrivateEditor = BKPref.sharedPreferences.edit();
        prefsPrivateEditor.putString(key, value);
        prefsPrivateEditor.apply();
        prefsPrivateEditor = null;
        BKPref.sharedPreferences = null;
    }

    public static String getValue(Context context, String key, String defaultValue) {
        BKPref.openPref(context);
        String result = BKPref.sharedPreferences.getString(key, defaultValue);
        BKPref.sharedPreferences = null;
        return result;
    }

    //==============================================================================================
    //Int Values

    public static void setValue(Context context, String key, int value) {
        BKPref.openPref(context);
        SharedPreferences.Editor prefsPrivateEditor = BKPref.sharedPreferences.edit();
        prefsPrivateEditor.putInt(key, value);
        prefsPrivateEditor.apply();
        prefsPrivateEditor = null;
        BKPref.sharedPreferences = null;
    }

    public static int getValue(Context context, String key, int defaultValue) {
        BKPref.openPref(context);
        int result = BKPref.sharedPreferences.getInt(key, defaultValue);
        BKPref.sharedPreferences = null;
        return result;
    }

    //==============================================================================================
    //Long Values

    public static void setValue(Context context, String key, long value) {
        BKPref.openPref(context);
        SharedPreferences.Editor prefsPrivateEditor = BKPref.sharedPreferences.edit();
        prefsPrivateEditor.putLong(key, value);
        prefsPrivateEditor.apply();
        prefsPrivateEditor = null;
        BKPref.sharedPreferences = null;
    }

    public static long getValue(Context context, String key, long defaultValue) {
        BKPref.openPref(context);
        long result = BKPref.sharedPreferences.getLong(key, defaultValue);
        BKPref.sharedPreferences = null;
        return result;
    }

    //==============================================================================================
    //Boolean Values

    public static boolean getValue(Context context, String key, boolean defaultValue) {
        BKPref.openPref(context);
        boolean result = BKPref.sharedPreferences.getBoolean(key, defaultValue);
        BKPref.sharedPreferences = null;
        return result;
    }

    public static void setValue(Context context, String key, boolean value) {
        BKPref.openPref(context);
        SharedPreferences.Editor prefsPrivateEditor = BKPref.sharedPreferences.edit();
        prefsPrivateEditor.putBoolean(key, value);
        prefsPrivateEditor.apply();
        prefsPrivateEditor = null;
        BKPref.sharedPreferences = null;
    }
}
