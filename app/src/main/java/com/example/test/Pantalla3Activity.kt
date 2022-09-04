package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Pantalla3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla3)
    }

    override fun onBackPressed() {
        val intent = intent
        intent.putExtra("RESULTADO", "Mensaje desde la pantalla 3")
        setResult(RESULT_OK, intent)
        finish()
        super.onBackPressed()
    }

}