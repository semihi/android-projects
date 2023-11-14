package com.example.solvingtimer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_launch.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        numberPicker.minValue=20
        numberPicker.maxValue=600
        numberPicker.value=60

        btnStart.setOnClickListener {
            val intent = Intent(this,TimerActivity::class.java)
            intent.putExtra("targetTime",numberPicker.value)
            startActivity(intent)
            finish()
        }
    }
}