/**
 * -------------------------------------------------------------
 * Unidad: UD2 – Lenguaje de Programación Java
 * Ejercicio: Ordenamiento de 3 números
 * Descripción:
 *   Solicita tres números y un tipo de ordenamiento (ascendente o descendente).
 *   Utiliza estructuras condicionales y el método Arrays.sort() para ordenarlos.
 *
 * Autor: Ana Vertedor (Nerine Aoi)
 * Fecha: 27/11/2024
 * -------------------------------------------------------------
 */

import java.util.Arrays;
import java.util.Scanner;

public class OrdenarNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[3];

        System.out.println("Introduce el primer número:");
        numeros[0] = scanner.nextInt();
        System.out.println("Introduce el segundo número:");
        numeros[1] = scanner.nextInt();
        System.out.println("Introduce el tercer número:");
        numeros[2] = scanner.nextInt();

        System.out.println("Introduce el orden (ascendente o descendente):");
        String orden = scanner.next();

        if (orden.equalsIgnoreCase("ascendente")) {
            Arrays.sort(numeros);
        } else if (orden.equalsIgnoreCase("descendente")) {
            Arrays.sort(numeros);
            for (int i = 0; i < numeros.length / 2; i++) {
                int temp = numeros[i];
                numeros[i] = numeros[numeros.length - 1 - i];
                numeros[numeros.length - 1 - i] = temp;
            }
        } else {
            System.out.println("Orden no válido. Inténtalo de nuevo.");
            scanner.close();
            return;
        }

        System.out.println("Números ordenados: " + Arrays.toString(numeros));
        scanner.close();
    }
}
