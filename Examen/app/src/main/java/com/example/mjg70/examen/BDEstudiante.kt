package com.example.mjg70.examen

class BDEstudiante{
    companion object {
        val LST_ESTUDIANTE:ArrayList<Estudiante> = ArrayList();
        var serial:Int= 1;
        var nombreUsuario:String = "";

        fun guardarUsuario(nombre:String){
            this.nombreUsuario = nombre;
        }

        fun agregarEstudiante(estudiante: Estudiante):ArrayList<Estudiante>{
            estudiante.id = serial
            serial++
            LST_ESTUDIANTE.add(estudiante)
            return LST_ESTUDIANTE
        }

        fun mostrarEstudiante(): List<Estudiante> {
            return this.LST_ESTUDIANTE
        }

        fun eliminarEstudiante(id:Int){
            this.LST_ESTUDIANTE.removeAll{ it.id == id }
        }

        fun actualizarEstudiante(estudiante: Estudiante){
            val indice = this.LST_ESTUDIANTE.indexOfFirst { it.id == estudiante.id }
            this.LST_ESTUDIANTE[indice] = estudiante
        }

    }

}