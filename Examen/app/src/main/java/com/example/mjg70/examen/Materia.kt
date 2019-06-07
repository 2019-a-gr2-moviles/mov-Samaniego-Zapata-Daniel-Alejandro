package com.example.mjg70.examen

import android.os.Parcel
import android.os.Parcelable

class Materia(var id:Int?,
              var numeroMateria:Int,
              var codigo:String,
              var descripcion:String,
              var activo:String,
              var fechaNacimiento:String,
              var horasSemanales:Int,
              var estudianteId:Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun toString(): String {
        return "Número Materia: ${numeroMateria} Descripcion: ${descripcion} Activo: ${activo} Fecha Nacimiento:${fechaNacimiento} Horas Semanales:${horasSemanales}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeInt(numeroMateria)
        parcel.writeString(codigo)
        parcel.writeString(descripcion)
        parcel.writeString(activo)
        parcel.writeString(fechaNacimiento)
        parcel.writeInt(horasSemanales)
        parcel.writeInt(estudianteId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Materia> {
        override fun createFromParcel(parcel: Parcel): Materia {
            return Materia(parcel)
        }

        override fun newArray(size: Int): Array<Materia?> {
            return arrayOfNulls(size)
        }
    }
}
