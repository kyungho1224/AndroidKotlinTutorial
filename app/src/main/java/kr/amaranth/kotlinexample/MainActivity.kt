package kr.amaranth.kotlinexample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import kr.amaranth.kotlinexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var clickCount = 0

        binding.btnClick.setOnClickListener {
            clickCount += 1
            Snackbar.make(it, "click! $clickCount", Snackbar.LENGTH_SHORT).show()
        }

    }

}