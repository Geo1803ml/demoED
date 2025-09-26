#!/usr/bin/env python3
# Batalla Naval (solo fase de colocación)

TAM = 10
BARCOS = [("Portaaviones",5), ("Acorazado",4), ("Crucero",3), ("Submarino",3), ("Destructor",2)]

def nuevo_tablero():
    return [["~"]*TAM for _ in range(TAM)]  # "~" = agua

def imprimir(tab):
    # Imprime encabezado de columnas y filas numeradas 1..10
    print("   " + " ".join(f"{i+1:2}" for i in range(TAM)))
    for i, fila in enumerate(tab):
        print(f"{i+1:2} " + " ".join(fila))

def pedir_int(mensaje, a, b):
    while True:
        try:
            v = int(input(mensaje))
            if a <= v <= b:
                return v
        except ValueError:
            pass
        print(f"Introduce un entero entre {a} y {b}.")

def pedir_orientacion():
    while True:
        o = input("Orientación (H horizontal / V vertical): ").strip().upper()
        if o in ("H","V"):
            return o
        print("Escribe H o V.")

def cabe(tab, r, c, largo, orient):
    # Comprueba si cabe en límites y no toca otra "B"
    if orient == "H":
        if c + largo > TAM: return False
        return all(tab[r][cc] == "~" for cc in range(c, c+largo))
    else:
        if r + largo > TAM: return False
        return all(tab[rr][c] == "~" for rr in range(r, r+largo))

def poner(tab, r, c, largo, orient):
    if orient == "H":
        for cc in range(c, c+largo): tab[r][cc] = "B"
    else:
        for rr in range(r, r+largo): tab[rr][c] = "B"

def colocar_jugador(nombre):
    print("\n" + "="*30)
    print(f"{nombre} — coloca tus barcos")
    tab = nuevo_tablero()
    imprimir(tab)
    for nombre_barco, largo in BARCOS:
        print(f"\nColocar {nombre_barco} (largo {largo})")
        while True:
            orient = pedir_orientacion()
            fila = pedir_int(f"Fila inicial 1..{TAM}: ", 1, TAM) - 1
            col  = pedir_int(f"Columna inicial 1..{TAM}: ", 1, TAM) - 1
            if cabe(tab, fila, col, largo, orient):
                poner(tab, fila, col, largo, orient)
                print(f"{nombre_barco} colocado.")
                imprimir(tab)   # muestra inmediatamente
                break
            else:
                print("No cabe o se solapa. Prueba otra posición.")
    return tab

def main():
    print("Batalla Naval — fase de colocación (10x10)")
    t1 = colocar_jugador("Jugador 1")
    input("Jugador 1: pulsa Enter y pasa el control...")
    print("\n"*30)
    t2 = colocar_jugador("Jugador 2")
    print("\nColocación finalizada.")

if __name__ == "__main__":
    main()