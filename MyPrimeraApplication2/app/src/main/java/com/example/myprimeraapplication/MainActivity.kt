package com.example.myprimeraapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_actividad_dos.setOnClickListener {
            //this.irAActividadDos()
            irAActividadDos()
        }
        btn_parcelable.setOnClickListener {
            irAParcelable()
        }

        btn_adapter.setOnClickListener {
            irAListView()
        }

        btn_toast.setOnClickListener {
            irAToast()
        }

    }

    fun irAActividadDos(){
        val intent = Intent(this, Actividad_Dos::class.java)

        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        intent.putExtra("nombre", "Daniel")
        intent.putExtra("edad", 29)

        startActivity(intent)
    }

    fun irAParcelable(){
        val intentExplicito = Intent(
            this, Parcelable::class.java
        )

        val daniel = Usuario("Daniel",
            29,
            Date(),
            12.12)
        intentExplicito.putExtra("usuario", daniel)

        val cachetes = Mascota("Cachetes", daniel)
        intentExplicito.putExtra("mascota", cachetes)

        startActivity(intentExplicito)

    }

    fun irAListView(){
        val intentExplicito = Intent(
            this, ListViewActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun irAToast(){
        val intentExplicito = Intent(
            this, SnackbarActivity::class.java
        )
        startActivity(intentExplicito)
    }

}


