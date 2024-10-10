//almacenar, verificar y buscar contactos en una agenda

package agenda;

import java.util.List;

public class VerificacionYBusqueda {
    private List<Contacto> contactos; // Lista para almacenar contactos

    public VerificacionYBusqueda(List<Contacto> contactos) {
        this.contactos = contactos; // Inicializa la lista de contactos desde una lista externa
    }

    // Metodo para verificar si un contacto existe en la lista
    public boolean existeContacto(Contacto c) {
        return contactos.contains(c); // Devuelve true si el contacto ya está en la lista
    }

    // Metodo para buscar un contacto por su nombre
    public Contacto buscaContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto; // Retorna el contacto si se encuentra
            }
        }
        return null; // Retorna null si no se encuentra el contacto
    }
}
