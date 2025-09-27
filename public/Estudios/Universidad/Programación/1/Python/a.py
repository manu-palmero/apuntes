import random


class Clase:
    contador = 0

    # a = ''
    def __init__(self, a) -> None:
        self.a = a
        Clase.contador += 1
        pass

    @classmethod
    def f(cls):
        print(cls.contador)

    def ff():
        return


class Principal:

    def __init__(self, fecha) -> None:
        self.fecha = fecha

    def main(self):
        # Acceder y manipular la variable fecha
        print(f"La fecha original es: {self.fecha}")

        # Ejemplo de manipulación: cambiar la fecha
        self.fecha = "2024-01-01"
        print(f"La nueva fecha es: {self.fecha}")


# Crear una instancia de la clase
mi_principal = Principal("2023-09-19")

# Llamar al método main
mi_principal.main()


n = 0

aa = Clase("aaa")
aa = Clase("bbb")
aa = Clase("ccc")

Clase.f()

a = [1, 2, 3]
b = a
b.append(4)  # Esto afecta a a
print(a)  # Salida: [1, 2, 3, 4]

x = 5
y = x
x += 1
print(y)


class MiClase:
    def __init__(self, valor):
        self.valor = valor


objeto1 = MiClase(10)
objeto2 = objeto1  # objeto2 referencia a objeto1
objeto2.valor = 20  # Modificación en objeto2
print(objeto1.valor)  # Salida: 20

iterador = iter([1, 2, 3])
for i in range(5):
    try:
        print(next(mi_iterador))  # Intentar obtener el siguiente elemento
    except StopIteration:
        print("No hay más elementos.")  # Manejo de la excepción