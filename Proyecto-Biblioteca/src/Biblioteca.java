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

    public void agregarPrestamo(Prestamo prestamo){
        if (verificarPrestamo(prestamo.getCodigo())) {
            listaPrestamos.add(prestamo);
            prestamo.getBibliotecario().incrementarCantidadPrestados();
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
}