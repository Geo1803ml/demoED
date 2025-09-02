
// Declaracion
int numeros[5];             // arreglo de 5 enteros
int otros[] = {10, 20, 30}; // inicialización directa

// Asigancion
numeros[0] = 10;

// Lectura
std::cout << numeros[0];  // 10

// Recorrido
for (int i = 0; i < 5; i++) {
    std::cout << numeros[i] << std::endl;
}
// Range-based for (C++11+)
for (int n : otros) {
    std::cout << n << std::endl;
}