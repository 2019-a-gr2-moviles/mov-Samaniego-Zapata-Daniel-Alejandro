package com.example.myprimeraapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log


class Parcelable : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        val daniel: Usuario? = this.intent
            .getParcelableExtra<Usuario>("usuario")

        val cachetes: Mascota? = this.intent
            .getParcelableExtra<Mascota>("mascota")

        Log.i("parcelable", "Nombre ${daniel?.nombre}")
        Log.i("parcelable", "Nombre ${daniel?.edad}")
        Log.i("parcelable", "Nombre ${daniel?.fechaNacimiento.toString()}")
        Log.i("parcelable", "Nombre ${daniel?.sueldo}")

        Log.i("parcelable", "Nombre ${cachetes?.nombre}")
        Log.i("parcelable", "Nombre ${cachetes?.duenio?.nombre}")

    }

    fun regresarAMenu(){
        val intentExcplicito = Intent(
            this, MainActivity::class.java
        )
        startActivity(intentExcplicito)
    }
}