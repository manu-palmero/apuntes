from . import clases as c
import random

def longitud(l: iter) -> int:
    long = 0
    for i in l:
        long += 1
    return long

def rellenar_automaticamente(lista, filas, columnas):
    for m in c.Rango(0, filas-1):
        for n in c.Rango(0,columnas-1):
            valor = random.randint(1,999)
            if 0 < valor  < 1000:
                if valor<10: 
                    valorStr = f"  {str(valor)} "
                elif valor<100: 
                    valorStr = f" {str(valor)} "
                elif valor<1000: 
                    valorStr = f" {str(valor)} "
                # else: valorStr = str(valor)
                lista[m][n] = valorStr
    print(lista)

def llenar_lista_manualmente(lista:list,filas:int,columnas:int) -> list:
    for m in c.Rango(0, filas-1):
        for n in c.Rango(0,columnas-1):
            while True:
                valor = int(input(f"Ingrese un valor entre 1 y 999 para la posición [{m}, {n}]: "))
                if 0 < valor  < 1000:
                    if valor<10: 
                        valorStr = f"  {str(valor)} "
                    elif valor<100: 
                        valorStr = f" {str(valor)} "
                    elif valor<1000: 
                        valorStr = f" {str(valor)} "
                    # else: valorStr = str(valor)
                    lista[m][n] = valorStr
                    break
                else:
                    print("El valor no está dentro del rango admitido, intente de nuevo")

def imprimir_lista(lista:list,filas:int,columnas:int):
    print(f"   |", end="")
    for m in c.Rango(0, columnas-1):
        print(f"    {m}      |", end="")
    print("")
    for m in c.Rango(0, filas-1):
        print(f"{m}  |   ", end="")
        for n in c.Rango(0,columnas-1):
            if columnas != 1:
                print(lista[m][n], end="    |   ")
            else: 
                print(lista[m], end="    |   ")
        print("")


def calcular_sumatoria_filas(lista, filas, columnas) -> list:
    sumatoria = [] # Crear lista
    for m in c.Rango(0, filas-1): # Rellenar lista con 0
        sumatoria += [0]
    for m in c.Rango(0, filas-1): # Para cada fila
        for n in c.Rango(0,columnas-1): # Para cada columna
            sumatoria[m] += int(lista[m][n]) # Suma el valor
    return sumatoria

def calcular_sumatoria_columnas(lista, filas, columnas) -> list:
    sumatoria = []
    for m in c.Rango(0, columnas-1):
        sumatoria += [0]
    for m in c.Rango(0, filas-1):
        for n in c.Rango(0,columnas-1):
            sumatoria[n] += int(lista[m][n])
    return sumatoria

def ordenar_lista_mayor_a_menor(lista, filas) -> list:
    ordenada = []
    for m in c.Rango(0,filas-1):
        ordenada += [0]
    for m in c.Rango(0,filas-1):
        mayor = 0
        for n in c.Rango(0, longitud(lista)-1):
            numero = lista[n]
            if numero > mayor:
                mayor = numero
                indiceDelMayor = n
            ordenada[m] = mayor
        lista[indiceDelMayor] = 0
    return ordenada
# def ordenar_lista_mayor_a_menor(lista, filas) -> list:
#     ordenada = []
#     for m in c.Rango(0,filas-1):
#         ordenada += [0]
#     for m in c.Rango(0,filas-1):
#         mayor = 0
#         for n in c.Rango(0, longitud(lista)-1):
#             numero = lista[n]
#             if numero > mayor:
#                 mayor = numero
#                 indiceDelMayor = n
#             ordenada[m] = mayor
#         lista[indiceDelMayor] = 0
#     return ordenada