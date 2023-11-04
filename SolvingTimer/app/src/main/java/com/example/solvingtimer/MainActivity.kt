package com.example.solvingtimer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.fixedRateTimer
import android.os.Handler
import android.os.Looper


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSet.setOnClickListener {
            progressBar.max = Integer.parseInt(inputMax.getText().toString());
        }

        var isRunning: Boolean = false
        var prog: Int = 0


        btnStart.setOnClickListener() {

            if (isRunning == false) {
                isRunning = true

                fixedRateTimer("timer", false, 0L, 1000){
                    this@MainActivity.runOnUiThread {
                        if (prog<progressBar.max) {
                            prog = prog+1
                            progressBar.progress = prog
                        } else {

                        }
                    }
                }
            }
        }
    }
}