package co.edu.uniquindio.poo;

import java.sql.Time;
import java.util.Date;
import java.util.LinkedList;

public class Reuniones {
    // Atributos
    private String descripcion;
    private Date fecha;
    private Time hora;
    private LinkedList<Contacto> listaContactosAsistentes;


    // Constructor
    public Reuniones(String descripcion, Date fecha, Time hora){
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        listaContactosAsistentes = new LinkedList<>();
    }

    
    // Getters
    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public LinkedList<Contacto> getListaContactosAsistentes() {
        return listaContactosAsistentes;
    }

    // Setters
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }


    public void setListaContactosAsistentes(LinkedList<Contacto> listaContactosAsistentes) {
        this.listaContactosAsistentes = listaContactosAsistentes;
    }


    // ToString
    @Override
    public String toString() {
        return "Reuniones [descripcion=" + descripcion + ", fecha=" + fecha + ", hora=" + hora
                + ", listaContactosAsistentes=" + listaContactosAsistentes + "]";
    }

    // Funciones
    
    // Función para validar que el contacto no existe en la reunion
    public boolean validarContactoReunion(String telefono){
        boolean validacion = false;
        for(Contacto contacto : listaContactosAsistentes){
            if (contacto.getTelefono().equals(telefono)){
                validacion = true;
            }
        }
        return validacion;
    }

    // Agregar contacto a Reunion
    public void agregarContactoReunion(Agenda agenda, Contacto... arrayListContactosReunion){
        // Pasamos los datos del array a nuestro linkedList
        for (Contacto contacto : arrayListContactosReunion){
            if (validarContactoReunion(contacto.getTelefono())){
                Agenda.mostrarMensaje("El contacto ya se encuentra en la reunion");
            } else{
                listaContactosAsistentes.add(contacto);
            }
        }
    }

    // Función eliminar contacto de la reunion
    public void eliminarContactoReunion(String telefono){
        for (Contacto contacto : listaContactosAsistentes){
            if (contacto.getTelefono().equals(telefono)){
                listaContactosAsistentes.remove(contacto);
                Agenda.mostrarMensaje("Se removió con éxito al numero: " + contacto.getTelefono());
            }
        }
    }

    // Función para modificar la fecha de la reunión
    public void modificarFechaReunion(Date fechaNueva){
        setFecha(fechaNueva);
        Agenda.mostrarMensaje("La fecha de la reunion se cambio con éxito");
    }

    // Función para modificar la hora de la reunión
    public void modificarHoraReunion(Time horanueva){
        setHora(horanueva);
        Agenda.mostrarMensaje("La hora de la reunion se cambio con éxito");
    }


    // Función para modificar la descripción de la reunion
    public void modificarDescripcionReunion(String datonuevo){
        setDescripcion(datonuevo);
        Agenda.mostrarMensaje("La descripción de la reunion se cambio con éxito");
    }
}
