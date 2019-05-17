package com.example.myprimeraapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_actividad_dos.setOnClickListener {
            //this.irAActividadDos()
            irAActividadDos()
        }
    }

    fun irAActividadDos(){
        val intent = Intent(this, Actividad_Dos::class.java)
        startActivity(intent)
    }


}


