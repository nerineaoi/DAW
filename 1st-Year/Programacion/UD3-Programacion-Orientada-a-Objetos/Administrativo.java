package ud3caso1app;

public class Administrativo extends Empleado {
    private String seccion;

    public Administrativo() {
    }

    public Administrativo(String nombre, int edad, double salario, String direccion, String telefono, int numeroEmpleado, String turno, String seccion) {
        super(nombre, edad, salario, direccion, telefono, numeroEmpleado, turno);
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
}
