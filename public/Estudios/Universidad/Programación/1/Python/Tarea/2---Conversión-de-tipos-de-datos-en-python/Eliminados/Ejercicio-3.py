#Codifique un algoritmo que solicite el ingreso de un numero de 3 dígitos (100 - 999)
#y por medio del uso de las operaciones matemáticas módulo 10 y división por 10
#efectué la suma de los 3 dígitos del número. Ejemplo ingreso 563, salida del algoritmo
#14. Plantee el algoritmo planteando métodos para su resolución.

numero = int(input("Ingrese un numero que este entre 100 y 999:" )); 

numero1 = numero % 10; 
numero = numero // 10; 

numero2 = numero % 10; 
numero = numero // 10; 

numero3 = numero % 10; 

sumaNumeros = numero1 + numero2 + numero3; 

print( "La suma de los tres digitos es: ", sumaNumeros); 


#AHORA DEBERIA FUNCIONAR 
