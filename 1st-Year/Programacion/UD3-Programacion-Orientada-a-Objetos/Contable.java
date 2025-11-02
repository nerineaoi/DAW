package ud3caso1app;

public class Contable extends Empleado {
    private String areaFinanciera;

    public Contable() {
    }

    public Contable(String nombre, int edad, double salario, String direccion, String telefono, int numeroEmpleado, String turno, String areaFinanciera) {
        super(nombre, edad, salario, direccion, telefono, numeroEmpleado, turno);
        this.areaFinanciera = areaFinanciera;
    }

    public String getAreaFinanciera() {
        return areaFinanciera;
    }

    public void setAreaFinanciera(String areaFinanciera) {
        this.areaFinanciera = areaFinanciera;
    }
}
