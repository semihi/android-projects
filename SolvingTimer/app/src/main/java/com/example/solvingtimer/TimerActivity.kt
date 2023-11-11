package com.example.solvingtimer

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_timer.btnStartPause
import kotlinx.android.synthetic.main.activity_timer.progressBarFirst
import kotlinx.android.synthetic.main.activity_timer.textTimer

class TimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        Log.d("myLog","4 4 4 4 4")

        var intent = intent
        var targetTime = intent.getIntExtra("targetTime",60)
        progressBarFirst.max=targetTime

        Log.d("myLog",targetTime.toString())

        var duration: Int = 0
        var prog: Int = 0
        var running: Boolean = true
        var seconds: Int = 0

        btnStartPause.setOnClickListener {

            val handler = Handler()
            handler.post(object : Runnable {
                override fun run() {
                    if (running) {
                        seconds++
                        val minutes = seconds / 60
                        val secs = seconds % 60

                        textTimer.text = String.format("%2d:%02d", minutes, secs)

                        handler.postDelayed(this, 1000)
                    }
                }
            })


        }
    }
}
