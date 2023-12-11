package kr.amaranth.kotlinexample

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kr.amaranth.kotlinexample.databinding.ActivityThreadBinding

class ThreadActivity : AppCompatActivity() {

    val threadStart = 0
    val threadStop = 1
    private var timeThread: TimeThread? = null
    var timeHandler: TimeHandler = TimeHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityThreadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonThreadStart.setOnClickListener {
            timeThread = TimeThread()
            timeThread?.startFlag()
            timeThread?.start()
        }

        binding.buttonThreadStop.setOnClickListener {
            timeHandler.sendEmptyMessage(threadStop)
        }

    }

    inner class TimeThread : Thread() {

        private var time = 0
        private var isPlaying = false

        fun startFlag() {
            isPlaying = true
        }

        fun stopFlag() {
            isPlaying = false
        }

        override fun run() {
            super.run()
            while (isPlaying) {
                val message: Message = Message.obtain()
                message.what = threadStart
                message.arg1 = time++
                message.obj = " 초 경과"
                timeHandler.sendMessage(message)
                sleep(1000)
            }
        }
    }

    inner class TimeHandler: Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                threadStart -> {
                    Log.d("Timer", msg.arg1.toString() + msg.obj)
                }
                threadStop -> {
                    timeThread?.stopFlag()
                    timeThread = null
                }
                else -> {

                }
            }
        }
    }

}