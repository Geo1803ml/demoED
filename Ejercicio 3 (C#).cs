
using System;
using System.Collections.Generic;

class Program {
    static void Main() {
        // Recorrido
        int[] arreglo = {10, 20, 30, 40, 50};
        Console.WriteLine("Recorrido:");
        for (int i = 0; i < arreglo.Length; i++) {
            Console.WriteLine(arreglo[i]);
        }

        // Inserción en índice usando List
        List<int> lista = new List<int>() {10, 20, 30, 40};
        lista.Insert(2, 99); // inserta en índice 2
        Console.WriteLine("Después de insertar: " + string.Join(", ", lista));

        // Búsqueda lineal
        int buscado = 30;
        bool encontrado = false;
        for (int i = 0; i < lista.Count; i++) {
            if (lista[i] == buscado) {
                Console.WriteLine("Elemento encontrado en posición " + i);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            Console.WriteLine("Elemento no encontrado");
        }
    }
}