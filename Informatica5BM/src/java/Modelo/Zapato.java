package Modelo;

public class Zapato {

    private int codigoZapato;
    private String modelo;
    private int talla;
    private String color;
    private double precio;
    private int stock;

    public Zapato() {
    }

    public Zapato(String modelo, int talla, String color, double precio, int stock) {
        this.modelo = modelo;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
    }

    public int getCodigoZapato() {
        return codigoZapato;
    }

    public void setCodigoZapato(int codigoZapato) {
        this.codigoZapato = codigoZapato;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
