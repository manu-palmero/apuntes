lista = []

while True:
    n = input("Ingrese un elemento (presione S para terminar de ingresar números): ")
    if n.upper() == "S":
        break
    lista.append(n)

setSinRepetidos = set(lista)

repetidos = {}

for n in setSinRepetidos:
    c = 0
    r = 0
    for e in lista:
        if e == n:
            c += 1
            r = e
    if c > 1:
        repetidos[r] = c

for i in repetidos:
    print(f"El número {i} se repite {repetidos[i]} veces.")
