
using System;

// Definición de clase Persona
class Persona {
    public string Nombre;
    public int Edad;

    // Constructor
    public Persona(string nombre, int edad) {
        Nombre = nombre;
        Edad = edad;
    }

    // Método
    public void MostrarInfo() {
        Console.WriteLine($"Nombre: {Nombre}, Edad: {Edad}");
    }
}

class Program {
    static void Main(string[] args) {
        Persona p1 = new Persona("María", 28);
        p1.MostrarInfo();  // Nombre: María, Edad: 28
    }
}