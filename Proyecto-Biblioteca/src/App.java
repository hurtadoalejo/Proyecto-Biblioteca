public class App {
    public static void main(String[] args) throws Exception {
        Bibliotecario bibliotecario = new Bibliotecario("Alejo", "100", "750254", "alejo@gmail.com", 1200000);
        Prestamo prestamo = new Prestamo("25", bibliotecario);
        Biblioteca biblioteca = new Biblioteca("Gaspar");
        biblioteca.agregarPrestamo(prestamo);
    }
}
