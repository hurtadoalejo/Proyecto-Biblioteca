import java.time.LocalDate;

public class Libro {
    private String codigo;
    private String isbn;
    private String autor;
    private String titulo;
    private String editorial;
    private LocalDate fechaLanzamiento;
    private int unidadesDisponibles;
    private String estadoLibro;

    /**
     * Metodo constructor de la clase Libro
     * @param codigo Codigo del libro a crear
     * @param isbn Isbn del libro a crear
     * @param autor Autor del libro a crear
     * @param titulo Titulo del libro a crear
     * @param editorial Editorial del libro a crear
     * @param year Año del libro a crear
     * @param month Mes del libro a crear
     * @param day Dia del libro a crear
     * @param unidadesDisponibles Unidades disponibles del libro a crear
     */
    public Libro(String codigo, String isbn, String autor, String titulo, String editorial, int year, int month, int day, int unidadesDisponibles) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fechaLanzamiento = LocalDate.of(year, month, day);
        this.unidadesDisponibles = unidadesDisponibles;
        this.estadoLibro = "Disponible";
    }

    /**
     * Metodo para disminuir la cantidad de libros disponibles
     * @param cantidad Cantidad a disminuir
     */
    public void disminuirDisponibles(int cantidad){
        unidadesDisponibles -= cantidad;
        actualizarEstadoLibro();
    }
    /**
     * Metodo para aumentar la cantidad de libros disponibles
     * @param cantidad Cantidad a aumentar
     */
    public void aumentarDisponibles(int cantidad){
        unidadesDisponibles += cantidad;
        actualizarEstadoLibro();
    }
    /**
     * Metodo para actualizar el estado del libro
     */
    public void actualizarEstadoLibro(){
        if (unidadesDisponibles == 0) {
            estadoLibro = "No disponible";
        }
        else if (unidadesDisponibles > 0) {
            estadoLibro = "Disponible";
        }
    }

    /**
     * Metodo para obtener el codigo del libro
     * @return Codigo del libro
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * Metodo para obtener el isbn del libro
     * @return Isbn del libro
     */
    public String getIsbn() {
        return isbn;
    }
    /**
     * Metodo para obtener el autor del libro
     * @return Autor del libro
     */
    public String getAutor() {
        return autor;
    }
    /**
     * Metodo para obtener el titulo del libro
     * @return Titulo del libro
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Metodo para obtener la editorial del libro
     * @return Editorial del libro
     */
    public String getEditorial() {
        return editorial;
    }
    /**
     * Metodo para obtener la fecha del libro
     * @return Fecha lanzamiento del libro
     */
    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }
    /**
     * Metodo para obtener las unidades disponibles del libro
     * @return Unidades disponibles del libro
     */
    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }
    /**
     * Metodo para obtener el estado del libro
     * @return Estado del libro
     */
    public String getEstadoLibro() {
        return estadoLibro;
    }

    /**
     * Metodo para modificar el codigo del libro
     * @param codigo Nuevo codigo del libro
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Metodo para modificar el codigo del libro
     * @param isbn Nuevo isbn del libro
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /**
     * Metodo para modificar el autor del libro
     * @param autor Nuevo autor del libro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    /**
     * Metodo para modificar el titulo del libro
     * @param titulo Nuevo titulo del libro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Metodo para modificar el editorial del libro
     * @param editorial Nueva editorial del libro
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    /**
     * Metodo para modificar la fecha lanzamiento del libro
     * @param fechaLanzamiento Nueva fecha lanzamiento del libro
     */
    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
    /**
     * Metodo para modificar las unidades disponibles del libro
     * @param unidadesDisponibles Nuevas unidades disponibles del libro
     */
    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }
    /**
     * Metodo para modificar el estado del libro
     * @param estadoLibro Nuevo estado del libro
     */
    public void setEstadoLibro(String estadoLibro) {
        this.estadoLibro = estadoLibro;
    }

    /**
     * Metodo para obtener la informacion del libro
     * @return Informacion del libro
     */
    public String toString() {
        return "Libro:" + "\nCodigo=" + codigo + ", ISBN=" + isbn + ", Titulo=" + titulo + ", Autor=" + autor + "\nEditorial=" + editorial + ", Fecha de lanzamiento=" + fechaLanzamiento + "\nUnidades disponibles=" + unidadesDisponibles + ", Estado del libro=" + estadoLibro;
    }   
}