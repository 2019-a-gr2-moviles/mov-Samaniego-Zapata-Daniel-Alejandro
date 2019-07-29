package com.example.examen2b.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.examen2b.R
import com.example.examen2b.adaptador.AdaptadorListaEstudiante
import com.example.examen2b.modelo.*
import com.example.examen2b.valoresEstaticos.Datos
import com.example.examen2b.valoresEstaticos.Servidor
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_lista_pacientes.*

class ListaEstudiantes : AppCompatActivity() {
    private var listaEstudiantes: ArrayList<Estudiante> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        obtenerPacientes()
        setContentView(R.layout.activity_lista_pacientes)
    }

    fun iniciarRecyclerView(
        listaEstudiantes: ArrayList<Estudiante>,
        actividad: ListaEstudiantes,
        recyclerView: androidx.recyclerview.widget.RecyclerView
    ) {
        val adaptadorCliente = AdaptadorListaEstudiante(listaEstudiantes, actividad, recyclerView)
        rv_pacientes.adapter = adaptadorCliente
        rv_pacientes.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        rv_pacientes.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)

        adaptadorCliente.notifyDataSetChanged()
    }

    private fun obtenerPacientes() {

        val url = Servidor.url("actor")
        Log.i("http", url)
        url.httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http", "Data: ${data}")

                        listaEstudiantes = Klaxon()
                            .parseArray<Estudiante>(data)!! as ArrayList<Estudiante>


                        Log.i("http", "$data")
                        runOnUiThread {
                            iniciarRecyclerView(listaEstudiantes, this, rv_pacientes)
                        }
                    }
                }
            }
    }

    fun eliminarPaciente(idPaciente: Int) {
        val url = Servidor.url("actor") + "?id=${idPaciente}"
        url.httpDelete()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        runOnUiThread {
                            startActivity(this.intent)
                        }
                    }
                }
            }
    }

    fun irGestionarMedicamentos(idPaciente: Int, listaMaterias: ArrayList<Materia>?) {
        val intent = Intent(
            this,
            GestionMaterias::class.java
        )
        Datos.listaMateria = listaMaterias!!
        intent.putExtra("idEstudiante", idPaciente)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun irActualizarPaciente(estudiante: Estudiante) {
        val intent = Intent(
            this,
            ActualizarEstudiante::class.java
        )
        intent.putExtra("id", estudiante.id)
        intent.putExtra("nombres", estudiante.nombres)
        intent.putExtra("apellidos", estudiante.apellidos)
        intent.putExtra("fechaNacimiento", estudiante.fechaNacimiento)
        intent.putExtra("semestreActual", estudiante.semestreActual)
        intent.putExtra("graduado", estudiante.graduado)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

}
