package com.example.mjg70.examen

import android.os.Parcel
import android.os.Parcelable


class Estudiante(var id:Int?,
                 var nombres:String,
                 var apellidos:String,
                 var fechaNacimiento:String,
                 var semestreActual:Int,
                 var graduado:String
) :Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun toString(): String {
        return "Nombres: ${nombres} Apellidos: ${apellidos} Fecha Nacimiento: ${fechaNacimiento} Semestre Actual:${semestreActual} Graduado:${graduado}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(nombres)
        parcel.writeString(apellidos)
        parcel.writeString(fechaNacimiento)
        parcel.writeInt(semestreActual)
        parcel.writeString(graduado)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Estudiante> {
        override fun createFromParcel(parcel: Parcel): Estudiante {
            return Estudiante(parcel)
        }

        override fun newArray(size: Int): Array<Estudiante?> {
            return arrayOfNulls(size)
        }
    }
}