package com.example.deber_guru

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewPH : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        var listaInicio = arrayListOf<Parcelable>()

        for(num in 1..10) {

            var addP1 = Parcelable(
                "Erika Cueva",
                "Galapagos",
                "Flora y fauna",
                "3-Premier, 2-All Star, 1-Top20",
                1,
                "Alemania"
            )

            var addP2 = Parcelable(
                "Elton Wick",
                "Paraguas",
                "Multicolores como un arcoiris",
                "2-Elite, 20-Popular",
                2,
                "China"
            )

             var addP3 = Parcelable(
                "Carlo Macas",
                "Ceinicienta",
                "Texturas",
                "1-Top30, 9-Premier",
                3,
                "India"
            )

            listaInicio.add(addP1)
            listaInicio.add(addP2)
            listaInicio.add(addP3)
        }

        iniciarRecylerView(listaInicio, this,rv_foto)

    }

    fun iniciarRecylerView(
        lista: List<Parcelable>,
        actividad: RecyclerViewPH,
        recycler_view: RecyclerView
    ) {
        val adaptadorFoto = AdaptadorFoto(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorFoto
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorFoto.notifyDataSetChanged()
    }

    fun irAVerFotoActivity(foto: Parcelable){
        val intentExplicito = Intent(
            this, VerFoto::class.java
        )
        intentExplicito.putExtra("foto",foto)
        startActivity(intentExplicito)
    }

}

