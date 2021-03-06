package com.example.polibus

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registro_admin.*

class RegistroAdmin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_admin)

        btn_aceptarAdmin.setOnClickListener{
            irRegistroUsuario()
        }

    }

    fun irRegistroUsuario(){
        val intentExplicito = Intent(
            this, Registro::class.java
        )
        startActivity(intentExplicito)
    }

}
