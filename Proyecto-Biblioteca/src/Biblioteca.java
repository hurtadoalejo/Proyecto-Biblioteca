import java.util.List;
import java.util.LinkedList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Biblioteca {
    private String nombre;
    private double dineroRecaudado;
    private List<Estudiante> listaEstudiantes;
    private List<Bibliotecario> listaBibliotecarios;
    private List<Prestamo> listaPrestamos;
    private List<Libro> listaLibros;

    /**
     * Metodo constructor de la clase Biblioteca
     * @param nombre Nombre de la biblioteca a crear
     */
    public Biblioteca(String nombre){
        this.nombre = nombre;
        dineroRecaudado = 0;
        listaEstudiantes = new LinkedList<>();
        listaBibliotecarios = new LinkedList<>();
        listaPrestamos = new LinkedList<>();
        listaLibros = new LinkedList<>();
    }

    public void agregarLibro(Libro libro){
        if (verificarLibro(libro.getCodigo(), libro.getIsbn())){
            listaLibros.add(libro);
        }
    }
    public boolean verificarLibro(String codigo, String isbn){
        boolean decision = true;
        for(Libro libroTemporal : listaLibros){
            if (libroTemporal.getCodigo().equals(codigo) || libroTemporal.getIsbn().equals(isbn)) {
                decision = false;
            }
        }
        return decision;
    }
    public void eliminarLibro(String codigo){
        for(Libro libroTemporal : listaLibros){
            if (libroTemporal.getCodigo().equals(codigo)) {
                listaLibros.remove(libroTemporal);
                break;
            }
        }
    }

    public void agregarEstudiante(Estudiante estudiante){
        if (verificarEstudiante(estudiante.getCedula())) {
            listaEstudiantes.add(estudiante);
        }
    }
    public boolean verificarEstudiante(String cedula){
        boolean decision = true;
        for(Estudiante estudianteTemporal: listaEstudiantes){
            if (estudianteTemporal.getCedula().equals(cedula)) {
                decision = false;
            }
        }
        return decision;
    }
    public void eliminarEstudiante(String cedula){
        for(Estudiante estudianteTemporal: listaEstudiantes){
            if (estudianteTemporal.getCedula().equals(cedula)) {
                listaEstudiantes.remove(estudianteTemporal);
                break;
            }
        }
    }

    public void agregarBibliotecario(Bibliotecario bibliotecario){
        if (verificarBibliotecario(bibliotecario.getCedula())) {
            listaBibliotecarios.add(bibliotecario);
        }
    }
    public boolean verificarBibliotecario(String cedula){
        boolean decision = true;
        for(Bibliotecario bibliotecarioTemporal : listaBibliotecarios){
            if (bibliotecarioTemporal.getCedula().equals(cedula)) {
                decision = false;
            }
        }
        return decision;
    }
    public void eliminarBibliotecario(String cedula){
        for(Bibliotecario bibliotecarioTemporal : listaBibliotecarios){
            if (bibliotecarioTemporal.getCedula().equals(cedula)) {
                listaBibliotecarios.remove(bibliotecarioTemporal);
                break;
            }
        }
    }

    public void agregarPrestamo(Prestamo prestamo){
        if (verificarPrestamo(prestamo.getCodigo())) {
            listaPrestamos.add(prestamo);
            int cantidadPrestamos = prestamo.getBibliotecario().getCantidadPrestamos();
            prestamo.getBibliotecario().setCantidadPrestamos(++cantidadPrestamos);
        }
    }
    public boolean verificarPrestamo(String codigo){
        boolean decision = true;
        for(Prestamo prestamoTemporal: listaPrestamos){
            if (prestamoTemporal.getCodigo().equals(codigo)) {
                decision = false;
            }
        }
        return decision;
    }
    public void eliminarPrestamo(String codigo){
        for(Prestamo prestamoTemporal: listaPrestamos){
            if (prestamoTemporal.getCodigo().equals(codigo)) {
                int cantidadPrestamos = prestamoTemporal.getBibliotecario().getCantidadPrestamos();
                prestamoTemporal.getBibliotecario().setCantidadPrestamos(cantidadPrestamos-1);
                listaPrestamos.remove(prestamoTemporal);
                break;
            }
        }
    }
    public void entregarPrestamo(String codigo, int year, int month, int day){
        LocalDate fechaEntrega = LocalDate.of(year, month, day);
        for(Prestamo prestamoTemporal: listaPrestamos){
            if (prestamoTemporal.getCodigo().equals(codigo)) {
                actualizarUnidadesDisponibles(prestamoTemporal);
                double totalPagar = calcularCostoPrestamo(prestamoTemporal, fechaEntrega);
                aumentarDineroRecaudado(totalPagar);
                mostrarPrecioPrestamo(totalPagar);
                listaPrestamos.remove(prestamoTemporal);
                break;
            }
        }
    }
    public void actualizarUnidadesDisponibles(Prestamo prestamoTemporal){
        for(DetallePrestamo detallePrestamoTemporal: prestamoTemporal.getListaDetallePrestamos()){
            int unidadesPoner = detallePrestamoTemporal.getCantidad();
            int unidadesActuales = detallePrestamoTemporal.getLibro().getUnidadesDisponibles();
            detallePrestamoTemporal.getLibro().setUnidadesDisponibles(unidadesActuales+unidadesPoner);
        }
    }
    public double calcularCostoPrestamo(Prestamo prestamoTemporal, LocalDate fechaEntrega){
        double totalPagar = 0;
        totalPagar = prestamoTemporal.getCostoPrestamoDia() * ChronoUnit.DAYS.between(fechaEntrega, prestamoTemporal.getFechaPrestamo());
        return totalPagar;
    }
    public void aumentarDineroRecaudado(Double totalPagar){
        dineroRecaudado += totalPagar;
    }
    public void mostrarPrecioPrestamo(double totalPagar){
        System.out.println("El costo del prestamo es de: " + totalPagar);
    }

    public void mostrarDatosLibro(String codigo){
        for(Libro libroTemporal : listaLibros){
            if (libroTemporal.getCodigo().equals(codigo)) {
                System.out.println(libroTemporal.toString());
                break;
            }
        }
    }

    public int contarCantidadPrestamosLibro(String titulo){
        int conteo = 0;
        for(Prestamo prestamoTemporal : listaPrestamos){
            if (verificarLibroPrestamo(prestamoTemporal.getListaDetallePrestamos(), titulo)){
                conteo ++;
            }
        }
        return conteo;
    }

    public boolean verificarLibroPrestamo(List<DetallePrestamo> listaDetallePrestamos, String titulo){
        boolean decision = false;
        for(DetallePrestamo detallePrestamoTemporal : listaDetallePrestamos){
            if (detallePrestamoTemporal.getLibro().getTitulo().equals(titulo)) {
                decision = true;
                break;
            }
        }
        return decision;
    }

    public void reemplazarLibro(Libro libroViejo, Libro libroNuevo){
        if (verificarReemplazarLibro(libroNuevo.getCodigo(), libroNuevo.getIsbn())) {
            for(int a = 0; a < listaLibros.size(); a++){
                if (listaLibros.get(a).getCodigo().equals(libroViejo.getCodigo())) {
                    listaLibros.set(a, libroNuevo);
                    break;
                }
            }
        }
    }
    public boolean verificarReemplazarLibro(String codigo, String isbn){
        boolean decision = false;
        for(Libro libroTemporal : listaLibros){
            if (libroTemporal.getCodigo().equals(codigo) && !libroTemporal.getIsbn().equals(isbn)) {
                decision = true;
                break;
            }
        }
        return decision;
    }
    
    public void mostrarDatosPrestamo(String codigo){
        for(Prestamo prestamoTemporal : listaPrestamos){
            if (prestamoTemporal.getCodigo().equals(codigo)) {
                System.out.println(prestamoTemporal.toString());
                break;
            }
        }
    }
    public void mostrarPrestamosBibliotecarios(){
        for(Bibliotecario bibliotecarioTemporal : listaBibliotecarios){
            System.out.println("Nombre: " + bibliotecarioTemporal.getNombre() + ", Cedula: " + bibliotecarioTemporal.getCedula() + "\nCantidad prestamos realizados: " + bibliotecarioTemporal.getCantidadPrestamos());
        }
    }
    public void mostrarDineroRecaudado(){
        System.out.println("El dinero recaudado por la biblioteca ha sido de: " + dineroRecaudado);
    }

    public String getNombre() {
        return nombre;
    }
    public double getDineroRecaudado() {
        return dineroRecaudado;
    }
    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }
    public List<Bibliotecario> getListaBibliotecarios() {
        return listaBibliotecarios;
    }
    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }
    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDineroRecaudado(double dineroRecaudado) {
        this.dineroRecaudado = dineroRecaudado;
    }
    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
    public void setListaBibliotecarios(List<Bibliotecario> listaBibliotecarios) {
        this.listaBibliotecarios = listaBibliotecarios;
    }
    public void setListaPrestamos(List<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }
    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", listaPrestamos=" + listaPrestamos + "]";
    }
}