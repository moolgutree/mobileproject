package kr.ac.dmu.a0523lifecycle2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.dmu.a0523lifecycle2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // activity 이동 버튼 이벤트
        binding.button2.setOnClickListener() {
            var intent = Intent(this, InfoActivity::class.java )
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        binding.textView2.text = MyApplication.INSTANCE.name
    }


}
