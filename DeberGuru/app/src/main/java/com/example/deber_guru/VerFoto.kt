package com.example.deber_guru

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.txt_descripcionAsunto
import kotlinx.android.synthetic.main.activity_main.txt_titulo
import kotlinx.android.synthetic.main.activity_ver_foto.*

class VerFoto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_foto)

        val foto: Parcelable? = this.intent.getParcelableExtra<Parcelable>("foto")

        when(foto?.id_fotografo){

            1-> {imageView.setImageResource(R.mipmap.galapagos)}
            2-> {imageView.setImageResource(R.mipmap.arcoiris)}
            3-> {imageView.setImageResource(R.mipmap.gs)}
        }

        /*
        if(foto?.id_fotografo==1){

            imageView.setImageResource(R.mipmap.gmsj)
            //img_icon.setImageResource(R.mipmap.icon1)


       } else{

            imageView.setImageResource(R.mipmap.arcoiris)
            //img_icon.setImageResource(R.mipmap.icon2)

       }*/
        txt_titulo.text = foto?.titulo
        txt_descripcionAsunto.text = foto?.descripcion
        txt_ph.text = foto?.fotografo
        txt_pais_origen.text = foto?.paisOrigen

    }
}
