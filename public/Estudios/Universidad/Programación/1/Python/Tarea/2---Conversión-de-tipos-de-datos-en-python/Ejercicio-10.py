frase = input("Ingrese una frase: ")
Mon = int(
    input(
        "Ingrese 1 si la quiere convertir a mayuscula o 2 si quiere convertir a minuscula"
    )
)
if Mon == 1:
    print(frase.upper())
elif Mon == 2:
    print(frase.lower())
else:
    print("El valor ingresado no es valido")
