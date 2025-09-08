
// Declaramos una matriz 3x3 como arreglo de arreglos
let matriz = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
];

console.log("Recorrido por columnas:");

// Recorremos columnas primero
for (let col = 0; col < 3; col++) {
    // Recorremos filas en cada columna
    for (let fila = 0; fila < 3; fila++) {
        // Accedemos a la matriz como [fila][col]
        process.stdout.write(matriz[fila][col] + " ");
    }
}