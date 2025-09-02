
#Definición de clase Persona
class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad

    def mostrar_info(self):
        print(f"Nombre: {self.nombre}, Edad: {self.edad}")

# Uso
p1 = Persona("Pedro", 30)
p1.mostrar_info()  # Nombre: Pedro, Edad: 30