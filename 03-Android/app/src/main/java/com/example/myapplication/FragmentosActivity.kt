package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragmentos.*

class FragmentosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)

        btn_primer.setOnClickListener {
            abrirPrimerFragmento()
        }

        btn_segundo.setOnClickListener {
            abrirSegundoFragmento()
        }
    }


    fun abrirPrimerFragmento(){
        // 1) Manager
        val fragmentManager = supportFragmentManager
        // 2) Empezar la transaccion
        val transaccion = fragmentManager.beginTransaction()
        // 3) Definir la instacion del fragmento
        val primerFragmento = PrimerFragment()
        // 4) Reemplazamos el fragmento
        transaccion.replace(R.id.cly_fragmentos, primerFragmento)
        // 5) Terminar la transaccion
        transaccion.commit()
    }

    fun abrirSegundoFragmento(){
        // 1) Manager
        val fragmentManager = supportFragmentManager
        // 2) Empezar la transaccion
        val transaccion = fragmentManager.beginTransaction()
        // 3) Definir la instacion del fragmento
        val primerFragmento = PrimerFragment()
        // 4) Reemplazamos el fragmento
        transaccion.replace(R.id.cly_fragmentos, primerFragmento)
        // 5) Terminar la transaccion
        transaccion.commit()
    }

}
