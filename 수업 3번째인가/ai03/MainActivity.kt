package kr.ac.dmu.ai040403

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.dmu.ai040403.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var iV1 : Int
        var iV2 : Int
        var iResult : Int

        binding.button.setOnClickListener() {
            iV1 = binding.editV1.text.toString().toInt()
            iV2 = binding.editV2.text.toString().toInt()
            if(iV1 > iV2) {
                iResult = iV1 - iV2
            } else {
                iResult = iV2 - iV1
            }
            binding.tvResult.text = iResult.toString()

            for(i in 1 .. 10) {
                binding.textView4.text = binding.textView4.text.toString().plus("*")
            }
            for(index in 1 .. 10 step 2) {
                binding.textView4.text = binding.textView4.text.toString().plus("?")
            }
            for(index in 10  downTo 1) {
                binding.textView4.text = binding.textView4.text.toString().plus("?")
            }
            for(i in 1 until  10 step 2) {
                binding.textView4.text = binding.textView4.text.toString().plus("*")
            }
        }
    }
}
