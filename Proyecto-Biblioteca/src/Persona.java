public class Persona {
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;

    /**
     * Metodo constructor de la clase Persona
     * @param nombre Nombre de la persona a crear
     * @param cedula Cedula de la persona a crear
     * @param telefono Telefono de la persona a crear
     * @param correo Correo de la persona a crear
     */
    public Persona(String nombre, String cedula, String telefono, String correo){
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
    }

    /**
     * Metodo para obtener el nombre de la persona
     * @return Nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo para obtener la cedula de la persona
     * @return Cedula de la persona
     */
    public String getCedula() {
        return cedula;
    }
    /**
     * Metodo para obtener el telefono de la persona
     * @return Telefono de la persona
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * Metodo para obtener el correo de la persona
     * @return Correo de la persona
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo para modificar el nombre de la persona
     * @param nombre Nuevo nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo para modificar la cedula de la persona
     * @param cedula Nueva cedula de la persona
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    /**
     * Metodo para modificar el telefono de la persona
     * @param telefono Nuevo telefono de la persona
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * Metodo para modificar el correo de la persona
     * @param correo Nuevo correo de la persona
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo para obtener la informacion de la persona
     * @return Informacion de la persona
     */
    public String toString() {
        return "Nombre=" + nombre + ", Cedula=" + cedula + ", Telefono=" + telefono + ", Correo=" + correo;
    }
}
