package kr.ac.dmu.ai050201

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.dmu.ai050201.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    // lateinit - 지금은 초기값이 없지만, 자눙에 초기화할 것이다.
    // lateinit var s1 : Int?  ==> 기본데이터타입에는 lateinit 안씀
    var s1 : String = ""
    var n1 : Int by lazy {
        s1.length
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("check", "함수 호출 결과는 ${functionTest(10, 20)}")
        Log.d("check", "함수 호출 결과는 ${functionTest(10)}")
        
        //var p = Person()
        //p.name = "홍길동"   // 객체지향이 캡슐화  위반

        var str1 : String?
        var str2 : String? = null
        str1 = "동양미래대학교"
        Log.d("check", "str1의 문자열 길이는 ${str1.length}")
        Log.d("check", "str1의 문자열 길이는 ${str2?.length}")
            // 변수?.함수 ==> 변수의 값이 null이 아닐 때만 함수 실행
            //               변수의 값이 null이면 함수 실행 안한다. 그냥 null
        Log.d("check", "str1의 문자열 길이는 ${str2?.length:0}")
    }


    fun functionTest(arg1: Int, arg2: Int = 10): Int {
        var temp: Int
        // arg1 = arg1 + 10 -- 함수 파라미터는 val(읽기 전용) 취급 이다.
        temp = arg1 + arg2
        // var temp2 = arg1 + arg2
        return temp
    }
}
