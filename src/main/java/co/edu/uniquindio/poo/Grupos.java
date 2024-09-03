package co.edu.uniquindio.poo;

import java.util.LinkedList;

public class Grupos {

    // Atributos
    private String nombre;
    private String categoria;
    private LinkedList<Contacto> listaGrupoContactos;
    

    // Constructor
    public Grupos(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
        listaGrupoContactos = new LinkedList<>();
    }


    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public LinkedList<Contacto> getListaGrupoContactos() {
        return listaGrupoContactos;
    }
    

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setListaGrupoContactos(LinkedList<Contacto> listaGrupoContactos) {
        this.listaGrupoContactos = listaGrupoContactos;
    }


    // ToString
    @Override
    public String toString() {
        return "Grupos [nombre=" + nombre + ", categoria=" + categoria + ", listaGrupoContactos=" + listaGrupoContactos
                + "]";
    }


    // Funciones
    // Validación si el contacto ya se encuentra en el grupo
    public boolean validarContactoGrupo(String telefono){
        boolean validacion = false;
        for (Contacto contacto : listaGrupoContactos){
            if(contacto.getTelefono().equals(telefono)){
                validacion = true;
            }
        }
        return validacion;
    }


    // Agregar contacto al grupo
    public void agregarContacto(Agenda agenda, Contacto... arrayListaContactos){
        // Pasar datos del Array a nuestro LinkedList para poder manipularlo
        for (Contacto contacto : arrayListaContactos){
            if (validarContactoGrupo(contacto.getTelefono())){
                Agenda.mostrarMensaje("El contacto con número de teléfono: " + contacto.getTelefono() + "ya se encuentra en el grupo");
            }else{
                listaGrupoContactos.add(contacto);
            }
        }
        // Validamos que si se ingresaron mas de 5 contactos para crear el grupo
        if(listaGrupoContactos.size() >= 5){
            Agenda.mostrarMensaje("El grupo se creo con exito");
        }else {
            Agenda.mostrarMensaje("El grupo no ha sido creado, tiene que ingresar más de 5 contactos");
            // Con esta función vaciamos nuestro linked list para que el usuario vuelva a intentar crear el grupo
            listaGrupoContactos.clear();
        
        }
    }
    

    // Eliminar contacto del grupo
    public void eliminarContacto(String telefono){
        for (Contacto contacto : listaGrupoContactos){
            if (contacto.getTelefono().equals(telefono)){
                if(listaGrupoContactos.size() == 5){
                    Agenda.mostrarMensaje("No se puede eliminar el contacto porque no hay miembros suficientes");
                }else{
                    listaGrupoContactos.remove(contacto);
                    Agenda.mostrarMensaje("El contacto" + contacto.getTelefono() + " se removio con éxito");
                    break;
                }
                break;
            }
        
        }
    }


    // Función para cambiar el nombre al grupo
    public void cambiarNombreGrupo(String nombre){
        setNombre(nombre);
        Agenda.mostrarMensaje("El nombre del grupo a cambiado a: " + nombre);
    }


    // Función para cambiar la categoria del grupo
    public void cambiarCategoriaGrupo(String categoria){
        setCategoria(categoria);
        Agenda.mostrarMensaje("La categoría el grupo a sido cambiada a: " + categoria);
    }
}
