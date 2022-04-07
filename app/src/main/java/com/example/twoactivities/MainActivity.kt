package com.example.twoactivities

import android.R.attr
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val TEXT_REQUEST = 1
    private var mReplyHeadTextView: TextView? = null
    private var mReplyTextView: TextView? = null

    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    private var mMessageEditText: EditText? = null
    private val LOG_TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMessageEditText = findViewById(R.id.editText_main)

        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, ActivitySecond::class.java)
        val message = mMessageEditText!!.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)

    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int, data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST && resultCode == RESULT_OK) {
            val reply: String = data?.getStringExtra(EXTRA_REPLY).toString()
            mReplyHeadTextView!!.visibility = View.VISIBLE
            mReplyTextView!!.text = reply
            mReplyTextView!!.visibility = View.VISIBLE
        }
    }
}