lista = []

while True:
    n = input("Ingrese un número (presione S para terminar de ingresar números): ")
    if n.upper() == "S":
        break
    lista.append(n)

l = len(lista)-1

for n in range(0,len(lista)):
    print(f"pasada {n}")
    print(f"{l}<{len(lista)-1} = {l < len(lista)-1}")
    if l > len(lista)-1:
        break
    for e in range(0,len(lista)):
        print(f"Para lista[{n}] = {lista[n]}: lista[{e}] = {lista[e]}    {e} == {n}: {lista[e] == lista[n]} & {e} != {n}: {e != n}")
        if lista[e] == lista[n] and e != n:
            print(f"Se borrará lista[{e}] = {lista[e]}")
            del lista[e]
            print(lista)

# lista = list(set(lista))

print(f"Lista final: {lista}")