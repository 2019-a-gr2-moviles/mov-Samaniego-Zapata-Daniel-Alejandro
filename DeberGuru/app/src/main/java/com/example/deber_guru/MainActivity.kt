package com.example.deber_guru

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_ingresar.setOnClickListener{
            irRecyclerView()
        }


    }

    fun irRecyclerView(){
        val intentExplicito = Intent(
            this, RecyclerViewPH::class.java
        )
        startActivity(intentExplicito)
    }
}