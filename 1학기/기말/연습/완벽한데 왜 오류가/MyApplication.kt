package kr.ac.dmu.pratice061501

import android.app.Application

class MyApplication: Application() {

    companion object {
        lateinit var preferences: PreferenceUtil   // 사용자 정의 타입(안드로이드 타입 아님)
    }

    override fun onCreate() {
        super.onCreate()
        preferences = PreferenceUtil(applicationContext) // 앱 자기 자신
    }
}
