package com.example.deber_guru

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        var listaInicio = arrayListOf<Parcelable>()

        for(num in 1..10) {

            var addP1 = Parcelable(
                "Erika Cueva",
                "Arrecifes en Galapagos",
                "3-Premier, 2-All Star, 1-Top20",
                1,
                "Alemania",
                50
            )

            var addP2 = Parcelable(
                "Elton Wick",
                "Paraguas",
                "2-Elite, 20-Popular",
                2,
                "China",
                15
            )

            var addP3 = Parcelable(
                "FACEBOOK",
                "Texturas",
                "1-Top30, 9-Premier",
                3,
                "India",
                68
            )

            listaInicio.add(addP1)
            listaInicio.add(addP2)
            listaInicio.add(addP3)
        }


        iniciarRecylerView(listaInicio, this,rv_foto)
    }

    fun iniciarRecylerView(
        lista: List<Parcelable>,
        actividad: RecyclerView,
        recycler_view: RecyclerView
    ) {
        val adaptadorMensaje = AdaptadorFoto(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorMensaje
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorMensaje.notifyDataSetChanged()
    }

    fun irAVerMensajeActivity(mensaje: Parcelable){
        val intentExplicito = Intent(
            this,
            VerMensaje::class.java
        )

        intentExplicito.putExtra("descripcion",mensaje)
        startActivity(intentExplicito)
    }

}

