package kr.amaranth.kotlinexample

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class ArrayActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array)

        val array = arrayOf<Int>(1, 2, 3)

        var number = array.get(0)
//        println(number)
        number = array[0]
//        println(number)

        array.set(0, 5)
        number = array.get(0)
//        println(number)
        number = array[0]
//        println(number)

        val intArray = intArrayOf(1, 2, 3, 4, 5)
        val charArray = charArrayOf('a', 'b', 'c')
        val doubleArray = doubleArrayOf(1.2, 3.14, 100.123)
        val boolArray = booleanArrayOf(true, true, false, true)

        var list = Array(5, init = { 0 })
//        println(list.toString())
//        println(list[4])

        /* list */
        val numberList = listOf<Int>(1, 2, 3, 4, 5, 6)
        println(numberList)
//        for (n in numberList) {
//            print("$n")
//        }
//        println()

        /* set 중복 안됨, 순서 보장 안됨 */
        val numberSet = setOf<Int>(1, 2, 3, 4, 4, 4)
        println(numberSet)
//        numberSet.forEach {
//            print("$it, ")
//        }
//        println()

        /* map */
        val numberMap = mapOf<String, Int>("one" to 1, "two" to 2)
//        println(numberMap.get("one"))
//        println(numberMap["one"])

        /* mutable */
        val mNumberList = mutableListOf<Int>(1, 2, 3)
        mNumberList.add(3, 4)
//        println(mNumberList)
        mNumberList.add(0, 10)
//        println(mNumberList)

        val mNumberSet = mutableSetOf<Int>(1, 2, 3, 3, 4, 4, 5)
        mNumberSet.add(9)
//        println(mNumberSet)

        val mNumberMap = mutableMapOf<String, Int>("one" to 1, "two" to 2)
        mNumberMap.put("three", 3)
        mNumberMap["four"] = 4
        mNumberMap.put("four", 4)
        mNumberMap.replace("one", 10)
        println(mNumberMap.keys)
        println(mNumberMap.values)
//        println(mNumberMap)
        /* mutable */

    }

}