public class App {
    public static void main(String[] args){
        Biblioteca biblioteca = new Biblioteca("Gaspar");
        Libro libro = new Libro("1", "1540", "Hugo", "Magia", "Planeta", 1980, 11,24, 5);
        Libro libro2 = new Libro("2", "1023", "Gabo", "Flores", "Planeta", 2020, 11, 24, 7);
        biblioteca.agregarLibro(libro);
        biblioteca.agregarLibro(libro2);
        Bibliotecario bibliotecario = new Bibliotecario("Alejo", "100", "750254", "alejo@gmail.com", 1200000, 2023, 10, 25);
        Bibliotecario bibliotecario2 = new Bibliotecario("Aleja", "110", "750232", "aleja@gmail.com", 1200000, 2022, 10, 25);
        biblioteca.agregarBibliotecario(bibliotecario);
        biblioteca.agregarBibliotecario(bibliotecario2);
        Estudiante estudiante = new Estudiante("Veronica", "1036000000", "3165000000", "vero@gmail.com");
        Estudiante estudiante2 = new Estudiante("Marco", "2455500", "3156709900", "marco@gmail.com");
        biblioteca.agregarEstudiante(estudiante2);
        biblioteca.agregarEstudiante(estudiante);
        Prestamo prestamo = new Prestamo("1", bibliotecario, estudiante, 2024, 10, 4, 2000);
        Prestamo prestamo2 = new Prestamo("2", bibliotecario2, estudiante2, 2024, 10, 4, 3000);
        biblioteca.agregarPrestamo(prestamo);
        biblioteca.agregarPrestamo(prestamo2);
        DetallePrestamo detallePrestamo = new DetallePrestamo(1, libro);
        DetallePrestamo detallePrestamo2 = new DetallePrestamo(1, libro);
        DetallePrestamo detallePrestamo3 = new DetallePrestamo(2, libro2);
        DetallePrestamo detallePrestamo4 = new DetallePrestamo(3, libro2);
        prestamo2.agregarDetallePrestamo(detallePrestamo2);
        prestamo2.agregarDetallePrestamo(detallePrestamo4);
        prestamo.agregarDetallePrestamo(detallePrestamo);
        prestamo.agregarDetallePrestamo(detallePrestamo3);
        biblioteca.entregarPrestamo("1", 2024, 11, 5);
        biblioteca.entregarPrestamo("2", 2024, 11, 5);
        //System.out.println(biblioteca.calcularSalariosPagar(2024, 10, 24));
        //prestamo.eliminarDetallePrestamo(detallePrestamo);
        //biblioteca.eliminarPrestamo("1");   
        //biblioteca.entregarPrestamo("2", 2024, 9, 5);
        //System.out.println(biblioteca.getListaPrestamos());
        //biblioteca.mostrarDatosPrestamo("1");
        //biblioteca.mostrarDineroRecaudado();
        //biblioteca.mostrarPrestamosBibliotecarios();
        //biblioteca.mostrarMayorPrestamista();
        //System.out.println(biblioteca.contarCantidadPrestamosLibro("Magia"));
    }
}