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

    /**
     * Metodo para agregar un libro a la lista de libros de biblioteca
     * @param libro Libro que se busca agregar
     */
    public void agregarLibro(Libro libro){
        if (verificarLibro(libro.getCodigo(), libro.getIsbn())){
            listaLibros.add(libro);
        }
    }
    /**
     * Metodo para verificar si un libro no tiene el mismo codigo o isbn que otro en la lista de libros de biblioteca
     * @param codigo Codigo del libro a verificar
     * @param isbn ISBN del libro a verificar
     * @return Decision sobre si el libro tiene el mismo codigo o isbn que otro
     */
    public boolean verificarLibro(String codigo, String isbn){
        boolean decision = true;
        for(Libro libroTemporal : listaLibros){
            if (libroTemporal.getCodigo().equals(codigo) || libroTemporal.getIsbn().equals(isbn)) {
                decision = false;
            }
        }
        return decision;
    }
    /**
     * Metodo para eliminar un libro de la lista de libros de la biblioteca
     * @param codigo Codigo del libro que se busca eliminar
     */
    public void eliminarLibro(String codigo){
        for(Libro libroTemporal : listaLibros){
            if (libroTemporal.getCodigo().equals(codigo)) {
                listaLibros.remove(libroTemporal);
                break;
            }
        }
    }

    /**
     * Metodo para agregar un estudiante a la lista de estudiantes de biblioteca
     * @param estudiante Estudiante que se busca agregar
     */
    public void agregarEstudiante(Estudiante estudiante){
        if (verificarEstudiante(estudiante.getCedula())) {
            listaEstudiantes.add(estudiante);
        }
    }
    /**
     * Metodo para verificar si un estudiante tiene la misma cedula que otro en la lista de estudiantes de biblioteca
     * @param cedula Cedula del estudiante a verificar
     * @return Decision sobre si el estudiante tiene la misma cedula que otro o no
     */
    public boolean verificarEstudiante(String cedula){
        boolean decision = true;
        for(Estudiante estudianteTemporal: listaEstudiantes){
            if (estudianteTemporal.getCedula().equals(cedula)) {
                decision = false;
            }
        }
        return decision;
    }
    /**
     * Metodo para eliminar un estudiante de la lista de libros de la biblioteca
     * @param cedula Cedula del estudiante que se busca eliminar
     */
    public void eliminarEstudiante(String cedula){
        for(Estudiante estudianteTemporal: listaEstudiantes){
            if (estudianteTemporal.getCedula().equals(cedula)) {
                listaEstudiantes.remove(estudianteTemporal);
                break;
            }
        }
    }

    /**
     * Metodo para agregar un bibliotecario a la lista de bibliotecarios de biblioteca
     * @param bibliotecario Bibliotecario que se busca agregar
     */
    public void agregarBibliotecario(Bibliotecario bibliotecario){
        if (verificarBibliotecario(bibliotecario.getCedula())) {
            listaBibliotecarios.add(bibliotecario);
        }
    }
    /**
     * Metodo para verificar si un bibliotecario tiene la misma cedula que otro en la lista de bibliotecarios de biblioteca
     * @param cedula Cedula del bibliotecario a verificar
     * @return Decision sobre si el bibliotecario tiene la misma cedula que otro o no
     */
    public boolean verificarBibliotecario(String cedula){
        boolean decision = true;
        for(Bibliotecario bibliotecarioTemporal : listaBibliotecarios){
            if (bibliotecarioTemporal.getCedula().equals(cedula)) {
                decision = false;
            }
        }
        return decision;
    }
    /**
     * Metodo para eliminar un bibliotecario de la lista de bibliotecarios de biblioteca
     * @param cedula Cedula del bibliotecario que se busca eliminar
     */
    public void eliminarBibliotecario(String cedula){
        for(Bibliotecario bibliotecarioTemporal : listaBibliotecarios){
            if (bibliotecarioTemporal.getCedula().equals(cedula)) {
                listaBibliotecarios.remove(bibliotecarioTemporal);
                break;
            }
        }
    }
    /**
     * Metodo para agregar un prestamos a la lista de prestamos de la biblioteca
     * @param prestamo Prestamo que se busca agregar
     */
    public void agregarPrestamo(Prestamo prestamo){
        if (verificarPrestamo(prestamo.getCodigo())) {
            listaPrestamos.add(prestamo);
            actualizarPrestamosBibliotecario(prestamo.getBibliotecario(), 1);
        }
    }
    /**
     * Metodo para verificar si un codigo es igual a el codigo de un prestamo de la lista de prestamos de la biblioteca
     * @param codigo Codigo que se busca verificar
     * @return Decision sobre si el codigo es igual que otro o no
     */
    public boolean verificarPrestamo(String codigo){
        boolean decision = true;
        for(Prestamo prestamoTemporal: listaPrestamos){
            if (prestamoTemporal.getCodigo().equals(codigo)) {
                decision = false;
            }
        }
        return decision;
    }
    /**
     * Metodo para eliminar un prestamo de la lista de prestamos de la biblioteca
     * @param codigo Codigo del prestamos que se busca eliminar
     */
    public void eliminarPrestamo(String codigo){
        for(Prestamo prestamoTemporal: listaPrestamos){
            if (prestamoTemporal.getCodigo().equals(codigo)) {
                actualizarPrestamosBibliotecario(prestamoTemporal.getBibliotecario(), -1);
                prestamoTemporal.eliminarDetallesPrestamos();
                listaPrestamos.remove(prestamoTemporal);
                break;
            }
        }
    }
    /**
     * Metodo para entregar un prestamo, el cual actualiza los libros disponibles, calcula el total de el prestamo, adiciona el * dinero extra que se le pagara al bibliotecario encargado, aumenta el dinero recaudado por la biblioteca, muestra el
     * precio a pagar del prestamo, y actualiza el estado del prestamo a "Pagado"
     * @param codigo Codigo del prestamo a entregar
     * @param year Año de la fecha de entrega
     * @param month Mes de la fecha de entrega
     * @param day Dia de la fecha de entrega
     */
    public void entregarPrestamo(String codigo, int year, int month, int day){
        LocalDate fechaEntrega = LocalDate.of(year, month, day);
        for(Prestamo prestamoTemporal: listaPrestamos){
            if (prestamoTemporal.getCodigo().equals(codigo)) {
                prestamoTemporal.actualizarLibrosDisponibles();
                double totalPagar = calcularCostoPrestamo(prestamoTemporal, fechaEntrega);
                prestamoTemporal.getBibliotecario().aumentarDineroExtra(totalPagar*0.20);
                aumentarDineroRecaudado(totalPagar);
                mostrarPrecioPrestamo(totalPagar);
                prestamoTemporal.setEstadoPrestamo("Pagado");
                break;
            }
        }
    }
    
    /**
     * Metodo para actualizar la cantidad de prestamos que tiene un bibliotecario
     * @param bibliotecario Bibliotecario que se busca actualizar
     * @param aplicar Cantidad de prestamos que se buscan actualizar al bibliotecario
     */
    public void actualizarPrestamosBibliotecario(Bibliotecario bibliotecario, int aplicar){
        int totalPrestamos = bibliotecario.getCantidadPrestamos()+aplicar;
        bibliotecario.setCantidadPrestamos(totalPrestamos);
    }
    /**
     * Metodo para calcular el costo total de un prestamo
     * @param prestamoTemporal Prestamo con el que se va a calcular el total a pagar de este
     * @param fechaEntrega Fecha de entrega del prestamo
     * @return Total a pagar del prestamo
     */
    public double calcularCostoPrestamo(Prestamo prestamoTemporal, LocalDate fechaEntrega){
        double totalPagar = 0;
        totalPagar = prestamoTemporal.getCostoPrestamoDia() * ChronoUnit.DAYS.between(prestamoTemporal.getFechaPrestamo(), fechaEntrega);
        return totalPagar;
    }
    /**
     * Metodo para adicionar el total a pagar de un prestamo a el dinero recaudado de la biblioteca
     * @param totalPagar Total a pagar de un prestamo
     */
    public void aumentarDineroRecaudado(Double totalPagar){
        dineroRecaudado += totalPagar;
    }
    /**
     * Metodo para mostrar el total a pagar del prestamo
     * @param totalPagar Total a pagar del prestamo
     */
    public void mostrarPrecioPrestamo(double totalPagar){
        System.out.println("El costo del prestamo es de: " + totalPagar);
    }
    /**
     * Metodo para mostrar los datos de un libro dado un codigo
     * @param codigo Codigo del libro a mostrar
     */
    public void mostrarDatosLibro(String codigo){
        for(Libro libroTemporal : listaLibros){
            if (libroTemporal.getCodigo().equals(codigo)) {
                System.out.println(libroTemporal.toString());
                break;
            }
        }
    }
    /**
     * Metodo para contar la cantidad de veces que el titulo de un libro esta incluido en la lista de prestamos de biblioteca
     * @param titulo Titulo de un libro a contar
     * @return Cantidad de veces que el titulo de un libro esta incluido en prestamos 
     */
    public int contarCantidadPrestamosLibro(String titulo){
        int conteo = 0;
        for(Prestamo prestamoTemporal : listaPrestamos){
            if (verificarLibroPrestamo(prestamoTemporal.getListaDetallePrestamos(), titulo)){
                conteo ++;
            }
        }
        return conteo;
    }
    /**
     * Metodo para verificar si el libro de un titulo coincide con el de otro en una lista de detalles de prestamos
     * @param listaDetallePrestamos Lista de detalles de prestamos
     * @param titulo Titulo del libro que se buca verificar
     * @return Decision sobre si el libro coincide con el de un detalle de prestamo o no
     */
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
    /**
     * Metodo para reescribir un libro por otro
     * @param libroViejo Libro que sera sobreescrito
     * @param libroNuevo Libro que se quiere sobreescribir
     */
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
    /**
     * Metodo para verificar si un libro tiene el mismo codigo y diferente isbn en la lista de libros de la biblioteca
     * @param codigo Codigo del libro a verificar
     * @param isbn Isbn del libro a verificar
     * @return Decision sobre si el libro tiene el mismo codigo y diferente isbn que otro o no
     */
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
    /**
     * Metodo para mostrar los datos de un prestamo
     * @param codigo Codigo del prestamo a mostrar
     */
    public void mostrarDatosPrestamo(String codigo){
        for(Prestamo prestamoTemporal : listaPrestamos){
            if (prestamoTemporal.getCodigo().equals(codigo)) {
                System.out.println(prestamoTemporal.toString());
                break;
            }
        }
    }
    /**
     * Metodo para mostrar una lista de los bibliotecarios de la biblioteca y los prestamos realizados por cada uno
     */
    public void mostrarPrestamosBibliotecarios(){
        System.out.println("Bibliotecarios:");
        for(Bibliotecario bibliotecarioTemporal : listaBibliotecarios){
            System.out.println("Nombre=" + bibliotecarioTemporal.getNombre() + ", Cedula=" + bibliotecarioTemporal.getCedula() + ", Telefono=" + bibliotecarioTemporal.getTelefono() + "\nCantidad prestamos realizados=" + bibliotecarioTemporal.getCantidadPrestamos());
        }
    }
    /**
     * Metodo para mostrar el dinero recaudado por la biblioteca
     */
    public void mostrarDineroRecaudado(){
        System.out.println("El dinero recaudado por la biblioteca ha sido de: " + dineroRecaudado);
    }
    /**
     * Metodo para mostrar el estudiante con mayor cantidad de prestamos
     */
    public void mostrarMayorPrestamista(){
        Estudiante estudianteMayorPrestamista = saberMayorPrestamista();
        if (estudianteMayorPrestamista == null) {
            System.out.println("No hay un estudiante que tenga algún prestamo solicitado");
        }
        else{
            System.out.println("El estudiante con más prestamos es: " + estudianteMayorPrestamista.toString());
        }
    }
    /**
     * Metodo para saber el estudiante con mas prestamos de la lista de estudiantes de la biblioteca
     * @return Estudiante con mas prestamos
     */
    public Estudiante saberMayorPrestamista(){
        Estudiante estudianteMayorPrestamista = null;
        int mayorCantidadPrestamos = 0;
        for(Estudiante estudianteTemporal : listaEstudiantes){
            int contador = 0;
            for(Prestamo prestamoTemporal : listaPrestamos){
                if (prestamoTemporal.getEstudiante().getCedula().equals(estudianteTemporal.getCedula())) {
                    contador++;
                }
            }
            if (contador > mayorCantidadPrestamos) {
                mayorCantidadPrestamos = contador;
                estudianteMayorPrestamista = estudianteTemporal;
            }
        }
        return estudianteMayorPrestamista; 
    }
    /**
     * Metodo para calcular el total de monto a pagar a los bibliotecarios
     * @param year Año de fecha de corte
     * @param month Mes de fecha de corte
     * @param day Dia de fecha de corte
     * @return Monto total a pagar a los bibliotecarios
     */
    public double calcularSalariosPagar(int year, int month, int day){
        LocalDate fechaActual = LocalDate.of(year, month, day);
        double salarioPagar = 0;
        for(Bibliotecario bibliotecario : listaBibliotecarios){
                salarioPagar += bibliotecario.calcularSalario(fechaActual);
            }
        return salarioPagar;
    }
    
    /**
     * Metodo para obtener el nombre de la biblioteca
     * @return Nombre de la biblioteca
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo para obtener el dinero recaudado de la biblioteca
     * @return Dinero recaudado de la biblioteca
     */
    public double getDineroRecaudado() {
        return dineroRecaudado;
    }
    /**
     * Metodo para obtener la lista de estudiantes de la biblioteca
     * @return Lista de estudiantes de la biblioteca
     */
    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }
    /**
     * Metodo para obtener la lista de bibliotecarios de la biblioteca
     * @return Lista de bibliotecarios de la biblioteca
     */
    public List<Bibliotecario> getListaBibliotecarios() {
        return listaBibliotecarios;
    }
    /**
     * Metodo para obtener la lista de prestamos de la biblioteca
     * @return Lista de prestamos de la biblioteca
     */
    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }
    /**
     * Metodo para obtener la lista de libros de la biblioteca
     * @return Lista de libros de la biblioteca
     */
    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    /**
     * Metodo para modificar el nombre de la biblioteca
     * @param nombre Nuevo nombre de la biblioteca
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo para modificar el dinero recaudado de la biblioteca
     * @param dineroRecaudado Nuevo dinero recaudad de la biblioteca
     */
    public void setDineroRecaudado(double dineroRecaudado) {
        this.dineroRecaudado = dineroRecaudado;
    }
    /**
     * Metodo para modificar la lista de estudiantes de la biblioteca
     * @param listaEstudiantes Nueva lista de estudiantes de la biblioteca
     */
    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
    /**
     * Metodo para modificar la lista de bibliotecarios de la biblioteca
     * @param listaBibliotecarios Nueva lista de bibliotecarios de la biblioteca
     */
    public void setListaBibliotecarios(List<Bibliotecario> listaBibliotecarios) {
        this.listaBibliotecarios = listaBibliotecarios;
    }
    /**
     * Metodo para modificar la lista de prestamos de la biblioteca
     * @param listaPrestamos Nueva lista de prestamos de la biblioteca
     */
    public void setListaPrestamos(List<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }
    /**
     * Metodo para modificar la lista de libros de la biblioteca
     * @param listaLibros Nueva lista de libros de la biblioteca
     */
    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    /**
     * Metodo para obtener la informacion de la biblioteca
     * @return Informacion de la biblioteca
     */
    public String toString() {
        String info = "Biblioteca: " + nombre + "\n\nLista de estudiantes:";
        for (Estudiante estudiante : listaEstudiantes){
            info += "\n" + estudiante.toString();
        }
        info += "\n\nLista de bibliotecarios:";
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            info += "\n" + bibliotecario.toString();
        }
        info += "\n\nLista de libros:";
        for (Libro libro : listaLibros) {
            info += "\n\n" + libro.toString();
        }
        info += "\n\nLista de prestamos:\n";
        for (Prestamo prestamo : listaPrestamos) {
            info += "\n" + prestamo.toString();
        }
        return info;
    }
}