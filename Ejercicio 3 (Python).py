
# Recorrido
arreglo = [10, 20, 30, 40, 50]
print("Recorrido:")
for i in range(len(arreglo)):
    print(arreglo[i])

# Inserción en índice
lista = [10, 20, 30, 40]
lista.insert(2, 99)  # inserta en índice 2
print("Después de insertar:", lista)

# Búsqueda lineal
buscado = 30
encontrado = False
for i in range(len(lista)):
    if lista[i] == buscado:
        print(f"Elemento encontrado en posición {i}")
        encontrado = True
        break

if not encontrado:
    print("Elemento no encontrado")