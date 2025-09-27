class Fraccion:
    def __init__(self, numerador, denominador):
        if denominador == 0:
            raise ValueError("El denominador no puede ser cero")
        self.numerador = numerador
        self.denominador = denominador

    def __str__(self):
        return f"{self.numerador}/{self.denominador}"

    @staticmethod
    def sumarFracciones(f1, f2):
        numerador = f1.numerador * f2.denominador + f2.numerador * f1.denominador
        denominador = f1.denominador * f2.denominador
        return Fraccion(numerador, denominador)

    @staticmethod
    def restarFracciones(f1, f2):
        numerador = f1.numerador * f2.denominador - f2.numerador * f1.denominador
        denominador = f1.denominador * f2.denominador
        return Fraccion(numerador, denominador)

    @staticmethod
    def multiplicarFracciones(f1, f2):
        numerador = f1.numerador * f2.numerador
        denominador = f1.denominador * f2.denominador
        return Fraccion(numerador, denominador)

    @staticmethod
    def dividirFracciones(f1, f2):
        if f2.numerador == 0:
            raise ValueError("No se puede dividir por una fracción con numerador cero")
        numerador = f1.numerador * f2.denominador
        denominador = f1.denominador * f2.numerador
        return Fraccion(numerador, denominador)


class OperacionesFraccion:
    @staticmethod
    def main():
        # Solicitar al usuario el ingreso de 4 valores numéricos enteros
        numerador1 = int(input("Ingrese el numerador de la primera fracción: "))
        denominador1 = int(input("Ingrese el denominador de la primera fracción: "))
        numerador2 = int(input("Ingrese el numerador de la segunda fracción: "))
        denominador2 = int(input("Ingrese el denominador de la segunda fracción: "))

        # Crear dos objetos Fracción
        fraccion1 = Fraccion(numerador1, denominador1)
        fraccion2 = Fraccion(numerador2, denominador2)

        # Ejecutar los métodos y mostrar los resultados
        suma = Fraccion.sumarFracciones(fraccion1, fraccion2)
        resta = Fraccion.restarFracciones(fraccion1, fraccion2)
        multiplicacion = Fraccion.multiplicarFracciones(fraccion1, fraccion2)
        division = Fraccion.dividirFracciones(fraccion1, fraccion2)

        print(f"Suma: {suma}")
        print(f"Resta: {resta}")
        print(f"Multiplicación: {multiplicacion}")
        print(f"División: {division}")


# Ejecutar el método main de la clase OperacionesFraccion
if __name__ == "__main__":
    OperacionesFraccion.main()
