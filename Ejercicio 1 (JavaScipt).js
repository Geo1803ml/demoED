
// Declaracion
let numeros = [10, 20, 30];
let vacio = new Array(5);   // arreglo con 5 espacios vacíos

// Asiganacion
numeros[1] = 50;

// Lectura
console.log(numeros[0]);

// Recorrido
for (let i = 0; i < numeros.length; i++) {
    console.log(numeros[i]);
}
// For-of
for (let n of numeros) {
    console.log(n);
}
// Métodos funcionales
numeros.forEach(n => console.log(n));