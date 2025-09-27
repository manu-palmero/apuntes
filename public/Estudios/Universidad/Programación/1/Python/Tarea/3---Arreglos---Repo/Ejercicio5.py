lista = []

while True:
    n = input("Ingrese un número (presione S para terminar de ingresar números): ")
    if n.upper() == "S":
        break
    try:
        lista.append(float(n))
    except TypeError as e:
        print(f"{e}, no es un número")
    except ValueError as e:
        print(f"{e}, no es un número")

multiplicador = float(input("Ingrese un número por el que multiplicar los valores: "))

for i in range(0, len(lista)):
    lista[i] = lista[i] * multiplicador

print(f"La lista final es {lista}")
