package com.android.memo_file

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil(context: Context) {

    private val preferences: SharedPreferences = // 내가 바꿀 수 있는거1 (preferences) 변수 이름
        context.getSharedPreferences("prefs_name", Context.MODE_PRIVATE)

    fun getString(key: String, prefs_value: String): String { // 내가 바꿀 수 있는거2 (String) value 타입-key는 무조건 String
        return preferences.getString(key, prefs_value).toString()
    }

    fun setString(key: String, prefs_value: String) {
        preferences.edit().putString(key, prefs_value).apply()
    }
}
