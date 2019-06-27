package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.Exception

class ConexionHttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conexion_http)

        val json = """{
            "createdAt": 1561663617636,
            "updatedAt": 1561663617636,
            "id": 1,
            "nombre": "Manticore Labs"
            }""".trimMargin()

        try {
            val empresaInstancia = Klaxon().parse<Empresa>(json)
            Log.i(
                "http",
                "Nombre $(empresaInstancia?.nombre)"
            )

            Log.i(
                "http",
                "Nombre $(empresaInstancia?.id)"
            )
        } catch (e:Exception){
            Log.i("http",
                "Error instanciado la empresa")
        }



    }




}