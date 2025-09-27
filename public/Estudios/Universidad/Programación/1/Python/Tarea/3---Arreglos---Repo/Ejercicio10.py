lista = []

while True:
    n = input("Ingrese un número (presione S para terminar de ingresar números): ")
    if n.upper() == "S":
        break
    lista.append(int(n))

while True:
    indices = []
    for i in range(0, len(lista)):
        indices.append(i)

    seleccion = input(
        f"""
Ingrese el número de índice del elemento que desea eliminar (presione S para salir):
          
    Lista:    {lista}
    Índices:  {indices}
        
    > """
    )
    if str(seleccion).upper() == "S":
        print(f"La lista final es: {lista}")
        break
    if int(seleccion) in range(0, len(lista)):
        del lista[int(seleccion)]
    if len(lista) == 0:
        print("Eliminó todos los elementos.")
        break
