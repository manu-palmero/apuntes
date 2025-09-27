package Ejercicios.Secuenciales;

import javax.swing.*;

/*
Ejercicio 3: Generador de Rutinas de Ejercicio
Escribe un programa que pida al usuario su nivel de condición física (principiante, intermedio, avanzado)
y luego genere una rutina de ejercicio semanal con diferentes tipos de ejercicios y
duraciones.
*/


public class Ejercicio_3 {
    public void ej3() {
        System.out.println("Ejercicio 3");
        String programa = "";
        String[] condiciones = {
                "Principiante",
                "Intermedio",
                "Avanzado"
        };
        String condicion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el nivel de condición física que tiene:",
                "Condición Física",
                JOptionPane.QUESTION_MESSAGE,
                null,
                condiciones,
                null
        );
        switch (condicion) {
            case "Principiante":
                programa = "Programa principiante:\n" +
                        "Lunes: Fuerza (30 min) - Sentadillas, flexiones, elevaciones de talón, plancha.\n" +
                        "Martes: Cardio (20 min) - Caminata rápida.\n" +
                        "Miércoles: Flexibilidad (30 min) - Estiramientos.\n" +
                        "Jueves: Descanso activo.\n" +
                        "Viernes: Fuerza (30 min) - Puentes de glúteos, press de hombros, plancha lateral.\n" +
                        "Sábado: Cardio (20 min) - Bicicleta.\n" +
                        "Domingo: Descanso.";
                break;
            case "Intermedio":
                programa = "Programa intermiedio:\n" +
                        "Lunes: Fuerza (45 min) - Sentadillas, flexiones, peso muerto, plancha.\n" +
                        "Martes: Cardio (30 min) - Correr.\n" +
                        "Miércoles: Flexibilidad (30 min) - Yoga.\n" +
                        "Jueves: Descanso activo.\n" +
                        "Viernes: Fuerza (45 min) - Zancadas, press banca, remo, plancha lateral.\n" +
                        "Sábado: HIIT (30 min) - Intervalos de alta intensidad.\n" +
                        "Domingo: Descanso.\n";
                break;
            case "Avanzado":
                programa = "Programa avanzado:\n" +
                        "Lunes: Fuerza (60 min) - Sentadillas frontales, flexiones avanzadas, peso muerto, plancha.\n" +
                        "Martes: Cardio (45 min) - Correr a ritmo intenso.\n" +
                        "Miércoles: Flexibilidad (30 min) - Yoga avanzado.\n" +
                        "Jueves: Descanso activo.\n" +
                        "Viernes: Fuerza (60 min) - Zancadas con peso, press militar, remo, plancha lateral.\n" +
                        "Sábado: HIIT (45 min) - Circuito intenso.\n" +
                        "Domingo: Descanso.";
                break;
            default:
                break;
        }
        System.out.println(programa);
        JOptionPane.showMessageDialog(null, programa, "Programa", JOptionPane.INFORMATION_MESSAGE);
    }
}
