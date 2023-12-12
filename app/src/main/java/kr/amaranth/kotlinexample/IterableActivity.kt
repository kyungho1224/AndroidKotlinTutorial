package kr.amaranth.kotlinexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.amaranth.kotlinexample.databinding.ActivityIterableBinding

class IterableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityIterableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)
        println(list)

        /* for basic without index */
        for (item in list) {
            print(item)
        }
        println()

        /* for with index */
        for ((i, item) in list.withIndex()) {
            if (i < list.count() - 1) {
                print("$item, ")
            } else {
                print("$item")
            }
        }
        println()

        /* forEach */
        list.forEach {
            println(it)
        }

        /* forEach use name */
        list.forEach { item ->
            println(item)
        }

        /* forEach with index */
        list.forEachIndexed { index, item ->
            println("index: $index = item: $item")
        }

        /*
        index search
        until : 0 ~ list.size - 1
        .. : 0 ~ list.size
         */
        for (i in 0 until list.size) {
            print("$i : ")
            println(list[i])
        }
        for (i in 0 until list.size step 2) {
            print("$i : ")
            println(list[i])
        }
        for (i in list.size - 1 downTo 0) {
            print("$i : ")
            println(list[i])
        }
        for (i in list.size - 1 downTo 0 step 2) {
            print("$i : ")
            println(list[i])
        }
        for (i in 0 .. 10) {
            println(i)
        }

        /* while */
        var start = 0
        val end = 5
        while (start < end) {
            start++
            println("while $start")
        }

        /* do while */
        do {
            start--
            println("do while $start")
        } while (start == 0)

    }

}