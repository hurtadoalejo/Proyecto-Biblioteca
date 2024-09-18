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
    
    public Prestamo(String codigo, Bibliotecario bibliotecario, Estudiante estudiante, int anio, int mes, int dia, int costoPrestamoDia) {
        this.codigo = codigo;
        this.bibliotecario = bibliotecario;
        this.estudiante = estudiante;
        this.fechaPrestamo = LocalDate.of(anio, mes, dia);
        this.costoPrestamoDia = costoPrestamoDia;
        listaDetallePrestamos = new LinkedList<>();
    }

    public void agregarDetallePrestamo(DetallePrestamo detallePrestamo){
        Libro libro = detallePrestamo.getLibro();
        int cantidad = detallePrestamo.getCantidad();
        if (verificarDetallePrestamo(cantidad, libro)) {
            listaDetallePrestamos.add(detallePrestamo);
            libro.setUnidadesDisponibles(libro.getUnidadesDisponibles()-cantidad);
            bibliotecario.setCantidadPrestamos(bibliotecario.getCantidadPrestamos()+1);
        }
    }
    public boolean verificarDetallePrestamo(int cantidad, Libro libro){
        boolean decision = true;
        if (cantidad > libro.getUnidadesDisponibles()) {
            decision = false;
        }
        return decision;
    } 
    public void eliminarDetallePrestamo(DetallePrestamo detallePrestamo){
        for(DetallePrestamo detallePrestamoPrueba : listaDetallePrestamos){
            if (detallePrestamoPrueba.getLibro().getCodigo().equals(detallePrestamoPrueba.getLibro().getCodigo())) {
                listaDetallePrestamos.remove(detallePrestamoPrueba);
                detallePrestamo.getLibro().setUnidadesDisponibles(detallePrestamo.getLibro().getUnidadesDisponibles()+detallePrestamo.getCantidad());
            }
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

    public String toString() {
        return "Prestamo [codigo=" + codigo + ", bibliotecario=" + bibliotecario + ", estudiante=" + estudiante
                + ", fechaPrestamo=" + fechaPrestamo + ", costoPrestamoDia=" + costoPrestamoDia
                + ", listaDetallePrestamos=" + listaDetallePrestamos + "]";
    } 
}
