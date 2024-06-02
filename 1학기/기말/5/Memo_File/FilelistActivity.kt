package com.android.memo_file

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.ArrayAdapter
import com.android.memo_file.databinding.ActivityFilelistBinding
import java.io.File

class FilelistActivity : AppCompatActivity() {

    // class 범위의 속성 변수
    lateinit var binding: ActivityFilelistBinding
    lateinit var rootSD: String
    lateinit var fileDir: File
    lateinit var fileList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_filelist)
        Log.d("myCheck", "FilelistActivity의 onCreate 메서드 실행")

        // lateinit 속성 변수 초기화
        binding = ActivityFilelistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rootSD = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString() // 저장 디렉토리

        fileDir = File(rootSD)
        fileList = ArrayList<String>()

        var list = fileDir.listFiles()   // 지정된 디렉터리의 파일 목록을 가져온다.
        // 파일 목록에서 기본으로 존재하는 파일은 제외
        for(i in 0 until list.size) { // list의 0번째 항목부터 (size -1) 항목까지 - ..안씀
            if(list[i].name != "profileInstalled" || !list[i].isDirectory )  {  // 기본으로 존재하는 파일이거나 디렉터리를 제외하기 위함
                // 기본으로 존재하는 파일의 이름 예: profileInstalled,
                // 디랙터리의 예:                 list[i].isDirectory가 참이면 해당 항목은 디렉터리
                // 두 가지 조건이 아닌 경우 파일 이름을 fileList에 추가
                fileList.add(list[i].name.toString())
            }
        }

        // fileList를 ArrayAdapter를 만들어 listView 컴포넌트의 adapter 설정하기
        binding.listView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fileList )

        // listView에서 항목을 선택하면  선택한 파일 이름을 MainActivity로 되돌려 주어야 한다.
        // listView의 항목선택 setOnItemClickedListener 이벤트 설정
        binding.listView.setOnItemClickListener() { adapterView, view, i, l ->
            // 3번째 인수가 선택된 항목의 index
            //binding.textView4.text = fileList[i]

            // 되돌아갈 intent 준비  --> intent말고 셰어드로
            var returnIntent = Intent()
            returnIntent.putExtra("fileNameToOpen", fileList[i])
            setResult(RESULT_OK, returnIntent)
            // 현재 activity 종료
            finish()
        }



    }
}
