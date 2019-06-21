package com.example.deber_guru

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class AdaptadorFoto(
    val listaFoto: List<Parcelable>,
    val contexto: RecyclerViewPH,
    val recyclerView: RecyclerView
    ) :

    RecyclerView.Adapter<AdaptadorFoto.MyViewHolder>() {
        inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            var nombreFotografoTextView: TextView
            var descriptionTextView: TextView
            var paisOrigenTextView: TextView
            var idFotografo: Int =0
            var imagenFoto: ImageView
            var tituloTextView: String = ""
            var premiosTextView: String = ""

            init {
                imagenFoto=view.findViewById(R.id.imgGuru) as ImageView
                nombreFotografoTextView = view.findViewById(R.id.txt_nombre) as TextView
                descriptionTextView = view.findViewById(R.id.txt_descripcionAsunto) as TextView
                paisOrigenTextView = view.findViewById(R.id.txt_pais) as TextView


                val layout = view.findViewById(R.id.relative_ly) as RelativeLayout

                layout.setOnClickListener {
                    val mensaje =Parcelable(
                        nombreFotografoTextView.text.toString(),
                        tituloTextView,
                        descriptionTextView.text.toString(),
                        premiosTextView,
                        idFotografo,
                        paisOrigenTextView.text.toString()

                    )
                    irAVerMensajeActivity(mensaje)

                    Log.i("recycler-view", "Layout presionado") }

            }
            fun irAVerMensajeActivity(foto:Parcelable){
                contexto.irAVerFotoActivity(foto)
            }
        }

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
            val itemView = LayoutInflater
                .from(p0.context)
                .inflate(
                    R.layout.layout,
                    p0,
                    false
                )
            return MyViewHolder(itemView)
        }

        override fun getItemCount(): Int {

            return listaFoto.size
        }

        override fun onBindViewHolder(myViewHolder: AdaptadorFoto.MyViewHolder, position: Int) {
            val foto = listaFoto[position]


            myViewHolder.nombreFotografoTextView.text = foto.fotografo
            myViewHolder.descriptionTextView.text = foto.descripcion
            myViewHolder.paisOrigenTextView.text = foto.paisOrigen
            myViewHolder.idFotografo = foto.id_fotografo
            myViewHolder.tituloTextView=foto.titulo
            myViewHolder.premiosTextView=foto.premios


            when (foto.id_fotografo) {
                1 -> {
                    myViewHolder.imagenFoto.setImageResource(R.mipmap.galapagos)
                }
                2 -> {
                    myViewHolder.imagenFoto.setImageResource(R.mipmap.arcoiris)
                }
                3 -> {
                    myViewHolder.imagenFoto.setImageResource(R.mipmap.gs)
                }

            }

        }
    }

