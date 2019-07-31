package com.example.examen2b.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.examen2b.R
import com.example.examen2b.modelo.Estudiante
import com.example.examen2b.valoresEstaticos.Datos
import com.example.examen2b.valoresEstaticos.Servidor
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_crear_paciente.*

class CrearEstudiante : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_paciente)
        btn_ins_pac.setOnClickListener {
            try {
                val actor = Estudiante(
                    null,
                    -1,
                    txt_nombreActor.text.toString(),
                    txt_apellidoActor.text.toString(),
                    dp_fechaNacimientoActor.text.toString(),
                    txt_numeroPeliculas.text.toString().toInt(),
                    sw_retiradoPaciente.text.toString().toBoolean()
                )
                ingresarEstudiante(actor)
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "${Datos.nombreUsuario}: Registro Erróneo",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun ingresarEstudiante(estudiante: Estudiante) {
        try {
            val url = Servidor.url("actor")
            val json = """
            {
            "nombres": "${estudiante.nombres}",
            "apellidos": "${estudiante.apellidos}",
            "fechaNacimiento": "${estudiante.fechaNacimiento}",
            "semestreActual": ${estudiante.semestreActual},
            "graduado" : ${estudiante.graduado}
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
                                    "${Datos.nombreUsuario}: Se ha registrado con éxito",
                                    Toast.LENGTH_LONG
                                ).show()
                                //irListaPacientes()
                                this.finish()
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

//    fun irListaPacientes() {
//        val intent = Intent(
//            this,
//            ListaEstudiantes::class.java
//        )
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
//        startActivity(intent)
//    }
}
