package com.example.mjg70.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    var usuario :String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        usuario = intent.getStringExtra("usuario").toString()
        btnEstudiante.setOnClickListener {gestionarEstudiante() }
        btnCrearMateria.setOnClickListener{ crearEstudiante()}
    }

    fun gestionarEstudiante(){
        val intentGestionarEstudiante = Intent(this, ConsultarActivity::class.java)
        intentGestionarEstudiante.putExtra("usuario", usuario)
        startActivity(intentGestionarEstudiante)
    }

    fun crearEstudiante(){
        val intentCrearEstudiante = Intent(this, IngresarActivity::class.java)
        intentCrearEstudiante.putExtra("usuario", usuario)
        startActivity(intentCrearEstudiante)
    }
}
