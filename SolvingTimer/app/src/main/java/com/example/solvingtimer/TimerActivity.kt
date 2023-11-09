package com.example.solvingtimer

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class TimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        Log.d("myLog","4 4 4 4 4")

        var intent = intent
        var targetTime = intent.getIntExtra("targetTime",60)

        Log.d("myLog","5 5 5 5 5")

    }
}
