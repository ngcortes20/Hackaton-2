package agenda;

import java.util.ArrayList;
import java.util.List;

public class GestionContacto {
    private List<Contacto> contactos; // Lista de contactos
    private int capacidad; // Capacidad máxima de la agenda

    // Constructor
    public GestionContacto(int capacidad) {
        this.capacidad = capacidad;
        this.contactos = new ArrayList<>();
    }

    // Método para añadir un contacto
    public void añadirContacto(Contacto c) {
        if (contactos.size() < capacidad) {
            if (!contactos.contains(c)) {
                contactos.add(c);
                System.out.println("Contacto añadido: " + c);
            } else {
                System.out.println("El contacto ya existe en la agenda.");
            }
        } else {
            System.out.println("La agenda está llena.");
        }
    }

    // Método para eliminar un contacto
    public void eliminarContacto(Contacto c) {
        if (contactos.remove(c)) {
            System.out.println("Contacto eliminado: " + c);
        } else {
            System.out.println("No se encontró el contacto para eliminar.");
        }
    }

    // Método para obtener la lista de contactos
    public List<Contacto> obtenerContactos() {
        return contactos;
    }

    // Método para modificar el teléfono de un contacto
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevoTelefono); // Actualiza el teléfono
                System.out.println("Teléfono de " + c.getNombre() + " " + c.getApellido() + " actualizado a " + nuevoTelefono);
                return; // Salir del método
            }
        }
        System.out.println("No se encontró el contacto con el nombre y apellido especificados.");
    }
}
