/**
 * -------------------------------------------------------------
 * Unidad: UD2 – Lenguaje de Programación Java
 * Ejercicio: Mostrar números del 10 al 1
 * Descripción:
 *   Muestra los números del 10 al 1 en orden decreciente usando un bucle for.
 *   Incluye la opción de repetir el programa según la elección del usuario.
 *
 * Autor: Ana Vertedor (Nerine Aoi)
 * Fecha: 27/11/2024
 * -------------------------------------------------------------
 */

public class Multiplos {
    public static void main(String[] args) {
        int contador = 0;

        System.out.println("Números múltiplos de 2 o 3 entre 1 y 100:");
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0 || i % 3 == 0) {
                System.out.println(i);
                contador++;
            }
        }

        System.out.println("Total: " + contador + " números múltiplos de 2 o 3.");
    }
}
