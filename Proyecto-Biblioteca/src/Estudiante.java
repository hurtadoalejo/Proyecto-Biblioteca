public class Estudiante extends Persona{


    /**
     * Metodo constructor de la clase Estudiante
     * @param nombre Nombre del estudiante a crear
     * @param cedula Cedula del estudiante a crear
     * @param telefono Telefono del estudiante a crear
     * @param correo Correo del estudiante a crear
     */
    public Estudiante(String nombre, String cedula, String telefono, String correo) {
        super(nombre, cedula, telefono, correo);
    }

    /**
     * Metodo para obtener la informacion del estudiante
     * @return Informacion del estudiante
     */
    public String toString(){
        return super.toString();
    }
}