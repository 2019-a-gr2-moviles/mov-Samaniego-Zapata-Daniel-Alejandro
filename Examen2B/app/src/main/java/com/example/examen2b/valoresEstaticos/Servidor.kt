package com.example.examen2b.valoresEstaticos

class Servidor {

    companion object {

        private val ip = "172.29.64.180"
        private val puerto = "1337"

        fun url(ruta: String): String {
            var rutaAux = ""
            when (ruta) {
                "actor" -> rutaAux = "actor"
                "pelicula" -> rutaAux = "pelicula"
                else -> rutaAux = ""
            }
            return "http://$ip:$puerto/${rutaAux}"
        }
    }
}