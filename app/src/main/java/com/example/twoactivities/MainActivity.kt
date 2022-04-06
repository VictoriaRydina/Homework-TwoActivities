package com.example.twoactivities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    private var mMessageEditText: EditText? = null
    private val LOG_TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMessageEditText = findViewById(R.id.editText_main)
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, ActivitySecond::class.java)
        val message = mMessageEditText!!.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
    }
}