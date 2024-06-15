package kr.ac.dmu.pratice061501

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import kr.ac.dmu.pratice061501.databinding.ActivityMainBinding
import kr.ac.dmu.pratice061501.databinding.FragmentFilenameBinding
import java.io.BufferedReader
import java.io.File
import java.io.FileOutputStream
import java.io.FileReader

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var binding2: FragmentFilenameBinding
    lateinit var filelistActivity: Intent

    var isSaved = false
    var fileNameToSave = "New"
    var fileNameToOpen = ""
    var state: Int = 1

    lateinit var intentFilelist: Intent

    lateinit var filelistActivityResult: ActivityResultLauncher<Intent>
    lateinit var sharedpreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        filelistActivity = Intent(this,FilelistActivity::class.java)

        binding.btnSave.isEnabled = false
        binding.textView2.text = fileNameToSave

        filelistActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            // callback 실행 순서가 onRestart() 뒤가 된다.
            if(it.resultCode == RESULT_OK) {
                fileNameToOpen = it.data?.getStringExtra("fileNameToOpen")?:""
                binding.textView2.text = fileNameToOpen
                fileNameToSave = fileNameToOpen
                // 선택한 파일 open해서 editText 컴포넌트에 보여주기
                //openSelectedFile()
            }
        }

        binding.btnNewmemo.setOnClickListener {
            if (!isSaved && binding2.editText2.text.length != 0) {
                // 내용이 저장되지 않은 경우
                if( fileNameToSave == "New") {   // 파일 이름이 'New'이면 한 번도 저장되지 않은 경우
                    replaceFragment(FilenameFragment())
                } else {                        // 파일 이름이 'New'가 아니기 때문에 파일 이름은 이미 부여된 경우
                    saveToFile()
                    binding2.editText2.setText("")
                    fileNameToSave = "New"
                    binding.textView2.text = fileNameToSave
                    replaceFragment(MemoFragment())
                }
            } else {
                // 내용이 저장된 경우에는 다른 작업 없이 정리
                binding2.editText2.setText("")
                fileNameToSave = "New"
                binding.textView2.text = fileNameToSave
            }

        }
        binding.btnSave.setOnClickListener() {
            if( fileNameToSave == "New") {
                // 한 번도 저장되지 않았기 때문에 파일 이름을 받아오기 위한 intent 호출
                val temp = MyApplication.preferences.getString("Filemame", "")
            } else {
                saveToFile()
            }
            binding.btnSave.isEnabled = false

            state = 2
        }
        binding.btnOpen.setOnClickListener {
            // 파일을 열기 전에 현재 작업 중인 내용의 저장 여부 처리
            if (!isSaved && binding2.editText2.text.length != 0) {
                // 내용이 저장되지 않은 경우
                if( fileNameToSave == "New") {
                    replaceFragment(FilenameFragment())
                } else {
                    saveToFile()
                    replaceFragment(FilenameFragment())
                }
            } else {
                replaceFragment(FilenameFragment())
            }

        }
        binding2.editText2.addTextChangedListener ( object: TextWatcher {
            // 기본 3가지 메서드를 overriding 해야 한다.
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int)     {
                // 아무 것도 없음
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //
                isSaved = false // editText 컴포넌트에서 내용이 변경된 이후 저장되지 않음을 설정
                // 메모장의 내용이 변경되었기 때문에 '파일 저장' 버튼 활성화
                binding.btnSave.isEnabled = true
                val tmp = binding.textView2.text.toString().substring(binding.textView2.text.toString().length - 1)
                if( tmp != "*") {
                    binding.textView2.text = binding.textView2.text.toString() + "*"
                }
                if(state == 8 || state == 10) {
                    binding.textView2.text = fileNameToOpen
                    state = 1
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // 아무 것도 없음
            }
        })
    }

    override fun onResume() {
        super.onResume()
        if(state == 2) {
            if(!isSaved && binding2.editText2.text.length != 0) {
                // 현재 내용 저장
                saveToFile()
            }
            binding2.editText2.setText("")
            fileNameToSave = "New"
            binding.textView2.text = fileNameToSave
            openSelectedFile()
            }
        }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }

    fun saveToFile() {
        // editText의 내용을 파일로 저장한다.
        if(!isSaved) {
            // base 디렉토리 설정
            val baseDir =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString()
            val file = File(baseDir, fileNameToSave)
            val fos = FileOutputStream(file)
            fos.write(binding2.editText2.text.toString().toByteArray())
            fos.close()
        }
        // 파일 저장을 마치면 '저장하기' 버튼 비활성화
        binding.btnSave.isEnabled = false
        isSaved = true
    }
    fun openSelectedFile() {
        var baseDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString()

        var file = baseDir + "/" + fileNameToOpen

        var reader = FileReader(file)
        var buffer = BufferedReader(reader)

        var temp: String?
        var readContent: String = ""

        while(true) {
            temp = buffer.readLine()  // 한 줄을 읽어 temp에 저장
            if(temp  == null) break
            else readContent += temp + "\n"
        }
        buffer.close()
        reader.close()

        binding2.editText2.setText( readContent )

    }
}
