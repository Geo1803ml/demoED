
#include <iostream>
using namespace std;

// Definición de clase Persona
class Persona {
public:
    string nombre;
    int edad;

    // Constructor
    Persona(string n, int e) {
        nombre = n;
        edad = e;
    }

    // Método
    void mostrarInfo() {
        cout << "Nombre: " << nombre << ", Edad: " << edad << endl;
    }
};

int main() {
    Persona p1("Carlos", 22);
    p1.mostrarInfo();  // Nombre: Carlos, Edad: 22
    return 0;
}