public class App {
    public static void main(String[] args){
        Bibliotecario bibliotecario = new Bibliotecario("Alejo", "100", "750254", "alejo@gmail.com", 1200000);
        Estudiante estudiante = new Estudiante("Veronica", "1036", "316500", "vero@gmail.com");
        Libro libro = new Libro("2704", "100000", "Hugo", "PEPITO", "Planeta", 1980, 11,24, 5);
        Prestamo prestamo = new Prestamo("1", bibliotecario, estudiante, 12, 10, 4, 2000);
        DetallePrestamo detallePrestamo = new DetallePrestamo(4, libro);
        Biblioteca biblioteca = new Biblioteca("Gaspar");
        prestamo.agregarDetallePrestamo(detallePrestamo);
        biblioteca.agregarBibliotecario(bibliotecario);
        biblioteca.agregarEstudiante(estudiante);
        biblioteca.agregarLibro(libro);
        biblioteca.agregarPrestamo(prestamo);
        System.out.println(biblioteca.contarCantidadPrestamosLibro("PEPITO"));
    }
}
