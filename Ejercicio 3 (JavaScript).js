
// Recorrido
let arreglo = [10, 20, 30, 40, 50];
console.log("Recorrido:");
for (let i = 0; i < arreglo.length; i++) {
    console.log(arreglo[i]);
}

// Inserción en índice
let lista = [10, 20, 30, 40];
lista.splice(2, 0, 99); // inserta en índice 2
console.log("Después de insertar:", lista);

// Búsqueda lineal
let buscado = 30;
let encontrado = false;
for (let i = 0; i < lista.length; i++) {
    if (lista[i] === buscado) {
        console.log("Elemento encontrado en posición " + i);
        encontrado = true;
        break;
    }
}
if (!encontrado) {
    console.log("Elemento no encontrado");
}