package Base

import Modelo.Doctor
import Modelo.Paciente
import Modelo.Tratamiento

class BaseDeDatosPaciente{
    companion object {
        val lstPaciente:ArrayList<Paciente> = ArrayList()
        val lstTratamiento:ArrayList<Tratamiento> = ArrayList()
        fun agregarPaciente(paciente: Paciente){
            lstPaciente.add(paciente)
        }
        fun buscarPaciente(nombre:String): Paciente {
            var paciente= Paciente()
            for (item: Paciente in lstPaciente) {
                if(item.nombrePaciente.equals(nombre)){
                    println("Nombre del Paciente: "+item.nombrePaciente +"\t"+ "Enfermedad del Paciente: "+item.enfermedadPaciente)
                    paciente=item
                }
            }
            return paciente
        }


        fun mostrarPacientes(){
            for (item: Paciente in lstPaciente){
                println("Codigo Paciente: "+item.codigoPaciente+"\n"
                        +"Nombre Paciente: "+item.nombrePaciente+"\n"
                        +"Apellido Paciente: "+item.apellidoPaciente+"\n"
                        +"Edad Paciente: "+item.edadPaciente+"\n"
                        +"Estado Civil Paciente: "+"\t"+item.estadoCivilPaciente+"\n"
                        +"Domicio Paciente: "+item.domicilioPaciente+"\n"
                        +"Telefono Paciente: "+item.telefonoPaciente+"\n"
                        +"Grupo Sanguineo Paciente: "+item.grupoSanguineoPaciente+"\n"
                        +"Alergias Paciente: "+item.alergiasPaciente+"\n"
                        +"Enfermedad Paciente: "+item.enfermedadPaciente)
                println("**********************************************************")
            }
        }

        fun eliminarPacientes(nombre:String){
            for (i in lstPaciente.indices) {
                if(lstPaciente[i].nombrePaciente.equals(nombre)){
                    lstPaciente.removeAt(i)
                    println("Eliminado")
                }
            }
        }

        fun agregarTratamiento(){
            var nombrePaciente:String
            var tratamiento = Tratamiento()
            println("Ingrese nombre paciente: ")
            nombrePaciente= readLine()?.toString() as String
            tratamiento.paciente = buscarPaciente(nombrePaciente)
            println("Llenar tratamiento")
            print("Nombre del doctor: ")
            tratamiento.nombreDoctor= readLine()?.toString() as String
            print("Tratamiento de la enfermedad del paciente: ")
            tratamiento.tratamientoEnfermedad = readLine()?.toString() as String
            print("Observación del paciente: ")
            tratamiento.observacion= readLine()?.toString() as String
            lstTratamiento.add(tratamiento)
            println("Tratamiento guardado con éxito")
        }

        fun buscarTratamientosNombrePaciente(nombre:String):ArrayList<Tratamiento>{
            var lstResultadoTratamiento:ArrayList<Tratamiento> = ArrayList()
            for(item:Tratamiento in lstTratamiento){
                if(nombre.equals(item.paciente.nombrePaciente)){
                    lstResultadoTratamiento.add(item)
                }
            }
            return lstResultadoTratamiento
        }

        fun comprobarDoctor(nombreDoctor:String):String{
            var nombreUsuario:String=""
            var lstDoctores:ArrayList<Doctor> = ArrayList()
            var doctor=Doctor()
            doctor.nombreDoctor="Carlos"
            doctor.apellidoDoctor="Giler"
            doctor.usuarioDoctor="cgiler"
            lstDoctores.add(doctor)
            var doctor2=Doctor()
            doctor2.nombreDoctor="Luis"
            doctor2.apellidoDoctor="Rivas"
            doctor2.usuarioDoctor="lrivas"
            lstDoctores.add(doctor2)
            var doctor3=Doctor()
            doctor3.nombreDoctor="Calixto"
            doctor3.apellidoDoctor="Saldarriaga"
            doctor3.usuarioDoctor="csaldarriaga"
            lstDoctores.add(doctor3)
            for(item:Doctor in lstDoctores){
                if(nombreDoctor==item.usuarioDoctor)
                    nombreUsuario=item.nombreDoctor +"\t"+ item.apellidoDoctor
            }
            return nombreUsuario
        }


    }
}