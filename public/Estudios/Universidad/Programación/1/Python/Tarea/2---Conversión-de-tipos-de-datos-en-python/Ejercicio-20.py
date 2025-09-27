from dataclasses import dataclass


class Fraccion:
    def __init__(self, n1, n2):
        self.num = n1
        self.den = n2

    def __str__(self):
        return f"{self.num}/{self.den}"

    @staticmethod
    def sumarFraccion(f1, f2):
        numerador = f1.num * f2.den + f2.num * f1.den
        denominador = f1.den * f2.den
        return Fraccion(numerador, denominador)

    def restarFraccion(f1, f2):
        numerador = f1.num * f2.den - f2.num * f1.den
        denominador = f1.den * f2.den
        return Fraccion(numerador, denominador)

    def multiplicarFraccion(f1, f2):
        numerador = f1.num * f2.num
        denominador = f1.den * f2.den
        return Fraccion(numerador, denominador)

    def dividirFraccion(f1, f2):
        numerador = f1.num * f2.den
        denominador = f1.den * f2.num
        return Fraccion(numerador, denominador)


class Principal:
    def main():
        n1 = int(input("Ingrese el numerador de la primer fraccion: "))
        d1 = int(input("Ingrese el denominador de la primer fraccion: "))
        n2 = int(input("Ingrese el numerador de la segunda fraccion: "))
        d2 = int(input("Ingrese el denominador de la segunda fraccion: "))
        f1 = Fraccion(n1, d1)
        f2 = Fraccion(n2, d2)
        suma = Fraccion.sumarFraccion(f1, f2)
        resta = Fraccion.restarFraccion(f1, f2)
        mult = Fraccion.multiplicarFraccion(f1, f2)
        div = Fraccion.dividirFraccion(f1, f2)
        print(
            f"La suma de las fracciones es: {suma}\nLa resta de las fracciones es: {resta}\nLa multiplicacion entre las fracciones es: {mult}\nLa division entre las fracciones es: {div}"
        )


Principal.main()
