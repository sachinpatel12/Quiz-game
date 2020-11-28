package com.example.quiz;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtil {

    private final SharedPreferences sharedPreferences;

    public SharedPreferenceUtil(Activity activity) {
        sharedPreferences = activity.getSharedPreferences("pref", Context.MODE_PRIVATE);
    }
    public void saveno(String ik, int value) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(ik,value).apply();
    }
    public  int getno(String ik)
    {
        return sharedPreferences.getInt(ik,0);
    }


    public void saveboolean(String k, boolean b) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(k,b).apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public void saveString(String key, String value) {
        SharedPreferences.Editor edit = sharedPreferences.edit();

        edit.putString(key, value).apply();
    }
    public boolean getboolean(String k) {
        return  sharedPreferences.getBoolean(k,false);
    }

}
