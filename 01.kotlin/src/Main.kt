fun main(args : Array<String>){
    //println("Hello, world!")



// VARIABLES que puede mutar y no pueden mutar

// QUÉ ES MUTAR?

// MUTABLES
var nombre = "Adrian"
nombre = "Vicente"

// Inmutables
val nombreI = "Adrian"
nombreI = "Vicente"

// Una buena práctica son las variables inmutables porque no quiero que se modifique un usuario sino solo lo interno

// TIPOS DE DATOS

val apellido = "Eguez"
val edad: Int = 29
val sueldo: Double = 1.21
val casado: Boolean = false
val profesor: Boolean = true
val hijos = null

//No es necesario poner el tipo de dato

// Para entender el tipo de dato se conoce en inglés como DUCK TYPING
// Si parece un pato
// Si camina como un pato
// Si suena como pato
// Si vuela como pato
// PATO

// CONDICIONALES

if(apellido == "Eguez" || nombre == "Adrian"){
    println("Verdadero")
}else{
    println("Falso")
}

val tieneNombreYApellido = if(apellido!=null && nombre!=null) "ok" else "no"
println(tieneNombreYApellido)

    estaJalado(1.0)
    estaJalado(8.0)
    estaJalado(0.0)
    estaJalado(7.0)
    estaJalado(10.0)
    holaMundo(mensaje: "Adrian")
    holaMundoAvanzado(2)
    val total = sumarDosNumeros(1, 3)
    pintln(total)

    val arregloCumpleaños = arrayOf(1, 2, 3, 4)

    val arregloTodo: Array<Any>= arrayOf(1, "asd", 1.3, true)

    arregloCumpleaños[0] = 5
    arregloCumpleaños.set(0, 5)



}


fun sumarDosNumeros(numUno: Int, numDos: Int):Int{
    return numUno + numDos
}

fun estaJalado(nota:Double): Double{
    when(nota){
        7.0 ->{
            println("Pasaste con las justas")
        }
        10.0->{
            println("Genial:D Felicitaciones")
        }
        0.0 ->{
            println("Dios mío que vago!")
        }
        else ->{
            println("Tu nota es $nota")
            //println("Tu nota es ${nota.ALGO}")
        }
    }
    return nota
}


fun holaMundo(mensaje: String): Unit {
    println("Mensaje: $mensaje.")
}

fun holaMundoAvanzado(mensaje: Any): Unit {
    println("Mensaje: $mensaje.")
}




