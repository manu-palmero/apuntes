def crear_matriz():
    return [[0 for aux in range(filas)] for aux in range(filas)]


def matriz_ident_inv():
    for i in range(filas):
        for j in range(filas):
            if i + j == filas - 1:
                matriz[i][j] = 1


filas = int(input("Ingrese el tamaño de la matriz identidad inversa: "))
matriz = crear_matriz()
matriz_ident_inv()
for i in matriz:
    print(i)
