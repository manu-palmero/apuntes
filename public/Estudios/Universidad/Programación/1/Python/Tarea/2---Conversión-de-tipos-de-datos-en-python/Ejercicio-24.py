def tex(cadena, indice=0):
    if indice == len(cadena):
        return
    else:
        print(cadena[indice])
    tex(cadena, indice + 1)


cadena = input("ingrese una cadena: ")
tex(cadena)
