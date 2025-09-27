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
matriz_rotada = np.rot90(np.rot90(np.rot90(matriz_llena)))
print("La matriz original es:")
for i in matriz_llena:
    print(i)
print(f"La matriz rotada 90 grados es:")
for i in matriz_rotada:
    print(i)
