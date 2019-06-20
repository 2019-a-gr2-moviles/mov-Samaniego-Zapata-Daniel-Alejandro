package com.example.deber_guru

import android.os.Parcel

class Parcelable (
    var fotografo: String,
    var descripcion:String,
    var premios: String,
    var id_fotografo: Int,
    var paisOrigen:String,
    var totalFotos:Int ): android.os.Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fotografo)
        parcel.writeString(descripcion)
        parcel.writeString(premios)
        parcel.writeInt(id_fotografo)
        parcel.writeString(paisOrigen)
        parcel.writeInt(totalFotos)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : android.os.Parcelable.Creator<android.os.Parcelable> {
        override fun createFromParcel(parcel: Parcel): android.os.Parcelable {
            return Parcelable(parcel)
        }

        override fun newArray(size: Int): Array<android.os.Parcelable?> {
            return arrayOfNulls(size)
        }
    }


}