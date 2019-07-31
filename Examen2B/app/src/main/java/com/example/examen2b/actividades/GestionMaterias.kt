package com.example.examen2b.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examen2b.R
import kotlinx.android.synthetic.main.activity_gestion_medicamentos.*

class GestionMaterias : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_medicamentos)
        val idPaciente = this.intent.getIntExtra("idEstudiante", -1)

        btn_gestionarPeliculas.setOnClickListener {
            irListaMaterias(idPaciente)
        }


        btn_registrarPelicula.setOnClickListener {
            irCrearMateria(idPaciente)
        }
        btn_mapa.setOnClickListener {
            irMapa(idPaciente)
        }
    }

    fun irListaMaterias(idPaciente: Int) {
        val intent = Intent(
            this,
            ListaMateria::class.java
        )
        intent.putExtra("idEstudiante", idPaciente)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun irCrearMateria(idPaciente: Int) {
        val intent = Intent(
            this,
            CrearMateria::class.java
        )
        intent.putExtra("idEstudiante", idPaciente)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun irMapa(idPaciente: Int) {
        val intent = Intent(
            this,
            MapsActivity::class.java
        )
        intent.putExtra("idEstudiante", idPaciente)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
