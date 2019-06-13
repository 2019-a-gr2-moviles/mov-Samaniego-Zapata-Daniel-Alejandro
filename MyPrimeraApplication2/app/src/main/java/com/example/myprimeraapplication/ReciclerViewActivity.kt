package com.example.myprimeraapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recicler_view.*

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)

        val lista = arrayListOf<Persona>()
        //val recycler_view = rv_personas
        //val actividad = this

        lista.add(Persona("Adrian", "17181245"))
        lista.add(Persona("Daniel", "15302745"))
        lista.add(Persona("Joss", "10345845"))

        iniciarRecyclerView(lista, this, this.rv_personas)

        /*val adaptadorPersona = AdaptadorPersona(
            lista,
            actividad,
            recycler_view)

        rv_personas.adapter = adaptadorPersona
        rv_personas.itemAnimator = DefaultItemAnimator()
        rv_personas.layoutManager = LinearLayoutManager(this)

        adaptadorPersona.notifyDataSetChanged()*/

    }

    fun iniciarRecyclerView(
        lista: List<Persona>,
        actividad: ReciclerViewActivity,
        recycler_view: RecyclerView
    ){
        val adaptadorPersona = AdaptadorPersona(
            lista,
            actividad,
            recycler_view)

        rv_personas.adapter = adaptadorPersona
        rv_personas.itemAnimator = DefaultItemAnimator()
        rv_personas.layoutManager = LinearLayoutManager(this)

        adaptadorPersona.notifyDataSetChanged()
    }

    fun cambiarNombreTextView(text:String){
        txv_titulo_rv.text = text
    }


}
