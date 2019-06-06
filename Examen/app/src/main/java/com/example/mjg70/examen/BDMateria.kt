package com.example.mjg70.examen

class BDMateria {
    companion object {
        val LST_MATERIA:ArrayList<Materia> = ArrayList();
        var serial:Int= 1;

        fun agregarMateria(materia: Materia):ArrayList<Materia>{
            materia.id = serial
            serial++
            LST_MATERIA.add(materia)
            return LST_MATERIA
        }

        fun mostrarMateria(padreId:Int): List<Materia> {
            val listFiltradaMateria = this.LST_MATERIA.filter { it.estudianteId ==  padreId}
            return listFiltradaMateria
        }

        fun eliminarMateria(id:Int){
            this.LST_MATERIA.removeAll{ it.id == id }
        }

        fun actualizarMateria(materia: Materia){
            val indice = this.LST_MATERIA.indexOfFirst { it.id == materia.id }
            this.LST_MATERIA[indice] = materia
        }

    }

}