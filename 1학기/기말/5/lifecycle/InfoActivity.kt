package kr.ac.dmu.a0523lifecycle2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.dmu.a0523lifecycle2.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_info)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener() {
            MyApplication.INSTANCE.name = binding.editTextText.text.toString()
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        binding.textView.text = MyApplication.INSTANCE.name
    }


}
