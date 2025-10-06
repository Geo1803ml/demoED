#!/usr/bin/env python3
# Fase de colocacion de barcos y Fase de ataque

TAM = 10
BARCOS = [
    ("Portaaviones", 5),
    ("Acorazado", 4),
    ("Crucero", 3),
    ("Submarino", 3),
    ("Destructor", 2)
]
IDS = [chr(ord("A") + i) for i in range(len(BARCOS))]  # IDs: A, B, C, D, E

# Crear tablero

def nuevo_tablero(valor="~"):
    """Crea un tablero 10x10 inicializado con el carácter indicado."""
    return [[valor]*TAM for _ in range(TAM)]

def imprimir(tab, ocultar_barcos=False):
    """Imprime el tablero en pantalla, con opción de ocultar barcos."""
    print("   " + " ".join(f"{i+1:2}" for i in range(TAM)))
    for i, fila in enumerate(tab):
        display_row = []
        for cel in fila:
            if ocultar_barcos and cel in IDS:
                display_row.append("~")
            else:
                display_row.append(cel)
        print(f"{i+1:2} " + " ".join(display_row))

def pedir_int(mensaje, a, b):
    """Pide un número entero dentro de un rango válido."""
    while True:
        try:
            v = int(input(mensaje))
            if a <= v <= b:
                return v
        except ValueError:
            pass
        print(f"Introduce un entero entre {a} y {b}.")

def pedir_orientacion():
    """Pide al jugador orientación H/V para colocar el barco."""
    while True:
        o = input("Orientación (H horizontal / V vertical): ").strip().upper()
        if o in ("H","V"):
            return o
        print("Escribe H o V.")

def cabe(tab, r, c, largo, orient):
    """Comprueba si un barco cabe sin salirse ni superponerse."""
    if orient == "H":
        if c + largo > TAM: return False
        return all(tab[r][cc] == "~" for cc in range(c, c+largo))
    else:
        if r + largo > TAM: return False
        return all(tab[rr][c] == "~" for rr in range(r, r+largo))

def poner(tab, r, c, largo, orient, id_barco):
    """Coloca el barco en el tablero."""
    if orient == "H":
        for cc in range(c, c+largo): tab[r][cc] = id_barco
    else:
        for rr in range(r, r+largo): tab[rr][c] = id_barco

# Fase de colocacion de barcos

def colocar_jugador(nombre):
    print("\n" + "="*40)
    print(f"{nombre} — coloca tus barcos")
    tab = nuevo_tablero()
    imprimir(tab)
    conteo_por_id = {}

    for idx, (nombre_barco, largo) in enumerate(BARCOS):
        id_barco = IDS[idx]
        print(f"\nColocar {nombre_barco} (largo {largo}) -> ID '{id_barco}'")
        while True:
            orient = pedir_orientacion()
            fila = pedir_int(f"Fila inicial 1..{TAM}: ", 1, TAM) - 1
            col  = pedir_int(f"Columna inicial 1..{TAM}: ", 1, TAM) - 1
            if cabe(tab, fila, col, largo, orient):
                poner(tab, fila, col, largo, orient, id_barco)
                conteo_por_id[id_barco] = {"nombre": nombre_barco, "restantes": largo}
                print(f"{nombre_barco} colocado.")
                imprimir(tab)   # muestra inmediatamente al jugador
                break
            else:
                print("No cabe o se solapa. Prueba otra posición.")

    total = sum(v["restantes"] for v in conteo_por_id.values())
    return tab, conteo_por_id, total


# Fase de ataque (turnos alternos)

def atacar(atacante_nombre, defensor_tab, defensor_conteos, defensor_fog):
    """Realiza un ataque de un jugador al tablero enemigo."""
    print(f"\n{atacante_nombre} — tu turno de ataque")
    imprimir(defensor_fog, ocultar_barcos=False)

    while True:
        fila = pedir_int(f"Fila 1..{TAM}: ", 1, TAM) - 1
        col  = pedir_int(f"Columna 1..{TAM}: ", 1, TAM) - 1

        if defensor_fog[fila][col] in ("X","o"):
            print("Ya has atacado esa casilla. Elige otra.")
            continue

        actual = defensor_tab[fila][col]

        # Impacto en barco enemigo
        if actual in IDS:
            idbar = actual
            defensor_tab[fila][col] = "X"
            defensor_fog[fila][col] = "X"
            defensor_conteos[idbar]["restantes"] -= 1
            print("¡Tocado!")

            # Si el barco queda sin casillas, está hundido
            if defensor_conteos[idbar]["restantes"] == 0:
                print(f"Hundido: {defensor_conteos[idbar]['nombre']} (ID {idbar})")
            return 1  # Casilla de barco destruida

        # Agua
        else:
            defensor_tab[fila][col] = "o"
            defensor_fog[fila][col] = "o"
            print("Agua.")
            return 0  # Fallo


def tablero_visible_para_atacante(defensor_tab):
    """Crea el tablero de 'niebla' que ve el atacante (sin barcos)."""
    fog = nuevo_tablero("~")
    for r in range(TAM):
        for c in range(TAM):
            if defensor_tab[r][c] == "X":
                fog[r][c] = "X"
            elif defensor_tab[r][c] == "o":
                fog[r][c] = "o"
    return fog

def main():
    print("Batalla Naval — colocación + ataques (10x10)")

    # Fase de colocacion
    
    t1, conteos1, total1 = colocar_jugador("Jugador 1")
    input("Jugador 1: pulsa Enter y pasa el control...")
    print("\n"*30)
    t2, conteos2, total2 = colocar_jugador("Jugador 2")
    print("\nColocación finalizada. ¡Comienza la batalla!")

    # Crear los tableros 'niebla' que ve cada atacante
    fog1 = tablero_visible_para_atacante(t2)  # lo que ve J1
    fog2 = tablero_visible_para_atacante(t1)  # lo que ve J2

    # Fase de ataque

    atacante = 1
    while True:
        if atacante == 1:
            golpe = atacar("Jugador 1", t2, conteos2, fog1)
            if golpe:
                total2 -= golpe
            if total2 == 0:
                print("\n ¡Jugador 1 ha hundido todos los barcos! GANA.")
                break
        else:
            golpe = atacar("Jugador 2", t1, conteos1, fog2)
            if golpe:
                total1 -= golpe
            if total1 == 0:
                print("\n ¡Jugador 2 ha hundido todos los barcos! GANA.")
                break

        # Alternar turnos
        atacante = 2 if atacante == 1 else 1
        input("Pulsa Enter para continuar y pasar el control...")
        print("\n"*10)

    print("\nTablero final Jugador 1:")
    imprimir(t1, ocultar_barcos=False)
    print("\nTablero final Jugador 2:")
    imprimir(t2, ocultar_barcos=False)
    print("\nFin del juego.")

if __name__ == "__main__":
    main()
    main()
