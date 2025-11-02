package ud3caso1app;

public class Principal {
    public static void main(String[] args) {
        // Crear instancia de Empleado
        Empleado empleado = new Empleado("Juan", 30, 2000.0, "Calle Falsa 123", "123456789", 1, "Mañana");
        empleado.mostrarInfo();

        // Crear instancia de Administrativo
        Administrativo admin = new Administrativo("Laura", 28, 1800.0, "Calle Real 456", "987654321", 2, "Tarde", "Recursos Humanos");
        admin.mostrarInfo();

        // Crear instancia de Contable
        Contable contable = new Contable("Carlos", 35, 2200.0, "Avenida Central 789", "654321987", 3, "Noche", "Impuestos");
        contable.mostrarInfo();

        // Crear instancia de Informático
        Informatico informatico = new Informatico("Ana", 25, 2500.0, "Calle Nueva 321", "456789123", 4, "Mañana", "Java");
        informatico.mostrarInfo();
        informatico.desarrollarSoftware();
    }
}
