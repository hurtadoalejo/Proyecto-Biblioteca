public class App {
    public static void main(String[] args){
        Bibliotecario bibliotecario = new Bibliotecario("Alejo", "100", "750254", "alejo@gmail.com", 1200000, 2024, 4, 23);
        Estudiante estudiante = new Estudiante("Veronica", "1036", "316500", "vero@gmail.com");
        Libro libro = new Libro("2704", "100000", "Hugo", "PEPITO", "Planeta", 1980, 11,24, 5);
        Libro libro2 = new Libro("2200", "1023", "Gabos", "Flores", "Planeta", 2020, 11, 24, 7);
        Prestamo prestamo = new Prestamo("1", bibliotecario, estudiante, 2024, 10, 4, 2000);
        Prestamo prestamo2 = new Prestamo("2", bibliotecario, estudiante, 2024, 10, 4, 2000);
        DetallePrestamo detallePrestamo = new DetallePrestamo(2, libro);
        DetallePrestamo detallePrestamo2 = new DetallePrestamo(2, libro);
        DetallePrestamo detallePrestamo3 = new DetallePrestamo(4, libro2);
        DetallePrestamo detallePrestamo4 = new DetallePrestamo(3, libro2);
        DetallePrestamo detallePrestamo5 = new DetallePrestamo(1, libro);
        Biblioteca biblioteca = new Biblioteca("Gaspar");
        prestamo.agregarDetallePrestamo(detallePrestamo);
        prestamo.agregarDetallePrestamo(detallePrestamo2);
        prestamo.agregarDetallePrestamo(detallePrestamo3);
        prestamo.agregarDetallePrestamo(detallePrestamo4);
        prestamo2.agregarDetallePrestamo(detallePrestamo5);
        biblioteca.agregarBibliotecario(bibliotecario);
        biblioteca.agregarEstudiante(estudiante);
        biblioteca.agregarLibro(libro);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarPrestamo(prestamo);
        biblioteca.agregarPrestamo(prestamo2);
        biblioteca.entregarPrestamo("1", 2024, 9, 5);
        biblioteca.entregarPrestamo("2", 2024, 9, 5);
        System.out.println(biblioteca.getDineroRecaudado());
        System.out.println(libro.getUnidadesDisponibles());
        System.out.println(libro2.getUnidadesDisponibles());
        biblioteca.mostrarDineroRecaudado();
        biblioteca.mostrarPrestamosBibliotecarios();
        System.out.println(bibliotecario.toString());
        //biblioteca.mostrarPrestamosBibliotecarios();
        //biblioteca.mostrarDatosPrestamo("1");
        //System.out.println(biblioteca.contarCantidadPrestamosLibro("PEPITO"));
    }
}
