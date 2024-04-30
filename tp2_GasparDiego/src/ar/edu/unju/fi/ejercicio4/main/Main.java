package ar.edu.unju.fi.ejercicio4.main;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<>();

        int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 – Alta de jugador");
            System.out.println("2 – Mostrar todos los jugadores");
            System.out.println("3 – Modificar la posición de un jugador");
            System.out.println("4 – Eliminar un jugador");
            System.out.println("5 – Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    altaJugador(scanner, jugadores);
                    break;
                case 2:
                    mostrarJugadores(jugadores);
                    break;
                case 3:
                    modificarPosicion(scanner, jugadores);
                    break;
                case 4:
                    eliminarJugador(scanner, jugadores);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void altaJugador(Scanner scanner, ArrayList<Jugador> jugadores) {
        try {
            System.out.println("Ingrese el nombre del jugador:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el apellido del jugador:");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese la fecha de nacimiento del jugador (YYYY-MM-DD):");
            LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());

            System.out.println("Ingrese la nacionalidad del jugador:");
            String nacionalidad = scanner.nextLine();

            System.out.println("Ingrese la estatura del jugador (en cm):");
            double estatura = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Ingrese el peso del jugador (en kg):");
            double peso = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Ingrese la posición del jugador (DELANTERO, MEDIO, DEFENSA, ARQUERO):");
            Posicion posicion = Posicion.valueOf(scanner.nextLine().toUpperCase());

            Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
            jugadores.add(jugador);

            System.out.println("Jugador creado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al ingresar datos. Asegúrese de ingresar los datos correctamente.");
        }
    }

    private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para mostrar.");
        } else {
            System.out.println("Jugadores:");
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    }

    private static void modificarPosicion(Scanner scanner, ArrayList<Jugador> jugadores) {
        try {
            if (jugadores.isEmpty()) {
                System.out.println("No hay jugadores para modificar.");
            } else {
                System.out.println("Ingrese el nombre del jugador:");
                String nombre = scanner.nextLine();

                System.out.println("Ingrese el apellido del jugador:");
                String apellido = scanner.nextLine();

                boolean encontrado = false;
                Iterator<Jugador> iterator = jugadores.iterator();
                while (iterator.hasNext()) {
                    Jugador jugador = iterator.next();
                    if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                        System.out.println("Ingrese la nueva posición del jugador (DELANTERO, MEDIO, DEFENSA, ARQUERO):");
                        Posicion nuevaPosicion = Posicion.valueOf(scanner.nextLine().toUpperCase());
                        jugador.setPosicion(nuevaPosicion);
                        System.out.println("Posición modificada con éxito.");
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("No se encontró un jugador con ese nombre y apellido.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Posición ingresada no válida.");
        }
    }

    private static void eliminarJugador(Scanner scanner, ArrayList<Jugador> jugadores) {
        try {
            if (jugadores.isEmpty()) {
                System.out.println("No hay jugadores para eliminar.");
            } else {
                System.out.println("Ingrese el nombre del jugador:");
                String nombre = scanner.nextLine();

                System.out.println("Ingrese el apellido del jugador:");
                String apellido = scanner.nextLine();

                boolean encontrado = false;
                Iterator<Jugador> iterator = jugadores.iterator();
                while (iterator.hasNext()) {
                    Jugador jugador = iterator.next();
                    if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                        iterator.remove();
                        System.out.println("Jugador eliminado con éxito.");
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("No se encontró un jugador con ese nombre y apellido.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error al ingresar datos. Asegúrese de ingresar los datos correctamente.");
        }
    }
}
