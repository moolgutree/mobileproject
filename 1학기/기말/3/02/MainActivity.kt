package kr.ac.dmu.ai051602

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import kr.ac.dmu.ai051602.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // 저장 여부 확인하는 속성
    private var isSaved = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // '새 메모' 버튼 이벤트
        binding.button.setOnClickListener() {
            if(isSaved) { // 저장 되어있는경우
            //binding.editText.setText("")
            } else { // 저장 안되어있는경우
                // 파일 저장
                saveToFile()
            }
            binding.editText.setText("")
        }
        // '저장' 버튼 이벤트
        binding.button2.setOnClickListener() {
            saveToFile()
        }
        // exitText 컴포넌트 이벤트 처리
        binding.editText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("check", "내용 변경 전")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("check", "내용 변경 중")
                isSaved = false
                binding.button2.isEnabled = true
                binding.textView2.setText(binding.textView2.text.toString() + "*")
            }

            override fun afterTextChanged(s: Editable?) {
                Log.d("check", "내용 변경 후")

            }
        })
    }
    fun saveToFile() {
        // editText 컴포넌트의 내용을 파일로 저장
        isSaved = true
        binding.textView2.setText(binding.textView2.text.toString() + "&")

        // var dateAndTime: LocalDateTime = LocalDateTime.now()  // 파일 이름을 현재 날짜시간...으로
        var dateAndTime = System.currentTimeMillis()

        var outputFile: FileOutputStream =
            openFileOutput(dateAndTime.toString() + ".txt", MODE_PRIVATE) // 넣을 준비
        outputFile.write(binding.editText.text.toString().toByteArray()) // 파일로
        outputFile.close() // 사용된 파일 닫기
        // 위치: data/data/쓰던패키지/여기에제장

        // 파일 저장 2
        // base 디렉토리 설정 -> 이거가 중요
        var baseDir =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString()
        //var filePath = "${baseDir}/${dateAndTime}"
        var file = File(baseDir, dateAndTime.toString()) //파일 객체를 따로 만듦
        val fos = FileOutputStream(file)
        fos.write(binding.editText.text.toString().toByteArray())
        fos.close()
    }
}
