//Ejercicio 1 (Java)

public class Ejercicio {
    public static void main(String[] args) {
        // Declaracion
        int[] numeros = new int[5];   
        String[] nombres = {"Ana", "Luis", "Pedro"}; 

        // Asignacion
        numeros[0] = 10;
        numeros[1] = 20;

        // Lectura
        System.out.println(numeros[0]);  // imprime 10

        // Recorrido con índice
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }

        // Recorrido con for-each
        for (int n : numeros) {
            System.out.println(n);
        }
    }
}