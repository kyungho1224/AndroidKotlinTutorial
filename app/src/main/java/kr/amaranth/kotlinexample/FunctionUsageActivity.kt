package kr.amaranth.kotlinexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kr.amaranth.kotlinexample.databinding.ActivityFunctionUsageBinding

class FunctionUsageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFunctionUsageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonFunctionBasic.setOnClickListener {
            Log.d("add result: ", add(1, 2).toString())
            binding.textviewResult.text = add(3, 4).toString()
        }

        /*
        일반적 호출
         */
        val result1 = add(20, 30)
        println(result1)

        /*
        명시적 함수 호출
         */
        val result2 = add(first = 10, second = 20)
        println(result2)

        val result3 = add(20, null)
        println(result3)

        val result4 = add(1, 2, 3, 4, 5)
        println(result4)

    }

    private fun add(first: Int, second: Int): Int {
        return first + second
    }

    private fun add(first: Int, second: Int? = 0): Int? {
        val result = second?.let {
            first.minus(it)
        }
        return result
    }

    private fun add(vararg numbers: Int) {
        for (number in numbers) {
            println(number)
        }
    }
}