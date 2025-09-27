class OperacionMatematica:
    def sumarNumeros(v1, v2):
        tot = v1 + v2
        print(f"La suma entre ambos valores es: {tot}")

    def restarNumeros(v1, v2):
        tot = v1 - v2
        print(f"La resta entre ambos valores es: {tot}")

    def multiplicarNumeros(v1, v2):
        tot = v1 * v2
        print(f"La multiplicacion entre ambos valores es: {tot}")

    def dividirNumeros(v1, v2):
        tot = v1 / v2
        print(f"La division entre ambos valores es: {tot}")

    def aplicarOperacion(opc, v1, v2):
        match opc:
            case "+":
                OperacionMatematica.sumarNumeros(v1, v2)
            case "-":
                OperacionMatematica.restarNumeros(v1, v2)
            case "*":
                OperacionMatematica.multiplicarNumeros(v1, v2)
            case "/":
                OperacionMatematica.dividirNumeros(v1, v2)
            case "0":
                exit()


class Principal:
    def main():
        opcion = 1
        valor1 = int(input("Ingrese el primer valor: "))
        valor2 = int(input("Ingrese el segundo valor: "))
        while opcion != 0:
            opcion = input(
                """"
                                   ===============================================================================
                                   =================================== MENU ======================================
                                   =                                                                             =
                                   =                       + - Sumar                                             =
                                   =                       - - Restar                                            =
                                   =                       / - Dividir                                           =
                                   =                       * - Multiplicar                                       =
                                   =                       0 - Salir                                             =
                                   =                                                                             =
                                   ===============================================================================
                                   """
            )
            OperacionMatematica.aplicarOperacion(opcion, valor1, valor2)


Principal.main()
