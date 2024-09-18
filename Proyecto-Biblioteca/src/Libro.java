import java.time.LocalDate;

public class Libro {
    private String codigo;
    private String isbn;
    private String autor;
    private String titulo;
    private String editorial;
    private LocalDate fecha;
    private int unidadesDisponibles;

    public Libro(String codigo, String isbn, String autor, String titulo, String editorial, int anio, int mes, int dia,
        int unidadesDisponibles) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fecha = LocalDate.of(anio, mes, dia);
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getCodigo() {
        return codigo;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getAutor() {
        return autor;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getEditorial() {
        return editorial;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    
}
