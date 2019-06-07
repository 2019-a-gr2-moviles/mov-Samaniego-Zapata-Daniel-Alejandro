package com.example.mjg70.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actualizar_materia.*

class ActualizarMateriaActivity : AppCompatActivity() {
    var id :Int = 0
    var idPadre :Int = 0
    var usuario :String = "";
    var estudianteRespaldo : Estudiante? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_materia)
        usuario = intent.getStringExtra("usuario").toString()
        val materiaRecibido = intent.getParcelableExtra<Materia>("Materia")
        estudianteRespaldo = intent.getParcelableExtra<Estudiante>("EstudianteRespaldo")
        txtnumeroMateria.setText(materiaRecibido.numeroMateria.toString())
        txtCodigo.setText(materiaRecibido.codigo.toString())
        txtDescripcion.setText(materiaRecibido.descripcion.toString())
        txtActivo.setText(materiaRecibido.activo.toString())
        txtFechaNacimiento.setText(materiaRecibido.fechaNacimiento.toString())
        txtHorasSemanales.setText(materiaRecibido.horasSemanales.toString())
        id = materiaRecibido.id.toString().toInt()
        idPadre = materiaRecibido.estudianteId.toString().toInt()
        btnActualizarMateria.setOnClickListener { actualizarMateria() }
        btnEliminarMateria.setOnClickListener { eliminarMateria() }
    }

    fun actualizarMateria(){
        val materia = Materia(id = null,
            numeroMateria = txtnumeroMateria.text.toString().toInt(),
            codigo = txtCodigo.text.toString(),
            descripcion = txtDescripcion.text.toString(),
            activo = txtActivo.text.toString(),
            fechaNacimiento = txtFechaNacimiento.text.toString(),
            horasSemanales = txtHorasSemanales.text.toString().toInt(),
            estudianteId = idPadre)
        BDMateria.actualizarMateria(materia)
        Toast.makeText(this, "Actualización materia exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Estudiante", estudianteRespaldo)
        startActivity(retorno)
    }

    fun eliminarMateria(){
        BDMateria.eliminarMateria(id)
        Toast.makeText(this, "Eliminación jugador exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Estudiante", estudianteRespaldo)
        startActivity(retorno)
    }
}
