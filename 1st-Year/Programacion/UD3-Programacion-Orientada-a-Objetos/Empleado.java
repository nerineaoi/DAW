package ud3caso1app;

public class Empleado {
    private String nombre;
    private int edad;
    protected double salario;
    protected String direccion;
    protected String telefono;
    private int numeroEmpleado;
    private String turno;

    public Empleado() {
    }

    public Empleado(String nombre, int edad, double salario, String direccion, String telefono, int numeroEmpleado, String turno) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.direccion = direccion;
        this.telefono = telefono;
        this.numeroEmpleado = numeroEmpleado;
        this.turno = turno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre + ", Edad: " + edad + ", Salario: " + salario +
                ", Dirección: " + direccion + ", Teléfono: " + telefono +
                ", Número Empleado: " + numeroEmpleado + ", Turno: " + turno);
    }
}
