package com.example.examen2b.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.examen2b.R
import com.example.examen2b.modelo.Materia
import com.example.examen2b.valoresEstaticos.Datos
import com.example.examen2b.valoresEstaticos.Servidor
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_crear_medicamento.*
import java.lang.Exception

class CrearMateria : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_medicamento)
        val idPaciente: Int = this.intent.getIntExtra("idEstudiante", -1)
        btn_ins_med.setOnClickListener {
            try {
                val medicamento = Materia(
                    -1,
                    txt_nuevaPelicula.text.toString(),
                    txt_anioLanzamiento.text.toString(),
                    txt_ratingPeli.text.toString(),
                    txt_actoresprincipales.text.toString(),
                    txt_sinopsis.text.toString().toInt(),
                    idPaciente,
                    txt_longitud.text.toString(),
                    txt_latitud.text.toString()
                )

                ingresarMedicamento(medicamento)
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "${Datos.nombreUsuario}: Operación fallida",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun ingresarMedicamento(materia: Materia) {

        try {
            val url = Servidor.url("pelicula")

            val json = """
            {
            "nombre" : "${materia.nombre}",
            "descripcion" : ${materia.descripcion},
            "codigo" : ${materia.codigo},
            "fechaCreacion" : "${materia.fechaCreacion}",
            "numeroHorasPorSemana" : "${materia.numeroHorasPorSemana}",
            "longitud" : "${materia.longitud}",
            "latitud" : "${materia.latitud}",
            "idEstudiante": ${materia.idEstudiante}
            }
                    """.trimIndent()

            Log.i("http", json)
            url.httpPost().body(json)
                .responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {
                            val ex = result.getException()
                            Log.i("http", "Error: ${ex.message}")
                        }
                        is Result.Success -> {
                            runOnUiThread {
                                Toast.makeText(
                                    this,
                                    "${Datos.nombreUsuario}: Operación exitosa",
                                    Toast.LENGTH_LONG
                                ).show()

                               irListaPacientes()
                                //this.finish()
                            }
                        }
                    }
                }
        } catch (e: Exception) {
            Toast.makeText(
                this,
                "${Datos.nombreUsuario}: Operación fallida",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun irListaPacientes() {
        val intent = Intent(
            this,
            ListaEstudiantes()::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
