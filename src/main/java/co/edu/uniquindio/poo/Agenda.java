package co.edu.uniquindio.poo;

import java.util.LinkedList;

public class Agenda {

    // Atributos
    private String nombre;
    private LinkedList<Contacto> listaContactos;
    

    // Constructor
    public Agenda(String nombre, Contacto contacto) {
        this.nombre = nombre;
        listaContactos = new LinkedList<>();
    }


    // Getters
    public String getNombre() {
        return nombre;
    }

    public LinkedList<Contacto> getListaContactos() {
        return listaContactos;
    }


    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListaContactos(LinkedList<Contacto> listaContactos) {
        this.listaContactos = listaContactos;
    }


    // ToString
    @Override
    public String toString() {
        return "Agenda [nombre=" + nombre + ", listaContactos=" + listaContactos + "]\n";
    }
    
    
    // Funciones 
    // Función para mostrar mensaje
    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }


    // Validación contacto no exista en la lista
    public boolean validarContacto(String telefono, String nombre){
        boolean validacionContacto = false;
        for(Contacto contacto : listaContactos){
            if (contacto.getTelefono().equals(telefono) && contacto.getNombre().equals(nombre)){
                validacionContacto = true;
            }
        }
        return validacionContacto;
    }


    // Función para agregar contactos a la lista
    public void agregarContacto(Contacto contacto){
        if (validarContacto(contacto.getTelefono(), contacto.getNombre())){
            mostrarMensaje("Error, el contacto ya existe en la agenda");
        } else{
            listaContactos.add(contacto);
        }
    }


    // Función para eliminar contacto de la agenda
    public void eliminarContacto(String telefono){
        for(Contacto contacto : listaContactos){
            if (contacto.getTelefono().equals(telefono)){
                listaContactos.remove(contacto);
            }
        }
    }

    // Función para actualización o modificación de contacto en la agenda
    public void modificarDatosContacto(String telefono, String cambiarDato, String nuevoDato){
        for(Contacto contacto : listaContactos){
            if (contacto.getTelefono().equals(telefono)){
                switch (cambiarDato.toLowerCase()) {
                    case "nombre":
                        contacto.setNombre(nuevoDato);
                        Agenda.mostrarMensaje("El nombre del contacto se cambio con éxito");
                        break;
                    case "alias":
                        contacto.setAlias(nuevoDato);
                        Agenda.mostrarMensaje("El alias del contacto se cambio con éxito");
                        break;
                    case "direccion":
                        contacto.setDireccion(nuevoDato);
                        Agenda.mostrarMensaje("La dirección del contacto se cambio con éxito");
                        break;
                    case "email":
                        contacto.setEmail(nuevoDato);
                        Agenda.mostrarMensaje("El email del contacto se cambio con éxito");
                        break;
                    default:
                        Agenda.mostrarMensaje("Ingresa un campo que desees cambiar valido, ejemplo: nombre");
                        break;
                }
            }
        }
    }



}
