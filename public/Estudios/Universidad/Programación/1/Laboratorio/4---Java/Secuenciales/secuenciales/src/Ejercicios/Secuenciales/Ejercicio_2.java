package Ejercicios.Secuenciales;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/*
 * Ejercicio 2: Calculadora de Calorías Quemadas
 * Escribe un programa que pida al usuario su peso en kilogramos, la duración del ejercicio en
 * minutos y el tipo de ejercicio (correr, nadar, andar en bicicleta), y luego calcule e imprima las
 * calorías quemadas. Utiliza diferentes tasas de calorías quemadas por minuto para cada tipo de
 * ejercicio.
 * */

public class Ejercicio_2 {
    public void ej2() {
        System.out.println("Ejercicio 2");
        double peso, duracion, tasaEstandar, tasaAjustada;
        String ejercicio;

        String[] ejercicios = {
                "Correr", "Nadar", "Andar en bicicleta",
        };

        Map<String, Integer> calorias = new HashMap<>();
        calorias.put("Correr", 12);
        calorias.put("Nadar", 7);
        calorias.put("Andar en bicicleta", 8);

        peso = Double.parseDouble(JOptionPane.showInputDialog(
                null,
                "Ingrese el peso en kilogramos:",
                "Peso",
                JOptionPane.QUESTION_MESSAGE
        ));
        duracion = Double.parseDouble(JOptionPane.showInputDialog(
                null,
                "Ingrese el duración del ejercicio en minutos:",
                "Duración",
                JOptionPane.QUESTION_MESSAGE));
        ejercicio = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el ejercicio:",
                "Ejercicio",
                JOptionPane.QUESTION_MESSAGE,
                null,
                ejercicios,
                null
        );
        DecimalFormat df = new DecimalFormat("#.##");
        tasaEstandar = calorias.get(ejercicio) * duracion;
        tasaAjustada = (tasaEstandar * (peso / 70));
        String caloriasQuemadas = df.format(tasaAjustada);


        String mensaje = "Las calorías que se consumirán haciendo el ejercicio de " + ejercicio + " durante " + duracion + " minutos serán " + tasaEstandar + "\nAjustado a su peso serán " + caloriasQuemadas + " calorías.";
        JOptionPane.showMessageDialog(null, mensaje, "", JOptionPane.INFORMATION_MESSAGE);
    }
}
