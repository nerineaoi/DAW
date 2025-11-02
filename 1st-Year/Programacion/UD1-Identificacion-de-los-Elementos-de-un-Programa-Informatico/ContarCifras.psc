Algoritmo ContarCifras
    // --- UD1: Identificación de los Elementos de un Programa Informático ---
    // Autor: Ana Vertedor (Nerine Aoi)
    // Fecha: 26/10/22024

    // Declaración de variables
    Definir numero Como Entero // Variable para almacenar el número ingresado por el usuario
    Definir respuesta Como Caracter // Variable para almacenar la decisión de continuar o finalizar del usuario
    respuesta <- "s" // Inicializamos "respuesta" con "s" para entrar en el ciclo la primera vez

    // Ciclo principal que se repite mientras el usuario desee continuar
    Mientras respuesta = "s" Hacer
        // Pedir al usuario que ingrese un número dentro del rango permitido
        Escribir "Introduce un número entre 0 y 99,999:"
        Leer numero

        // Validar que el número esté dentro del rango 0-99,999
        Mientras numero < 0 O numero > 99999 Hacer
            Escribir "Número fuera del rango permitido. Inténtalo nuevamente."
            Leer numero // Leer un nuevo valor de número hasta que esté en el rango
        FinMientras

        // Determinación de la cantidad de cifras según el valor de "numero"
        Si numero >= 0 Y numero < 10 Entonces
            Escribir "El número tiene 1 cifra." // Caso para números de 1 cifra (0 a 9)
        Sino
            Si numero >= 10 Y numero < 100 Entonces
                Escribir "El número tiene 2 cifras." // Caso para números de 2 cifras (10 a 99)
            Sino
                Si numero >= 100 Y numero < 1000 Entonces
                    Escribir "El número tiene 3 cifras." // Caso para números de 3 cifras (100 a 999)
                Sino
                    Si numero >= 1000 Y numero < 10000 Entonces
                        Escribir "El número tiene 4 cifras." // Caso para números de 4 cifras (1000 a 9999)
                    Sino
                        Si numero >= 10000 Y numero <= 99999 Entonces
                            Escribir "El número tiene 5 cifras." // Caso para números de 5 cifras (10000 a 99999)
                        FinSi
                    FinSi
                FinSi
            FinSi
        FinSi

        // Solicitar al usuario si desea realizar otra operación o finalizar
        Escribir "¿Quieres continuar? Pulsa s para sí o cualquier otra tecla para finalizar."
        Leer respuesta // Leer la respuesta; si es 's', el ciclo se repetirá, de lo contrario finalizará
    FinMientras

    // Mensaje final al cerrar el programa
    Escribir "Programa finalizado."
FinAlgoritmo
