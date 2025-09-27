import numpy as np


def crear_matriz(fila, columna):
    return [[0 for aux in range(columna)] for aux in range(fila)]


def crear_matriz_por_teclado():
    filas = int(input("Ingrese el número de filas: "))
    columnas = int(input("Ingrese el numero de columnas: "))
    matriz = crear_matriz(filas, columnas)

    print("Ingrese los elementos de la matriz:")
    for i in range(filas):
        for j in range(columnas):
            matriz[i][j] = int(input(f"Ingrese un valor para la posicion {i},{j}: "))

    return matriz


def sumar_filas(matriz):
    cont = 0
    sumatot = []
    for i in matriz:
        cont += 1
        sumatot.append(sum(i))
    return sumatot


matriz = crear_matriz_por_teclado()
print(f"\nLa matriz ingresada es:")
for fila in matriz:
    print(fila)
print(f"\nLa suma de los elementos de la matriz ingresada es: {np.sum(matriz)}")
print(f"Los resultados de cada fila son: ")
for i, suma in enumerate(sumar_filas(matriz)):
    print(f"La suma de la fila {i} es: {suma}")
