import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private String codigo;
    private Bibliotecario bibliotecario;
    private Estudiante estudiante;
    private LocalDate fechaPrestamo;
    private double costoPrestamoDia;
    private List<DetallePrestamo> listaDetallePrestamos;
    private EstadoPrestamo estadoPrestamo;
    private double totalPrestamo;
    private LocalDate fechaEntrega;
    
    /**
     * Metodo constructor de la clase Prestamo
     * @param codigo Codigo del prestamo a crear
     * @param bibliotecario Bibliotecario del prestamo a crear
     * @param estudiante Estudiante del prestamo a crear
     * @param year Año de la fecha del prestamo a crear
     * @param month Mes de la fecha del prestamo a crear
     * @param day Dia de la fecha del prestamo a crear
     * @param costoPrestamoDia Costo del prestamo por día a crear
     */
    public Prestamo(String codigo, Bibliotecario bibliotecario, Estudiante estudiante, int year, int month, int day, double costoPrestamoDia) {
        this.codigo = codigo;
        this.bibliotecario = bibliotecario;
        this.estudiante = estudiante;
        this.fechaPrestamo = LocalDate.of(year, month, day);
        this.costoPrestamoDia = costoPrestamoDia;
        listaDetallePrestamos = new LinkedList<>();
        this.estadoPrestamo = EstadoPrestamo.PENDIENTE;
        this.totalPrestamo = 0;
        this.fechaEntrega = null;
    }

    /**
     * Metodo para actualizar la fecha de entrega del prestamo
     */
    public void actualizarFechaEntrega(LocalDate fechaEntrega){
        setFechaEntrega(fechaEntrega);
    }
    /**
     * Metodo para calcular el costo total del prestamo
     * @param prestamoTemporal Prestamo con el que se va a calcular el total a pagar de este
     * @param fechaEntrega Fecha de entrega del prestamo
     * @return Total a pagar del prestamo
     */
    public void calcularCostoPrestamo(LocalDate fechaEntrega){
        double totalPagar = 0;
        int diasPrestamo = (int) ChronoUnit.DAYS.between(fechaPrestamo, fechaEntrega);
        for (DetallePrestamo detallePrestamo : listaDetallePrestamos) {
            totalPagar += detallePrestamo.calcularSubtotal(diasPrestamo);
        }
        totalPrestamo = totalPagar;
    }
    /**
     * Metodo para agregar un detalle de prestamo
     * @param detallePrestamo Detalle de prestamo que se busca agregar 
     */
    public void agregarDetallePrestamo(DetallePrestamo detallePrestamo){
        Libro libro = detallePrestamo.getLibro();
        int cantidad = detallePrestamo.getCantidad();
        listaDetallePrestamos.add(detallePrestamo);
        libro.disminuirDisponibles(cantidad);
    }
    /**
     * Metodo para verificar que el detalle de prestamo no supere la cantidad disponible
     * @param cantidad Cantidad del detalle de prestamo
     * @param libro Libro del detalle de prestamo
     * @return Decision sobre si se puede añadir o no
     */
    public boolean verificarDetallePrestamo(int cantidad, Libro libro){
        boolean decision = true;
        if (cantidad > libro.getUnidadesDisponibles() ) {
            decision = false;
        }
        return decision;
    }
    /**
     * Metodo para eliminar un detalle de prestamo
     * @param detallePrestamo Detalle de prestamo que se eliminara
     */
    public void eliminarDetallePrestamo(DetallePrestamo detallePrestamo){
        detallePrestamo.getLibro().aumentarDisponibles(detallePrestamo.getCantidad());
        detallePrestamo.reiniciarSubtotal();
        listaDetallePrestamos.remove(detallePrestamo);
    }
    /**
     * Metodo para actualizar todos los libros de un prestamo debido a la eliminacion de este
     */
    public void actualizarLibrosDisponibles(){
        for(DetallePrestamo detallePrestamoTemporal : listaDetallePrestamos){
            if (estadoPrestamo.equals(EstadoPrestamo.PENDIENTE)) {
                detallePrestamoTemporal.getLibro().aumentarDisponibles(detallePrestamoTemporal.getCantidad());
            }      
        }
    }

    /**
     * Metodo para obtener el codigo del prestamo
     * @return Codigo del prestamo
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * Metodo para obtener el bibliotecario del prestamo
     * @return Bibliotecario del prestamo
     */
    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }
    /**
     * Metodo para obtener el estudiante del prestamo
     * @return Estudiante del prestamo
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }
    /**
     * Metodo para obtener la fecha del prestamo
     * @return Fecha del prestamo
     */
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    /**
     * Metodo para obtener el costo del prestamo por dia
     * @return Costo del prestamo por dia
     */
    public double getCostoPrestamoDia() {
        return costoPrestamoDia;
    }
    /**
     * Metodo para obtener la lista de detalles de prestamos
     * @return Lista de detalles de prestamos
     */
    public List<DetallePrestamo> getListaDetallePrestamos() {
        return listaDetallePrestamos;
    }
    /**
     * Metodo para obtener el estado del prestamo
     * @return Estado del prestamo
     */
    public EstadoPrestamo getEstadoPrestamo() {
        return estadoPrestamo;
    }
    /**
     * Metodo para obtener el total del prestamo
     * @return Total del prestamo
     */
    public double getTotalPrestamo() {
        return totalPrestamo;
    }
    /**
     * Metodo para obtener la fecha de entrega del prestamo
     * @return Fecha de entrega del prestamo
     */
    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Metodo para modificar el codigo del prestamo
     * @param codigo Nuevo codigo del prestamo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Metodo para modificar el bibliotecario del prestamo
     * @param bibliotecario Nuevo bibliotecario del prestamo
     */
    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
    /**
     * Metodo para modificar el estudiante del prestamo
     * @param estudiante Nuevo estudiante del prestamo
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    /**
     * Metodo para modificar la fecha del prestamo
     * @param fechaPrestamo Nueva fecha del prestamo
     */
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    /**
     * Metodo para modificar el costo del prestamo por dia
     * @param costoPrestamoDia Nuevo costo de prestamo por dia
     */
    public void setCostoPrestamoDia(double costoPrestamoDia) {
        this.costoPrestamoDia = costoPrestamoDia;
    }
    /**
     * Metodo para modificar la lista de detalles de prestamos
     * @param listaDetallePrestamos Nueva lista de detalles de prestamos
     */
    public void setListaDetallePrestamos(List<DetallePrestamo> listaDetallePrestamos) {
        this.listaDetallePrestamos = listaDetallePrestamos;
    }
    /**
     * Metodo para modificar el estado del prestamo
     * @param estadoPrestamo Nuevo estado del prestamo
     */
    public void setEstadoPrestamo(EstadoPrestamo estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }
    /**
     * Metodo para modificar el total del prestamo
     * @param totalPrestamo Nuevo total del prestamo
     */
    public void setTotalPrestamo(double totalPrestamo) {
        this.totalPrestamo = totalPrestamo;
    }
    /**
     * Metodo para modificar la fecha de entrega del prestamo
     * @param fechaEntrega Nueva fecha de entrega del prestamo
     */
    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * Metodo para obtener la informacion del prestamo
     * @return Informacion del prestamo
     */
    public String toString() {
        String info = "Prestamo:\n" + "Codigo=" + codigo + ", Estado del prestamo=" + estadoPrestamo + "\nFecha del prestamo=" + fechaPrestamo + ", Fecha de entrega prestamo=" + fechaEntrega + "\nCosto por dia=" + costoPrestamoDia + ", Costo total=" + totalPrestamo + "\nBibliotecario: " + "Nombre=" + bibliotecario.getNombre() + ", Cedula=" + bibliotecario.getCedula() + "\nEstudiante: " + "Nombre=" + estudiante.getNombre() + ", Cedula=" + estudiante.getCedula() + "\n\nDetalles del prestamo:\n";
        if (listaDetallePrestamos.isEmpty()) {
            info += "No existen articulos en el prestamo";
        }
        else{
            for (DetallePrestamo detallePrestamo : listaDetallePrestamos) {
                info += detallePrestamo.toString() + "\n";
            }
        }
        return info;
    }  
}