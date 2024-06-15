package kr.ac.dmu.testteacher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.dmu.testteacher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var filenameIntent : Intent
    lateinit var filelistActivity: Intent
    var state: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // intent객체 변수 초기화
        filenameIntent = Intent(this, FilenameActivity::class.java)
        filelistActivity = Intent(this,FilelistActivity::class.java)
        
        binding.button2.setOnClickListener() { 
            // 새 메모 버튼
            state = 2
        }
        binding.button3.setOnClickListener() { 
            // 파일 저장
            // 파일 이름 받으러 activity 이동 - intent 이동(갖고 돌아올때 빈손으로 돌아옴)
            state = 4 // 액티비티 이동 코드 앞에 있어야됨
            startActivity(filenameIntent)

        }
        binding.button4.setOnClickListener() {
            // 파일 열기버튼
            state = 8
        }
    }
    override fun onRestart() {
        super.onRestart()
    }
    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        when(state) {
            1 -> { // 기본 시작
                Log.d("myCheck", "기본 시작 상태")

            }
            2 -> { // 새 메모 버튼
                Log.d("myCheck", "새 메모 버튼 클릭")
            }
            4 -> { // 파일 저장
                //sharedpriference 읽기
                val filename = Myapplication.preferences.getString("filename", "")
                Log.d("myCheck", "파일 이름 받고 옴")
                Log.d("myCheck", "저장할 팡리 이름은 ${filename}입니다")
                // 파일 저장(저장 코드 가져오면 됨)
            }
            8 -> { // 파일 열기
                Log.d("myCheck", "")
                // 선택한 파일 이름으로 파일 열기 - 이름 가져오는 코드

            }
        }
    }
}
