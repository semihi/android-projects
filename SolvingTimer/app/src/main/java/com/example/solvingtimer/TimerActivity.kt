package com.example.solvingtimer

import android.os.Bundle
import android.os.Handler
import android.util.Log
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
        progressBarFirst.max=targetTime*1000
        progressBarSecond.max=targetTime*1000
        progressBarThird.max=targetTime*1000


        val handler = Handler()
        var running: Boolean = false
        var numQuestion: Int = 1
        var timeStarted: Long = 0
        var timePaused: Long = 0
        var timeQsStarted: Long = 0
        var timeQsPaused: Long = 0
        var durRunning: Long
        var durPaused: Long = 0
        var durQsPaused: Long = 0
        var durQsRunning: Long


        fun continueTimer() {
            btnStartPause.text = "Duraklat"
            running = true
            durPaused += System.currentTimeMillis() - timePaused
            durQsPaused += System.currentTimeMillis() - timeQsPaused


            handler.post(object : Runnable {
                override fun run() {

                    durRunning = (System.currentTimeMillis() - timeStarted - durPaused)/1000
                    durQsRunning = (System.currentTimeMillis() - timeQsStarted - durQsPaused)/1000


                    textTimer.text = String.format("%2d:%02d", (durQsRunning.toInt()) / 60, (durQsRunning.toInt()) % 60)
                    textTotalTime.text = String.format("%02d:%02d", (durRunning.toInt()) / 60, (durRunning.toInt()) % 60)

                    handler.postDelayed(this, 1000)
                }
            })

            handler.post(object : Runnable {
                override fun run() {
                    if (running){
                        progressBarFirst.progress = (System.currentTimeMillis() - timeQsStarted - durQsPaused).toInt()
                        progressBarSecond.progress =(System.currentTimeMillis() - timeQsStarted - durQsPaused).toInt() - 1000*targetTime
                        progressBarThird.progress = (System.currentTimeMillis() - timeQsStarted - durQsPaused).toInt() - 2000*targetTime
                        handler.postDelayed(this, 10)
                    }
                }
            })

        }

        fun pauseTimer() {
            btnStartPause.text = "Devam Et"
            running = false
            handler.removeCallbacksAndMessages(null)
            timePaused = System.currentTimeMillis()
            timeQsPaused = System.currentTimeMillis()
        }

        fun startTimer() {
            timeStarted = System.currentTimeMillis()
            timeQsStarted = System.currentTimeMillis()
            timePaused = System.currentTimeMillis()
            timeQsPaused = System.currentTimeMillis()
            continueTimer()
        }


        btnStartPause.setOnClickListener {
            if (!running) {
                if (timeStarted == 0L) {
                    startTimer()
                } else {
                    continueTimer()
                }
            } else {
                pauseTimer()
            }
        }

        btnNext.setOnClickListener {
            pauseTimer()
            continueTimer()

            durQsPaused = 0
            numQuestion++
            textNumQuestion.text = numQuestion.toString()+". Soru"
            timeQsStarted = System.currentTimeMillis()
        }


    }
}
