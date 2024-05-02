package kr.ac.dmu.ai040401

import android.graphics.Color
import android.graphics.Color.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.dmu.ai040401.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var count = 1
        // var myVariable  타입을 지정하거나, 초기값이 있어야 한다.
        var myVar = Int
        myVar =
        var myVar2 : Long
        myVar2 = 2348263364
        var myVar3 : Float = 3.14f
        var myVar4 : Double = 3.14
        val myVar5 : Int = 10

        binding.button.setOnClickListener() {
            binding.tvBasic.text = "동양미래대학교"
            binding.tvBasic.setTextColor(Color.RED)
            count += 1
            Log.d("dmuai", "로그 객체를 사용한다. ")
            Log.d("dmuai", "count 변수의 값은 ${count} 이다. ")
        }
    }
}
