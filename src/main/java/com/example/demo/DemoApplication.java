package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
    }
}
