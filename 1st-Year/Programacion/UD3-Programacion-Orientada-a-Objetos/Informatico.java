package ud3caso1app;

public class Informatico extends Empleado {
    private String lenguajeProgramacion;

    public Informatico() {
    }

    public Informatico(String nombre, int edad, double salario, String direccion, String telefono, int numeroEmpleado, String turno, String lenguajeProgramacion) {
        super(nombre, edad, salario, direccion, telefono, numeroEmpleado, turno);
        this.lenguajeProgramacion = lenguajeProgramacion;
    }

    public String getLenguajeProgramacion() {
        return lenguajeProgramacion;
    }

    public void setLenguajeProgramacion(String lenguajeProgramacion) {
        this.lenguajeProgramacion = lenguajeProgramacion;
    }

    public void desarrollarSoftware() {
        System.out.println(getNombre() + " está desarrollando software en " + lenguajeProgramacion);
    }
}
