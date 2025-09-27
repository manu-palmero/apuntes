lista = input("Ingresa una lista de numeros separados por comas: ")
lista = lista.split(",")
# Convierto los elementos de la lista a enteros
lista = [int(lista) for lista in lista]
pares = [x for x in lista if x % 2 == 0]
impares = [x for x in lista if x % 2 != 0]
print(f"Pares: {len(pares)}")
print(f"Impares: {len(impares)}")
