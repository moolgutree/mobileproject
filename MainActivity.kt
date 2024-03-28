package kr.ac.dmu.ai0328

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import kr.ac.dmu.ai0328.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTextView.text = "DMU"

        binding.btnCancel.setOnClickListener() {
            binding.tvTextView.text = "DMU"
            binding.editName.setText("")
            binding.editNumPwd.setText("")
        }
        binding.btnOK.setOnClickListener() {
            binding.tvTextView.text = binding.editName.text
        }
    }
}
