package com.example.mjg70.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_consultar.*

class ConsultarActivity : AppCompatActivity() {
    var usuario :String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)
        usuario = intent.getStringExtra("usuario").toString()
        val adapter = ArrayAdapter<Estudiante>(
            this,
            android.R.layout.simple_list_item_1,
            BDEstudiante.mostrarEstudiante()
        )
        listView.adapter = adapter;
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val estudianteSeleccionado = parent.getItemAtPosition(position) as Estudiante
            val intentEstudianteSeleccionado = Intent(this, ActualizarActivity::class.java)
            intentEstudianteSeleccionado.putExtra("Estudiante", estudianteSeleccionado)
            intentEstudianteSeleccionado.putExtra("usuario", usuario)
            startActivity(intentEstudianteSeleccionado)
        }


    }
}
