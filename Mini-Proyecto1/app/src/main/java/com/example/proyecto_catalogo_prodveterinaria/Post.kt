package com.example.proyecto_catalogo_prodveterinaria

import com.google.gson.annotations.SerializedName

data class TipoProducto(
    @SerializedName("id") val id: Int,
    @SerializedName("tipoProducto") val tipoProducto: String,
    @SerializedName("percha") val percha: Int
)

class Post {
    var id: Number? = null
    var tipoProducto: String? = null
    var percha: Number? = null
    //var postTag: List<String>? = null

    constructor() : super() {}

    constructor(Id: Number, Tipo_Producto: String, Percha: Number) : super() {
        this.id = Id
        this.tipoProducto = Tipo_Producto
        this.percha = Percha
    }

}




