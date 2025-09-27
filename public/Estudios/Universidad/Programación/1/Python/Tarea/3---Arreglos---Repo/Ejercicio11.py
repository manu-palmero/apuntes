lista = []

while True:
    n = input("Ingrese un número (presione S para terminar de ingresar números): ")
    if n.upper() == "S":
        break
    lista.append(int(n))

num = int(input("Ingrese un número para buscarlo en la lista: "))
contador = 0

for n in lista:
    if num == n:
        contador += 1

print(f"El número {num} se repite {contador} veces")
