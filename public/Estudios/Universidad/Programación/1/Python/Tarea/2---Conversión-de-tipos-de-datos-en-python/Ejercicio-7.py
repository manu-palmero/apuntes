def letras(frase):
    contador = 0
    for letra in frase:
        if letra.lower() in "aeiouAEIOU":
            contador += 1
    return contador


frase = input("Ingrese la frase: ")
vocales = letras(frase)
print(f"En la frase hay {vocales} en la frase ingresada")
