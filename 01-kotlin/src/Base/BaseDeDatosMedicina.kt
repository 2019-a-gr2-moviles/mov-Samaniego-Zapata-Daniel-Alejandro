package Base

import Modelo.Medicina
import Modelo.Recetas

class BaseDeDatosMedicina{
    companion object {
        val lstMedicina:ArrayList<Medicina> = ArrayList()
        fun agregarMedicina(medicina: Medicina){
            lstMedicina.add(medicina)
        }

        fun mostrarMedicinas(){
            for (item: Medicina in lstMedicina){
                println(item.codigoMedicina +"\t"+ item.nombreMedicina)
            }
        }

        fun eliminarMedicina(nombre:String){
            for (i in lstMedicina.indices) {
                if(lstMedicina[i].nombreMedicina.equals(nombre)){
                    lstMedicina.removeAt(i)
                    println("Eliminado")
                }
            }
        }
        fun formarRecetas(nombre:String){
            var recetas = Recetas()
            var opcion :Int = 0
            for (item: Medicina in lstMedicina) {
                if(item.nombreMedicina.equals(nombre)){
                    recetas.lstRecetas.add(item)
                }
            }
            println("Desea agregar otra receta ? 1.- SI" +"\t"+ "2.-No")
            opcion = readLine()?.toInt() as Int
            when (opcion){
                1->{
                    formarRecetas(nombre)
                }
                2->{
                    println("Gracias por la compra")
                    for(item: Medicina in recetas.lstRecetas){
                        println(item.nombreMedicina + item.cantidadMedicina)
                    }
                }
            }

        }



    }
}