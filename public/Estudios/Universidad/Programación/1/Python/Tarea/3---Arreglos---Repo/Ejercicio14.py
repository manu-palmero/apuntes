""" 
Crea una función que reciba dos parámetros: el número de filas y columnas. La función
debe generar una matriz de ese tamaño, donde los valores son números enteros
consecutivos empezando desde 1.
"""

filas = int(input("Ingrese el número de filas: "))
columnas = int(input("Ingrese el número de columnas: "))

from pprint import pprint


def crearMatriz(filas, columnas):
    return [[0 for _ in range(columnas)] for _ in range(filas)]


def rellenarMatriz(filas, columnas, matriz):
    for f in range(0, filas):
        for c in range(0, columnas):
            if f == 0:
                matriz[f][c] = matriz[f][c - 1] + 1
            else:
                matriz[f][c] = matriz[f - 1][c] + columnas


matriz = crearMatriz(filas, columnas)

rellenarMatriz(filas, columnas, matriz)

for i in range(0, filas):
    pprint(f"{matriz[i]}")
