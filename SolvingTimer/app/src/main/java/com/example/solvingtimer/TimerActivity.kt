package com.example.solvingtimer

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_timer.btnNext
import kotlinx.android.synthetic.main.activity_timer.btnStartPause
import kotlinx.android.synthetic.main.activity_timer.progressBarFirst
import kotlinx.android.synthetic.main.activity_timer.progressBarSecond
import kotlinx.android.synthetic.main.activity_timer.progressBarThird
import kotlinx.android.synthetic.main.activity_timer.textNumQuestion
import kotlinx.android.synthetic.main.activity_timer.textTimer
import kotlinx.android.synthetic.main.activity_timer.textTotalTime

class TimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        var intent = intent
        var targetTime = intent.getIntExtra("targetTime",60)
        progressBarFirst.max=targetTime
        progressBarSecond.max=targetTime
        progressBarThird.max=targetTime

        var running: Boolean = false
        var seconds: Int = 0
        var Startion: Int = 0
        val handler = Handler()
        var minutes = 0
        var secs = 0
        var numQuestion = 1

        fun startTimer() {
            btnStartPause.text = "Duraklat"
            running = true
            seconds--
            handler.post(object : Runnable {
                override fun run() {
                    if (running) {
                        seconds++
                        minutes = (seconds-Startion) / 60
                        secs = (seconds-Startion) % 60

                        textTimer.text = String.format("%2d:%02d", minutes, secs)
                        progressBarFirst.progress = seconds-Startion
                        progressBarSecond.progress = seconds-Startion-targetTime
                        progressBarThird.progress = seconds-Startion-2*targetTime

                        textTotalTime.text = String.format("%02d:%02d", seconds/60, seconds % 60)

                        handler.postDelayed(this, 1000)
                    }
                }
            })
        }

        fun pauseTimer() {
            btnStartPause.text = "Devam Et"
            running = false
            handler.removeCallbacksAndMessages(null)
        }

        btnNext.setOnClickListener {
            pauseTimer()
            startTimer()

            numQuestion++
            textNumQuestion.text = numQuestion.toString()+". Soru"
            Startion = seconds+1
            minutes = 0
            secs = 0
        }

        btnStartPause.setOnClickListener {
            if (!running) {
                startTimer()
            } else {
                pauseTimer()
            }
        }
    }
}
