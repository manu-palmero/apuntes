lista = []

while True:
    n = input("Ingrese un número (presione S para terminar de ingresar números): ")
    if n.upper() == "S":
        break
    lista.append(float(n))

promedio = sum(lista) / len(lista)

print(promedio)