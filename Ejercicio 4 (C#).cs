
using System;

class Program {
    static void Main() {
        // Declaramos una matriz 3x3
        int[,] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Console.WriteLine("Recorrido por columnas:");

        // Recorremos columnas primero
        for (int col = 0; col < 3; col++) {
            // Dentro de cada columna recorremos las filas
            for (int fila = 0; fila < 3; fila++) {
                // Accedemos usando [fila, col] en C#
                Console.Write(matriz[fila, col] + " ");
            }
        }
    }
}