
// Definición de clase Persona
class Persona {
    constructor(nombre, edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    mostrarInfo() {
        console.log(`Nombre: ${this.nombre}, Edad: ${this.edad}`);
    }
}

// Uso
let p1 = new Persona("Luis", 25);
p1.mostrarInfo(); // Nombre: Luis, Edad: 25