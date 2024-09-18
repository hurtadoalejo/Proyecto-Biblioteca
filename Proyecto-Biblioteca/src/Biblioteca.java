import java.util.List;
import java.util.LinkedList;

public class Biblioteca {
    private String nombre;
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
            }
        }
    }

    public void agregarPrestamo(Prestamo prestamo){
        if (verificarPrestamo(prestamo.getCodigo())) {
            listaPrestamos.add(prestamo);
            int cantidadPrestamos = prestamo.getBibliotecario().getCantidadPrestamos();
            prestamo.getBibliotecario().setCantidadPrestamos(cantidadPrestamos++);;
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
                listaPrestamos.remove(prestamoTemporal);
            }
        }
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

    public String getNombre() {
        return nombre;
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

    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", listaLibros=" + listaLibros + "]";
    }

    
}