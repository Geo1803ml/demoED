# queue_list.py
from collections import deque

def insertar(q):
    elemento = input("Ingrese el elemento: ")
    q.append(elemento)
    print("Elemento insertado correctamente.")

def eliminar(q):
    if not q:
        print("SUBDESBORDAMIENTO (UNDERFLOW)")
        return
    elemento = q.popleft()
    print("Elemento eliminado:", elemento)

def mostrar(q):
    if not q:
        print("La cola está vacía.")
        return
    print("Elementos en la cola:")
    for elem in q:
        print(elem)

def main():
    q = deque()
    opcion = None
    while opcion != "4":
        print("\n*************** MENU PRINCIPAL ***************")
        print("1. Insertar un elemento")
        print("2. Eliminar un elemento")
        print("3. Mostrar la cola")
        print("4. Salir")
        opcion = input("Ingrese su opción: ").strip()

        if opcion == "1":
            insertar(q)
        elif opcion == "2":
            eliminar(q)
        elif opcion == "3":
            mostrar(q)
        elif opcion == "4":
            print("Saliendo del programa...")
        else:
            print("Opción inválida. Intente nuevamente.")

if __name__ == "__main__":
    main()
