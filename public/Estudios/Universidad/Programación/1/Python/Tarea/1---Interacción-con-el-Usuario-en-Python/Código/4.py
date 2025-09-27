n1 = 2 # crea una variable y almacena el numero 2
n2 = -2 # crea una variable y almacena el número -2
igual = False # crea una variable y almacena el valor de falso, será usada para control de flujo

if n1 < n2: # comprueba si es verdadero o falso
    mayor = n2 # si n2 es mayor, la variable correspondiente se asignará a cada uno
    menor = n1
elif n1 > n2: # si n2 no es mayor que n1 pero n1 es mayor que n2, entonces procedera a lo siguiente:
    mayor = n1
    menor = n2
else: # si no se cumplen las condiciones anteriores, es que los dos números son iguales
    igual = True # se cambia el valor de la variable de control para cambiar el flujo de ka siguiente parte

if igual: # si los números son iguales
    print("Son iguales")
else: # pero si son diferentes
    print(f"{mayor} es mayor que {menor}") # imprime una cadena de texto diciendo cuál es mayor 