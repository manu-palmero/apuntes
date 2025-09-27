lista=input("Ingrese una lista de numeros separados por comas: ")
lista=lista.split(",")

#Conversion a entero
lista=[int(lista) for lista in lista]

print(f"Numero mayor: {max(lista)}")
print(f"Numero menor: {min(lista)}")