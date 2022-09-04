package com.example.test.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.test.R

class MainActivity : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    lateinit var textoInicial:String
    //Esta será la etiqueta que será usada como base para dar seguimiento al
    //comportamiento del ciclo de vida de la actividad
    val MESSAGE_DEBUG:String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result
                -> onActivityResult(result.resultCode, result ) }
        showLog("1 onCreate")
        val boton = findViewById<Button>(R.id.boton_cambio)
        val texto:TextView = findViewById(R.id.mensajeInicial)

        if(savedInstanceState !=null){
            textoInicial= savedInstanceState.getString("texto").toString()
            texto.text= textoInicial
        }else{
            textoInicial = "Mensaje Inicial!"
            texto.text = textoInicial
        }

        boton.setOnClickListener {
            textoInicial= "Cambio de texto"
            texto.text = textoInicial
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("texto", textoInicial)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e(MainActivity::class.java.simpleName, savedInstanceState.getString("texto").toString())
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

    private fun onActivityResult(requestCode: Int, result: ActivityResult) {
        val data = result.data?.extras
        if(result.resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "Mensaje enviado: ${data?.getString("RESULTADO")}",
                Toast.LENGTH_LONG).show()
        }
    }


    fun irPantalla2(view: View) {
        //Toast es usado para mostrar un mensaje en pantalla.
        Toast.makeText(this, "Se mostro pantalla numero 2", Toast.LENGTH_LONG).show()
        //Comando usado para mostrar la informacion en consola.
        Log.v(MainActivity::class.java.simpleName, "Pasar a la pantalla 2")
        val intent = Intent(this, Pantalla2Activity::class.java)
        startActivity(intent)
    }

    fun irPantalla3(view: View){
        Log.v(MainActivity::class.java.simpleName,"Pasar a pantalla 3")
        val intent = Intent(this, Pantalla3Activity::class.java)
        resultLauncher.launch(intent)
    }



    /**
     * Muestra un mensaje en consola usando el log level Debug
     */
    fun showLog(message:String){
        Log.d(MESSAGE_DEBUG, message)
    }


}


