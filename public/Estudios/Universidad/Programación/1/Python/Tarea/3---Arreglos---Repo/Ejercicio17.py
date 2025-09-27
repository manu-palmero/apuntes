def crear_matriz():
    return [[0 for aux in range(columnas)] for aux in range(filas)]


def llenar_matriz():
    print("Ingrese los elementos de la matriz:")
    for i in range(filas):
        for j in range(columnas):
            matriz[i][j] = int(input(f"Ingrese un valor para la posicion {i},{j}: "))
    return matriz


def num_mayor():
    cont = 0
    for i in range(filas):
        for j in range(columnas):
            if cont == 0:
                mayor = matriz_llena[i][j]
                cont += 1
            elif matriz_llena[i][j] > mayor:
                mayor = matriz_llena[i][j]
    return mayor


filas = int(input("Ingrese el número de filas: "))
columnas = int(input("Ingrese el numero de columnas: "))
matriz = crear_matriz()
matriz_llena = llenar_matriz()
nummas = num_mayor()
print(f"El mayor numero de los elementos de la matriz es: {nummas}")
