package com.example.mjg70.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_consultar_materia.*

class ConsultarMateriaActivity : AppCompatActivity() {
    var padreId : Int = 0
    var usuario :String = "";
    var estudianteRespaldo : Estudiante? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuario = intent.getStringExtra("usuario").toString()
        estudianteRespaldo = intent.getParcelableExtra<Estudiante>("EstudianteRespaldo")
        padreId = intent.getIntExtra("padreId", -1)
        setContentView(R.layout.activity_consultar_materia)
        val adapter = ArrayAdapter<Materia>(
            this,
            android.R.layout.simple_list_item_1,
            BDMateria.mostrarMateria(padreId)
        )
        listView.adapter = adapter;
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val materiaSeleccionado = parent.getItemAtPosition(position) as Materia
            val intentMateriaSeleccionado = Intent(this, ActualizarMateriaActivity::class.java)
            intentMateriaSeleccionado.putExtra("usuario", usuario)
            intentMateriaSeleccionado.putExtra("Materia", materiaSeleccionado)
            intentMateriaSeleccionado.putExtra("EstudianteRespaldo", estudianteRespaldo)
            startActivity(intentMateriaSeleccionado)
        }
    }
}
