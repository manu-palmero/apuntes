def suma(num):
    if num <= 1:
        return num
    else:
        return num + suma(num - 1)


num = input("Ingrese un numero entero: ")
suma = suma(int(num))
print(suma)
