import random

a = random.randint(0, 100) # Genera un número entero aleatorio entre 1 y 100
i = 1 # Contador de intentos 

while True:
    n = int(input("Adivine el número entero aleatorio entre 0 y 100: ")) # Pide al usuario el número
    if n > a:
        print("Muy grande.")
        i += 1
    if n < a:
        print("Muy pequeño.")
        i += 1
    if n == a:
        print(f"Número correcto! Acertado en {i} intentos")
        break