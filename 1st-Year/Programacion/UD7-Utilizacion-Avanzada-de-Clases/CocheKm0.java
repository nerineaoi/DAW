public class CocheKm0 extends Coche implements Vendible {
    private static final double DESCUENTO = 0.08; // 8%

    public CocheKm0(String marca, String modelo, int anio, double precioBase) {
        super(marca, modelo, anio, precioBase);
    }

    @Override
    public String tipo() {
        return "Coche Km0";
    }

    @Override
    public double getPrecioVenta() {
        return getPrecioBase() * (1 - DESCUENTO);
    }

    @Override
    public String toString() {
        return super.toString() + " (descuento " + (DESCUENTO * 100) + "%)";
    }
}
