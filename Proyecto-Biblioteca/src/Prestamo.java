public class Prestamo {
    private String codigo;
    private Bibliotecario bibliotecario;

    public Prestamo(String codigo, Bibliotecario bibliotecario) {
        this.codigo = codigo;
        this.bibliotecario = bibliotecario;
    }
    
    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }
    public String getCodigo() {
        return codigo;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
