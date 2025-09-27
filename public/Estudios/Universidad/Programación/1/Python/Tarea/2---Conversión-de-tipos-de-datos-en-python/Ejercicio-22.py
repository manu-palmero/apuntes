def suma(num):
    if num <= 1:
        return num
    else:
        return num % 10 + suma(num // 10)


num = input("Ingrese un numero: ")
suma = suma(int(num))
print("La suma es ", suma)
