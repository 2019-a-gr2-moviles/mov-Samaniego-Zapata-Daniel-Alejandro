package com.example.proyecto_catalogo_prodveterinaria

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_ingresar_tipo_producto.*
import kotlinx.android.synthetic.main.content_main.*
import java.io.BufferedReader
import java.io.File

class ingresarTipoProducto : AppCompatActivity() {

    private var jsonInicial:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_tipo_producto)

        /*guardar.setOnClickListener {
            val intent = Intent(this, writeJSONtoFile(Id: Int, Tipo_Producto: String, Fecha_Expiracion:String)::class.java)
            startActivity(intent)
        }*/
        guardar.setOnClickListener {
        val et_idInput = findViewById<TextInputEditText>(R.id.layoutId)
        val et_tipoProductoInput = findViewById<TextInputEditText>(R.id.layoutTipoProducto)
        val et_perchaInput = findViewById<TextInputEditText>(R.id.layoutPercha)
        val id:Int= 1
        val tipo_Producto = et_tipoProductoInput.text.toString()
        val percha = et_perchaInput.text.toString()

        writeJSONtoFile(id, tipo_Producto, percha)
            }
    }

    private fun writeJSONtoFile(id: Int, Tipo_Producto: String, Percha:String) {
        //readJSONfromFile()
        var post = Post(id, Tipo_Producto, Percha)
        var gson = Gson()
        var jsonString:String = gson.toJson(post)
        var jsonString2:String = jsonInicial.toString()
        var jsonFinal = jsonString.toString()

        //textView.setText(jsonString)
        val file=File("/data/data/com.example.proyecto_catalogo_prodveterinaria/files/tipoProducto.json")
        file.writeText(jsonFinal)
    }


    private fun readJSONfromFile() {
        var gson = Gson()
        val bufferedReader: BufferedReader = File("/data/data/com.example.proyecto_catalogo_prodveterinaria/files/tipoProducto.json").bufferedReader()
        val inputString = bufferedReader.use { it.readText() }
        jsonInicial = inputString
    }
}
