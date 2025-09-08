
#include <iostream>
using namespace std;

int main() {
    // Declaramos una matriz de 3x3
    int matriz[3][3] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    cout << "Recorrido por columnas:" << endl;

    // Bucle externo: recorre las columnas
    for (int col = 0; col < 3; col++) {
        // Bucle interno: recorre las filas
        for (int fila = 0; fila < 3; fila++) {
            // Imprimimos primero fila y luego columna
            cout << matriz[fila][col] << " ";
        }
    }

    return 0;
}