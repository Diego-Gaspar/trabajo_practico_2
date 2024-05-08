package ar.edu.unju.fi.ejercicio5.main;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> productos = precargarProductos();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Mostrar productos");
            System.out.println("2 - Realizar compra");
            System.out.println("3 - Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
                switch (opcion) {
                    case 1:
                        mostrarProductos(productos);
                        break;
                    case 2:
                        realizarCompra(productos, scanner);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        return;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.nextLine(); 
                opcion = 0; 
            }
        } while (opcion != 3);
    }

 private static ArrayList<Producto> precargarProductos() {
     ArrayList<Producto> productos = new ArrayList<>();

     productos.add(new Producto("Producto1", 10.5, true));
     productos.add(new Producto("Producto2", 20.3, true));
     productos.add(new Producto("Producto3", 15.0, false));
     productos.add(new Producto("Producto4", 8.75, true));
     productos.add(new Producto("Producto5", 12.0, true));
     productos.add(new Producto("Producto6", 30.25, false));
     productos.add(new Producto("Producto7", 25.8, true));
     productos.add(new Producto("Producto8", 17.99, false));
     productos.add(new Producto("Producto9", 22.5, true));
     productos.add(new Producto("Producto10", 19.0, true));
     productos.add(new Producto("Producto11", 14.75, true));
     productos.add(new Producto("Producto12", 9.99, false));
     productos.add(new Producto("Producto13", 28.45, true));
     productos.add(new Producto("Producto14", 35.0, true));
     productos.add(new Producto("Producto15", 42.75, false));

     return productos;
 }

    
    private static void mostrarProductos(ArrayList<Producto> productos) {
        System.out.println("Productos disponibles:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.println((i + 1) + ". Nombre: " + producto.getNombre() + ", Precio: $" + producto.getPrecio() + ", Estado: " + (producto.isEstado() ? "Disponible" : "Sin stock"));
        }
    }


    private static void realizarCompra(ArrayList<Producto> productos, Scanner scanner) {
        ArrayList<Producto> productosSeleccionados = new ArrayList<>();
        double totalCompra = 0.0;

        System.out.println("Productos disponibles:");
        mostrarProductos(productos);

        System.out.print("Ingrese el número de producto que desea comprar (0 para terminar): ");
        int numeroProducto;
        do {
            try {
                numeroProducto = scanner.nextInt();
                scanner.nextLine(); 
                if (numeroProducto < 0 || numeroProducto > productos.size()) {
                    System.out.println("Número de producto inválido. Por favor, ingrese un número válido.");
                    continue;
                }
                if (numeroProducto == 0) {
                    break; 
                }
                Producto productoSeleccionado = productos.get(numeroProducto - 1);
                if (productoSeleccionado.isEstado()) {
                    productosSeleccionados.add(productoSeleccionado);
                    totalCompra += productoSeleccionado.getPrecio();
                } else {
                    System.out.println("El producto seleccionado no está disponible.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.nextLine(); 
            }
        } while (true);

        
        System.out.println("Resumen de la compra:");
        for (Producto producto : productosSeleccionados) {
            System.out.println(producto.getNombre() + " - $" + producto.getPrecio());
        }
        System.out.println("Total a pagar: $" + totalCompra);

       
        System.out.println("Seleccione el método de pago:");
        System.out.println("1 - Pago en efectivo");
        System.out.println("2 - Pago con tarjeta");
        System.out.print("Ingrese el número correspondiente al método de pago: ");
        int metodoPago;
        do {
            try {
                metodoPago = scanner.nextInt();
                scanner.nextLine(); 
                if (metodoPago < 1 || metodoPago > 2) {
                    System.out.println("Opción de pago inválida. Por favor, ingrese 1 o 2.");
                    continue;
                }
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.nextLine(); 
            }
        } while (true);

        if (metodoPago == 1) {
            
            PagoEfectivo pagoEfectivo = new PagoEfectivo(totalCompra, LocalDate.now());
            pagoEfectivo.realizarPago(totalCompra);
            pagoEfectivo.imprimirRecibo();
        } else {
            System.out.print("Ingrese el número de tarjeta: ");
            String numeroTarjeta = scanner.nextLine();
            System.out.print("Ingrese la fecha de pago (en formato dd/mm/aa): ");
            String fechaPagoStr = scanner.nextLine();
            LocalDate fechaPago = LocalDate.parse(fechaPagoStr, DateTimeFormatter.ofPattern("dd/MM/yy"));
            PagoTarjeta pagoTarjeta = new PagoTarjeta(numeroTarjeta, fechaPago, totalCompra);
            pagoTarjeta.realizarPago(totalCompra);
            pagoTarjeta.imprimirRecibo();
        }
}
}

