package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constante.Provincia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Provincia[] provincias = Provincia.values();

        for (Provincia provincia : provincias) {
            System.out.println("Ingrese la población de " + provincia + ":");
            int poblacion = scanner.nextInt();
            provincia.setPoblacion(poblacion);

            System.out.println("Ingrese la superficie de " + provincia + ":");
            int superficie = scanner.nextInt();
            provincia.setSuperficie(superficie);
        }

        System.out.println("Datos ingresados correctamente.");
        System.out.println();

        for (Provincia provincia : provincias) {
            System.out.println("Provincia: " + provincia);
            System.out.println("Población: " + provincia.getPoblacion());
            System.out.println("Superficie: " + provincia.getSuperficie());
            System.out.println("Densidad Poblacional: " + provincia.calcularDensidadPoblacional());
            System.out.println();
        }
        scanner.close();
    }
}
