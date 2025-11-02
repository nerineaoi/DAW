import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class Uno {
    public static void main(String[] args) {
        String directorio = "C:/EjerciciosStreams";
        String rutaArchivo = directorio + "/uno.java";
        
        File dir = new File(directorio);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        System.out.println("------------------");
        System.out.println("Generando uno.java con números del 0 al 10...");
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, StandardCharsets.UTF_8))) {
            for (int i = 0; i <= 10; i++) {
                bw.write(i + "\n");
            }
            System.out.println("✅ Archivo creado: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("❌ Error al escribir en el archivo: " + e.getMessage());
        }
        
        mostrarContenidoArchivo(rutaArchivo);
    }
    
    private static void mostrarContenidoArchivo(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta, StandardCharsets.UTF_8))) {
            System.out.println("📄 Contenido de " + ruta + ":");
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            System.out.println("------------------");
        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo: " + e.getMessage());
        }
    }
}

class Dos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String directorio = "C:/EjerciciosStreams";
        String rutaArchivo = directorio + "/dos.java";
        
        File dir = new File(directorio);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        System.out.println("------------------");
        System.out.println("📐 Calculando el área de un triángulo...");
        
        double base = obtenerNumero(scanner, "✏️ Escribe aquí la base del triángulo: ");
        double altura = obtenerNumero(scanner, "✏️ Escribe aquí la altura del triángulo: ");
        double area = (base * altura) / 2;
        
        System.out.println("✅ Área calculada: " + area);
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, StandardCharsets.UTF_8))) {
            bw.write("Base: " + base + "\n");
            bw.write("Altura: " + altura + "\n");
            bw.write("Área del triángulo: " + area + "\n");
            System.out.println("✅ Área guardada en " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("❌ Error al escribir en el archivo: " + e.getMessage());
        }
        
        scanner.close();
        System.out.println("------------------");
    }
    
    private static double obtenerNumero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.println("⚠️ Entrada no válida. Introduzca un número válido.");
            scanner.next(); // Descartar entrada inválida
            System.out.print(mensaje);
        }
        return scanner.nextDouble();
    }
}

class Tres {
    public static void main(String[] args) {
        String directorio = "C:/EjerciciosStreams";
        String rutaArchivo = directorio + "/datos.txt";
        
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            System.out.println("📄 Creando archivo datos.txt con datos de ejemplo...");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, StandardCharsets.UTF_8))) {
                bw.write("Nombre: María López Teléfono: 955215263\n");
                bw.write("Nombre: Juan Pérez Teléfono: 954332211\n");
                System.out.println("✅ Archivo datos.txt creado correctamente.");
            } catch (IOException e) {
                System.out.println("❌ Error al crear datos.txt: " + e.getMessage());
            }
        }
        
        System.out.println("📄 Leyendo contenido de datos.txt...");
        try (BufferedReader br = new BufferedReader(new FileReader(archivo, StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            System.out.println("------------------");
        } catch (IOException e) {
            System.out.println("❌ Error al leer datos.txt: " + e.getMessage());
        }
    }
}

class Cuatro {
    public static void main(String[] args) {
        String directorio = "C:/EjerciciosStreams";
        String rutaEntrada = directorio + "/datos.txt";
        String rutaSalida = directorio + "/DatosAleatorios";
        
        File dir = new File(directorio);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        File archivoEntrada = new File(rutaEntrada);
        if (!archivoEntrada.exists()) {
            System.out.println("❌ Error: datos.txt no existe. Ejecuta Tres para crearlo primero.");
            return;
        }
        
        System.out.println("------------------");
        System.out.println("📄 Generando archivo de acceso aleatorio...");
        
        try (BufferedReader brEntrada = new BufferedReader(new FileReader(rutaEntrada, StandardCharsets.UTF_8));
             BufferedWriter bw = new BufferedWriter(new FileWriter(rutaSalida, StandardCharsets.UTF_8))) {
            
            String linea;
            while ((linea = brEntrada.readLine()) != null) {
                bw.write(linea + "\n");
            }
            
            System.out.println("✅ Archivo de acceso aleatorio generado en " + rutaSalida);
        } catch (IOException e) {
            System.out.println("❌ Error al generar el archivo aleatorio: " + e.getMessage());
        }
        
        System.out.println("📄 Leyendo DatosAleatorios...");
        try (BufferedReader brSalida = new BufferedReader(new FileReader(rutaSalida, StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = brSalida.readLine()) != null) {
                System.out.println(linea);
            }
            System.out.println("------------------");
        } catch (IOException e) {
            System.out.println("❌ Error al leer DatosAleatorios: " + e.getMessage());
        }
    }
}

