package Vista

import Base.BaseDeDatosPaciente
import Base.BaseDeDatosMedicina
import Modelo.Medicina
import Modelo.Paciente
import Modelo.Tratamiento

fun main(args: Array<String>){

    /*println("Hola mundo")

    // Int edad = 29;

    // Mutable -> Cambiarse / Reasignar

    var edad: Int = 29

    edad = 10

    // Inmutable -> No puede cambiarse / No se puede reasignar

    val edadInmutable:Int = 29


    // Duck Typing

    var curso = 101 // Inferi que es un Int

    curso = 102

    var nombre = "Mario"

    var apellido = 'H'

    var casado = false

    var sueldo = 10.1

    var fechaNacimiento = Date()

    println(fechaNacimiento.toString())


    when(casado){
        false -> println("Feliz $nombre") // template strings
        true -> println("Triste ${nombre}") // template strings
        else -> {
            println("No me voy a ejecutar")
            println("Ni yo tampoco")
        }
    }

    var bono = if (casado) 1000.00 else 0.00

    val sueldoTotal = calcularSueldo(bono)
    println(sueldoTotal)

    val adrian = Usuario("Mario", vApellido = "Giler", vApellidoMaterno = "Salavarria")
    println(adrian)
    println(BaseDeDatos.Usuarios)
    println(BaseDeDatos.agregarUsuario("mario"))
    println(BaseDeDatos.Usuarios)
    var medicina = Modelo.Medicina()
    medicina.codigoMedicina="1369742"
    medicina.nombreMedicina="Paracetamol"
    Base.BaseDeDatosMedicina.agregarMedicina(medicina)
    var medicina2 = Modelo.Medicina()
    medicina2.codigoMedicina="1697420"
    medicina2.nombreMedicina="Aspirina"
    Base.BaseDeDatosMedicina.agregarMedicina(medicina2)
    Base.BaseDeDatosMedicina.eliminarMedicina("1697420")
    Base.BaseDeDatosMedicina.mostrarMedicinas()*/
    /*val frame = JFrame("Menu Modelo.Medicina")
    frame.contentPane = Menu().panel
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.pack()
    frame.isVisible = true*/
    var usuario:String=""
    var nombreUsuario:String=""
    println("Bienvenido al Sistema de Control de Pacientes")
    print("Ingrese su usuario del sistema: ")
    usuario= readLine()?.toString() as String
    nombreUsuario=BaseDeDatosPaciente.comprobarDoctor(usuario)
    if(!nombreUsuario.equals("")){
        println("Bienvenido Doctor: " +nombreUsuario)
        println("A Continuación se le presenta las opciones del sistema Doctor " + nombreUsuario)
        activarAplicacion()
    }else{
        println("No existe usuario, digite de nuevo el usuario")
        print("Ingrese su usuario del sistema: ")
        usuario= readLine()?.toString() as String
    }


}

