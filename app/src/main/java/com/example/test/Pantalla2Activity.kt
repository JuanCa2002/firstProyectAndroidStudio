package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Pantalla2Activity : AppCompatActivity() {
    val MESSAGE_DEBUG:String = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla2)
        showLog("1 onCreate")
    }

    override fun onStart() {
        super.onStart()
        showLog("2 onStart")
    }
    override fun onResume() {
        super.onResume()
        showLog("3 onResume")
    }
    override fun onPause() {
        super.onPause()
        showLog("4 onPause")
    }

    override fun onStop() {
        super.onStop()
        showLog("5 onStop")
    }
    override fun onRestart() {
        super.onRestart()
        showLog("6 onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
        showLog("7 onDestroy")
    }

    /**
     * Muestra un mensaje en consola usando el log level Debug
     */
    fun showLog(message:String){
        Log.d(MESSAGE_DEBUG, message)
    }
}