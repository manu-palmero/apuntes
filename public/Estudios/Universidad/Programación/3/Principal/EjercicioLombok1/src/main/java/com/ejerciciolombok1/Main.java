package com.ejerciciolombok1;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de Domicilio y Persona
        Domicilio miCasa = Domicilio.builder().calle("Calle Falsa").numero(123).build();
        Persona yo = Persona.builder().nombre("Juancito").edad(30).build();

        // Establecer la referencia en Domicilio
        yo.setDomicilio(miCasa);

        // Ahora, esta llamada funciona correctamente sin recursividad
        System.out.println(yo);
        System.out.println(miCasa.getResidente());

    }
}