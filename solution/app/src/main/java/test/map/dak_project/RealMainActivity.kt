package test.map.dak_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import test.map.dak_project.databinding.ActivityRealMainBinding

class RealMainActivity : AppCompatActivity() {
    private var realMainBinding: ActivityRealMainBinding? = null
    private val binding get() = realMainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityRealMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}