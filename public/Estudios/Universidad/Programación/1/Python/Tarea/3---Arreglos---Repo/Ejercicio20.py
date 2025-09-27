def crear_matriz():
    return [[0 for aux in range(columnas)] for aux in range(filas)]


def matriz_ident():
    for i in range(filas):
        matriz[i][i] = 1


filas = int(input("Ingrese el tamaño de la matriz identidad: "))
columnas = filas
matriz = crear_matriz()
matriz_ident()
for i in matriz:
    print(i)
