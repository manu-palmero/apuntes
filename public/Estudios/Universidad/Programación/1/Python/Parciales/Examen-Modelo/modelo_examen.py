from modules import clases as c
from modules import funciones as f
import random


#  Ejercicio 1
# Cargar una Lista de números decimales de tamaño MXN y mostrar los datos
# cargados. El tamaño de la Lista debe ser solicitado e ingresado por el usuario,
# indicando un valor entero para las filas y un valor entero para las columnas, el
# valor mínimo valido debe ser de 3x2, crear la Lista y solicitar los valores
# numéricos para cargar de datos en cada posición. La carga de los datos puede ser
# manual, donde los datos serán ingresados por el usuario o aleatoria, donde los
# números serán generados automáticamente, ambos casos en el rango de 1 a 999.
# El sistema preguntara al usuario como quiere hacer la carga de valores.

lista = []

while True:
    filas = int(input("Ingrese el número de filas: "))  # Mínimo 3
    columnas = int(input("Ingrese el número de columnas: "))  # Mínimo 2
    if filas >= 3 and columnas >= 2:
        break
    else:
        if filas < 3:
            print("Las filas deben ser al menos 3.")
        if columnas < 2:
            print("Las columnas deben ser al menos 2.")


for m in c.Rango(0, filas - 1):
    lista += [[]]
    for n in c.Rango(0, columnas - 1):
        lista[m] += [0]

while True:
    print("Desea ingresar los valores automáticamente (1) o manualmente (0)?")
    auto: bool = int(input("> "))

    match auto:
        case 1:
            auto = True
            break
        case 0:
            auto = False
            break
        case _:
            print("Entrada inválida, intente de nuevo")

if auto:
    f.rellenar_automaticamente(lista, filas, columnas)
else:
    f.llenar_lista_manualmente(lista, filas, columnas)

# Ejercicio 2
# Mostrar la Lista resultante por pantalla en formato de Lista (filas y columnas).

f.imprimir_lista(lista, filas, columnas)

# Ejercicio 3
# Generar una nueva Lista de N filas por 1 columna que contenga en cada celda de
# la columna la sumatoria de las celdas de cada una de las filas de la Lista cargada
# en el punto 1.

listaNueva = []

listaNueva = f.calcular_sumatoria_filas(lista, filas, columnas)

# Ejercicio 4
# Mostrar la Lista resultante por pantalla.

print("\n")
f.imprimir_lista(listaNueva, filas, 1)

# Ejercicio 5
# Generar una nueva Lista de tamaño N filas por 2 columnas donde la primer
# columna contenga los valores calculados en el punto 3 pero ordenados de
# Mayor a Menor, y en la segunda columna asignar el valor de la fila que poseía
# originalmente en la Lista del punto 3.

tercerLista = []

for m in c.Rango(0, filas - 1):
    tercerLista += [[]]
    for n in c.Rango(0, 1):
        tercerLista[m] += [0]


for m in c.Rango(0, filas - 1):
    for n in c.Rango(0, 1):
        tercerLista[m][1] = listaNueva[m]

print("\n")

mayorAMenor = f.ordenar_lista_mayor_a_menor(listaNueva, f.longitud(listaNueva))

for m in c.Rango(0, filas - 1):
    for n in c.Rango(0, 1):
        tercerLista[m][0] = mayorAMenor[m]

# Ejercicio 6
# Mostrar la Lista resultante por pantalla.

f.imprimir_lista(tercerLista, filas, 2)

# Ejercicio 7
# Finalmente sume los elementos de la columna 1 de la Lista del punto 5 y muestre el resultado de la sumatoria por pantalla.

print("\n")

sumatoriaListaPunto5 = f.calcular_sumatoria_columnas(tercerLista, filas, 1)


print(
    f"La sumatoria de la primera columna de la Lista anterior es: {int(sumatoriaListaPunto5[0])}"
)
