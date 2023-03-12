import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Obra> obras = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("-- Menú --\n");
            System.out.println("1 - Mostrar clientes");
            System.out.println("2 - Crear clientes");
            System.out.println("3 - Crear una obra");
            System.out.println("4 - Crear un pedido");
            System.out.println("5 - Mostrar pedidos");
            System.out.println("6 - Salir\n");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (clientes.size() == 0) {
                        System.out.println("\nNo hay clientes registrados.");
                    } else {
                        System.out.println("\n-- Clientes --\n");
                        for (Cliente cliente : clientes) {
                            System.out.println(cliente);
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n¿Nombre?");
                    scanner.nextLine();
                    String nombreCliente = scanner.nextLine();
                    Cliente nuevoCliente = new Cliente(nombreCliente);
                    clientes.add(nuevoCliente);
                    System.out.println("\nCliente " + clientes.size() + " agregado.\n");
                    break;
                case 3:
                    System.out.println("\n¿Tipo?");
                    System.out.println("1 - Libro");
                    System.out.println("2 - Vídeo");
                    int tipoObra = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("\n¿Título?");
                    String tituloObra = scanner.nextLine();
                    System.out.println("\n¿Autor?");
                    String autorObra = scanner.nextLine();
                    if (tipoObra == 1) {
                        System.out.println("\n¿Número de páginas?");
                        int numPaginas = scanner.nextInt();
                        Obra nuevaObra = new Libro(tituloObra, autorObra, numPaginas);
                        obras.add(nuevaObra);
                    }if(tipoObra == 2){
                        System.out.println("\n¿Duración (minutos)?");
                        int duracionMinutos = scanner.nextInt();
                        Obra nuevaObra = new Video(tituloObra, autorObra, duracionMinutos);
                        obras.add(nuevaObra);
                    }else{
                        System.out.println("\nOpción no válida.");
                    }
                    System.out.println("\n" + obras.get(obras.size() - 1) + " añadido\n");
                    break;
                case 4:
                    if (clientes.size() == 0) {
                        System.out.println("\nNo hay clientes registrados.");
                    } else if (obras.size() == 0) {
                        System.out.println("\nNo hay obras registradas.");
                    } else {
                        System.out.println("\n¿Para qué cliente?");
                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.println("Cliente n°." + (i + 1) + ": " + clientes.get(i).getNombre());
                        }
                        int numCliente = scanner.nextInt() - 1;
                        Cliente clienteSeleccionado = clientes.get(numCliente);
                        ArrayList<Obra> obrasPedido = new ArrayList<>();
                        int opcionObra;
                        do {
                            System.out.println("\n¿Qué obra agregar al pedido?");
                            for (int i = 0; i < obras.size(); i++) {
                                System.out.println((i + 1) + " - " + obras.get(i));
                            }
                            System.out.println((obras.size() + 1) + " - Terminar pedido");
                            opcionObra = scanner.nextInt();
                            if (opcionObra != obras.size() + 1) {
                                obrasPedido.add(obras.get(opcionObra - 1));
                            }
                        } while (opcionObra != obras.size() + 1);
                        Pedido nuevoPedido = new Pedido(clienteSeleccionado);
                        for (Obra obra : obrasPedido) {
                            nuevoPedido.agregarObra(obra);
                        }
                        pedidos.add(nuevoPedido);
                        System.out.println("\nPedido " + pedidos.size() + " agregado.\n");
                    }
                    break;
                case 5:
                    if (pedidos.size() == 0) {
                        System.out.println("\nNo hay pedidos registrados.");
                    } else {
                        System.out.println("\n-- Pedidos --\n");
                        for (Pedido pedido : pedidos) {
                            System.out.println(pedido);
                        }
                    }
                    break;
                case 6:
                    System.out.println("\nHasta luego.");
                    break;
                default:
                    System.out.println("\nOpción no válida.");
                    break;
            }
        } while (opcion != 6);
    }
}