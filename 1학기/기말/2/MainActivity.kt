package kr.ac.dmu.ai050901

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kr.ac.dmu.ai050901.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var checkResult : Int = 0
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageButton.setOnClickListener() {
            Toast.makeText(this,
                            "이미지버튼 클릭했다.",
                            Toast.LENGTH_LONG).show()
        }

        binding.checkBox.setOnClickListener() {
            // checkbox 클릭여부 확인
            // checkbox 선택, 해제 구분 안됨
            // binding.checkBox.isChecked 속성은 체크- true / un체크 - false
            checkBoxClicked(binding.checkBox.id)
            // findViewById쓰는거랑 같음
        }
        binding.checkBox2.setOnClickListener() {
            checkBoxClicked(binding.checkBox2.id)
        }
        binding.radioGroup.setOnCheckedChangeListener() { group, checkedId ->
            Log.d("check", "$group")
            Log.d("check", "$checkedId")
            var radioResult = ""
            when(checkedId){
                // viewBinding에서 컴포넌트 id 확인
                // 최신 binding방식
                binding.radioButton.id -> {
                    // binding.radioButton.isChecked ==> 도 상관 없음
                    radioResult = "첫 번째 radio 선택"
                }
                // 예전 java방식
                R.id.radioButton2 -> {
                    radioResult = "두 번째 radoi 선택"
                }
            }
            var builder = AlertDialog.Builder(this)
            builder.setTitle("RadioButton Result")
            builder.setMessage(radioResult)
            builder.show()
        }

        binding.toggleButton.setOnClickListener() {
            var msg : String
            if(binding.toggleButton.isChecked) {
                msg = "토글버튼 ON"
                binding.toggleButton.setText(msg)
            } else {
                msg = "토글버튼 OFF"
                binding.toggleButton.setText(msg)
            }
            var builder = AlertDialog.Builder(this)
            builder.setTitle("토글버튼 결과")
            builder.setMessage(msg)
            builder.show()
        }
        // switch도 똑같음
        binding.switch1.setOnClickListener() {
            var msg : String
            if(binding.switch1.isChecked) {
                msg = "스위치 ON"
                binding.switch1.setText(msg)
            } else {
                msg = "스위치 OFF"
                binding.switch1.setText(msg)
            }
            var builder = AlertDialog.Builder(this)
            builder.setTitle("스위치 결과")
            builder.setMessage(msg)
            builder.show()
        }

    }// onCreate
    fun checkBoxClicked(id: Int) {
        when(id) {
            R.id.checkBox -> {
                if (binding.checkBox.isChecked) {
                    checkResult += 1
                } else {
                    checkResult -= 1
                }
            }
            R.id.checkBox2 -> {
                if (binding.checkBox2.isChecked) {
                    checkResult += 2
                } else {
                    checkResult -= 2
                }
            }
        }
        when(checkResult) {
            0 -> {Toast.makeText(this, "선택 없음", Toast.LENGTH_SHORT).show()}
            1 -> {Toast.makeText(this, "선택1 선택", Toast.LENGTH_SHORT).show()}
            2 -> {Toast.makeText(this, "선택2 선택", Toast.LENGTH_SHORT).show()}
            3 -> {Toast.makeText(this, "둘 다 선택", Toast.LENGTH_SHORT).show()}
        }
    }
}
