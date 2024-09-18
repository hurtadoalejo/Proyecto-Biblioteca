public class App {
    public static void main(String[] args){
        Bibliotecario bibliotecario = new Bibliotecario("Alejo", "100", "750254", "alejo@gmail.com", 1200000);
        Estudiante estudiante = new Estudiante("Veronica", "1036", "316500", "vero@gmail.com");
        Libro libro = new Libro("2704", "100000", "Hugo", "PEPITO", "Planeta", 1980, 11,24, 5);
        Libro libro2 = new Libro("2200", "1023", "Gabos", "Flores", "Planeta", 2020, 11, 24, 7);
        Prestamo prestamo = new Prestamo("1", bibliotecario, estudiante, 2024, 10, 4, 2000);
        DetallePrestamo detallePrestamo = new DetallePrestamo(2, libro);
        DetallePrestamo detallePrestamo2 = new DetallePrestamo(2, libro);
        DetallePrestamo detallePrestamo3 = new DetallePrestamo(4, libro2);
        DetallePrestamo detallePrestamo4 = new DetallePrestamo(3, libro2);
        Biblioteca biblioteca = new Biblioteca("Gaspar");
        prestamo.agregarDetallePrestamo(detallePrestamo);
        prestamo.agregarDetallePrestamo(detallePrestamo2);
        prestamo.agregarDetallePrestamo(detallePrestamo3);
        prestamo.agregarDetallePrestamo(detallePrestamo4);
        
        biblioteca.agregarBibliotecario(bibliotecario);
        biblioteca.agregarEstudiante(estudiante);
        biblioteca.agregarLibro(libro);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarPrestamo(prestamo);
        biblioteca.mostrarPrestamosBibliotecarios();
        //biblioteca.mostrarDatosPrestamo("1");
        //System.out.println(biblioteca.contarCantidadPrestamosLibro("PEPITO"));
    }
}
