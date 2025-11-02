public class Alumno {
    private String nombre;
    private int edad;
    private double nota;

    public Alumno(String nombre, int edad, double nota) {
        this.nombre = nombre;
        this.edad = edad;
        this.nota = nota;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public double getNota() { return nota; }

    public void setEdad(int edad) { this.edad = edad; }
    public void setNota(double nota) { this.nota = nota; }

    @Override
    public String toString() {
        return "Alumno{nombre='" + nombre + "', edad=" + edad + ", nota=" + nota + "}";
    }
}
/**
 * -------------------------------------------------------------
 * Unidad: UD6 – Programación Orientada a Objetos en Java
 * Clase: Alumno
 * Descripción:
 *   Define la clase Alumno con atributos para el nombre, edad y nota.
 *   Incluye constructor, getters, setters y un método toString().
 *
 * Autor: Ana Vertedor (Nerine Aoi)
 * Fecha: 23/04/2025
 * -------------------------------------------------------------
 */