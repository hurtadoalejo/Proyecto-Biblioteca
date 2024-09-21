public class DetallePrestamo {
    private int cantidad;
    private Libro libro;

    /**
     * Metodo constructor de la clase DetallePrestamo
     * @param cantidad Cantidad de libros del detalle de pretasmo a crear
     * @param libro Libro del detalle de pretasmo a crear
     */
    public DetallePrestamo(int cantidad, Libro libro) {
        this.cantidad = cantidad;
        this.libro = libro;
    }

    /**
     * Metodo para obtener la cantidad de libros del detalle de prestamo
     * @return Cantidad de libros del detalle de prestamo
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * Metodo para obtener el libro del detalle de prestamo
     * @return Libro del detalle de prestamo
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Metodo para modificar la cantidad de libros del detalle de prestamo
     * @param cantidad Nueva cantidad de libros del detalle de prestamo
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Metodo para modificar el libro del detalle de prestamo
     * @param libro Nuevo libro del detalle de prestamo
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * Metodo para obtener la informacion del detalle de prestamo
     * @return Informacion del detalle de prestamo
     */
    public String toString() {
        return "DetallePrestamo [cantidad=" + cantidad + ", libro=" + libro.getTitulo() + "]";
    }    
}