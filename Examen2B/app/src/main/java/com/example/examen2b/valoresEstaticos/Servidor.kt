package com.example.examen2b.valoresEstaticos

class Servidor {

    companion object {

        private val ip = "172.29.23.158"
        private val puerto = "1337"

        fun url(ruta: String): String {
            var rutaAux = ""
            when (ruta) {
                "estudiante" -> rutaAux = "actor"
                "materia" -> rutaAux = "pelicula"
                else -> rutaAux = ""
            }
            return "http://$ip:$puerto/${rutaAux}"
        }
    }
}