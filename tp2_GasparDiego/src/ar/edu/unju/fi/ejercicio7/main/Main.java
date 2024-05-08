package ar.edu.unju.fi.ejercicio7.main;

import ar.edu.unju.fi.ejercicio7.model.Producto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
    	
        ArrayList<Producto> productos = precargarProductos();

        boolean salir = false;
        while (!salir) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1 - Mostrar productos disponibles");
            System.out.println("2 - Mostrar productos faltantes");
            System.out.println("3 - Incrementar precios de los productos");
            System.out.println("4 - Mostrar productos de la categoría Electrohogar disponibles");
            System.out.println("5 - Ordenar productos por precio de forma descendente");
            System.out.println("6 - Mostrar nombres de productos en mayúsculas");
            System.out.println("7 - Salir");
            System.out.print("Seleccione una opción: ");

            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                	System.out.println("Productos disponibles:");
                    mostrarProductosDisponibles(productos);
                    break;
                case 2:
                	System.out.println("Productos faltantes:");
                    mostrarProductosFaltantes(productos);
                    break;
                case 3:
                	List<Producto> productosIncrementados = incrementarPrecios(productos);
                    System.out.println("Precios de los productos incrementados en un 20%:");
                    mostrarProductos(productosIncrementados, p -> true, p -> System.out.println(p));
                    break;
                case 4:
                	System.out.println("Productos de la categoría Electrohogar disponibles:");
                    mostrarProductosElectrohogarDisponibles(productos);
                    break;
                case 5:
                	ordenarProductosPorPrecioDescendente(productos);
                    System.out.println("Productos ordenados por precio de forma descendente:");
                    mostrarProductos(productos, p -> true, p -> System.out.println(p));
                    break;
                case 6:
                	System.out.println("Nombres de productos en mayúsculas:");
                    mostrarNombresEnMayusculas(productos);
                    break;
                case 7:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } 
    }

   
    private static ArrayList<Producto> precargarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Cepillo", 20, false, "Limpieza"));
        productos.add(new Producto("Repelente", 70, false, "Limpieza"));
        productos.add(new Producto("Lavadora", 500, true, "Electrohogar"));
        productos.add(new Producto("Trapo", 50, false, "Limpieza"));
        productos.add(new Producto("Dentrifico", 40, true, "Limpieza"));
        productos.add(new Producto("Shampoo", 80, true, "Limpieza"));
        productos.add(new Producto("Televisor", 700, true, "Electrohogar"));
        productos.add(new Producto("Computadora", 1000, false, "Electrohogar"));
        productos.add(new Producto("Esponja", 30, false, "Limpieza"));
        productos.add(new Producto("AXE", 60, false, "Limpieza"));
        productos.add(new Producto("AYUDIN", 70, true, "Limpieza"));
        productos.add(new Producto("Microondas", 300, true, "Electrohogar"));
        productos.add(new Producto("REXONA", 60, true, "Limpieza"));
        productos.add(new Producto("Jabon", 30, false, "Limpieza"));
        productos.add(new Producto("Aspiradora", 400, false, "Electrohogar"));
        return productos;
    }
    
    private static void mostrarProductos(List<Producto> productos, Predicate<Producto> criterio, Consumer<Producto> accion) {
        productos.stream()
                .filter(criterio)
                .forEach(accion);
    }

    
    private static void mostrarProductosDisponibles(List<Producto> productos) {
        Consumer<Producto> consumer = p -> System.out.println(p);
        productos.stream()
                .filter(Producto::isEstado) 
                .forEach(consumer); 
    }
    
    private static void mostrarProductosFaltantes(List<Producto> productos) {
        Predicate<Producto> faltantesPredicate = p -> !p.isEstado();
        productos.stream()
                .filter(faltantesPredicate) 
                .forEach(System.out::println); 
    }

    private static List<Producto> incrementarPrecios(List<Producto> productos) {
        Function<Producto, Producto> incrementarPrecioFunction = p -> {
            double nuevoPrecio = p.getPrecio() * 1.20; 
            return new Producto(p.getNombre(), nuevoPrecio, p.isEstado(), p.getCategoria());
        };

        List<Producto> productosIncrementados = productos.stream()
                .map(incrementarPrecioFunction) 
                .collect(Collectors.toList()); 

        return productosIncrementados; 
    }
    
    private static void mostrarProductosElectrohogarDisponibles(List<Producto> productos) {
        Predicate<Producto> electrohogarPredicate = p -> p.getCategoria().equals("Electrohogar") && p.isEstado(); 
        productos.stream()
                .filter(electrohogarPredicate) 
                .forEach(System.out::println); 
    }

    private static void ordenarProductosPorPrecioDescendente(List<Producto> productos) {
        Comparator<Producto> comparadorPorPrecioDescendente = Comparator.comparing(Producto::getPrecio).reversed();
        productos.sort(comparadorPorPrecioDescendente); 
    }
    
    private static void mostrarNombresEnMayusculas(List<Producto> productos) {
        productos.stream()
                .map(p -> p.getNombre().toUpperCase()) 
                .forEach(System.out::println); 
    }

}
