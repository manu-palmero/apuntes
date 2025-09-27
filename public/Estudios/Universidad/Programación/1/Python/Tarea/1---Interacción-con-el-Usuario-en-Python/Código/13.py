from math import sqrt # Función de raíz cuadrada

def primo(n) -> bool: # Función para determinar si un número es primo que devuelve un valor booleano
    if n <= 1: # Los números por debajo del 1 y el mismo 1 no son primos
        return False
    r = int(sqrt(n)) # r es el resultado truncado de la raíz cuadrada de la entrada de la función
    for i in range(2,r+1): # Para cada número entre 2 y r, puesto como +1 para que funcione correctamente con la función rage()
        if n % i == 0: # Si encuentra divisores entre estos números entonces no es primo, devuelve Flase
            return False
    return True # Por defecto devuelve True

n = int(input("Ingrese un número entero: ")) # Pide al usuario un número entero

if primo(n): # Comprueba el resultado de la función primo()
    print(f"El número {n} es primo.")
else:
    print(f"El número {n} no es primo.")