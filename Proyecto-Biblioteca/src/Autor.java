import java.util.List;
import java.util.LinkedList;

public class Autor extends Persona{
    private String nacionalidad;
    private List<Libro> listaLibros;

    /**
     * Metodo constructor de la clase autor
     * @param nombre Nombre del autor a crear
     * @param cedula Cedula del autor a crear
     * @param telefono Telefono del autor a crear
     * @param correo Correo del autor a crear
     * @param nacionalidad Nacionalidad del autor a crear
     */
    public Autor(String nombre, String cedula, String telefono, String correo, String nacionalidad) {
        super(nombre, cedula, telefono, correo);
        this.nacionalidad = nacionalidad;
        this.listaLibros = new LinkedList<>();
    }

    /**
     * Metodo para agregar un libro a la lista de libros del autor
     * @param libro Libro que se busca agregar
     */
    public void agregarLibro(Libro libro){
        if (verificarLibro(libro.getCodigo())) {
            listaLibros.add(libro);
        } 
    }
    /**
     * Metodo para verificar si un libro tiene el mismo codigo que otro en la lista de prestamos del autor
     * @param codigo Codigo del libro a verificar
     * @return Decision sobre si el libro tiene el mismo codigo que otro
     */
    public boolean verificarLibro(String codigo){
        boolean decision = true;
        for (Libro libroTemporal : listaLibros) {
            if (libroTemporal.getCodigo().equals(codigo)) {
                decision = false;
                break;
            }
        }
        return decision;
    }
    /**
     * Metodo para eliminar un libro a la lista de libros del autor
     * @param codigo Codigo del libros a eliminar
     */
    public void eliminarLibro(String codigo){
        for (Libro libroTemporal : listaLibros) {
            if (libroTemporal.getCodigo().equals(codigo)) {
                listaLibros.remove(libroTemporal);
                break;
            }
        }
    }

    /**
     * Metodo para obtener la nacionalidad del autor
     * @return Nacionalidad del autor
     */
    public String getNacionalidad() {
        return nacionalidad;
    }
    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    /**
     * Metodo para modificar la nacionalidad del autor
     * @param nacionalidad Nueva nacionalidad del autor
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    /**
     * Metodo para obtener la informacion del autor
     * @return Informacion del autor
     */
    public String toString() {
        String info = super.toString() + ", Nacionalidad=" + nacionalidad + "\nLista de libros:";
        for (Libro libro : listaLibros) {
            info += "\nLibro=" + libro.getTitulo() + ", Fecha de Lanzamiento=" + libro.getFechaLanzamiento();
        }
        return info;
    }
}