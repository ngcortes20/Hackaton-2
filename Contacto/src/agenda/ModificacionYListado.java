package agenda;

import java.util.List;

class ListarContactos {
    private GestionContacto gestionContacto; // Referencia a la clase GestionContacto

    // Constructor
    public ListarContactos(GestionContacto gestionContacto) {
        this.gestionContacto = gestionContacto; // Inicializa la referencia
    }

    // Método para listar los contactos
    public void listarContactos() {
        List<Contacto> contactos = gestionContacto.obtenerContactos(); // Obtenemos la lista de contactos

        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return; // Salimos del método si la lista está vacía
        }

        // Contador para enumerar contactos
        int contador = 1;

        // Recorremos la lista de contactos para imprimirlos
        for (Contacto c : contactos) {
            System.out.println(contador + ". " + c.getNombre() + " " + c.getApellido() + " - " + c.getTelefono());
            contador++; // Incrementa el contador después de cada contacto
        }

        // Imprimimos el número de contactos en la agenda
        System.out.println("Tienes " + contactos.size() + " contactos en tu agenda.");
    }

    // Método para modificar el teléfono de un contacto
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        gestionContacto.modificarTelefono(nombre, apellido, nuevoTelefono);
    }
}
