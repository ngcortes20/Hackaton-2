package agenda;

import java.util.ArrayList;
import java.util.List;

public class ManejoEspacioAgenda {
    private List<Contacto> contactos;
    private int tamanoMaximo;

    // Constructor que recibe el tamaño máximo de la agenda
    public ManejoEspacioAgenda(int tamanoMaximo) {
        this.tamanoMaximo = tamanoMaximo;
        this.contactos = new ArrayList<>();
    }

    // Constructor por defecto que establece un tamaño máximo de 10
    public ManejoEspacioAgenda() {
        this(10); // Tamaño por defecto de 10 contactos
    }

    // Método para verificar si la agenda está llena
    public boolean agendaLlena() {
        return contactos.size() == tamanoMaximo;
    }

    // Método para mostrar un mensaje si la agenda está llena
    public void mostrarMensajeAgendaLlena() {
        if (agendaLlena()) {
            System.out.println("La agenda está llena. No hay espacio disponible para nuevos contactos.");
        } else {
            System.out.println("La agenda no está llena. Hay espacio disponible para nuevos contactos.");
        }
    }

    // Método para calcular el espacio libre en la agenda
    public int espacioLibres() {
        return tamanoMaximo - contactos.size();
    }

    // Método para mostrar cuántos contactos más se pueden agregar a la agenda
    public void mostrarEspacioLibres() {
        System.out.println("Quedan " + espacioLibres() + " contactos más que se pueden agregar a la agenda.");
    }

    // Método para añadir un contacto a la agenda
    public boolean añadirContacto(Contacto contacto) {
        if (!agendaLlena()) {
            contactos.add(contacto);
            return true;
        } else {
            System.out.println("No se pudo añadir el contacto. La agenda está llena.");
            return false;
        }
    }

    // Método para eliminar un contacto de la agenda
    public boolean eliminarContacto(Contacto contacto) {
        if (contactos.contains(contacto)) {
            contactos.remove(contacto);
            return true;
        } else {
            System.out.println("El contacto no se encuentra en la agenda.");
            return false;
        }
    }
}
