package kr.amaranth.kotlinexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.amaranth.kotlinexample.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var value1: Int
        var value2: Int
        var value3: String

        /*
        public inline fun <T, R> T.let(
            block: (T) -> R
        ): R
         */
        intent.let {
            value1 = intent.getIntExtra("intentValue1", 0)
            value2 = intent.getIntExtra("intentValue2", 0)
            value3 = intent.getStringExtra("intentValue3").toString()
        }
        Log.d("-----", "value1: $value1")
        Log.d("-----", "value2: $value2")
        Log.d("-----", "value3: $value3")

        binding.btnResultReturn.setOnClickListener {
            val intent = Intent(this@SubActivity, MainActivity::class.java)
            intent.putExtra("sumResult", value1 + value2)
            setResult(RESULT_OK, intent)
            finish()
        }

    }

}