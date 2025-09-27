try: # no exigido en la materia, mas es útil para aclarar errores en el ingreso de variables por el usuario
    n = float(input("Ingrese un número: ")) # pide al usuario que ingrese un número para almacenarlo en una variable
except ValueError: # si el usuario ingresa algo que no sea un número, le dara advertencia del error
    print("No es un número.")
else: # si el usuario ingresa un número, procederá a lo siguiente
    if n % 2 == 0: # si el resto del cociente entre el número ingresado y 2 es 0
        print("Es divisible por 2.")
    else: # pero si es diferente de cero
        print("No es divisibl por 2.")