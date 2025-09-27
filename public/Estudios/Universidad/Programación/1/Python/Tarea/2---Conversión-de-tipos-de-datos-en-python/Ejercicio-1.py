SHORT_MIN = -32.768
SHORT_MAX = 32.767
LONG_MIN = -9223372036854775808
LONG_MAX = 9223372036854775807


def short(num):
    if SHORT_MIN <= num <= SHORT_MAX:
        print(f"Valor convertido a short: {int(num)}")
    else:
        print("El valor está fuera del rango de short.")


def long(num):
    if LONG_MIN <= num <= LONG_MAX:
        print(f"Valor convertido a long: {int(num)}")
    else:
        print("El valor esta fuera del rango de long.")


while True:
    valorDecimal = float(input("Ingrese un numero decimal: "))
    short(valorDecimal)
    print(f"Valor convertido a int: {int(valorDecimal)}")
    long(valorDecimal)
    print(f"Valor convertido a float: {float(valorDecimal)}")
