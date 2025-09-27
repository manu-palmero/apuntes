from math import sqrt


def primo(
    n,
) -> (
    bool
):  # Función para determinar si un número es primo que devuelve un valor booleano
    if n <= 1:  # Los números por debajo del 1 y el mismo 1 no son primos
        return False
    r = int(
        sqrt(n)
    )  # r es el resultado truncado de la raíz cuadrada de la entrada de la función
    for i in range(
        2, r + 1
    ):  # Para cada número entre 2 y r, puesto como +1 para que funcione correctamente con la función rage()
        if (
            n % i == 0
        ):  # Si encuentra divisores entre estos números entonces no es primo, devuelve Flase
            return False
    return True  # Por defecto devuelve True


def filtrarPrimos(lista: list) -> list:
    primos = []
    for n in lista:
        if primo(float(n)):
            primos.append(n)
    return primos


lista = []

while True:
    n = input("Ingrese un número (presione S para terminar de ingresar números): ")
    if n.upper() == "S":
        break
    lista.append(n)

listaPrimos = filtrarPrimos(lista)

print(f"La lista solamente con números primos es: {listaPrimos}")
