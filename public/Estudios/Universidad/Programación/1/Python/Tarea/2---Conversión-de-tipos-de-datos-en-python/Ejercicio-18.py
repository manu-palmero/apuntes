"""
En la clase FuncionesPrograma codifique una método getFechaDate estática que
reciba como parámetro 3 valores enteros, día, mes, anio y retorne la fecha de tipo
date correspondiente.

En la clase Principal creada en el punto anterior haga uso de la función getFechaDate.
"""

from num2words import num2words


def diaExisteEnMes(d, m, a) -> bool:
    """Función para comprobar la existencia de un día dentro de un mes determinado

    Argumentos:
        d: día
        m: mes
        a: año

    Devuelve:
        bool: Existe el día (True) o no (False)
    """
    d = int(d)
    m = int(m)
    a = int(a)
    match m:
        case 1 | 3 | 5 | 7 | 8 | 10 | 12:
            dias = 31
        case 4 | 6 | 9 | 11:
            dias = 30
        case 2:
            if a % 4 == 0 and (a % 100 != 0 or a % 400 == 0):
                dias = 29
            else:
                dias = 28
    return 1 <= d <= dias


class Principal:

    def __init__(self, dia, mes, anio) -> None:
        self.d, self.m, self.a = dia, mes, anio

    def main(self):
        fechaStr = FuncionesPrograma.getFechaDate(self.d, self.m, self.a)
        print(fechaStr)


class FuncionesPrograma:
    @staticmethod
    def getFechaDate(dia, mes, anio):
        if 1 <= mes <= 12:
            if diaExisteEnMes(dia, mes, anio):
                if dia < 10:
                    dia = f"0{dia}"
            else:
                return f"No existe el día {dia} en el {num2words(mes, ordinal=True, lang='es')} mes"
            if mes < 10:
                mes = f"0{mes}"
        else:
            return f"No existe el mes {mes}"
        match anio:
            case x if anio <= x < 10:
                anio = f"000{anio}"
            case x if anio <= x < 100:
                anio = f"00{anio}"
            case x if anio <= x < 1000:
                anio = f"0{anio}"
        return f"{dia}/{mes}/{anio}"

    @staticmethod
    def getFechaString(f) -> str:
        """Función que expresa una fecha dada en formato DD/MM/AAAA como una fecha en palabras

        Argumentos:
            f (str): Fecha dada
        """
        if f[2] == "/" and f[5] == "/" and len(f) == 10:
            dd: str = f[0:2]
            mm: str = f[3:5]
            aaaa: str = f[6:10]

            if 1 <= int(mm) <= 12:
                m = meses[mm]
            else:
                return f"{mm} no es un mes."

            if diaExisteEnMes(dd, mm, aaaa):
                if dd == "01":
                    d = "Primero"
                else:
                    d = num2words(dd, lang="es")
            else:
                return f"No existe el día {dd} en {m}"
            d = d.capitalize()
            m = m.capitalize()
            a = num2words(aaaa, lang="es")

            return f"{d} de {m} de {a}."
        else:
            return f"{f} no está en formato DD/MM/AAAA."


d = int(input("Ingrese un día: "))
m = int(input("Ingrese un mes: "))
a = int(input("Ingrese un mes: "))
pri = Principal(d, m, a)
pri.main()
