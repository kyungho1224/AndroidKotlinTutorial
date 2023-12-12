package kr.amaranth.kotlinexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.amaranth.kotlinexample.databinding.ActivityControlFlowBinding

class ControlFlowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityControlFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val a: Int = 10
        val b: Int = 20

        /* 일반적인 사용 */
        if (a > b) {
            println("a가 b보다 크다.")
        } else if (a < b) {
            println("a가 b보다 작다.")
        } else {
            println("a와 b는 같다.")
        }

        /* 결과를 변수에 할당 */
        val max = if (a > b) {
            a
        } else {
            b
        }

        /* 엘비스 */
        val num1: Int? = null
        val num2 = num1 ?: 100
        println(num2)

        /* when */
        val value: Int? = null
        when (value) {
            null -> println("value is null")
            else -> println("value is not null")
        }

        val bool: Boolean? = null
        when (bool) {
            true -> println("bool is true")
            false -> println("bool is false")
            null -> println("bool is null")
        }

        var num: Int = 100
        when (num) {
            is Int -> {
                println("num is Int")
            }
            else -> {
                println("num is not Int")
            }
        }

        num = 88
        when (num) {
            in 60..70 -> {
                println("num is 60-70")
            }
            in 71..80 -> {
                println("num is 71-80")
            }
            in 81..90 -> {
                println("num is 81-90")
            }
            else -> {
                println("num is ?????")
            }
        }

    }

}