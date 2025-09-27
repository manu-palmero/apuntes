package Ejercicios.Secuenciales;

import javax.swing.JOptionPane;

/*
 * Ejercicio 1: Generador de Horóscopo
 * Escribe un programa que pida al usuario su fecha de nacimiento (en formato DD/MM/AAAA) y luego
 * imprima su signo del zodiaco y un mensaje de horóscopo correspondiente.
 */

public class Ejercicio_1 {
    public void ej1() {
        System.out.println("Ejercicio 1");
        String date;
        String[] date_arr;
        int day, month, year;
        boolean l, d, m;
        do {
            do {
                date = JOptionPane.showInputDialog(null, "Ingrese su fecha de nacimiento", "Fecha de nacimiento", JOptionPane.QUESTION_MESSAGE);
                date_arr = date.split("/");
                l = date_arr.length == 3;
                if (!l) {
                    JOptionPane.showMessageDialog(null, "Fecha incompleta", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (!l);

            day = Integer.parseInt(date_arr[0]);
            month = Integer.parseInt(date_arr[1]);
            year = Integer.parseInt(date_arr[2]);

            m = month <= 12 && month > 0;
            if (!m) {
                JOptionPane.showMessageDialog(null, "Mes incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            }
            d = diaEnMes(day, month, year);
            if (!d) {
                JOptionPane.showMessageDialog(null, "Día incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!d || !m);
        String signo = zodiaco(day, month);
        String mensaje = mensaje_zodiaco(signo);
        JOptionPane.showMessageDialog(null, mensaje, "Tu signo es " + signo, JOptionPane.INFORMATION_MESSAGE);

    }

    public static boolean diaEnMes(int day, int month, int year) {
        int days = 0;
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                days = 31;
                break;
            case 4, 6, 9, 11:
                days = 30;
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    days = 29;
                }
                break;
            default:
                days = 28;
        }
        return 1 <= day && day <= days;
    }

    public static String zodiaco(int day, int month) {
        String signo = "";
        if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) {
            signo = "Aries";
        } else if (month == 4 || (month == 5 && day <= 20)) {
            signo = "Tauro";
        } else if (month == 5 || (month == 6 && day <= 20)) {
            signo = "Géminis";
        } else if (month == 6 || (month == 7 && day <= 22)) {
            signo = "Cáncer";
        } else if (month == 7 || (month == 8 && day <= 22)) {
            signo = "Leo";
        } else if (month == 8 || (month == 9 && day <= 22)) {
            signo = "Virgo";
        } else if (month == 9 || (month == 10 && day <= 22)) {
            signo = "Libra";
        } else if (month == 10 || (month == 11 && day <= 21)) {
            signo = "Esorpio";
        } else if (month == 11 || (month == 12 && day <= 21)) {
            signo = "Sagitario";
        } else if (month == 12 || (month == 1 && day <= 19)) {
            signo = "Capricornio";
        } else if (month == 1 || (month == 2 && day <= 18)) {
            signo = "Acuario";
        } else if (month == 2 || month == 3) {
            signo = "Picsis";
        }
        return signo;
    }

    public static String mensaje_zodiaco(String signo) {
        return switch (signo) {
            case "Aries" -> ("Eres valiente y lleno de energía.");
            case "Tauro" -> ("La estabilidad y la lealtad son tus mayores virtudes.");
            case "Géminis" -> ("Tienes una mente curiosa y adaptable.");
            case "Cáncer" -> ("Eres muy emocional y cariñoso.");
            case "Leo" -> ("El carisma y la creatividad te definen.");
            case "Virgo" -> ("Tu atención al detalle es impresionante.");
            case "Libra" -> ("La búsqueda de la armonía y la justicia es lo tuyo.");
            case "Escorpio" -> ("Eres intenso y apasionado.");
            case "Sagitario" -> ("La aventura y la independencia son tus señas de identidad.");
            case "Capricornio" -> ("Eres ambicioso y disciplinado.");
            case "Acuario" -> ("Tu pensamiento innovador y humanitario te destaca.");
            case "Picsis" -> ("Eres muy sensible y tienes una gran imaginación.");
            default -> "";
        };
    }
}
