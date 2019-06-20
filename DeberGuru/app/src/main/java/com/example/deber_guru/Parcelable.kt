package com.example.deber_guru

import android.os.Parcel
import android.os.Parcelable

class Parcelable (
    var fotografo: String,
    var titulo: String,
    var descripcion:String,
    var premios: String,
    var id_fotografo: Int,
    var paisOrigen:String ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fotografo)
        parcel.writeString(titulo)
        parcel.writeString(descripcion)
        parcel.writeString(premios)
        parcel.writeInt(id_fotografo)
        parcel.writeString(paisOrigen)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Parcelable> {
        override fun createFromParcel(parcel: Parcel): Parcelable {
            return Parcelable(parcel)
        }

        override fun newArray(size: Int): Array<Parcelable?> {
            return arrayOfNulls(size)
        }
    }


}