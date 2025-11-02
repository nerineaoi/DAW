import java.util.*;

public class GestorAlumnos {

    // Demostración con ambas estructuras
    private static Alumno[] alumnosArray = new Alumno[100];
    private static int usados = 0;

    private static List<Alumno> alumnos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n=== Gestor de Alumnos (UD6) ===");
            System.out.println("1. Añadir (ArrayList)");
            System.out.println("2. Listar (ArrayList)");
            System.out.println("3. Buscar por nombre (ArrayList)");
            System.out.println("4. Eliminar por nombre (ArrayList)");
            System.out.println("5. Añadir (Array)");
            System.out.println("6. Listar (Array)");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            op = leerInt(sc);

            switch (op) {
                case 1 -> addArrayList(sc);
                case 2 -> listArrayList();
                case 3 -> findArrayList(sc);
                case 4 -> removeArrayList(sc);
                case 5 -> addArray(sc);
                case 6 -> listArray();
                case 0 -> System.out.println("Bye!");
                default -> System.out.println("Opción no válida.");
            }
        } while (op != 0);

        sc.close();
    }

    // ---- ArrayList ----
    private static void addArrayList(Scanner sc) {
        System.out.print("Nombre: "); String n = sc.nextLine().trim();
        System.out.print("Edad: ");   int e = leerInt(sc);
        System.out.print("Nota: ");   double no = leerDouble(sc);
        alumnos.add(new Alumno(n, e, no));
        System.out.println("Añadido.");
    }

    private static void listArrayList() {
        if (alumnos.isEmpty()) { System.out.println("Sin alumnos."); return; }
        alumnos.forEach(System.out::println);
        // Estadística simple
        double media = alumnos.stream().mapToDouble(Alumno::getNota).average().orElse(0.0);
        System.out.println("Media de notas: " + String.format("%.2f", media));
    }

    private static void findArrayList(Scanner sc) {
        System.out.print("Nombre a buscar: ");
        String q = sc.nextLine().trim().toLowerCase();
        alumnos.stream()
               .filter(a -> a.getNombre().toLowerCase().contains(q))
               .forEach(System.out::println);
    }

    private static void removeArrayList(Scanner sc) {
        System.out.print("Nombre exacto a eliminar: ");
        String q = sc.nextLine().trim();
        boolean removed = alumnos.removeIf(a -> a.getNombre().equalsIgnoreCase(q));
        System.out.println(removed ? "Eliminado." : "No encontrado.");
    }

    // ---- Array clásico ----
    private static void addArray(Scanner sc) {
        if (usados >= alumnosArray.length) { System.out.println("Array lleno."); return; }
        System.out.print("Nombre: "); String n = sc.nextLine().trim();
        System.out.print("Edad: ");   int e = leerInt(sc);
        System.out.print("Nota: ");   double no = leerDouble(sc);
        alumnosArray[usados++] = new Alumno(n, e, no);
        System.out.println("Añadido en array.");
    }

    private static void listArray() {
        if (usados == 0) { System.out.println("Array vacío."); return; }
        for (int i = 0; i < usados; i++) System.out.println(alumnosArray[i]);
    }

    // ---- helpers ----
    private static int leerInt(Scanner sc) {
        while (true) {
            try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (Exception e) { System.out.print("Número inválido. Intenta otra vez: "); }
        }
    }
    private static double leerDouble(Scanner sc) {
        while (true) {
            try { return Double.parseDouble(sc.nextLine().trim()); }
            catch (Exception e) { System.out.print("Número inválido. Intenta otra vez: "); }
        }
    }
}
/**
 * -------------------------------------------------------------
 * Unidad: UD6 – Programación Orientada a Objetos en Java
 * Clase: GestorAlumnos
 * Descripción:
 *   Programa para gestionar alumnos usando ArrayList y Array clásico.
 *   Permite añadir, listar, buscar y eliminar alumnos.
 *
 * Autor: Ana Vertedor (Nerine Aoi)
 * Fecha: 23/04/2025
 * -------------------------------------------------------------
 */