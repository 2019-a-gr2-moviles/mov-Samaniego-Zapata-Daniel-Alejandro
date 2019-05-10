package com.example.proyecto_catalogo_prodveterinaria

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_menu_catalogo_producto.*
import java.io.InputStream
import java.io.IOException
import org.json.JSONArray
import java.io.File


class MenuCatProducto : AppCompatActivity() {

    var arrayListaCatProducto = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_catalogo_producto)
        //read_json()
        listarJsonArrayTipPro()

        ingresarNuevoTipoProducto.setOnClickListener {
            val intent = Intent(this, ingresarTipoProducto::class.java)
            startActivity(intent)
        }
    }

    fun listarJsonArrayTipPro() {
        var json: String? = null

        try {
            val inputStream: InputStream = File("/data/data/com.example.proyecto_catalogo_prodveterinaria/files/tipoProducto.json").inputStream()
            json = inputStream.bufferedReader().use { it.readText() }
            val jsonCompleto: String = "[" + json.toString() + "]"
            var jsonarr = JSONArray(jsonCompleto)

            for (i in 0..jsonarr.length()-1) {
                var jsonobj = jsonarr.getJSONObject(i)
                arrayListaCatProducto.add(jsonobj.getString("producto"))
            }
            var adpt = ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayListaCatProducto)
            listViewCatProducto.adapter = adpt
        }
        catch (e: IOException) {
            println(e.toString())
        }
    }



}
