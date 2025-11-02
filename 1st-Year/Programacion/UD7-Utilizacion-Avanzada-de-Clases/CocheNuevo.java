public class CocheNuevo extends Coche implements Vendible {
    private double impuesto = 0.21; // IVA

    public CocheNuevo(String marca, String modelo, int anio, double base) {
        super(marca, modelo, anio, base);
    }

    @Override public String tipo() { return "Nuevo"; }

    @Override
    public double getPrecioVenta() {
        return getPrecioBase() * * 1.21; // precio base + IVA
    }

    // Exponer precio base protegido via método
    private double getPrecioBase() { 
        // no hay protected getter en super; recreamos con reflexión de diseño:
        // si prefieres, cambia el campo en Coche a protected o añade getter público.
        try {
            var f = Coche.class.getDeclaredField("precioBase");
            f.setAccessible(true);
            return f.getDouble(this);
        } catch (Exception e) { return 0; }
    }
}
