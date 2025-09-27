# Cree una clase OperacionMatematica con dos atributos valor1 y valor2 y un atributo de nombre operación.
class OperacionMatematica:
    def __init__(self, num1, num2):
        self.num1 = num1
        self.num2 = num2

    def suma(self):
        return self.num1 + self.num2

    def resta(self):
        return self.num1 - self.num2

    def multiplicacion(self):
        return self.num1 * self.num2

    def division(self):
        return self.num1 / self.num2


num1 = int(input("Ingrese el primer numero: "))
num2 = int(input("Ingrese el segundo numero: "))

cuentas = OperacionMatematica(num1, num2)
print("Suma: ", OperacionMatematica.suma(cuentas))
print("Resta: ", OperacionMatematica.resta(cuentas))
print("Multiplicacion", OperacionMatematica.multiplicacion(cuentas))
print("Division", OperacionMatematica.division(cuentas))