fun activarAplicacion(){
    var estado:Int=0
    var opcion:Int
    println("1.- Agregar Paciente"+ "\n"+
            "2.- Eliminar Paciente" +"\n"+
            "3.- Mostrar Pacientes"+"\n"+
            "4.- Registrar Tratamiento"+"\n"+
            "5.- Buscar Tratamientos"+"\n"+
            "6.- Finalizar")
    println("Seleccione una opción:")
    opcion = readLine()?.toInt() as Int
    when(opcion){
        1 -> {
            println("Ingrese los datos solicitados en el inventario")
            var paciente = Paciente()
            print("Codigo del paciente: ")
            paciente.codigoPaciente= readLine()?.toString() as String
            print("Nombre del paciente: ")
            paciente.nombrePaciente = readLine()?.toString() as String
            print("Apellido del paciente: ")
            paciente.apellidoPaciente = readLine()?.toString() as String
            print("Edad del paciente: ")
            paciente.edadPaciente= readLine()?.toInt() as Int
            print("Estado civil del paciente: ")
            paciente.estadoCivilPaciente= readLine()?.toString() as String
            print("Domicilio del paciente: ")
            paciente.domicilioPaciente= readLine()?.toString() as String
            print("Telefono del paciente: ")
            paciente.telefonoPaciente = readLine()?.toString() as String
            print("Grupo Sanguineo del paciente: ")
            paciente.grupoSanguineoPaciente = readLine()?.toString() as String
            print("Alergias del paciente: ")
            paciente.alergiasPaciente = readLine()?.toString() as String
            print("Enfermedad del paciente: ")
            paciente.enfermedadPaciente = readLine()?.toString() as String
            BaseDeDatosPaciente.agregarPaciente(paciente)
                if(estado==0){
                activarAplicacion()
                }else{
                println("Programa Finalizado")
                }
            }
        2 -> {
             var nombrePaciente:String
             println("Escriba el nombre del paciente que desea eliminar")
             nombrePaciente = readLine()?.toString() as String
             BaseDeDatosPaciente.eliminarPacientes(nombrePaciente)
                if(estado==0){
                    activarAplicacion()
                }else{
                    println("Programa Finalizado")
                }
            }
        3 -> {
             BaseDeDatosPaciente.mostrarPacientes()
                if(estado==0){
                    activarAplicacion()
                }else{
                    println("Programa Finalizado")
                }
        }
        4 -> {
            println("Registrar tratamiento")
            BaseDeDatosPaciente.agregarTratamiento()
            if(estado==0){
                activarAplicacion()
            }else{
                println("Programa Finalizado")
            }
        }
        5 -> {
            println("Buscar tratamientos del paciente a tráves del nombre")
            var ejemplo:String =""
            println("*************************************************")
            var lstResultadoTratamientos:ArrayList<Tratamiento> = ArrayList()
            ejemplo= readLine()?.toString() as String
            lstResultadoTratamientos=BaseDeDatosPaciente.buscarTratamientosNombrePaciente(ejemplo)
            for(item:Tratamiento in lstResultadoTratamientos){
                var contador:Int=1
                println("Tratamient"+contador+": "+item.tratamientoEnfermedad)
                contador++
            }
            if(estado==0){
                activarAplicacion()
            }else{
                println("Programa Finalizado")
            }
        }
        6 -> {
            estado=1
        }
    }
}




/*fun calcularSueldo(bono: Double): Double{
    var sueldo = 800.00
    return sueldo + bono
}

fun saludar(): Unit{
    println("Hola mundo")
}

class Usuario(public var nombre:String){//1er constructor
    public var apellido:String? = null
    public var apellidoMaterno:String? = null
    constructor(vNombre:String, vApellido:String):this(vNombre){//2do o 3er constructor
        this.apellido = vApellido
    }
    constructor(vNombre:String, vApellido:String, vApellidoMaterno:String):this(vNombre){//2do o 3er constructor
        this.apellido = vApellido
        apellidoMaterno=vApellidoMaterno
    }
    /*public var nombre:String

    constructor(vNombre: String){
        this.nombre = vNombre
        nombre = vNombre
    }*/

    override fun toString(): String{
        val apellidoMayusculas = if(!apellido.isNullOrBlank()) this.apellido?.toUpperCase() else ""
        val apellidoMaterno = if(!apellidoMaterno.isNullOrBlank()) this.apellidoMaterno?.toUpperCase() else ""
        return "Hola ${nombre} ${apellidoMayusculas} ${apellidoMaterno}"

    }
}


open class Animal(var nombre:String){

}

class Tortuga( nombre: String,var pesoCaparazon:Double):Animal(nombre){

    init {
        println("$nombre $pesoCaparazon")
    }
}

var animal= Animal(nombre = "caballo")
var george = Tortuga(nombre = "George", pesoCaparazon = 12.5)

class Ejemplo{
    init {
        println("Estoy en el init")
    }
    var nombre:String
    constructor(nNombre:String){
        nombre=nNombre
        println("Estoy en el constructor ${nombre}")

    }

}

var ejemplo = Ejemplo(nNombre = "Mario")

class BaseDeDatos{
    companion object{
        val Usuarios:ArrayList<String> = ArrayList()
        fun agregarUsuario(nombre:String){
            Usuarios.add(nombre)
        }
    }
}
*/
