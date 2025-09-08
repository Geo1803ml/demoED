
# Declaramos una matriz 3x3 como lista de listas
matriz = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

print("Recorrido por columnas:")

# Recorremos columnas primero
for col in range(3):
    # Recorremos filas dentro de cada columna
    for fila in range(3):
        # Accedemos primero a la fila y luego a la columna
        print(matriz[fila][col], end=" ")