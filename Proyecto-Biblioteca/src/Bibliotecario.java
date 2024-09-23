import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bibliotecario extends Persona{
    private double salarioBase;
    private int cantidadPrestamos;
    private LocalDate fechaIngreso;
    private double dineroExtra;

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
        super(nombre, cedula, telefono, correo);
        this.salarioBase = salarioBase;
        this.cantidadPrestamos = 0;
        this.fechaIngreso = LocalDate.of(year, month, day);
        this.dineroExtra = 0;
    }
    /**
     * Metodo para actualizar la cantidad de prestamos que tiene el bibliotecario
     * @param aplicar Cantidad de prestamos que se buscan actualizar al bibliotecario
     */
    public void actualizarPrestamosBibliotecario(int aplicar){
        cantidadPrestamos += aplicar;
    }

    /**
     * Metodo para calcular el salario final del bibliotecario
     * @param fechaActual fecha actual al momento de calcular el salario final
     * @return Salario final del bibliotecario
     */
    public double calcularSalario(LocalDate fechaActual){
        int aniosServicio = (int) ChronoUnit.YEARS.between(fechaIngreso, fechaActual);
        double aumentoPorAntiguedad = (aniosServicio * 0.02)+1;
        double totalDineroExtra = 0;
        if (aumentoPorAntiguedad > 1) {
            totalDineroExtra = dineroExtra * aumentoPorAntiguedad;
        }
        else{
            totalDineroExtra = dineroExtra;
        }        
        double salarioTotal = salarioBase + totalDineroExtra;
        return salarioTotal;
    }

    /**
     * Metodo para aumentar las bonificaciones monetarias del bibliotecario
     * @param totalPagar Bonificacion monetaria a agregar al bibliotecario
     */
    public void aumentarDineroExtra(double totalPagar){
        dineroExtra += totalPagar;
    }

    /**
     * Metodo para obtener el salario base del bibliotecario
     * @return  Salario base del bibliotecario
     */
    public double getSalarioBase() {
        return salarioBase;
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
     * Metodo para obtener el dinero extra del bibliotecario
     * @return Dinero extra del bibliotecario
     */
    public double getDineroExtra() {
        return dineroExtra;
    }

    /**
     * Metodo para modificar el salario del bibliotecario
     * @param salario Nuevo salario del bibliotecario
     */
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
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
     * Metodo para obtener el dinero extra del bibliotecario
     * @param dineroExtra Nuevo monto de dinero extra del bibliotecario
     */
    public void setDineroExtra(double dineroExtra) {
        this.dineroExtra = dineroExtra;
    }

    /**
     * Metodo para obtener la informacion del bibliotecario
     * @return Informacion del bibliotecario
     */
    public String toString(){
        return "Bibliotecario: " + "Nombre=" + super.getNombre() + ", Cedula=" + super.getCedula() + ", Telefono=" + super.getTelefono() + ", Fecha de ingreso=" + fechaIngreso;
    }
}