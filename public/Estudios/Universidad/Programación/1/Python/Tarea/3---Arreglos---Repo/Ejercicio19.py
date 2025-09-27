def crear_matriz():
    return [[0 for aux in range(columnas)] for aux in range(filas)]


def llenar_matriz():
    print("Ingrese los elementos de la matriz:")
    for i in range(filas):
        for j in range(columnas):
            matriz[i][j] = int(input(f"Ingrese un valor para la posicion {i},{j}: "))
    return matriz


def sacar_diag():
    diag = []
    for i in range(filas):
        diag.append(matriz_llena[i][i])
    return diag


filas = int(input("Ingrese el tamaño de la matriz cuadrada: "))
columnas = filas
matriz = crear_matriz()
matriz_llena = llenar_matriz()
diagonalprin = sacar_diag()
print(f"Los elementos de la diagonal principal son: \n{diagonalprin}")
