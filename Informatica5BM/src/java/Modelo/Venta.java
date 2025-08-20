package Modelo;

public class Venta {
    private int codigoVenta;
    private int codigoZapato;

  
    public Venta() {
    }

    public Venta(int codigoZapato) {
        this.codigoZapato = codigoZapato;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public int getCodigoZapato() {
        return codigoZapato;
    }

    public void setCodigoZapato(int codigoZapato) {
        this.codigoZapato = codigoZapato;
    }
}
