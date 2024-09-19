import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bibliotecario {
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;
    private double salario;
    private int cantidadPrestamos;
    private LocalDate fechaIngreso;

    /**
     * Metodo constructor de la clase Bibliotecario
     * @param nombre Nombre del bibliotecario a crear
     * @param cedula Cedula del bibliotecario a crear
     * @param telefono Telefono del bibliotecario a crear
     * @param correo Correo del bibliotecario a crear
     * @param salarioBase salarioBase del bibliotecario a crear
     * @param year Año de la fecha de ingreso del bibliotecario a crear
     * @param month Mes de la fecha de ingreso del bibliotecario a crear
     * @param day Dia de la fecha de ingreso del bibliotecario a crear
     */
    public Bibliotecario(String nombre, String cedula, String telefono, String correo, double salarioBase, int year, int month, int day) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.salario = salarioBase;
        this.cantidadPrestamos = 0;
        this.fechaIngreso = LocalDate.of(year, month, day);
    }

    public void calcularSalario(LocalDate fechaActual){
        int aniosServicio = (int) ChronoUnit.YEARS.between(fechaIngreso, fechaActual);
        int salarioTotal 

    }

    /**
     * Metodo para obtener el nombre del bibliotecario
     * @return Nombre del bibliotecario
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo para obtener la cedula del bibliotecario
     * @return Cedula del bibliotecario
     */
    public String getCedula() {
        return cedula;
    }
    /**
     * Metodo para obtener el telefono del bibliotecario
     * @return Telefono del bibliotecario
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * Metodo para obtener el correo del bibliotecario
     * @return Correo del bibliotecario
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * Metodo para obtener el salario del bibliotecario
     * @return Salario del bibliotecario
     */
    public double getSalario() {
        return salario;
    }
    /**
     * Metodo para obtener el correo del bibliotecario
     * @return Cantidad de prestamos del bibliotecario
     */
    public int getCantidadPrestamos() {
        return cantidadPrestamos;
    }
    /**
     * Metodo para obtener la fecha de ingreso del bibliotecario
     * @return Fecha de ingreso del bibliotecario
     */
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Metodo para modificar el nombre del bibliotecario
     * @param nombre Nuevo nombre del bibliotecario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo para modificar la cedula del bibliotecario
     * @param cedula Nueva cedula del bibliotecario
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    /**
     * Metodo para modificar el teleffono del bibliotecario
     * @param telefono Nuevo telefono del bibliotecario
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * Metodo para modificar el correo del bibliotecario
     * @param correo Nuevo correo del bibliotecario
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * Metodo para modificar el salario del bibliotecario
     * @param salario Nuevo salario del bibliotecario
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }
    /**
     * Metodo para modificar la cantidad de prestamos del bibliotecario
     * @param cantidadPrestamos Nueva cantidad de prestamos del bibliotecario
     */
    public void setCantidadPrestamos(int cantidadPrestamos) {
        this.cantidadPrestamos = cantidadPrestamos;
    }
    /**
     * Metodo para modificar la fecha de ingreso del bibliotecario
     * @param fechaIngreso Nueva fecha de ingreso del bibliotecario
     */
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Metodo para obtener la informacion del bibliotecario
     * @return Informacion del bibliotecario
     */
    public String toString() {
        return "Bibliotecario [nombre=" + nombre + ", cedula=" + cedula + "]";
    } 
}