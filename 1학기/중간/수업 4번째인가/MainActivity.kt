package kr.ac.dmu.ai041101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kr.ac.dmu.ai041101.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 클래스 범위의 변수 선언
    var selectedOp: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // binding 설정
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 버튼 이번트 등록
        binding.btnCalc.setOnClickListener() {
            binding.tvResult.text = when {  // 자바의 스위치같은거
                selectedOp ==0 -> {
                    (binding.editNum1.text.toString().toInt() +
                            binding.editNum2.text.toString().toInt()).toString()
                }
                selectedOp==1 -> {
                    (binding.editNum1.text.toString().toInt() -
                            binding.editNum2.text.toString().toInt()).toString()
                }
                selectedOp==2 -> {
                    (binding.editNum1.text.toString().toInt() *
                            binding.editNum2.text.toString().toInt()).toString()
                }
                else -> {
                    if(binding.editNum2.text.toString().toInt() != 0) {
                        (binding.editNum1.text.toString().toInt() /
                                binding.editNum2.text.toString().toInt()).toString()
                    } else {
                        "0으로 나눌 수 없습니다."
                    }
                }
            }
        }

        // 1. resources에 정의된 string-array를 읽어온다. 따라서 타입은 string-array가 된다
        val items = resources.getStringArray(R.array.operatorArray)
        // val items2 = arrayOf("+", "-", "*", "/")
        // 위 두 줄이 같다 - 위는 리소스를 가져와 넣기, 아래는 직접넣기 - 위가 더 효율적임 ㅇㅇ
        // 두 번째 방법의 문제는 -1) 여러번 사용할 때 - 수정해야 할 때 여러번 수정해야 함

        //2. 어댑터 만들기 이거 뒤 주석 다 알아야힘
        val myAdapter = ArrayAdapter(this,                  // 어댑터를 만들 장소 -> 리소스에있는걸 가져와서 문자열 배열로 끼워넣는다
            android.R.layout.simple_spinner_dropdown_item,  // spinner의 모양 결정
            items)                                          // spinner에 넣을 데이터
        
        //3. 어댑터를 spinner 컴포넌트와 연결
        binding.spinner.adapter = myAdapter                 //교수님은 spinnerOperator

        //4. spinner에 이벤트 리스너 설정
        binding.spinner.onItemSelectedListener =    // = 코틀린 객체
            object: AdapterView.OnItemSelectedListener {// 스피너 이번트가 오브젝트가 어댑터 뷰 쓴다
                // 정의 해야할 메서드가 둘 이상일 때

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // 아무것도 할 게 없음( 선택이 안되었기 때문 ) - 함수는 만들어야 함(추상으로 만들어져서)
            }override fun onItemSelected(
                    parent: AdapterView<*>?, // 첫 번째 파라미터
                    view: View?, // 두 번째 파라미터
                    position: Int,  // 0부터
                    id: Long
            ) {
                    Log.d("check", "parent는 ${parent.toString()} 입니다") // spinner의 부모 클래스 컴포넌트
                    Log.d("check", "view는 ${view.toString()}") // spinner에서 실제 내용을 보여주는 컴포넌트
                    Log.d("check", "id는 ${position}") // 선택한 학목의 위치값으로 0부터, Array로 가지고온 뎅터의 배열 첨자
                    Log.d("check", "선택한 항목은 ${id}") // id는 항목의 공유값으로 position이다. // 성격 확인하려고 한거
                    selectedOp = position
            }
            }


    }
}
