package com.example.twoactivities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivitySecond : AppCompatActivity() {

    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = getIntent()
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.text_message)
        textView.text = message
    }
}