lista = []

while True:
    n = input("Ingrese un elemento (presione S para terminar de ingresar números): ")
    if n.upper() == "S":
        break
    lista.append(n)

listaInvertida = lista[::-1]

# listaInvertida = lista.reverse()

print(listaInvertida)
