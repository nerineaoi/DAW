public abstract class Coche {
    private String marca;
    private String modelo;
    private int anio;
    private double precioBase;

    public Coche(String marca, String modelo, int anio, double precioBase) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precioBase = precioBase;
    }

    public String getMarca()  { return marca; }
    public String getModelo() { return modelo; }
    public int getAnio()      { return anio; }
    public double getPrecioBase() { return precioBase; }

}


    public abstract String tipo();

    @Override
    public String toString() {
        return tipo() + " { " + marca + " " + modelo + " (" + anio + "), base=" + precioBase + " }";
    }
}
