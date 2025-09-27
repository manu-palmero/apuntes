class Rango:
    def __init__(self, inicio, fin):
        self.inicio = inicio
        self.fin = fin
        self.actual = inicio
    def __iter__(self):
        return self
    def __next__(self):
        if self.actual <= self.fin:
            valor = self.actual
            self.actual += 1
            return valor
        else:
            raise StopIteration
