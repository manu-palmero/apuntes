semana_laboral = { # Se define el diccionario con los días laborales y no laborales con su número correspondiente
    1: "Laboral",
    2: "Laboral",
    3: "Laboral",
    4: "Laboral",
    5: "Laboral",
    6: "No laboral",
    7: "No laboral",
}

while True: # Inicia el bucle
    día = int(input("Ingrese un día de la semana (1-7): ")) # Pide al usuario el día de la semana
    if 1 <= día <= 7: # Si el número ingresado está entre el 1 y el 7
        print(semana_laboral[día]) # Busca el número que el usuario ingresó dentro del diccionario e imprime el valor correspondiente
        break # Sale del bucle