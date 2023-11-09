package com.example.solvingtimer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.NumberPicker
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_launch.*
import kotlin.concurrent.fixedRateTimer


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        numberPicker.minValue=20
        numberPicker.maxValue=600
        numberPicker.value=60


        Log.d("myLog","0 0 0 0 0")

        btnStart.setOnClickListener {

            val intent = Intent(this,TimerActivity::class.java)
            intent.putExtra("targetTime",numberPicker.value)
            Log.d("myLog","1 1 1 1 1")
            finish()

            Log.d("myLog","2 2 2 2 2")
            startActivity(intent)
            Log.d("myLog","3 3 3 3 3")

        }

        var isRunning: Boolean = false
        var prog: Int = 0


//            progressBar.max = Integer.parseInt(inputMax.getText().toString());

//        btnStart.setOnClickListener() {
//
//            if (isRunning == false) {
//                isRunning = true
//
//                fixedRateTimer("timer", false, 0L, 1000){
//                    this@MainActivity.runOnUiThread {
//                        if (prog<progressBar.max) {
//                            prog = prog+1
//                            progressBar.progress = prog
//                        } else {
//
//                        }
//                    }
//                }
//            }
//        }
    }
}