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


filas = int(input("Ingrese el número de filas: "))
columnas = int(input("Ingrese el numero de columnas: "))
matriz = crear_matriz()
matriz_llena = llenar_matriz()
transpuesta = crear_transpuesta()
print("Matriz normal")
for fila in matriz:
    print(fila)
print("\nMatriz Transpuesta")
for fila in transpuesta:
    print(fila)
