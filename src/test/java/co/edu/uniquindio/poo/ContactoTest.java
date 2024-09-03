/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class ContactoTest {
    private static final Logger LOG = Logger.getLogger(ContactoTest.class.getName());

    // Test no ingresar datos vacio
    @Test
    public void datosVacios() {
        LOG.info("Iniciado test shouldAnswerWithTrue");
        assertThrows(Throwable.class, ()-> new Contacto("", "", "", "", ""));
        LOG.info("Finalizando test shouldAnswerWithTrue");
    }

    // Test validación correo "@"
    @Test
    public void validarCorreo() {
        LOG.info("Iniciado test shouldAnswerWithTrue");
        assertThrows(Throwable.class, ()-> new Contacto("Santiago", "SAN", "mz 14 casa 56", "3022415007", "sa"));
        LOG.info("Finalizando test shouldAnswerWithTrue");
    }

    @Test
    public void validarNumero() {
        LOG.info("Iniciado test shouldAnswerWithTrue");
        assertThrows(Throwable.class, ()-> new Contacto("Santiago", "SAN", "mz 14 casa 56", "asda213", "sa"));
        LOG.info("Finalizando test shouldAnswerWithTrue");
    }
    
}
