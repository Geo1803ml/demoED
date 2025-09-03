
#include <iostream>
#include <vector>
using namespace std;

int main() {
    // Recorrido
    int arreglo[] = {10, 20, 30, 40, 50};
    cout << "Recorrido:" << endl;
    for (int i = 0; i < 5; i++) {
        cout << arreglo[i] << endl;
    }

    // Inserción en índice usando vector
    vector<int> lista = {10, 20, 30, 40};
    lista.insert(lista.begin() + 2, 99); // inserta en índice 2
    cout << "Después de insertar: ";
    for (int n : lista) cout << n << " ";
    cout << endl;

    // Búsqueda lineal
    int buscado = 30;
    bool encontrado = false;
    for (int i = 0; i < lista.size(); i++) {
        if (lista[i] == buscado) {
            cout << "Elemento encontrado en posición " << i << endl;
            encontrado = true;
            break;
        }
    }
    if (!encontrado) {
        cout << "Elemento no encontrado" << endl;
    }
    return 0;
}