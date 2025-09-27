lista = []

while True:
    n = input("Ingrese un número (presione S para terminar): ")
    if n.upper() == "S":
        break
    lista.append(float(n))
    
suma = sum(lista)
print(suma)