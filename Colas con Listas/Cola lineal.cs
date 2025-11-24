// QueueList.cs
using System;
using System.Collections.Generic;

class QueueList {
    static void Insertar(Queue<int> q) {
        Console.Write("Ingrese el elemento (entero): ");
        string input = Console.ReadLine();
        int elemento;
        while (!int.TryParse(input, out elemento)) {
            Console.Write("Por favor ingrese un número entero: ");
            input = Console.ReadLine();
        }
        q.Enqueue(elemento);
        Console.WriteLine("Elemento insertado correctamente.");
    }

    static void Eliminar(Queue<int> q) {
        if (q.Count == 0) {
            Console.WriteLine("SUBDESBORDAMIENTO (UNDERFLOW)");
            return;
        }
        int elemento = q.Dequeue();
        Console.WriteLine("Elemento eliminado: " + elemento);
    }

    static void Mostrar(Queue<int> q) {
        if (q.Count == 0) {
            Console.WriteLine("La cola está vacía.");
            return;
        }
        Console.WriteLine("Elementos en la cola:");
        foreach (var elem in q) {
            Console.WriteLine(elem);
        }
    }

    static void Main() {
        var q = new Queue<int>();
        string opcion = "";
        while (opcion != "4") {
            Console.WriteLine("\n*************** MENU PRINCIPAL ***************");
            Console.WriteLine("1. Insertar un elemento");
            Console.WriteLine("2. Eliminar un elemento");
            Console.WriteLine("3. Mostrar la cola");
            Console.WriteLine("4. Salir");
            Console.Write("Ingrese su opción: ");
            opcion = Console.ReadLine().Trim();

            switch (opcion) {
                case "1":
                    Insertar(q);
                    break;
                case "2":
                    Eliminar(q);
                    break;
                case "3":
                    Mostrar(q);
                    break;
                case "4":
                    Console.WriteLine("Saliendo del programa...");
                    break;
                default:
                    Console.WriteLine("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }
}
