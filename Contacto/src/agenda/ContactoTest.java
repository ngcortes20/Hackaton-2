package agenda;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ContactoTest {

    @Test
    public void testEquals() {
        Contacto contacto1 = new Contacto("Juan", "Pérez", "123456789");
        Contacto contacto2 = new Contacto("Juan", "Pérez", "987654321");
        Contacto contacto3 = new Contacto("Ana", "Gómez", "555555555");

        // Esto debe ser verdadero porque los nombres y apellidos son iguales
        assertTrue(contacto1.equals(contacto2));

        // Esto debe ser falso porque los nombres y apellidos son diferentes
        assertFalse(contacto1.equals(contacto3));
    }
}
