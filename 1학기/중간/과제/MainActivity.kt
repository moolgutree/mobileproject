package kr.ac.dmu.ai0328

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.ac.dmu.ai0328.databinding.ActivityMainBinding
import java.lang.Integer.parseInt


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var num1: String
        var num2: String
        var result: Int

        binding.btnPlus.setOnClickListener {


            num1 = binding.editNum1.getText().toString();
            num2 = binding.editNum2.getText().toString();
            result = Integer.parseInt(num1) + Integer.parseInt(num2)
            binding.tvResult2.setText(result.toString());
        }
    }
}
