package kr.ac.dmu.ai052301

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.dmu.ai052301.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // class 범위의 변수 - 클래스 속성
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("myCheck", "MainActivtiy의 onCreate 실행")
        
        // '앱 정보 보기' 버튼에 이벤트 설정
        binding.button.setOnClickListener() {
            // Activtiy 이동을 위해 Intent 객체 사용
            var intent = Intent(this, // 출발점
                InfoActivity::class.java // 이동할 activity
            )
            // intent에 데이터 넣기
            intent.putExtra("name","Main에서 보내는 데이터") // 문자열 보냄
            intent.putExtra("number",200) // 숫자 보냄
            startActivity(intent) // 이동

            // 버튼을 클릭하더라도 InfoActivity 넘어가기 전에 모든거 처리 후 이동
            Log.d("myCheck", "앱 정보 보기 버튼 클릭함")
        }
    }//onCreate

    override fun onStart() {
        super.onStart()
        Log.d("myCheck", "MainActivtiy의 onStart 첫 번째 실행")
    }

    override fun onResume() {
        super.onResume()
        Log.d("myCheck", "MainActivtiy의 onResume 실행")
        // onCreate -> onStart -> onResume
        binding.textView2.text = MyApplication.INSTANCE.gname
        binding.textView2.text =
            binding.textView2.text.toString() + MyApplication.INSTANCE.intDate
        // MyApplication.kt에 등록이 미리 된 것 MainActivity에서 찾아 사용
    }

    // start나 resume에서 파일정보 저장해야됨(정보가 있냐 없냐 구분해야됨)

    override fun onPause() {
        super.onPause()
        Log.d("myCheck", "MainActivtiy의 onPause 실행")
        // 데이터 처리 코드 넣지 않는다.
        // 순간 지나간다(일시멈춤 멈춤이 아님)
    }

    override fun onStop() {
        super.onStop()
        Log.d("myCheck", "MainActivtiy의 onStop 실행")
        // Activtiy 이동 후, 정리할 코드가 있다면 여기(onStop)에서
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("myCheck", "MainActivtiy의 onDestroy 실행")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("myCheck", "MainActivtiy의 onRestart 실행")
    }
}
