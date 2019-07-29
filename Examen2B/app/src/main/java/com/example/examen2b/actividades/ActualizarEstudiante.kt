package com.example.examen2b.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.examen2b.R
import com.example.examen2b.modelo.Estudiante
import com.example.examen2b.valoresEstaticos.Datos
import com.example.examen2b.valoresEstaticos.Servidor
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_actualizar_paciente.*
import java.lang.Exception

class ActualizarEstudiante : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_paciente)
        val id: Int = this.intent.getIntExtra("id", -1)
        val nombres: String = this.intent.getStringExtra("nombres")
        val apellidos: String = this.intent.getStringExtra("apellidos")
        val fechaNacimiento: String = this.intent.getStringExtra("fechaNacimiento")
        val hijos: Int = this.intent.getIntExtra("semestreActual", -1)
        val tieneSeguro: Boolean = this.intent.getBooleanExtra("graduado", false)
        Log.i("http", "Datos del Actor: $id $nombres $apellidos $fechaNacimiento $hijos")

        txt_nom_pac_act.hint = nombres
        txt_ape_pac_act.hint = apellidos
        fec_nac_pac_act.hint = fechaNacimiento
        txt_hij_pac_act.hint = hijos.toString()

        btn_act_pac_conf.setOnClickListener {
            try {
                var seguro = false
                if (sw_seg_pac_act.isChecked) {
                    seguro = true
                }
                val paciente = Estudiante(
                    null,
                    id,
                    txt_nom_pac_act.text.toString(),
                    txt_ape_pac_act.text.toString(),
                    fec_nac_pac_act.text.toString(),
                    txt_hij_pac_act.text.toString().toInt(),
                    seguro
                )
                actualizarPaciente(paciente)
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "${Datos.nombreUsuario}: Operación fallida",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun actualizarPaciente(estudiante: Estudiante) {
        try {
            val url = Servidor.url("actor") + "/${estudiante.id}"
            val json = """
            {
            "nombres": "${estudiante.nombres}",
            "apellidos": "${estudiante.apellidos}",
            "fechaNacimiento": "${estudiante.fechaNacimiento}",
            "semestreActual": "${estudiante.semestreActual}",
            "graduado" : "${estudiante.graduado}"
                                         }
                    """.trimIndent()

            url.httpPut().body(json)
                .responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {
                            val ex = result.getException()
                            Log.i("http", "Error: ${ex.message}")
                            Toast.makeText(
                                this,
                                "${Datos.nombreUsuario}: Operación fallida",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                        is Result.Success -> {

                            runOnUiThread {
                                Toast.makeText(
                                    this,
                                    "${Datos.nombreUsuario}: Actualización exitosa",
                                    Toast.LENGTH_LONG
                                ).show()
                                irListaPacientes()
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

    fun irListaPacientes() {
        intent = Intent(
            this,
            ListaEstudiantes::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
