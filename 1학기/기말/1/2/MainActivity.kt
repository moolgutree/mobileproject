package kr.ac.dmu.ai050202

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kr.ac.dmu.ai050202.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener() {
            if (binding.imageView1.visibility == View.VISIBLE) {
                binding.imageView1.visibility = View.INVISIBLE
                binding.imageView2.visibility = View.VISIBLE
            } else {
                binding.imageView1.visibility = View.VISIBLE
                binding.imageView2.visibility = View.INVISIBLE
            }
        }

        binding.imageButton.setOnClickListener() {
            Toast.makeText(this, "이미지버튼 클릭", Toast.LENGTH_LONG).show()
        }
    }
}
