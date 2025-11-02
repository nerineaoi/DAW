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

public class CalcularIMC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double peso = 0, altura = 0;

        while (true) {
            try {
                System.out.println("Introduce tu peso en kg (entre 30 y 300):");
                peso = scanner.nextDouble();
                if (peso >= 30 && peso <= 300) break;
                System.out.println("Peso inválido. Debe estar entre 30 y 300.");
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, introduce un número.");
                scanner.next(); // Limpiar el buffer
            }
        }

        while (true) {
            try {
                System.out.println("Introduce tu altura en metros (entre 1.30 y 2.00):");
                altura = scanner.nextDouble();
                if (altura >= 1.30 && altura <= 2.00) break;
                System.out.println("Altura inválida. Debe estar entre 1.30 y 2.00.");
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, introduce un número.");
                scanner.next(); // Limpiar el buffer
            }
        }

        double imc = peso / (altura * altura);
        System.out.println("Tu índice de masa corporal es: " + imc);

        if (imc < 18.5) {
            System.out.println("Nivel de peso: Bajo peso");
        } else if (imc < 25.0) {
            System.out.println("Nivel de peso: Normal");
        } else if (imc < 30.0) {
            System.out.println("Nivel de peso: Sobrepeso");
        } else {
            System.out.println("Nivel de peso: Obesidad");
        }

        scanner.close();
    }
}

        scanner.close();
    }
}
