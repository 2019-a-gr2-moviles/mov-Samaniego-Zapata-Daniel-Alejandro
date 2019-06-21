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
                "GALÁPAGOS",
                "Flora y fauna",
                "Trofeos: 3-Premier, 2-All Star, 1-Top20",
                1,
                "Alemania"
            )

            var addP2 = Parcelable(
                "Elton Wick",
                "ARCOIRIS",
                "Multicolores como tus estados de ánimo",
                "Trofeos: 2-Elite, 20-Popular",
                2,
                "China"
            )

             var addP3 = Parcelable(
                "Carlo Macas",
                "FLORECITA",
                "Si bajas tu mirada encontrarás otros mundos.",
                "Trofeos: 1-Top30, 9-Premier",
                3,
                "India"
            )


            var addP4 = Parcelable(
                "Ergun Korel",
                "ABEJIN",
                ":=))",
                "Trofeos: 1-Top100, 2-GuruPick, 123-Swap",
                4,
                "Turquía"
            )


            var addP5 = Parcelable(
                "Alejandra Campos",
                "TIEMPO",
                "Aún vuelvo cada día a ciertos lugares, solo para verlas, no me olvidan",
                "Trofeos: 4-Skilled, 5-Elite",
                5,
                "Estados Unidos"
            )
            listaInicio.add(addP1)
            listaInicio.add(addP2)
            listaInicio.add(addP3)
            listaInicio.add(addP4)
            listaInicio.add(addP5)
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

