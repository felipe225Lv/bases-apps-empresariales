package com.example.demo.model;

public class Moto extends Vehiculo {

    public Moto(String marca) {
        super(marca);
    }

    @Override
    public void acelerar() {
        System.out.println("La moto " + marca + " está acelerando rápidamente.");
    }
}
