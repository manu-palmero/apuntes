def rever(cadena):
    if len(cadena) == 0:
        return cadena
    else:
        return cadena[-1] + rever(cadena[:-1])


cadena = input("Ingrese una frase: ")
tex = rever(cadena)
print(f"El texto al inverso es: {tex}")
