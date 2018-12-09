package com.acc.gp.quick.note.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class SharePreferenceUtils {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;


    public SharePreferenceUtils(Context context) {
        preferences = context.getSharedPreferences(Const.SHARE_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
        this.context = context;
    }

    public int getIntData(String key) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int r = preferences.getInt(key, 0);
        return r;
    }

    public void insertIntData(String key, int value) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public int getStringData(String key) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int r = preferences.getInt(key, 0);
        return r;
    }

    public void insertStringData(String key, int value) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }


}
