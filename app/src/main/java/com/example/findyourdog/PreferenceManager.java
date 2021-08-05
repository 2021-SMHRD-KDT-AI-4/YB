package com.example.findyourdog;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    private static final String FILE_NAME = "myAPP";
    public static final String DEFAULT_STRING = "데이터가 없습니다";
    private static final Boolean DEFAULT_BOOLEAN = false;
    private static final  int DEFAULT_INT = -1;
    private static final long DEFAULT_LONG = -1L;
    private static final float DEFAULT_FLOAT = -1F;

    private static SharedPreferences prefs;
    private static SharedPreferences.Editor editor;

    // SharedPreferences 생성 메소드
    private  static SharedPreferences getSharedPreferences(Context context){
        return context.getSharedPreferences(FILE_NAME,context.MODE_PRIVATE);
    }
    // String 값 저장 메소드
    public static void setString(Context context,String key, String value){
        prefs = getSharedPreferences(context);
        editor = prefs.edit();
        editor.putString(key,value);
        editor.commit();
    }
    // boolean 값 저장 메소드
    public static void setBoolean(Context context,String key, Boolean value){
        prefs = getSharedPreferences(context);
        editor = prefs.edit();
        editor.putBoolean(key,value);
        editor.commit();
    }
    public static void setInt(Context context, String key, int value){
        prefs = getSharedPreferences(context);
        editor = prefs.edit();
        editor.putInt(key,value);
        editor.commit();
    }
    // float 값 저장 메소드
    public static void setFloat(Context context, String key, float value){
        prefs = getSharedPreferences(context);
        editor = prefs.edit();
        editor.putFloat(key,value);
        editor.commit();
    }
    public static void setLong(Context context, String key, long value){
        prefs = getSharedPreferences(context);
        editor = prefs.edit();
        editor.putLong(key,value);
        editor.commit();
    }

     //Boolean 값 가져오는 메소드
    public static Boolean getBoolean(Context context, String key){
        prefs = getSharedPreferences(context);
        return prefs.getBoolean(key,DEFAULT_BOOLEAN);
    }
    // int 값 가져오는 메소드
    public static int getInt(Context context, String key){
        prefs = getSharedPreferences(context);
        return prefs.getInt(key,DEFAULT_INT);
    }
    // float 값 가져오는 메소드
    public static float getFloat(Context context, String key){
        prefs = getSharedPreferences(context);
        return prefs.getFloat(key,DEFAULT_FLOAT);
    }
    // Long 값 가져오는 메소드
    public static Long getLong(Context context, String key){
        prefs = getSharedPreferences(context);
        return prefs.getLong(key,DEFAULT_LONG);
    }
    // String 값 가져오는 메소드
    public static String getString(Context context, String key){
        prefs = getSharedPreferences(context);
        return prefs.getString(key,DEFAULT_STRING);
    }

    // 해당 key 값을 삭제하는 메소드
    public static void remove(Context context, String key){
        prefs = getSharedPreferences(context);
        editor = prefs.edit();
        editor.remove(key);
        editor.commit();
    }
    // SharedPreferences myApp 파일 안에 데이터 전부 삭제하는 메소드
    public static void clear(Context context){
        prefs = getSharedPreferences(context);
        editor = prefs.edit();
        editor.clear();
        editor.commit();
    }
}
