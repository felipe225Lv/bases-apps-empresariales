package com.example.demo.model;

import java.util.List;

public class Empresa {
    private List<Empleado> empleados;

    public Empresa(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public double calcularSalarioPromedio() {
        return empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0);
    }

    public void mostrarEmpleados() {
        System.out.println("Lista de empleados:");
        for (Empleado empleado : empleados) {
            System.out.println("Nombre: " + empleado.getNombre() + ", Cargo: " + empleado.getCargo() + ", Salario: $" + empleado.getSalario());
        }
    }
}
