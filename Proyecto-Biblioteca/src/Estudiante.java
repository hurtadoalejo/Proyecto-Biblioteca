public class Estudiante {
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;

    /**
     * Metodo constructor de la clase Estudiante
     * @param nombre Nombre del estudiante a crear
     * @param cedula Cedula del estudiante a crear
     * @param telefono Telefono del estudiante a crear
     * @param correo Correo del estudiante a crear
     */
    public Estudiante(String nombre, String cedula, String telefono, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
    }

    /**
     * Metodo para obtener el nombre del estudiante
     * @return Nombre del estudiante
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo para obtener la cedula del estudiante
     * @return Cedula del estudiante
     */
    public String getCedula() {
        return cedula;
    }
    /**
     * Metodo para obtener el telefono del estudiante
     * @return Telefono del estudiante
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * Metodo para obtener el correo del estudiante
     * @return Correo del estudiante
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo para modificar el nombre del estudiante
     * @param nombre Nuevo nombre del estudiante
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo para modificar el nombre del estudiante
     * @param nombre Nuevo nombre del estudiante
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    /**
     * Metodo para modificar el nombre del estudiante
     * @param nombre Nuevo nombre del estudiante
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * Metodo para modificar el nombre del estudiante
     * @param nombre Nuevo nombre del estudiante
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo para obtener la informacion del estudiante
     * @return Informacion del estudiante
     */
    public String toString() {
        return "Estudiante: nombre=" + nombre + ", cedula=" + cedula + ", telefono=" + telefono + ", correo=" + correo;
    }
}