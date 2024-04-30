package ar.edu.unju.fi.ejercicio1.main;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> productos = new ArrayList<>();

        int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 – Crear Producto");
            System.out.println("2 – Mostrar productos");
            System.out.println("3 – Modificar producto");
            System.out.println("4 – Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcion) {
                case 1:
                    productos.add(crearProducto(scanner));
                    break;
                case 2:
                    mostrarProductos(productos);
                    break;
                case 3:
                    modificarProducto(scanner, productos);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static Producto crearProducto(Scanner scanner) {
        System.out.println("Ingrese el código del producto:");
        String codigo = scanner.nextLine();

        System.out.println("Ingrese la descripción del producto:");
        String descripcion = scanner.nextLine();

        System.out.println("Ingrese el precio unitario del producto:");
        double precioUnitario = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Elija el origen de fabricación:");
        mostrarOpciones(OrigenFabricacion.values());
        int opcionOrigen = scanner.nextInt();
        OrigenFabricacion origen = OrigenFabricacion.values()[opcionOrigen - 1];
        scanner.nextLine();

        System.out.println("Elija la categoría:");
        mostrarOpciones(Categoria.values());
        int opcionCategoria = scanner.nextInt();
        Categoria categoria = Categoria.values()[opcionCategoria - 1];
        scanner.nextLine();

        return new Producto(codigo, descripcion, precioUnitario, origen, categoria);
    }

    private static void mostrarProductos(ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para mostrar.");
        } else {
            System.out.println("Productos:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    private static void modificarProducto(Scanner scanner, ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para modificar.");
        } else {
            mostrarProductos(productos);
            System.out.println("Ingrese el índice del producto a modificar (el indice del primer producto vale 0):");
            int indice = scanner.nextInt();
            scanner.nextLine(); 

            if (indice >= 0 && indice < productos.size()) {
                Producto producto = productos.get(indice);

                System.out.println("¿Qué desea modificar?");
                System.out.println("1 - Descripción");
                System.out.println("2 - Precio unitario");
                System.out.println("3 - Origen de fabricación");
                System.out.println("4 - Categoría");
                int opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la nueva descripción:");
                        String nuevaDescripcion = scanner.nextLine();
                        producto.setDescripcion(nuevaDescripcion);
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo precio unitario:");
                        double nuevoPrecio = scanner.nextDouble();
                        scanner.nextLine(); 
                        producto.setPrecioUnitario(nuevoPrecio);
                        break;
                    case 3:
                        System.out.println("Elija el nuevo origen de fabricación:");
                        mostrarOpciones(OrigenFabricacion.values());
                        int opcionOrigen = scanner.nextInt();
                        OrigenFabricacion nuevoOrigen = OrigenFabricacion.values()[opcionOrigen - 1];
                        scanner.nextLine(); 
                        producto.setOrigenFabricacion(nuevoOrigen);
                        break;
                    case 4:
                        System.out.println("Elija la nueva categoría:");
                        mostrarOpciones(Categoria.values());
                        int opcionCategoria = scanner.nextInt();
                        Categoria nuevaCategoria = Categoria.values()[opcionCategoria - 1];
                        scanner.nextLine(); 
                        producto.setCategoria(nuevaCategoria);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("Índice de producto no válido.");
            }
        }
    }

    private static <T extends Enum<T>> void mostrarOpciones(T[] opciones) {
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + " - " + opciones[i]);
        }
    }

}
