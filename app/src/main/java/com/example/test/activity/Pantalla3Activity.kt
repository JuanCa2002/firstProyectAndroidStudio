package com.example.test.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test.R

class Pantalla3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_layout_activity)
    }

    override fun onBackPressed() {
        val intent = intent
        intent.putExtra("RESULTADO", "Mensaje desde la pantalla 3")
        setResult(RESULT_OK, intent)
        finish()
        super.onBackPressed()
    }

}