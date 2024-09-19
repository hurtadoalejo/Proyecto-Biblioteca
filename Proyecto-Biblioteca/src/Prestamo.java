import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Prestamo {
    private String codigo;
    private Bibliotecario bibliotecario;
    private Estudiante estudiante;
    private LocalDate fechaPrestamo;
    private double costoPrestamoDia;
    private List<DetallePrestamo> listaDetallePrestamos;
    private String estadoPrestamo;
    
    public Prestamo(String codigo, Bibliotecario bibliotecario, Estudiante estudiante, int year, int month, int day, int costoPrestamoDia) {
        this.codigo = codigo;
        this.bibliotecario = bibliotecario;
        this.estudiante = estudiante;
        this.fechaPrestamo = LocalDate.of(year, month, day);
        this.costoPrestamoDia = costoPrestamoDia;
        listaDetallePrestamos = new LinkedList<>();
        estadoPrestamo = "Pendiente";
    }

    public void agregarDetallePrestamo(DetallePrestamo detallePrestamo){
        Libro libro = detallePrestamo.getLibro();
        int cantidad = detallePrestamo.getCantidad();
        listaDetallePrestamos.add(detallePrestamo);
        libro.disminuirDisponibles(cantidad);
    }
    public boolean verificarDetallePrestamo(int cantidad, Libro libro){
        boolean decision = true;
        if (cantidad > libro.getUnidadesDisponibles() ) {
            decision = false;
        }
        return decision;
    } 
    public void eliminarDetallePrestamo(DetallePrestamo detallePrestamo){
        detallePrestamo.getLibro().aumentarDisponibles(detallePrestamo.getCantidad());
        listaDetallePrestamos.remove(detallePrestamo);
    }

    public void eliminarDetallesPrestamos(){
        for(DetallePrestamo detallePrestamoTemporal : listaDetallePrestamos){
            detallePrestamoTemporal.getLibro().aumentarDisponibles(detallePrestamoTemporal.getCantidad());
            eliminarDetallePrestamo(detallePrestamoTemporal);
        }
    }
    
    public void actualizarLibrosDisponibles(){
        for(DetallePrestamo detallePrestamoTemporal : listaDetallePrestamos){
            detallePrestamoTemporal.getLibro().aumentarDisponibles(detallePrestamoTemporal.getCantidad());
        }
    }

    public String getCodigo() {
        return codigo;
    }
    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }
    public Estudiante getEstudiante() {
        return estudiante;
    }
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    public double getCostoPrestamoDia() {
        return costoPrestamoDia;
    }
    public List<DetallePrestamo> getListaDetallePrestamos() {
        return listaDetallePrestamos;
    }
    public String getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public void setCostoPrestamoDia(double costoPrestamoDia) {
        this.costoPrestamoDia = costoPrestamoDia;
    }
    public void setListaDetallePrestamos(List<DetallePrestamo> listaDetallePrestamos) {
        this.listaDetallePrestamos = listaDetallePrestamos;
    }
    public void setEstadoPrestamo(String estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }

    public String toString() {
        return "Prestamo [codigo=" + codigo + ", bibliotecario=" + bibliotecario + ", estudiante=" + estudiante
                + ", fechaPrestamo=" + fechaPrestamo + ", costoPrestamoDia=" + costoPrestamoDia
                + ", listaDetallePrestamos=" + listaDetallePrestamos + ", estadoPrestamo=" + estadoPrestamo + "]";
    }  
}
