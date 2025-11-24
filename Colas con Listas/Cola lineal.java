// QueueList.java
import java.util.LinkedList;
import java.util.Scanner;

public class QueueList {
    public static void insertar(LinkedList<Integer> q, Scanner sc) {
        System.out.print("Ingrese el elemento (entero): ");
        while (!sc.hasNextInt()) {
            System.out.print("Por favor ingrese un número entero: ");
            sc.next();
        }
        int elemento = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        q.addLast(elemento);
        System.out.println("Elemento insertado correctamente.");
    }

    public static void eliminar(LinkedList<Integer> q) {
        if (q.isEmpty()) {
            System.out.println("SUBDESBORDAMIENTO (UNDERFLOW)");
            return;
        }
        int elemento = q.removeFirst();
        System.out.println("Elemento eliminado: " + elemento);
    }

    public static void mostrar(LinkedList<Integer> q) {
        if (q.isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }
        System.out.println("Elementos en la cola:");
        for (int elem : q) {
            System.out.println(elem);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        String opcion = "";

        while (!opcion.equals("4")) {
            System.out.println("\n*************** MENU PRINCIPAL ***************");
            System.out.println("1. Insertar un elemento");
            System.out.println("2. Eliminar un elemento");
            System.out.println("3. Mostrar la cola");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1": insertar(q, sc); break;
                case "2": eliminar(q); break;
                case "3": mostrar(q); break;
                case "4": System.out.println("Saliendo del programa..."); break;
                default: System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        sc.close();
    }
}
