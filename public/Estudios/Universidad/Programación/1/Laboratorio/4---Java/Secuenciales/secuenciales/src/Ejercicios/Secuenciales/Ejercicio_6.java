package Ejercicios.Secuenciales;

/*
Ejercicio 6: Generador de Planes de Estudio
Escribe un programa que pida al usuario cuántas horas al día puede estudiar y luego genere un
plan de estudio semanal distribuyendo esas horas en diferentes materias.
*/

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.*;

public class Ejercicio_6 {
    public void ej6() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        System.out.println("Ejercicio 6");
        Random rand = new Random();
        String[] materias = {
                "Matemática",
                "Lengua",
                "Sistemas Operativos",
                "Filosofía",
                "Historia",
        };
        String[] dias = {
                "Lunes",
                "Martes",
                "Miércoles",
                "Jueves",
                "Viernes",
                "Sábado",
                "Domingo",
        };
        Map<String, String[][]> plan = new HashMap<>();
        double horas = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad de horas que puede estudar a la semana: ", "Generador de plan de estudios", JOptionPane.QUESTION_MESSAGE));
        System.out.println("Generador de plan de estudios");

        for (String dia : dias) {
            panel.add(new JLabel(" "));
            panel.add(new JLabel("\n" + dia));
            double h = horas / materias.length / 5.6;
            if (dia.equals("Domingo")) {
                panel.add(new JLabel("Descanso"));
                continue;
            }
            if (dia.equals("Sábado")) {
                int[] l = {0, 0, 0};
                int a, b, c;
                do {
                    for (int i = 0; i < 3; i++) {
                        l[i] = rand.nextInt(materias.length);
                    }
                } while (l[0] == l[1] || l[1] == l[2] || l[2] == l[0]);

                for (int j : l) {
                    panel.add(new JLabel(materias[j] + ": " + decimal_a_hora(h)));
                }
                continue;
            }
            for (String materia : materias) {
                panel.add(new JLabel(materia + ": " + decimal_a_hora(h) + "\n"));
            }
        }
        JOptionPane.showMessageDialog(null, panel);
    }

    public static String decimal_a_hora(double horas) {
        DecimalFormat df = new DecimalFormat("#");

        int h = (int) horas;
        double md = Math.round((horas - h) * 100.0) / 100.0;
        int m = (int) (md * 60);

        return h + " horas y " + m + " minutos.";
    }
}
