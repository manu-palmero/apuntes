package com.manuel_palmero.tp1;

import com.manuel_palmero.tp1.Cajero.Cajero_automatico;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Cajero_automatico cajero = new Cajero_automatico(23, false, " no se que va a acá ");
        cajero.procesar_pedido();
        cajero.pago(21);
        cajero.pago(42);
        Cajero_automatico cajero2 = new Cajero_automatico(23, true, " no se que va a acá ");
        cajero2.procesar_pedido();
        cajero2.pago(21);
        cajero2.pago(42);
    }
}