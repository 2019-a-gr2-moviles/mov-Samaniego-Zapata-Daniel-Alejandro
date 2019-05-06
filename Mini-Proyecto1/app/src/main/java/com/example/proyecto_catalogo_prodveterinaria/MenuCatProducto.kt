package com.example.proyecto_catalogo_prodveterinaria

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_menu_catalogo_producto.*
import java.io.InputStream
import java.io.IOException
import org.json.JSONArray


class MenuCatProducto : AppCompatActivity() {

    var arrayListaCatProducto = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_catalogo_producto)
        read_json()

        ingresarNuevoTipoProducto.setOnClickListener {
            val intent = Intent(this, ingresarTipoProducto::class.java)
            startActivity(intent)
        }
    }



    fun read_json() {
        var json: String? = null

        try {
            val inputStream: InputStream = assets.open("tipoProducto.json")
            json = inputStream.bufferedReader().use { it.readText() }

            var jsonArreglo = JSONArray(json)   // del json le cambio a un arreglo


            for (i in 0..jsonArreglo.length()-1) {
                var jsonObjeto = jsonArreglo.getJSONObject(i)
                arrayListaCatProducto.add(jsonObjeto.getString("producto"))
            }

            var adapt = ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayListaCatProducto)
            listViewCatProducto.adapter = adapt

        }
        catch (e: IOException) {

        }
    }

}
