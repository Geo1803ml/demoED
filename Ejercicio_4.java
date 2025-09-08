
public class Ejercicio_4 {
    public static void main(String[] args) {
        // Declaramos una matriz 3x3
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Recorrido por columnas:");

        // Recorremos primero las columnas
        for (int col = 0; col < 3; col++) {
            // Dentro de cada columna recorremos las filas
            for (int fila = 0; fila < 3; fila++) {
                // Accedemos usando [fila][col]
                System.out.print(matriz[fila][col] + " ");
            }
        }
    }
}