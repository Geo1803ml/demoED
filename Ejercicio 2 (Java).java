// Definición de un tipo de dato compuesto (clase Persona)
public class Persona {
    String nombre;
    int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Ana", 20);
        p1.mostrarInfo();  // Nombre: Ana, Edad: 20
    }
}
