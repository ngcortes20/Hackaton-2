package agenda;
// inicializar objetos que se usarán en las pruebas
import org.junit.Before;
import org.junit.Test;
//indicar que el metodo es una prueba
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VerificacionYBusquedaTest {
    private VerificacionYBusqueda verificacion;
    private List<Contacto> contactos;

    @Before
    public void setUp() {
        // Inicializa la lista de contactos y la instancia de VerificacionYBusqueda
        contactos = new ArrayList<>();
        verificacion = new VerificacionYBusqueda(contactos);
    }

    @Test
    public void testAgregarYVerificarContacto() {
        // Crear un nuevo contacto
        Contacto contacto = new Contacto("Juan", "Pérez", "123456789");
        // Agregar el contacto a la lista
        contactos.add(contacto);

        // Verificar que el contacto existe
        assertTrue(verificacion.existeContacto(contacto));
    }

    @Test
    public void testNoExisteContacto() {
        // Crear un nuevo contacto que no se va a agregar
        Contacto contacto = new Contacto("Maria", "Gómez", "987654321");

        // Verificar que el contacto no existe en la lista
        assertFalse(verificacion.existeContacto(contacto));
    }

    @Test
    public void testBuscarContactoExistente() {
        // Crear un nuevo contacto
        Contacto contacto = new Contacto("Carlos", "López", "123123123");
        // Agregar el contacto a la lista
        contactos.add(contacto);

        // Buscar el contacto por nombre
        Contacto encontrado = verificacion.buscaContacto("Carlos");

        // Verificar que se haya encontrado el contacto
        assertNotNull(encontrado);
        assertEquals(contacto, encontrado); // Verificar que el contacto encontrado sea el correcto
    }

    @Test
    public void testBuscarContactoInexistente() {
        // Buscar un contacto que no existe en la lista
        Contacto encontrado = verificacion.buscaContacto("Ana");

        // Verificar que no se haya encontrado el contacto
        assertNull(encontrado);
    }
}
