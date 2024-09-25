import java.util.List;
import java.util.LinkedList;

public class Editorial {
    private String nombre;
    private String correo;
    private String paisOrigen;
    private List<Libro> listaLibros;

    public Editorial(String nombre, String correo, String paisOrigen) {
        this.nombre = nombre;
        this.correo = correo;
        this.paisOrigen = paisOrigen;
        this.listaLibros = new LinkedList<>();
    }

/**
     * Metodo para agregar un libro a la lista de libros de la editorial
     * @param libro Libro que se busca agregar
     */
    public void agregarLibro(Libro libro){
        if (verificarPrestamo(libro.getCodigo())) {
            listaLibros.add(libro);
        } 
    }
    /**
     * Metodo para verificar si un libro tiene el mismo codigo que otro en la lista de prestamos de la editorial
     * @param codigo Codigo del libro a verificar
     * @return Decision sobre si el libro tiene el mismo codigo que otro
     */
    public boolean verificarPrestamo(String codigo){
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
     * Metodo para eliminar un libro a la lista de libros de la editorial
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
     * Metodo para obtener el nombre de la editorial
     * @return Nombre de la editorial
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo para obtener el correo de la editorial
     * @return Correo de la editorial
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * Metodo para obtener el pais de origen de la editorial
     * @return Pais de origen de la editorial
     */
    public String getPaisOrigen() {
        return paisOrigen;
    }
    /**
     * Metodo para obtener la lista de libros de la editorial
     * @return Lista de libros de la editorial
     */
    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    /**
     * Metodo para modificar el nombre de la editorial
     * @param nombre Nuevo nombre de la editorial
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo para modificar el correo de la editorial
     * @param correo Correo de la editorial
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * Metodo para modificar el pais de origen de la editorial
     * @param paisOrigen Pais de origen de la editorial
     */
    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    /**
     * Metodo para modificar la lista de libros de la editorial
     * @param listaLibros Lista de libros de la editorial
     */
    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    /**
     * Metodo para obtener la informacion de la editorial
     * @return Informacion de la editorial
     */
    public String toString() {
        String info = "Editorial: Nombre=" + nombre + ", Correo=" + correo + ", Pais origen=" + paisOrigen + "\nLista de libros:";
        for (Libro libro : listaLibros) {
            info += "Libro=" + libro.getTitulo() + ", Autor=" + libro.getAutor().getNombre();
        }
        return info;
    }
}