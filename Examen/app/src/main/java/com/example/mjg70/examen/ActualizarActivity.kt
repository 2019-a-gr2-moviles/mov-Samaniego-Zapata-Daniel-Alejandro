package com.example.mjg70.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actualizar.*

class ActualizarActivity : AppCompatActivity() {
    var padreId : Int = 0
    var usuario :String = ""
    var estudiante:Estudiante?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar)
        usuario = intent.getStringExtra("usuario").toString()
        estudiante = intent.getParcelableExtra<Estudiante>("Estudiante")
        val estudianteRecibido = intent.getParcelableExtra<Estudiante>("Estudiante")
        imput_Nombre.setText(estudianteRecibido.nombres.toString())
        imput_Apellido.setText(estudianteRecibido.apellidos.toString())
        txtFechaNacimiento.setText(estudianteRecibido.fechaNacimiento.toString())
        txtSemestreActual.setText(estudianteRecibido.semestreActual.toString())
        txtGraduadoAct.setText(estudianteRecibido.graduado.toString())
        padreId = estudianteRecibido.id!!;
        btnActualizar.setOnClickListener { actualizarEstudiante() }
        btnEliminar.setOnClickListener { eliminarEstudiante() }
        btnCrearMateria.setOnClickListener { crearMateria() }
        btnGestionarMateria.setOnClickListener { gestionarMateria() }
        btnMenuRetorno.setOnClickListener { retorno() }
    }

    fun actualizarEstudiante(){
        val actualizarEstudiante = Estudiante(id = padreId,
            nombres = imput_Nombre.text.toString(),
            apellidos = imput_Apellido.text.toString(),
            fechaNacimiento = txtFechaNacimiento.text.toString(),
            semestreActual = txtSemestreActual.text.toString().toInt(),
            graduado = txtGraduadoAct.text.toString()
        )
        BDEstudiante.actualizarEstudiante(actualizarEstudiante)
        Toast.makeText(this, "Actualización exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }

    fun eliminarEstudiante(){
        BDEstudiante.eliminarEstudiante(padreId);
        Toast.makeText(this, "Eliminación exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }

    fun crearMateria(){
        val estudianteRespaldo = Estudiante(id = padreId,
            nombres = imput_Nombre.text.toString(),
            apellidos = imput_Apellido.text.toString(),
            fechaNacimiento = txtFechaNacimiento.text.toString(),
            semestreActual = txtSemestreActual.text.toString().toInt(),
            graduado = txtGraduadoAct.text.toString()
        )
        val retorno = Intent(this, IngresarMateriaActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("padreId", padreId)
        retorno.putExtra("EstudianteRespaldo", estudianteRespaldo)
        startActivity(retorno)
    }

    fun gestionarMateria(){
        val estudianteRespaldo = Estudiante(id = padreId,
            nombres = imput_Nombre.text.toString(),
            apellidos = imput_Apellido.text.toString(),
            fechaNacimiento = txtFechaNacimiento.text.toString(),
            semestreActual = txtSemestreActual.text.toString().toInt(),
            graduado = txtGraduadoAct.text.toString()
        )
        val retorno = Intent(this, ConsultarMateriaActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("padreId", padreId)
        retorno.putExtra("EquipoRespaldo", estudianteRespaldo)
        startActivity(retorno)
    }

    fun retorno(){
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }
}
