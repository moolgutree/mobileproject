package kr.ac.dmu.ai052301

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.dmu.ai052301.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_info)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("myCheck", "InfoActivtiy의 onCreate 실행")

        binding.textView.text = "이 앱은 \n인공지능학과에서 \n예제 앱이다."
        
        if(intent.hasExtra("name")) { //intent(정의 안되면 자기자신) 한테 넘어온것중 name이라는 Extra(보낸거)갖고 있나?
            binding.textView.text =
                binding.textView.text.toString() + "\n\n" + intent.getStringExtra("name") // 넣을때는 일일이 지정해서 꺼내야됨
        }
        if(intent.hasExtra("number")) {
            binding.textView.text =
                binding.textView.text.toString() + "\n\n" + intent.getIntExtra("number", 0) // number가 없을 때 디폴트값 무조건 지정해줘야됨 이번엔 0으로 써라
        }
        binding.button2.setOnClickListener() {
            finish() // 원래 activity로 돌아가기
            Log.d("myCheck", "원상복구 버튼 클릭함")
        }
    } // onCreate
    override fun onStart() {
        super.onStart()
        Log.d("myCheck", "InfoActivtiy의 onStart 실행")
    }

    override fun onResume() {
        super.onResume()
        Log.d("myCheck", "InfoActivtiy의 onResume 실행")
    }

    override fun onPause() {
        super.onPause()
        Log.d("myCheck", "InfoActivtiy의 onPause 실행")
    }

    override fun onStop() {
        super.onStop()
        Log.d("myCheck", "InfoActivtiy의 onStop 실행")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("myCheck", "InfoActivtiy의 onDestroy 실행")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("myCheck", "InfoActivtiy의 onRestart 실행")
    }
}
