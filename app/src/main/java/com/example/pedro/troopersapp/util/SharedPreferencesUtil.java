package com.example.pedro.troopersapp.util;

import android.content.SharedPreferences;

/**
 * Created by Pedro on 18/11/2017.
 */

public class SharedPreferencesUtil {

    private SharedPreferences sharedPreferences;

    public SharedPreferencesUtil(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public String get(String key) {
        return sharedPreferences.getString(key, "");
    }

    public boolean hasValue(String key) {
        return sharedPreferences.contains(key);
    }

    public void save(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
}
