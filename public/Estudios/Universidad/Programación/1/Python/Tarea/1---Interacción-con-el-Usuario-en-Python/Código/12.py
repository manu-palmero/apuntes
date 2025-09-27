# Existe la estructura "switch" en python, denominada "match", desde la versión 3.10

while True: # Comienza el bucle
    día = int(input("Ingrese un día de la semana (1-7): ")) # El usuario ingresa un día de la semana en forma de número
    if 1 <= día <= 7: # Si lo que ingresa el usuario está entre 1 y 7
        match día: # Se fija en la variable día
            # case x if 1 <= x <= 5: # Si la variable es del 1 al 5 utilizando if()
            case x if x in range(1,6): # Si la variable es del 1 al 5 utilizando range()
                print("Día laboral.") # Imprime
                break # Sale del bucle
            case 6 | 7: # Si la variable es 6 o 7
                print("Día no laboral.") # Imprime
                break # Sale del bucle