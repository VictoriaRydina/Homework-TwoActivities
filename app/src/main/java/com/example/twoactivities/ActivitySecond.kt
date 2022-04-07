package com.example.twoactivities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivitySecond : AppCompatActivity() {

    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    private var mReply: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        mReply = findViewById(R.id.editText_second)

        val intent = getIntent()
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.text_message)
        textView.text = message
    }

    fun returnReply(view: View) {
        val reply = mReply!!.text.toString()
        val replyIntent = Intent(this, MainActivity::class.java)
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }
}