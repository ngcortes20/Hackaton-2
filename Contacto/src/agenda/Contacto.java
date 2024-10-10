package agenda;
//Esta clase define el modelo de contacto y contendrá los atributos y métodos necesarios para crear
//  gestionar los datos de un contacto
public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;

    // Constructor
public Contacto(String nombre, String apellido, String telefono) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.telefono = telefono;
}
    //Getter and Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //Devuelve true si ambos atributos (nombre y apellido) son iguales;
    // de lo contrario, devuelve false.

    @Override
    public boolean equals(Object obj) {
        // Verifica si ambos objetos son la misma instancia
        if (this == obj) {
            return true;
        }
        // Verifica si obj es nulo o no es una instancia de Contacto
        if (obj == null || !(obj instanceof Contacto)) {
            return false;
        }

        // Realiza el casting a Contacto
        Contacto otroContacto = (Contacto) obj;

        // Compara los nombres y apellidos ignorando mayúsculas y minúsculas
        return this.nombre.equalsIgnoreCase(otroContacto.nombre) &&
                this.apellido.equalsIgnoreCase(otroContacto.apellido);
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }
}

