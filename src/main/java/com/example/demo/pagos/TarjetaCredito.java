package com.example.demo.pagos;

public class TarjetaCredito implements Pagable {
    private String numeroTarjeta;

    public TarjetaCredito(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public void procesarPago(double cantidad) {
        System.out.println("Pagando $" + cantidad + " con la tarjeta: " + numeroTarjeta);
    }
}
