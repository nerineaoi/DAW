import java.util.*;

public class Concesionario {
    private final List<Coche> stock = new ArrayList<>();

    public void add(Coche c) { stock.add(c); }
    public void list() { stock.forEach(System.out::println); }

    public void listarVendibles() {
        stock.stream().filter(c -> c instanceof Vendible)
             .forEach(c -> System.out.println(c + " -> venta: " + ((Vendible) c).getPrecioVenta()));
    }

    public void listarAlquilables() {
        stock.stream().filter(c -> c instanceof Alquilable)
             .forEach(c -> System.out.println(c + " -> alquiler/día: " + ((Alquilable) c).precioAlquilerDia()));
    }

    public static void main(String[] args) {
        Concesionario cc = new Concesionario();
        // Demo de inventario
        cc.add(new CocheNuevo("Toyota", "Corolla", 2025, 21000));
        cc.add(new CocheKm0("Seat", "Leon", 2024, 19500));
        cc.add(new CocheSegundaMano("BMW", "118d", 2018, 26000, 90000));

        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n=== Concesionario (UD7) ===");
            System.out.println("1. Listar todo");
            System.out.println("2. Listar vendibles (precio venta)");
            System.out.println("3. Listar alquilables (precio día)");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            op = leerInt(sc);

            switch (op) {
                case 1 -> cc.list();
                case 2 -> cc.listarVendibles();
                case 3 -> cc.listarAlquilables();
                case 0 -> System.out.println("Bye!");
                default -> System.out.println("Opción no válida.");
            }
        } while (op != 0);
        sc.close();
    }

    private static int leerInt(Scanner sc) {
        while (true) {
            try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (Exception e) { System.out.print("Número inválido. Intenta otra vez: "); }
        }
    }
}
