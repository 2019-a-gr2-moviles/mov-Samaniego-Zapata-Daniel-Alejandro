package com.example.proyecto_catalogo_prodveterinaria

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_ingresar_producto.*

class ingresarProducto : AppCompatActivity() {

    private var jsonTipProInicial:String?=null

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_producto)
        setSupportActionBar(toolbar)



    }

}
