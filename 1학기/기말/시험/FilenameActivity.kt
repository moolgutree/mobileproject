package kr.ac.dmu.testteacher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.dmu.testteacher.databinding.ActivityFilenameBinding

class FilenameActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_filename)
        var binding = ActivityFilenameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener() {
            // SharedPreference에 이름 저장
            Myapplication.preferences.setString("filename", "abc.txt")
            finish()
        }
    }
}
