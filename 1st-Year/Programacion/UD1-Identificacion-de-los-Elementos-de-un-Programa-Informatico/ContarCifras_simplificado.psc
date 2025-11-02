// --- UD1: Identificación de los Elementos de un Programa Informático ---
// Autor: Ana Vertedor (Nerine Aoi)
// Fecha: 26/10/22024

Algoritmo ContarCifras
    // Declaración de variables
    Definir numero Como Entero
    Definir continuar Como Caracter
    
    // Inicio del bucle principal
    Repetir
        Escribir "Introduce un número entre 0 y 99,999: "
        Leer numero
        
        // Validación del rango del número
        Mientras numero < 0 O numero > 99999 Hacer
            Escribir "El número no está en el rango correcto. Inténtalo de nuevo."
            Escribir "Introduce un número entre 0 y 99,999: "
            Leer numero
        FinMientras
        
        // Determinar el número de cifras
        Si numero < 10 Entonces
            Escribir "El número tiene 1 cifra."
        Sino
            Si numero < 100 Entonces
                Escribir "El número tiene 2 cifras."
            Sino
                Si numero < 1000 Entonces
                    Escribir "El número tiene 3 cifras."
                Sino
                    Si numero < 10000 Entonces
                        Escribir "El número tiene 4 cifras."
                    Sino
                        Escribir "El número tiene 5 cifras."
                    FinSi
                FinSi
            FinSi
        FinSi
        
        // Preguntar si desea continuar
        Escribir "¿Quieres continuar? Pulsa 's' para continuar o cualquier otra tecla para finalizar."
        Leer continuar
    Hasta Que continuar <> "s"
FinAlgoritmo

