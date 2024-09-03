package co.edu.uniquindio.poo;

public class App {
    public static void main(String[] args) {


        // Definimos la Agenda
        Agenda agenda1 = new Agenda("Agenda1", null);

        // Definimos las reuniones
        Reuniones reunion1 = new Reuniones("Cumpleaños", null, null);

        // Definimos los grupos
        Grupos grupo1 = new Grupos("Los mejores", "Amigos");
      
        // Definimos los contactos
        Contacto contacto1 = new Contacto("Santiago", "Santi", "mz 14 casa 3", "3217651234", "santiago.ariasr1@gmail.com");
        Contacto contacto2 = new Contacto("Mariana", "Mari", "mz 2 casa 18", "3023130890", "mariana@gmail.com");
        Contacto contacto3 = new Contacto("David", "Hurtado", "mz 13 casa 13", "3212415007", "david@gmail.com");
        Contacto contacto4 = new Contacto("Luisa", "Profe", "mz 3 casa 13", "3256780984", "luisa@gmail.com");
        Contacto contacto5 = new Contacto("Laura", "Lau", "mz 12 casa 81", "3293459871", "lau@gmail.com");
        Contacto contacto6 = new Contacto("Pepito", "Pepe", "mz 23 casa 13", "3190985430", "pepe@gmail.com");

        // Agregamos los contactos a la agenda
        agenda1.agregarContacto(contacto1);
        agenda1.agregarContacto(contacto2);
        agenda1.agregarContacto(contacto3);
        agenda1.agregarContacto(contacto4);
        agenda1.agregarContacto(contacto5);
        agenda1.agregarContacto(contacto6);

        // Agregamos los contactos a una reunion
        reunion1.agregarContactoReunion(agenda1, contacto1);
        reunion1.agregarContactoReunion(agenda1, contacto2);
        reunion1.agregarContactoReunion(agenda1, contacto3);

        // Intentamos crear un grupo con menos de 5 personas para validar excepción
        grupo1.agregarContacto(agenda1, contacto1, contacto2);

        // Repetimos pero intentando crear el grupo con mas de 5 personas
        grupo1.agregarContacto(agenda1, contacto1, contacto2, contacto3, contacto4, contacto5);
        

        // Quitamos 1 contacto del grupo
        grupo1.eliminarContacto("3217651234");

        // Quitamos 1 contacto de la reunion
        reunion1.eliminarContactoReunion("3023130890");

        // Modificamos la categoria del grupo
        grupo1.cambiarCategoriaGrupo("Fiesta");

        // Modificamos la descripcion de la reunion
        reunion1.modificarDescripcionReunion("Reunion gerencia de proyectos");

        // Modificamos un dato del contacto
        agenda1.modificarDatosContacto("3023130890", "alias", "Carmona");
        
    }   
}
