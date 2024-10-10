package agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacidadMaxima;

        // Solicitar la capacidad máxima de la agenda al usuario
        while (true) {
            System.out.print("Por favor, introduce la capacidad máxima de la agenda (10-20 contactos): ");
            capacidadMaxima = scanner.nextInt();
            if (capacidadMaxima >= 10 && capacidadMaxima <= 20) {
                break; // Salir del bucle si la entrada es válida
            } else {
                System.out.println("Entrada no válida. Debe ser un número entre 10 y 20.");
            }
        }

        // Crear una instancia de GestionContacto con la capacidad máxima ingresada por el usuario
        GestionContacto gestionContactos = new GestionContacto(capacidadMaxima);
        ManejoEspacioAgenda manejoEspacio = new ManejoEspacioAgenda(capacidadMaxima); // Instancia de ManejoEspacioAgenda

        // Crear las listas para verificación y listado de contactos
        List<Contacto> listaContactos = new ArrayList<>();
        VerificacionYBusqueda verificacionYBusqueda = new VerificacionYBusqueda(listaContactos);
        ListarContactos listarContactos = new ListarContactos(gestionContactos);


        boolean continuar = true;

        while (continuar) {
            System.out.println("\nTu agenda:");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Listar contactos");
            System.out.println("5. Modificar número de teléfono");
            System.out.println("6. Salir");
            System.out.print("Por favor, introduce una opción válida: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Añadir contacto
                    if (manejoEspacio.agendaLlena()) {
                        manejoEspacio.mostrarMensajeAgendaLlena();
                        break;
                    }

                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine().trim();
                    System.out.print("Ingrese el apellido: ");
                    String apellido = scanner.nextLine().trim();
                    System.out.print("Ingrese el teléfono: ");
                    String telefono = scanner.nextLine().trim();

                    Contacto nuevoContacto = new Contacto(nombre, apellido, telefono);

                    // Añadir contacto a la gestión
                    gestionContactos.añadirContacto(nuevoContacto);
                    listaContactos.add(nuevoContacto); // Agregar a la lista para búsqueda y verificación
                    manejoEspacio.mostrarEspacioLibres(); // Mostrar espacio libre después de añadir
                    break;

                case 2:
                    // Eliminar contacto
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine().trim();
                    System.out.print("Ingrese el apellido del contacto a eliminar: ");
                    String apellidoEliminar = scanner.nextLine().trim();

                    Contacto contactoEliminar = new Contacto(nombreEliminar, apellidoEliminar, "");
                    gestionContactos.eliminarContacto(contactoEliminar);
                    listaContactos.remove(contactoEliminar); // También intenta eliminar del lista de verificación
                    manejoEspacio.mostrarEspacioLibres(); // Mostrar espacio libre después de eliminar
                    break;

                case 3:
                    // Buscar contacto
                    System.out.print("Ingrese el nombre del contacto a buscar: ");
                    String nombreBuscar = scanner.nextLine().trim();
                    Contacto contactoEncontrado = verificacionYBusqueda.buscaContacto(nombreBuscar);

                    if (contactoEncontrado != null) {
                        System.out.println("Contacto encontrado: " + contactoEncontrado);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;

                case 4:
                    // Listar contactos
                    System.out.println("   ");
                    listarContactos.listarContactos(); // Llamada al método de listar
                    break;

                case 5:
                    // Modificar número de teléfono
                    System.out.print("Ingrese el nombre del contacto a modificar: ");
                    String nombreModificar = scanner.nextLine().trim();
                    System.out.print("Ingrese el apellido del contacto a modificar: ");
                    String apellidoModificar = scanner.nextLine().trim();
                    System.out.print("Ingrese el nuevo número de teléfono: ");
                    String nuevoTelefono = scanner.nextLine().trim();

                    listarContactos.modificarTelefono(nombreModificar, apellidoModificar, nuevoTelefono); // Llamar al método de modificar
                    break;

                case 6:
                    // Salir
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
        System.out.println("Programa finalizado.");
    }
}
