
public class Ejercicio3 {
    public static void main(String[] args) {
        // Recorrido
        int[] arreglo = {10, 20, 30, 40, 50};
        System.out.println("Recorrido:");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }

        // Inserción en índice (simulado con ArrayList para facilidad)
        java.util.ArrayList<Integer> lista = new java.util.ArrayList<>();
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.add(40);
        lista.add(2, 99); // inserta en posición 2
        System.out.println("Después de insertar: " + lista);

        // Búsqueda lineal
        int buscado = 30;
        boolean encontrado = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == buscado) {
                System.out.println("Elemento encontrado en posición " + i);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Elemento no encontrado");
        }
    }
}