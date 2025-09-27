package Ejercicios.Secuenciales;

import javax.swing.*;
import java.text.DecimalFormat;

/*
Ejercicio 7: Calculadora de Índice de Felicidad
Escribe un programa que pida al usuario varios factores de felicidad (nivel de satisfacción con la
vida, nivel de estrés, nivel de salud, etc.) en una escala del 1 al 10 y luego calcule e imprima un
índice de felicidad basado en esos factores.
*/


public class Ejercicio_7 {
    public void ej7() {
        System.out.println("Ejercicio 7");
        JPanel panel = new JPanel(); // Crea un panel
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Establece que la disposición de los elementos de dicho panel sea vertical (eje Y)

        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Crea cajas de selección
        JComboBox<Integer> satisfaccion = new JComboBox<>(nums);
        JComboBox<Integer> estres = new JComboBox<>(nums);
        JComboBox<Integer> salud = new JComboBox<>(nums);

        // Añade elementos al panel
        panel.add(new JLabel("Seleccione del 1 al 10 qué tan satisfecho está con su vida:"));
        panel.add(satisfaccion);
        panel.add(new JLabel("Seleccione del 1 al 10 qué tan estresado se siente en su vida:"));
        panel.add(estres);
        panel.add(new JLabel("Seleccione del 1 al 10 qué tal está su salud:"));
        panel.add(salud);

        int respuesta = JOptionPane.showConfirmDialog(null, panel, "Calculadora de Índice de Felicidad", JOptionPane.OK_CANCEL_OPTION);
        int indiceSatisfaccion = nums[satisfaccion.getSelectedIndex()];
        int indiceEstres = nums[estres.getSelectedIndex()];
        int indiceSalud = nums[salud.getSelectedIndex()];

        double[] indice = {indiceSatisfaccion, 11-indiceEstres, indiceSalud};

        DecimalFormat df = new DecimalFormat("#.##");
        String indiceTotal = df.format(promedio(indice));

        if (respuesta != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Se canceló la operacion");
        } else {
            JOptionPane.showMessageDialog(null, "Su índice de felicidad es " + indiceTotal, "Índice de felicidad calculado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static double promedio(double[] nums) {
        double sum = 0;
        for (double num : nums) {
            sum += num;
        }
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
        return sum / nums.length;
    }
}
