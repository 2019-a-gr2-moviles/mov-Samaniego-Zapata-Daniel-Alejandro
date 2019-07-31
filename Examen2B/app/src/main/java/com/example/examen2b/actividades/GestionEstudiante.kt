package com.example.examen2b.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examen2b.R
import kotlinx.android.synthetic.main.activity_gestion_pacientes.*

class GestionEstudiante : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_pacientes)
        btn_gestionActores.setOnClickListener {
            irListaEstudiantes()
        }
        btn_crearActor.setOnClickListener {
            irCrearEstudiante()
        }
    }
    private fun irListaEstudiantes() {
        val intent = Intent(
            this,
            ListaEstudiantes::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun irCrearEstudiante() {
        val intent = Intent(
            this,
            CrearEstudiante::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
        startActivity(intent)
    }

}
