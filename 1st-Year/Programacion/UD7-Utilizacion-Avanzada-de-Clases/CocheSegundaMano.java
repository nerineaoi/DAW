public class CocheSegundaMano extends Coche implements Vendible, Alquilable {
    private int kms;
    public CocheSegundaMano(String marca, String modelo, int anio, double precioBase, int kms) {
        super(marca, modelo, anio, precioBase);
        this.kms = kms;
    }

    @Override
    public String tipo() {
        return "CocheSegundaMano";
    }

    @Override
    public double getPrecioVenta() {
         double desgaste = Math.min(0.5, kms / 100000.0); // máx 50% de bajada
        return getPrecioBase() * (1.0 - desgaste);
    }

    @Override
    public double precioAlquilerDia() {
        // precio base de alquiler muy simple
        return Math.max(25, getPrecioBase() * 0.0005);
    }

        public double getPrecioBase() { return super.getPrecioBase(); } // si añadiste el getter
}
/**
 * -------------------------------------------------------------
 * Unidad: UD7 – Herencia y Polimorfismo en Java
 * Clase: CocheSegundaMano
 * Descripción:
 *   Define la clase CocheSegundaMano que extiende Coche e implementa Vendible y Alquilable.
 *   Incluye cálculo de precio de venta basado en kilómetros y precio de alquiler diario.
 *
 * Autor: Ana Vertedor (Nerine Aoi)
 * Fecha: 17/05/2025
 * -------------------------------------------------------------
 */