package kr.ac.dmu.ai052301

import android.app.Application

class MyApplication: Application() {
    var gname: String = "홍길동"
    var intDate: Int = 300
    var INSTANCE: MyApplication // 나 자신

    // 객체 프로퍼티(속성) 초기화 // 초기화 방법 1
    init {
        INSTANCE = this
    }

    // java에서 static // 초기화 방법 2
    companion object { // data object
        lateinit var INSTANCE: MyApplication
    }
}
