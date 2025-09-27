lista = input("Ingresa una lista de numeros separados por comas: ")
lista = lista.split(",")
# Convierto los elementos de la lista a enteros
lista = [int(lista) for lista in lista]
lista = set(lista)
print(lista)
