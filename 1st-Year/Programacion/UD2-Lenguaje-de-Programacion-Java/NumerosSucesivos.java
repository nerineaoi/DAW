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

public class NumerosSucesivos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        while (true) {
            System.out.println("Introduce un número positivo:");
            numero = scanner.nextInt();
            if (numero > 0) break;
            System.out.println("Número inválido. Debe ser positivo.");
        }

        System.out.println("Los primeros 20 números sucesivos son:");
        for (int i = numero + 1; i <= numero + 20; i++) {
            System.out.println(i);
        }

        scanner.close();
    }
}


            System.out.println(i);
        }

        scanner.close();
    }
}
