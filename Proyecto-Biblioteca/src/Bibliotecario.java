public class Bibliotecario {
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;
    private double salario;
    private int cantidadPrestamos;

    /**
     * Metodo constructor de la clase Bibliotecario
     * @param nombre Nombre del bibliotecario a crear
     * @param cedula Cedula del bibliotecario a crear
     * @param telefono Telefono del bibliotecario a crear
     * @param correo Correo del bibliotecario a crear
     * @param salarioBase salarioBase del bibliotecario a crear
     */
    public Bibliotecario(String nombre, String cedula, String telefono, String correo, double salarioBase) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.salario = salarioBase;
        this.cantidadPrestamos = 0;
    }
    
    public String getNombre() {
        return nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public double getSalario() {
        return salario;
    }
    public int getCantidadPrestamos() {
        return cantidadPrestamos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public void setCantidadPrestamos(int cantidadPrestamos) {
        this.cantidadPrestamos = cantidadPrestamos;
    }

    
}
