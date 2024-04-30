package ar.edu.unju.fi.ejercicio2.main;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Efemeride> efemerides = new ArrayList<>();

        int opcion;
        do {
            System.out.println("Menú de acciones:");
            System.out.println("1 - Crear efeméride");
            System.out.println("2 - Mostrar efemérides");
            System.out.println("3 - Eliminar efeméride");
            System.out.println("4 - Modificar efeméride");
            System.out.println("5 - Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearEfemeride(scanner, efemerides);
                    break;
                case 2:
                    mostrarEfemerides(efemerides);
                    break;
                case 3:
                    eliminarEfemeride(scanner, efemerides);
                    break;
                case 4:
                    modificarEfemeride(scanner, efemerides);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void crearEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
        System.out.println("Ingrese el código de la efeméride:");
        String codigo = scanner.nextLine();

        System.out.println("Ingrese el mes de la efeméride (1-12):");
        int mesNum = scanner.nextInt();
        scanner.nextLine();
        if (mesNum < 1 || mesNum > 12) {
            System.out.println("Mes no válido.");
            return;
        }
        Mes mes = Mes.values()[mesNum - 1];

        System.out.println("Ingrese el día de la efeméride:");
        int dia = scanner.nextInt();
        scanner.nextLine();

        if (dia < 1 || dia > obtenerDiasEnMes(mes)) {
            System.out.println("Día no válido para el mes seleccionado.");
            return;
        }

        System.out.println("Ingrese el detalle de la efeméride:");
        String detalle = scanner.nextLine();

        efemerides.add(new Efemeride(codigo, mes, dia, detalle));
        System.out.println("Efeméride creada con éxito.");
    }

    private static int obtenerDiasEnMes(Mes mes) {
        switch (mes) {
            case ENERO:
            case MARZO:
            case MAYO:
            case JULIO:
            case AGOSTO:
            case OCTUBRE:
            case DICIEMBRE:
                return 31;
            case ABRIL:
            case JUNIO:
            case SEPTIEMBRE:
            case NOVIEMBRE:
                return 30;
            case FEBRERO:
                return 28;
            default:
                return 0;
        }
    }


    private static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides para mostrar.");
        } else {
            System.out.println("Efemérides:");
            for (Efemeride efemeride : efemerides) {
                System.out.println(efemeride);
            }
        }
    }

    private static void eliminarEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides para eliminar.");
        } else {
            mostrarEfemerides(efemerides);
            System.out.println("Ingrese el índice de la efeméride a eliminar (inicia desde 0):");
            int indice = scanner.nextInt();
            scanner.nextLine();
            if (indice >= 0 && indice < efemerides.size()) {
                efemerides.remove(indice);
                System.out.println("Efeméride eliminada con éxito.");
            } else {
                System.out.println("Índice de efeméride no válido.");
            }
        }
    }

    private static void modificarEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides para modificar.");
        } else {
            mostrarEfemerides(efemerides);
            System.out.println("Ingrese el índice de la efeméride a modificar:");
            int indice = scanner.nextInt();
            scanner.nextLine();
            if (indice >= 0 && indice < efemerides.size()) {
                Efemeride efemeride = efemerides.get(indice);

                System.out.println("¿Qué desea modificar?");
                System.out.println("1 - Código");
                System.out.println("2 - Mes");
                System.out.println("3 - Día");
                System.out.println("4 - Detalle");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nuevo código:");
                        String nuevoCodigo = scanner.nextLine();
                        efemeride.setCodigo(nuevoCodigo);
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo mes (1-12):");
                        int nuevoMesNum = scanner.nextInt();
                        scanner.nextLine();
                        if (nuevoMesNum < 1 || nuevoMesNum > 12) {
                            System.out.println("Mes no válido.");
                            break;
                        }
                        efemeride.setMes(Mes.values()[nuevoMesNum - 1]);
                        break;
                    case 3:
                        System.out.println("Ingrese el nuevo día:");
                        int nuevoDia = scanner.nextInt();
                        scanner.nextLine();
                        efemeride.setDia(nuevoDia);
                        break;
                    case 4:
                        System.out.println("Ingrese el nuevo detalle:");
                        String nuevoDetalle = scanner.nextLine();
                        efemeride.setDetalle(nuevoDetalle);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
                System.out.println("Efeméride modificada con éxito.");
            } else {
                System.out.println("Índice de efeméride no válido.");
            }
        }
    }
}
