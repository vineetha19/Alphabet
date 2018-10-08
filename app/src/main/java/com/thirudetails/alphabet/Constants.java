package com.thirudetails.alphabet;

import android.content.Context;
import android.content.SharedPreferences;

import java.net.URLConnection;

import static android.content.Context.MODE_PRIVATE;

public class Constants {



    public static final String MY_PREFERENCES = "MY_PREFERENCES";
    public static final String FIRST_INSTALL = "FIRST_INSTALL";
    public static final String POSITION = "POSITION";
    public static final String KEY_ARRAY_IMAGE = "Key_array";


    public static void setPrefernc(Context context, String TAG, String value) {
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TAG, value);
        editor.apply();
    }

    public static String getPrefernc(Context context, String TAG) {
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE);
        String value = preferences.getString(TAG, "");
        return value;
    }

    public static boolean isImageFile(String path) {
        String fileType = URLConnection.guessContentTypeFromName(path);
        return fileType != null && fileType.startsWith("image");
    }

    public static boolean isVideoFile(String path) {
        String fileType = URLConnection.guessContentTypeFromName(path);
        return fileType != null && fileType.startsWith("video");
    }
}
