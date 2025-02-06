package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.pagos.Pagable;
import com.example.demo.pagos.TarjetaCredito;
import com.example.demo.pagos.TransferenciaBancaria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("\n--- Ejemplos empresa ---");

		Empleado emp1 = new Empleado("Juan", 2000000, "Desarrollador");
		Empleado emp2 = new Empleado("Ana", 2500000, "Gerente");
		Empleado emp3 = new Empleado("Luis", 1800000, "Profesor");

		Empresa empresa = new Empresa(Arrays.asList(emp1, emp2, emp3));
		empresa.mostrarEmpleados();
		System.out.println("Salario promedio: $" + empresa.calcularSalarioPromedio());

		System.out.println("\n--- Ejemplos Vehículos ---");
		// Ejemplo con Vehiculo
		List<Vehiculo> vehiculos = Arrays.asList(
				new Carro("Toyota"),
				new Moto("Yamaha"),
				new Carro("Honda")
		);

		for (Vehiculo vehiculo : vehiculos) {
			System.out.print("Vehículo: " + vehiculo.getMarca() + " - ");
			vehiculo.acelerar();
		}

		System.out.println("\n--- Ejemplos Procesamiento de Pagos ---");

		List<Pagable> pagos = Arrays.asList(
				new TarjetaCredito("12345678"),
				new TransferenciaBancaria("00123456789")
		);

		double[] montos = {150.75, 300.50};
		for (int i = 0; i < pagos.size(); i++) {
			pagos.get(i).procesarPago(montos[i]);
		}
	}
}
