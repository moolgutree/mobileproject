package kr.ac.dmu.pratice061501

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kr.ac.dmu.pratice061501.databinding.FragmentFilenameBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FilenameFragment : Fragment(R.layout.fragment_filename) {
    lateinit var binding: FragmentFilenameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = FragmentFilenameBinding.inflate(layoutInflater)

        binding.btnName.setOnClickListener() {
            MyApplication.preferences.setString("filename", "abc.txt")
        }
    }


}
