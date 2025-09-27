contraseña = "1234" # Declaración de variables
intentos = 3

while intentos >= 0: # Inicia el bucle
    entrada = str(input("Ingrese la contraseña: ")) # El usuario ingresa la contraseña
    intentos -= 1 # Resta uno a los intentos disponibles
    if entrada == contraseña: # Si la contraseña es correcta
        print("Acceso correcto.")
        break
    elif intentos > 0: # Si la contraseña es incorrecta y todavía le quedan intentos
        print(f"Acceso fallido, intente otra vez, {intentos} intentos restantes")
    else: # Si es incorrecta y no le quedan intentos
        print("El acceso se ha bloqueado después de tres intentos fallidos.")
        break