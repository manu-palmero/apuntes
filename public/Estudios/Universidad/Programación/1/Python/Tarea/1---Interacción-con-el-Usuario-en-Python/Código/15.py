def cadenaPositivaDeUnNum(
    n: int,
):  # Función que devuelve una cadena que contiene un número positivo a pesar de que sea negativo, se utilizará para contar la cantidad de caracteres sin que moleste el signo
    c: str
    if n < 0:
        n = n + (-n * 2)
        c = str(n)
    else:
        c = str(n)
    return n, c


def dos(
    n: int,
) -> bool:  # Función que comprueba si el número ingresado es divisible por
    if n % 2 == 0:
        return True
    else:
        return False


def tres(
    n: int,
) -> bool:  # Función que comprueba si el número ingresado es divisible por tres
    n, c = cadenaPositivaDeUnNum(n)
    l = len(c)
    a = 0
    for i in range(0, l):
        a = a + int(c[i])
    if a % 3 == 0:
        return True
    else:
        return False


def cinco(
    n: int,
) -> bool:  # Función que comprueba si el número ingresado es divisible por cinco
    c = str(n)
    n = int(c[-1])
    if n == 0 or n == 5:
        return True
    else:
        return False


def seis(
    n: int,
) -> bool:  # Función que comprueba si el número ingresado es divisible por seis
    if dos(n) and tres(n):
        return True
    else:
        return False


def nueve(
    n: int,
) -> bool:  # Función que comprueba si el número ingresado es divisible por nueve
    n, c = cadenaPositivaDeUnNum(n)
    l = len(c)
    a = 0
    for i in range(0, l):
        a = a + int(c[i])
    if a == 9 or a % 9 == 0:
        return True
    else:
        return False


def diez(
    n: int,
) -> bool:  # Función que comprueba si el número ingresado es divisible por diez
    n = int(str(n)[-1])
    if n == 0:
        return True
    else:
        return False


while True: # Bucle para que ingrese sí o sí un número entero
    try:
        n = int(input("Ingrese un número entero: "))
    except ValueError: # Si no es un número entero
        print("No es un número entero.")
    else:
        break # Si ingresa el número y es entero sale del bucle

# Definición de variables que contendrán los valores booleanos de los criterios de divisibilidad
c2 = dos(n)
c3 = tres(n)
c5 = cinco(n)
c6 = seis(n)
c9 = nueve(n)
c10 = diez(n)

# Lista y diccionario utilizados solo para el formato del texto final
cl = [2, 3, 5, 6, 9, 10]
cd = {
    2: c2,
    3: c3,
    5: c5,
    6: c6,
    9: c9,
    10: c10,
}
cc = []

# Bucle que añade los criterios de divisibilidad cumplidos a una lista vacía
for i in cl:
    if cd[i]:
        cc.append(i)

# Condición usada para el formato del texto final, formatea la salida de acuerdo a si será un solo número o más de uno
# Si es más de un dígito
if len(cc) > 1:
    # Corta el último elemento de la lista y lo añade a una cadena que contiene una "y"
    ccu = f"y {cc.pop()}" 
    # Formatea los elementos de la lista de criterios de divisibilidad cumplidos de modo que 
    # queden en formato de cadena cada elemento con map(), y unirlos en una sola cadena 
    # separados por una coma con join()
    ccs = ", ".join(map(str, cc)) 
    # Une los elementos separados por una coma con el elemento final que contiene la "y"
    ccs = f"{ccs} {ccu}"
else: # Si es un solo criterio cumplido
    ccs = str(cc[0])

salida = f"El número {n} es divisible por {ccs}." # Asigna a una variable la salida final con los criterios de divisibilidad cumplidos por el número ingresado

print(salida)
