package com.example.buttonclickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
private const val TAG="MainActivity"
private const val TEXT_CONTENTS="TextContents"
class MainActivity : AppCompatActivity() {
    private var textView:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"OnCreate:Called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userInput:EditText=findViewById<EditText>(R.id.editText)
        userInput.setText("")
        val button:Button=findViewById<Button>(R.id.button)
        textView=findViewById<TextView>(R.id.textView)
        textView?.text=""
        textView?.movementMethod=ScrollingMovementMethod()
        button.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                Log.d(TAG,"OnClick:Called")
                textView?.append("${userInput.text} \n")
                userInput.setText("")            }
        })
    }
    override fun onStart() {
        Log.d(TAG,"OnStart:Called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        Log.d(TAG,"onRestoreInstanceState:Called")
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text=savedInstanceState?.getString(TEXT_CONTENTS,"")
    }

    override fun onResume() {
        Log.d(TAG,"onResume:Called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG,"onPause:Called")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.d(TAG,"onSaveInstanceState:Called")
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENTS,textView?.text.toString())
    }

    override fun onStop() {
        Log.d(TAG,"onStop:Called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy:Called")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.d(TAG,"onRestart:Called")
        super.onRestart()
    }
}
