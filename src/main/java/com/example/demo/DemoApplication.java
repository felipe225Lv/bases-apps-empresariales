package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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

	// Método para filtrar nombres que comienzan con "A"
    public static void filtrarNombresConA(List<String> nombres) {
        List<String> nombresConA = nombres.stream()
                .filter(nombre -> nombre.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Nombres que comienzan con 'A': " + nombresConA);
    }

    // Método para convertir todos los nombres a mayúsculas
    public static void convertirMayusculas(List<String> nombres) {
        List<String> nombresMayusculas = nombres.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Nombres en mayúsculas: " + nombresMayusculas);
    }

    // Método para contar cuántos nombres tienen más de 5 letras
    public static void contarNombresLargos(List<String> nombres) {
        long cantidadNombresLargos = nombres.stream()
                .filter(nombre -> nombre.length() > 5)
                .count();
        System.out.println("Cantidad de nombres con más de 5 letras: " + cantidadNombresLargos);
    }

    // Método para contar cuántas veces aparece cada palabra en una lista de Strings
    public static void contarPalabrasFrecuencia(List<String> palabras) {
        Map<String, Long> frecuenciaPalabras = palabras.stream()
                .collect(Collectors.groupingBy(palabra -> palabra, Collectors.counting()));
        System.out.println("Frecuencia de palabras: " + frecuenciaPalabras);
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

		 // Lista de nombres
        List<String> nombres = Arrays.asList("Ana", "Pedro", "Andrés", "María", "Alejandro", "Luis", "Alba", "Carlos");

        // Lista de palabras para contar frecuencias
        List<String> palabras = Arrays.asList("Java", "Python", "Java", "C++", "Python", "Java", "C#", "Python");

        while (true) {
            // Mostrar opciones al usuario
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Filtrar los nombres que comienzan con 'A'");
            System.out.println("2. Convertir todos los nombres a mayúsculas");
            System.out.println("3. Contar cuántos nombres tienen más de 5 letras");
            System.out.println("4. Contar cuántas veces aparece cada palabra en una lista de Strings");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();

            // Ejecutar la opción seleccionada
            switch (opcion) {
                case 1:
                    filtrarNombresConA(nombres);
                    break;
                case 2:
                    convertirMayusculas(nombres);
                    break;
                case 3:
                    contarNombresLargos(nombres);
                    break;
                case 4:
                    contarPalabrasFrecuencia(palabras);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return; // Salir del programa
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
    }
    
}
