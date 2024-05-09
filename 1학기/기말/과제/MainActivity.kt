package kr.ac.dmu.ai050901

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kr.ac.dmu.ai050901.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    class MainActivity : AppCompatActivity() {
        lateinit var binding: ActivityMainBinding
        var aaa: Int = 0
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            //setContentView(R.layout.activity_main)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)


            var items = resources.getStringArray(R.array.image)
            var myAdapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                items
            )

            binding.spinner1234.adapter = myAdapter

            binding.spinner1234.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                    override fun onItemSelected(
                        parent: AdapterView<*>?, // 첫 번째 파라미터
                        view: View?, // 두 번째 파라미터
                        position: Int,  // 0부터
                        id: Long
                    ) {
                        aaa = position
                        if (aaa == 0) {
                            binding.imageView2.visibility = View.INVISIBLE
                            binding.imageView1.visibility = View.VISIBLE
                            Toast.makeText(this@MainActivity, "이미지스피너1 클릭", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            binding.imageView1.visibility = View.INVISIBLE
                            binding.imageView2.visibility = View.VISIBLE
                            Toast.makeText(this@MainActivity, "이미지스피너2 클릭", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
        }
    }
}
