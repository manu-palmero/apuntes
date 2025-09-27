class Persona:
    def __init__(self):
        pass
    def __init_subclass__(cls):
        pass

def deco(funcion):
    def mod():
        print("Algo antes")
        funcion()
        print("Algo después")
    return mod

def repetir(funcion):
    def rep():
        while True:
            try: funcion()
            except: print("Error"); pass
            else: break
    return rep

@repetir
@deco
def pedir_dato():
    return int(input())

hola = pedir_dato()