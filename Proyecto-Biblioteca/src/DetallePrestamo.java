public class DetallePrestamo {
    private int cantidad;
    private Libro libro;
    private double subtotal;
    private Prestamo prestamo;

    /**
     * Metodo constructor de la clase DetallePrestamo
     * @param cantidad Cantidad de libros del detalle de pretasmo a crear
     * @param libro Libro del detalle de pretasmo a crear
     */
    public DetallePrestamo(int cantidad, Libro libro, Prestamo prestamo) {
        this.cantidad = cantidad;
        this.libro = libro;
        this.prestamo = prestamo;
        subtotal = 0;
    }
    /**
     * Metodo para reiniciar el subtotal del detalle de prestamo a 0 pesos
     */
    public void reiniciarSubtotal(){
        subtotal = 0;
    }
    /**
     * Metodo para calcular el subtotal del detalle de prestamo
     * @return Subtotal del detalle de prestamo
     */
    public double calcularSubtotal(int diasPrestamo){
        double subtotal = prestamo.getCostoPrestamoDia()*cantidad*diasPrestamo;
        return subtotal;
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
     * Metodo para obtener el prestamo al que pertenece el detalle de prestamo
     * @return Prestamo que contiene el detalle de prestamo
     */
    public Prestamo getPrestamo() {
        return prestamo;
    }
    /**
     * Metodo para obtener el subtotal del detalle de prestamo
     * @return Subtotal del detalle de prestamo
     */
    public double getSubtotal() {
        return subtotal;
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
     * Metodo para obtener el prestamo al que pertenece el detalle de prestamo
     * @param prestamo Subtotal del detalle de prestamo
     */
    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
    /**
     * Metodo para modificar el subtotal del detalle de prestamo
     * @param subtotal Subtotal del detalle de prestamo
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    /**
     * Metodo para obtener la informacion del detalle de prestamo
     * @return Informacion del detalle de prestamo
     */
    public String toString() {
        return "DetallePrestamo: " + "Libro=" + libro.getTitulo() + ", Cantidad=" + cantidad;
    }    
}