public class App {
    public static void main(String[] args) throws Exception {
        Bibliotecario bibliotecario = new Bibliotecario("Alejo", "100", "750254", "alejo@gmail.com", 1200000);
        Estudiante estudiante = new Estudiante("Veronica", "1036", "316500", "vero@gmail.com");
        Prestamo prestamo = new Prestamo("1", bibliotecario, estudiante, 12, 10, 4, 2000);
        Biblioteca biblioteca = new Biblioteca("Gaspar");
        biblioteca.agregarPrestamo(prestamo);
    }
}
