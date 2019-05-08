package com.example.proyecto_catalogo_prodveterinaria

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import com.google.gson.Gson
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

        val idInput = findViewById<TextInputEditText>(R.id.layoutId)
        val tipoProductoInput = findViewById<TextInputEditText>(R.id.layoutTipoProducto)
        val fechaExpiracionInput = findViewById<TextInputEditText>(R.id.layoutPercha)
        val id = idInput.text.toString().toInt()
        val tipo_Producto = tipoProductoInput.text.toString()
        val fec_exp = fechaExpiracionInput.text.toString()

        writeJSONtoFile(id, tipo_Producto, fec_exp)
    }

    private fun writeJSONtoFile(id: Int, tipo_Producto: String, fec_exp:String) {
        readJSONfromFile()
        var post = Post(id, tipo_Producto, fec_exp)
        var gson = Gson()
        var jsonString:String = gson.toJson(post)
        var jsonString2:String = jsonInicial.toString()
        var jsonFinal = jsonString2 +  ',' +jsonString.toString()

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
