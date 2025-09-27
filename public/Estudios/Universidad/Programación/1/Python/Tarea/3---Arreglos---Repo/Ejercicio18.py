import numpy as np


def crear_matriz():
    return [[0 for aux in range(columnas)] for aux in range(filas)]


def llenar_matriz():
    print("Ingrese los elementos de la matriz:")
    for i in range(filas):
        for j in range(columnas):
            matriz[i][j] = int(input(f"Ingrese un valor para la posicion {i},{j}: "))
    return matriz


filas = int(input("Ingrese el número de filas: "))
columnas = int(input("Ingrese el numero de columnas: "))
matriz = crear_matriz()
matriz_llena = llenar_matriz()
escal = int(input("Ingrese un escalar para multiplicar por la matriz: "))
multi = np.dot(matriz_llena, escal)
print("La matriz original es:")
for i in matriz_llena:
    print(i)
print(f"La matriz multiplicada por el escalar {escal} es:")
for i in multi:
    print(i)
