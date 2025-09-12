
import java.util.Scanner;

public class Mini_Proyecto_1 {
    private static char[][] tablero = new char[3][3];
    private static char jugadorActual = 'X';
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarTablero();
        System.out.println("Juego del Gato - 2 jugadores");
        System.out.println("Jugador X y Jugador O. Ingresa posición del 1 al 9:");
        imprimirInstrucciones();

        while (true) {
            imprimirTablero();
            System.out.printf("Turno del jugador %c. Ingresa una posición (1-9): ", jugadorActual);
            int posicion;
            try {
                posicion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor no valido. Ingresa un número del 1 al 9.");
                continue;
            }

            if (!hacerMovimiento(posicion)) {
                System.out.println("Lugar ocupado. Intenta otra posición.");
                continue;
            }

            if (hayGanador()) {
                imprimirTablero();
                System.out.printf("¡Jugador %c gana! Felicidades.\n", jugadorActual);
                break;
            }

            if (tableroLleno()) {
                imprimirTablero();
                System.out.println("Empate. El tablero está lleno.");
                break;
            }

            cambiarJugador();
        }

        System.out.println("Fin del juego.");
    }

    // Comienza el tablero con espacios en blanco
    private static void inicializarTablero() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tablero[i][j] = ' ';
    }

    // Muestra el tablero en consola
    private static void imprimirTablero() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.printf(" %c | %c | %c \n", tablero[i][0], tablero[i][1], tablero[i][2]);
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }

    // Muestra las posiciones de los cuadros del 1 al 9
    private static void imprimirInstrucciones() {
        System.out.println();
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("---+---+---");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("---+---+---");
        System.out.println(" 7 | 8 | 9 ");
        System.out.println();
    }

    // Colocar el simbolo del jugador que esta jugando
    private static boolean hacerMovimiento(int pos) {
        if (pos < 1 || pos > 9) return false;
        int fila = (pos - 1) / 3;
        int col = (pos - 1) % 3;
        if (tablero[fila][col] != ' ') return false;
        tablero[fila][col] = jugadorActual;
        return true;
    }

    // Cambia el jugador entre 'X' y 'O'
    private static void cambiarJugador() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }

    // Comprueba si hay ganador (filas, columnas o diagonales)
    private static boolean hayGanador() {
        // Filas y columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual)
                return true;
            if (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual)
                return true;
        }
        // Diagonales
        if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual)
            return true;
        if (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual)
            return true;

        return false;
    }

    // Comprueba si el tablero está lleno (empate)
    private static boolean tableroLleno() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (tablero[i][j] == ' ')
                    return false;
        return true;
    }
}