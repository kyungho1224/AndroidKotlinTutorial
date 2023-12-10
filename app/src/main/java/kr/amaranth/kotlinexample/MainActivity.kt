package kr.amaranth.kotlinexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
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


        binding.btnIntent.setOnClickListener {
            val intent = Intent(this@MainActivity, SubActivity::class.java)
            startActivity(intent)
        }

        binding.btnIntentAndValue.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            intent.apply {
                this.putExtra("intentValue1", 10)
                this.putExtra("intentValue2", 20)
                this.putExtra("intentValue3", "Hello Kotlin")
            }
            startActivity(intent)
        }

        val activityLauncher = openActivityResultLauncher()
        binding.btnIntentAndResult.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            intent.apply {
                this.putExtra("intentValue1", 10)
                this.putExtra("intentValue2", 20)
            }
            activityLauncher.launch(intent)
        }

    }

    private fun openActivityResultLauncher(): ActivityResultLauncher<Intent> {
        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    result.data?.let {
                        Toast.makeText(
                            this,
                            "수신 성공 result: ${it.getIntExtra("sumResult", 0)}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(this, "수신 실패", Toast.LENGTH_SHORT).show()
                }
            }
        return resultLauncher
    }

}