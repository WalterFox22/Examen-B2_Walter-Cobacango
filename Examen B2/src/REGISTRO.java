public class REGISTRO {
    String cedula;
    int n_historial_clinico;
    String nombre;
    String apellido;
    String telefono;
    int edad;
    String descripcion;

    public REGISTRO(String cedula, int n_historial_clinico, String nombre, String apellido, String telefono, int edad, String descripcion) {
        this.cedula = cedula;
        this.n_historial_clinico = n_historial_clinico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
        this.descripcion = descripcion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getN_historial_clinico() {
        return n_historial_clinico;
    }

    public void setN_historial_clinico(int n_historial_clinico) {
        this.n_historial_clinico = n_historial_clinico;
    }

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
