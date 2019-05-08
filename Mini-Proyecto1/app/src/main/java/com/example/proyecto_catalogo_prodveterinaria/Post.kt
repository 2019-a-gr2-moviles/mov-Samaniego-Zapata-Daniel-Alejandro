package com.example.proyecto_catalogo_prodveterinaria

import com.google.gson.annotations.SerializedName

data class TipoProducto(
    @SerializedName("id") val id: Int,
    @SerializedName("producto") val producto: String,
    @SerializedName("fecha_Exp") val fecha_Exp: String
)

class Post {
    var id: Number? = null
    var producto: String? = null
    var fecha_Exp: String? = null
    //var postTag: List<String>? = null

    constructor() : super() {}

    constructor(Id: Number, Producto: String, Fecha_Expiracion: String) : super() {
        this.id = Id
        this.producto = Producto
        this.fecha_Exp = Fecha_Expiracion
    }

}




