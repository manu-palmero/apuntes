def crear_matriz():
    return [[0 for aux in range(columnas)] for aux in range(filas)]


def llenar_matriz():
    print("Ingrese los elementos de la matriz:")
    for i in range(filas):
        for j in range(columnas):
            matriz[i][j] = int(input(f"Ingrese un valor para la posicion {i},{j}: "))
    return matriz


def crear_transpuesta():
    matriztrans = crear_matriz()
    for i in range(filas):
        for j in range(columnas):
            matriztrans[i][j] = matriz_llena[j][i]
    return matriztrans


def validacion():
    cont = 0
    for i in range(filas):
        for j in range(columnas):
            if matriz_llena[i][j] != transpuesta[i][j]:
                cont += 1
                break
    if cont == 0:
        print("La matriz es Simetrica")
    else:
        print("La matriz NO es simetrica ")


filas = int(input("Ingrese el número de filas: "))
columnas = int(input("Ingrese el numero de columnas: "))
if filas != columnas:
    print("La matriz NO es simetrica")
else:
    matriz = crear_matriz()
    matriz_llena = llenar_matriz()
    transpuesta = crear_transpuesta()
    validacion()
