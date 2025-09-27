while True:
    lista1 = []
    lista2 = []
    print("Ingrese dos listas de la misma longitud.")
    while True:
        n = input("Ingrese un número (presione S para pasar a la siguiente lista): ")
        if n.upper() == "S":
            break
        lista1.append(int(n))
    while True:
        n = input("Ingrese un número (presione S para terminar de ingresar números): ")
        if n.upper() == "S":
            break
        lista2.append(int(n))
    if len(lista1) == len(lista2):
        break
    else:
        print("Las listas no tienen la misma longitud, deberá crearlas de nuevo.")

listaFinal = []

for i in range(0, len(lista1)):
    listaFinal.append(lista1[i] + lista2[i])

print(listaFinal)
