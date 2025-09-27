# Pido la cantidad al usuario
cantidad = float(input("Ingrese la cantidad: "))

# Utilizo metodos matematicos como divisiones y modulos para saber cuantos billetes son necesarios
print(f"Cantidad de billetes de 200 necesarios: {cantidad//200}")
cantidad = cantidad % 200
print(f"Cantidad de billetes de 100 necesarios: {cantidad//100}")
cantidad = cantidad % 100
print(f"Cantidad de billetes de 50 necesarios: {cantidad//50}")
cantidad = cantidad % 50
print(f"Cantidad de billetes de 20 necesarios: {cantidad//20}")
cantidad = cantidad % 20
print(f"Cantidad de billetes de 10 necesarios: {cantidad//10}")
cantidad = cantidad % 10
print(f"Cantidad de billetes de 5 necesarios: {cantidad//5}")
cantidad = cantidad % 5
print(f"Cantidad de billetes de 2 necesarios: {cantidad//2}")
cantidad = cantidad % 2
print(f"Cantidad de billetes de 1 necesarios: {cantidad//1}")
cantidad = cantidad % 1
print(f"Cantidad de monedas de 0.50 necesarias: {cantidad//0.50}")
cantidad = cantidad % 0.50
print(f"Cantidad de monedas de 0.05 necesarias: {cantidad//0.049}")
