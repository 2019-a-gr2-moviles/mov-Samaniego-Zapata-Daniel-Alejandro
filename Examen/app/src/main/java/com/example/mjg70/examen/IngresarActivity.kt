package com.example.mjg70.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar.*

class IngresarActivity : AppCompatActivity() {
    var usuario:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar)
        usuario = intent.getStringExtra("usuario").toString()
        btnGuardarEstudiante.setOnClickListener { aceptarIngreso() }
        btnCancelarEstudiante.setOnClickListener { cancelarIngreso()}
    }

    fun cancelarIngreso(){
        val intentCancelar= Intent(this, MenuActivity::class.java)
        intentCancelar.putExtra("usuario", usuario)
        startActivity(intentCancelar)
    }

    fun aceptarIngreso(){
        val estudiante= Estudiante(id = null,
            nombres = imput_Nombre.text.toString(),
            apellidos = imput_Apellido.text.toString(),
            fechaNacimiento = txtFechaNacimiento.text.toString(),
            semestreActual = txtSemestreActual.text.toString().toInt(),
            graduado = txtGraduado.text.toString())
        BDEstudiante.agregarEstudiante(estudiante)
        Toast.makeText(this, "Ingreso exitoso "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }
}
