def num(frase):
    # .isdigit: sirve para ver si contiene numeros la frase o no.
    # Any: te larga V o F
    return any(a.isdigit() for a in frase)


frase = input("Introduzca una frase: ")
vof = num(frase)
if vof:
    print("Si contine numeros")
else:
    print("No contine numeros")
