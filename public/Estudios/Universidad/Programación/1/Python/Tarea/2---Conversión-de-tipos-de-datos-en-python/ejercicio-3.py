
num = int(input("Ingrese un numero de tres digitos: "))

# Suma de sus digitos con operaciones matematicas
sumaDeDigitos = 0
for i in range(0, 3):
    sumaDeDigitos = sumaDeDigitos + num % 10
    num = num // 10

# Imprimo el resultado
print(f"La suma de sus digitos es {sumaDeDigitos}")
