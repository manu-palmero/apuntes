def plata(bille):
    bi200 = bi100 = bi50 = bi20 = bi10 = bi5 = bi2 = bi1 = 0
    mon05 = mon25 = mon10 = mon005 = 0
    if bille >= 200:
        bi200 = bille // 200
        bille %= 200
    if bille >= 100:
        bi100 = bille // 100
        bille %= 100
    if bille >= 50:
        bi50 = bille // 50
        bille %= 50
    if bille >= 20:
        bi20 = bille // 20
        bille %= 20
    if bille >= 10:
        bi10 = bille // 10
        bille %= 10
    if bille >= 5:
        bi5 = bille // 5
        bille %= 5
    if bille >= 2:
        bi2 = bille // 2
        bille %= 2
    if bille >= 1:
        bi1 = bille // 1
        bille %= 1
    if bille >= 0.50:
        mon05 = bille // 0.50
        bille %= 0.50
    if bille >= 0.25:
        mon25 = bille // 0.25
        bille %= 0.25
    if bille >= 0.10:
        mon10 = bille // 0.10
        bille %= 0.10
    if bille >= 0.05:
        mon005 = bille // 0.05
        bille %= 0.05

        # Imprimir resultados
    print(
        f"Billetes de 200: {bi200}\n Billetes de 100: {bi100}\n Billetes de 50: {bi50}\n Billetes de 20: {bi20}\n "
        f"Billetes de 10: {bi10}\n Billetes de 5: {bi5}\n Billetes de 2: {bi2}\n Billetes de 1: {bi1}\n "
        f"Monedas de 0.50: {mon05}\n Monedas de 0.25: {mon25}\n Monedas de 0.10: {mon10}\n Monedas de 0.05: {mon005}"
    )


canti = float(input("Cantidad de plata: "))
plata(canti)
