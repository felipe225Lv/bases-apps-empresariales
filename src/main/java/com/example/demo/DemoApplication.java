package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.pagos.Pagable;
import com.example.demo.pagos.TarjetaCredito;
import com.example.demo.pagos.TransferenciaBancaria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n--- Ejemplo 1 ---");


    // Comprobar si un número es primo
    System.out.print("Ingrese un número para verificar si es primo: ");
    int numero = scanner.nextInt();
    System.out.println("¿El número " + numero + " es primo? " + esPrimo(numero));

    // Encontrar el número más grande y el más pequeño en una lista
    System.out.print("\nIngrese la cantidad de números en la lista: ");
    int cantidad = scanner.nextInt();
    List<Integer> numeros = new ArrayList<>();

    System.out.println("Ingrese los números:");
    for (int i = 0; i < cantidad; i++) {
        numeros.add(scanner.nextInt());
    }

    int[] resultado = minMax(numeros);
    System.out.println("Mínimo: " + resultado[0] + ", Máximo: " + resultado[1]);

    // Verificar si una palabra es un palíndromo
    System.out.print("\nIngrese una palabra para verificar si es un palíndromo: ");
    scanner.nextLine(); // Consumir el salto de línea pendiente
    String palabra = scanner.nextLine();
    System.out.println("¿La palabra '" + palabra + "' es un palíndromo? " + esPalindromo(palabra));

    scanner.close();
    
    
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
 // Función para verificar si un número es primo
    public static boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Función para encontrar el número más grande y el más pequeño en una lista
    public static int[] minMax(List<Integer> lista) {
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("La lista no puede estar vacía.");
        }
        int min = lista.get(0);
        int max = lista.get(0);

        for (int num : lista) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        return new int[]{min, max};
    }

    // Función para verificar si una palabra es un palíndromo
    public static boolean esPalindromo(String palabra) {
        palabra = palabra.toLowerCase().replaceAll("\\s+", "");
        int izquierda = 0, derecha = palabra.length() - 1;

        while (izquierda < derecha) {
            if (palabra.charAt(izquierda) != palabra.charAt(derecha)) {
                return false;
            }
            izquierda++;
            derecha--;
        }
        return true;
    }


}
