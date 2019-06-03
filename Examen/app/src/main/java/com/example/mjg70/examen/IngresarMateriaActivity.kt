package com.example.mjg70.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar_materia.*

class IngresarMateriaActivity : AppCompatActivity() {
    var padreId : Int = 0
    var usuario :String = ""
    var estudianteRespaldo : Estudiante? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_materia)
        usuario = intent.getStringExtra("usuario").toString()
        estudianteRespaldo = intent.getParcelableExtra<Estudiante>("EstudianteRespaldo")
        padreId = intent.getIntExtra("padreId", -1)
        btnGuardar.setOnClickListener { guardarMateria() }
    }

    fun guardarMateria(){
        val materia = Materia(id = null,
            numeroMateria = txtnumeroMateria.text.toString().toInt(),
            codigo = txtCodigo.text.toString(),
            descripcion = txtDescripcion.text.toString(),
            activo = txtActivo.text.toString(),
            fechaNacimiento = txtFechaNacimiento.text.toString(),
            horasSemanales = txtHorasSemanales.text.toString().toInt(),
            estudianteId = padreId)
        BDMateria.agregarMateria(materia)
        Toast.makeText(this, "Materia creada exitosamente "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Estudiante", estudianteRespaldo)
        startActivity(retorno)
    }
}
