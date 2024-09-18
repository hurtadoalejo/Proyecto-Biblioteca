import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Prestamo {
    private String codigo;
    private Bibliotecario bibliotecario;
    private Estudiante estudiante;
    private LocalDate fechaPrestamo;
    private List<DetallePrestamo> listaDetallePrestamos;
    private double costoPrestamoDia;

    public Prestamo(String codigo, Bibliotecario bibliotecario, Estudiante estudiante, int anio, int mes, int dia, int costoPrestamoDia) {
        this.codigo = codigo;
        this.bibliotecario = bibliotecario;
        this.estudiante = estudiante;
        this.fechaPrestamo = fechaPrestamo.of(anio, mes, dia);
        this.costoPrestamoDia = costoPrestamoDia;
        listaDetallePrestamos = new LinkedList<>();
    }

    public void agregarDetallePrestamo(DetallePrestamo detallePrestamo){
        Libro libro = detallePrestamo.getLibro();
        int cantidad = detallePrestamo.getCantidad();
        if (verificarDetallePrestamo(cantidad, libro)) {
            libro.setUnidadesDisponibles(libro.getUnidadesDisponibles()-cantidad);
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
    public void entregarPrestamo(){
        
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
    public void setListaDetallePrestamos(List<DetallePrestamo> listaDetallePrestamos) {
        this.listaDetallePrestamos = listaDetallePrestamos;
    }
}
