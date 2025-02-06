package com.example.demo.pagos;

public class TransferenciaBancaria implements Pagable {
    private String cuentaBancaria;

    public TransferenciaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    @Override
    public void procesarPago(double cantidad) {
        System.out.println("Transfiriendo $" + cantidad + " desde la cuenta: " + cuentaBancaria);
    }
}
