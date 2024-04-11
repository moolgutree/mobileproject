package kr.ac.dmu.ai041101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.dmu.ai041101.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // binding 설정
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 버튼ㅇ 이번트 등록
        binding.btnCalc.setOnClickListener() {
            binding.tvResult.text = (binding.editNum1.text.toString().toInt() +
                    binding.editNum2.text.toString().toInt()).toString()
        }

        // resources에 정의된 string-array를 읽어온다. 따라서 타입은 string-array가 된다
        val items = resources.getStringArray(R.array.operatorArray)
        // val items2 = arrayOf("+", "-", "*", "/")
        // 위 두 줄이 같다 - 위는 리소스를 가져와 넣기, 아래는 직접넣기 - 위가 더 효율적임 ㅇㅇ
        // 두 번째 방법의 문제는 -1) 여러번 사용할 때 - 수정해야 할 때 여러번 수정해야 함
    }
}
