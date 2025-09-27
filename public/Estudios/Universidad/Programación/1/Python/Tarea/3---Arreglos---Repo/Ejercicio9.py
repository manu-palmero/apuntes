def verPrimo(lista):
    for elemento in lista:
        cont = 0
        for i in range(1, elemento + 1):
            if elemento % i == 0:
                cont += 1
        if cont > 2:
            print(f"El numero {elemento} NO es primo")
        if cont == 2:
            print(f"El numero {elemento} es primo")


rta = "s"
lista = []

while rta == "s":
    rta = input("Desea agregar un elemento? S/N")
    if rta == "s":
        elem = int(input("Ingrese el numero que desea agregar a la lista: "))
        lista.append(elem)
verPrimo(lista)
