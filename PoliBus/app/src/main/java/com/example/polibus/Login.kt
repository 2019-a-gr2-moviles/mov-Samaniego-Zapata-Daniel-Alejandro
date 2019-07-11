package com.example.polibus

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_registrateAqui.setOnClickListener{
            irRegistroAdmin()
        }

    }

    fun irRegistroAdmin(){
        val intentExplicito = Intent(
            this, RegistroAdmin::class.java
        )
        startActivity(intentExplicito)
    }

}
