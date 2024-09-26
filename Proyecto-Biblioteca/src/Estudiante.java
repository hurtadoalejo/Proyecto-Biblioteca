import java.util.List;
import java.util.LinkedList;

public class Estudiante extends Persona{

    private EstadoEstudiante estado;
    private List<Prestamo> listaPrestamos;

    /**
     * Metodo constructor de la clase Estudiante
     * @param nombre Nombre del estudiante a crear
     * @param cedula Cedula del estudiante a crear
     * @param telefono Telefono del estudiante a crear
     * @param correo Correo del estudiante a crear
     * @param estado Estado del estudiante a crear
     */
    public Estudiante(String nombre, String cedula, String telefono, String correo, EstadoEstudiante estado) {
        super(nombre, cedula, telefono, correo);
        this.estado = estado;
        listaPrestamos = new LinkedList<>();
    }

    /**
     * Metodo para agregar un prestamo a la lista de prestamos del estudiante
     * @param prestamo Prestamo que se busca agregar
     */
    public void agregarPrestamo(Prestamo prestamo){
        if (verificarPrestamo(prestamo.getCodigo())) {
            listaPrestamos.add(prestamo);
        } 
    }
    /**
     * Metodo para verificar si un prestamo tiene el mismo codigo que otro en la lista de prestamos del estudiante
     * @param codigo Codigo del prestamo a verificar
     * @return Decision sobre si el prestamo tiene el mismo codigo que otro
     */
    public boolean verificarPrestamo(String codigo){
        boolean decision = true;
        for (Prestamo prestamoTemporal : listaPrestamos) {
            if (prestamoTemporal.getCodigo().equals(codigo)) {
                decision = false;
            }
        }
        return decision;
    }
    /**
     * Metodo para eliminar un prestamo a la lista de prestamos del estudiante
     * @param codigo Codigo del prestamo a eliminar
     */
    public void eliminarPrestamo(String codigo){
        for (Prestamo prestamoTemporal : listaPrestamos) {
            if (prestamoTemporal.getCodigo().equals(codigo)) {
                listaPrestamos.remove(prestamoTemporal);
                break;
            }
        }
    }

    /**
     * Metodo para obtener el estado del estudiante
     * @return Estado del estudiante
     */
    public EstadoEstudiante getEstado() {
        return estado;
    }
    /**
     * Metodo para obtener la lista de prestamos del estudiante
     * @return Lista de prestamos del estudiante
     */
    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    /**
     * Metodo para modificar el estado del estudiante
     * @param estado Nuevo estado del estudiante
     */
    public void setEstado(EstadoEstudiante estado) {
        this.estado = estado;
    }
    /**
     * Metodo para modificar la lista de prestamos del estudiante
     * @param listaPrestamos Nueva lista de prestamos del estudiante
     */
    public void setListaPrestamos(List<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    /**
     * Metodo para obtener la informacion del estudiante
     * @return Informacion del estudiante
     */
    public String toString(){
        String info = "\nEstudiante: " + super.toString() + ", Estado=" + estado + "\nLista de prestamos:\n";
        if (listaPrestamos.isEmpty()) {
            info += "Este estudiante no tiene ningun prestamo";
        }
        else{
            for (Prestamo prestamoTemporal : listaPrestamos) {
                info += "Prestamo codigo=" + prestamoTemporal.getCodigo();
            }
        }
        return info;
    }
}