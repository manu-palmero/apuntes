from datetime import date


class FuncionesPrograma:
    @staticmethod
    def getFechaString(fecha):
        # Diccionarios para convertir números a palabras
        dias = {
            "01": "Uno",
            "02": "Dos",
            "03": "Tres",
            "04": "Cuatro",
            "05": "Cinco",
            "06": "Seis",
            "07": "Siete",
            "08": "Ocho",
            "09": "Nueve",
            "10": "Diez",
            "11": "Once",
            "12": "Doce",
            "13": "Trece",
            "14": "Catorce",
            "15": "Quince",
            "16": "Dieciséis",
            "17": "Diecisiete",
            "18": "Dieciocho",
            "19": "Diecinueve",
            "20": "Veinte",
            "21": "Veintiuno",
            "22": "Veintidós",
            "23": "Veintitrés",
            "24": "Veinticuatro",
            "25": "Veinticinco",
            "26": "Veintiséis",
            "27": "Veintisiete",
            "28": "Veintiocho",
            "29": "Veintinueve",
            "30": "Treinta",
            "31": "Treinta y uno",
        }

        meses = {
            "01": "Enero",
            "02": "Febrero",
            "03": "Marzo",
            "04": "Abril",
            "05": "Mayo",
            "06": "Junio",
            "07": "Julio",
            "08": "Agosto",
            "09": "Septiembre",
            "10": "Octubre",
            "11": "Noviembre",
            "12": "Diciembre",
        }

        unidades = {
            "0": "cero",
            "1": "uno",
            "2": "dos",
            "3": "tres",
            "4": "cuatro",
            "5": "cinco",
            "6": "seis",
            "7": "siete",
            "8": "ocho",
            "9": "nueve",
        }

        decenas = {
            "10": "diez",
            "11": "once",
            "12": "doce",
            "13": "trece",
            "14": "catorce",
            "15": "quince",
            "16": "dieciséis",
            "17": "diecisiete",
            "18": "dieciocho",
            "19": "diecinueve",
            "20": "veinte",
            "30": "treinta",
            "40": "cuarenta",
            "50": "cincuenta",
            "60": "sesenta",
            "70": "setenta",
            "80": "ochenta",
            "90": "noventa",
        }

        centenas = {
            "100": "cien",
            "200": "doscientos",
            "300": "trescientos",
            "400": "cuatrocientos",
            "500": "quinientos",
            "600": "seiscientos",
            "700": "setecientos",
            "800": "ochocientos",
            "900": "novecientos",
        }

        # Dividir la fecha en día, mes y año
        dia, mes, año = fecha.split("/")

        # Convierto el año a palabras
        año_palabras = []
        if año[0] == "1":
            año_palabras.append("mil")
            año = año[1:]
        elif año[0] == "2":
            año_palabras.append("dos mil")
            año = año[1:]

        if año:
            if len(año) == 3:
                if año[0] != "0":
                    año_palabras.append(centenas[año[0] + "00"])
                año = año[1:]
            if len(año) == 2:
                if año[0] != "0":
                    if año[0] == "1":
                        año_palabras.append(decenas[año])
                        año = ""
                    else:
                        año_palabras.append(decenas[año[0] + "0"])
                        año = año[1:]
            if len(año) == 1:
                if año[0] != "0":
                    año_palabras.append(unidades[año[0]])

        año_palabras = " ".join(año_palabras)

        # Construir la cadena final
        fecha_literal = f"{dias[dia]} de {meses[mes]} de {año_palabras}"
        return fecha_literal

    @staticmethod
    def getFechaDate(dia, mes, año):
        return date(año, mes, dia)


class Principal:
    @staticmethod
    def main():
        fecha = input("Ingrese una fecha con el siguiente formato: dd/mm/aaaa\n")
        fecha_literal = FuncionesPrograma.getFechaString(fecha)
        print(fecha_literal)
        dia = int(input("Ingrese el dia: "))
        mes = int(input("Ingrese el mes: "))
        año = int(input("Ingrese el año: "))
        fecha_date = FuncionesPrograma.getFechaDate(dia, mes, año)
        print(fecha_date)


# Ejecutar el método main de la clase Principal
Principal.main()
