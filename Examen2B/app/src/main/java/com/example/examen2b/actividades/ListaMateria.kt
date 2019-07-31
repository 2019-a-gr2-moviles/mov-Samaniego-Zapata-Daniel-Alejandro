package com.example.examen2b.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.examen2b.R
import com.example.examen2b.adaptador.AdaptadorListaMaterias
import com.example.examen2b.modelo.Materia
import com.example.examen2b.valoresEstaticos.Datos
import com.example.examen2b.valoresEstaticos.Servidor
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_lista_medicamentos.*

class ListaMateria : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_medicamentos)
        val idPaciente = this.intent.getIntExtra("idEstudiante", -1)
        iniciarRecyclerView(Datos.listaMateria, this, rv_medicamentos)

    }

    fun iniciarRecyclerView(
        listaMaterias: ArrayList<Materia>,
        actividad: ListaMateria,
        recyclerView: androidx.recyclerview.widget.RecyclerView
    ) {
        val adaptadorMedicamento = AdaptadorListaMaterias(listaMaterias, actividad, recyclerView)
        rv_medicamentos.adapter = adaptadorMedicamento
        rv_medicamentos.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        rv_medicamentos.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)

        adaptadorMedicamento.notifyDataSetChanged()
    }

    fun eliminarMedicamento(idMedicamento: Int) {
        val url = Servidor.url("pelicula") + "?id=${idMedicamento}"
        url.httpDelete()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        runOnUiThread {
                            irListaPacientes()
                        }
                    }
                }
            }
    }

    fun irListaPacientes() {
        val intent = Intent(
            this,
            ListaEstudiantes::class.java
        )
        startActivity(intent)
    }


    fun irActualizarMedicamento(materia: Materia) {
        val intent = Intent(
            this,
            ActualizarMateria::class.java
        )
        intent.putExtra("id", materia.id)
        intent.putExtra("uso", "${materia.numeroHorasPorSemana}")
        intent.putExtra("gramos", materia.descripcion)
        intent.putExtra("fechaCreacion", "${materia.fechaCreacion}")
        intent.putExtra("nombre", "${materia.nombre}")
        intent.putExtra("pastillas", materia.codigo)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

}
