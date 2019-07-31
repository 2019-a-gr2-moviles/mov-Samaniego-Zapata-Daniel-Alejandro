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
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_actualizar_medicamento.*
import java.lang.Exception

class ActualizarMateria : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_medicamento)
        val id: Int = this.intent.getIntExtra("id", -1)
        val numeroPastillas = this.intent.getIntExtra("pastillas", -1)  //codigo
        val nombre = this.intent.getStringExtra("nombre")   //nombre
        //val fechaCaducidad = this.intent.getStringExtra("fechaCaducidad")
        val gramosAIngerir = this.intent.getIntExtra("gramos", -1)  //descripcion
        val usadoPara = this.intent.getStringExtra("uso") //numeroHorasPorSemana
        val composicion = this.intent.getStringExtra("fechaCreacion")
        Log.i("http", "Datos del Actor: $id $numeroPastillas $nombre $gramosAIngerir")

        txt_num_pas_med_act.hint = numeroPastillas.toString()
        txt_nom_med_act.hint = nombre
        //fec_cad_med_act.hint = fechaCaducidad
        txt_gra_med_act.hint = gramosAIngerir.toString()
        txt_uso_med_act.hint = usadoPara
        txt_comp_med_act.hint = composicion
        btn_act_med_conf.setOnClickListener {
            try {
                val medicamento = Materia(
                    id,
                    txt_nom_med_act.text.toString(),
                    txt_gra_med_act.text.toString(),
                    txt_num_pas_med_act.text.toString(),
                    txt_comp_med_act.text.toString(),
                    txt_uso_med_act.text.toString().toInt(),
                    -1,
                    txt_lon_act.text.toString(),
                    txt_lat_act.text.toString()
                )

                actualizarMateria(medicamento)
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "${Datos.nombreUsuario}: Operación fallida",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun actualizarMateria(materia: Materia) {
        try{
        val url = Servidor.url("pelicula") + "/${materia.id}"
            Log.i("url","url to patch ${url}")

            val parametros = listOf(
                "nombre" to  "${materia.nombre}",
                "descripcion"  to  "${materia.descripcion}",
                "codigo" to  "${materia.codigo}",
                "fechaCreacion" to  "${materia.fechaCreacion}",
                "numeroHorasPorSemana" to "${materia.numeroHorasPorSemana}",
                "longitud" to  "${materia.longitud}",
                "latitud" to "${materia.latitud}"
            )

//        val json = """
//            {
//             "nombre" : "${materia.nombre}",
//             "descripcion" : "${materia.descripcion}",
//             "codigo" : "${materia.codigo}",
//            "fechaCreacion" : "${materia.fechaCreacion}",
//            "numeroHorasPorSemana" : "${materia.numeroHorasPorSemana}",
//            "longitud" : "${materia.longitud}"
//            "latitud" : "${materia.latitud}",
//
//                                                     }
//                    """.trimIndent()
//        Log.i("http", url)
//        Log.i("http", json)
        url.httpPut(parametros)
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
                                "${Datos.nombreUsuario}: Operación exitosa",
                                Toast.LENGTH_LONG
                            ).show()
                            irListaPacientes()
                            //this.finish()
                        }
                    }
                }
            }}catch (e:Exception){
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
