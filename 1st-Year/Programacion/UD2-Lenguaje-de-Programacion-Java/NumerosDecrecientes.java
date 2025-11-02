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

import java.util.Scanner;

public class NumerosDecrecientes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;

        do {
            for (int numero = 10; numero >= 1; numero--) {
                System.out.println(numero);
            }

            System.out.println("¿Quieres repetir el programa? (sí/no):");
            respuesta = scanner.next();
        } while (respuesta.equalsIgnoreCase("sí"));

        scanner.close();
        System.out.println("Programa finalizado.");
    }
}
