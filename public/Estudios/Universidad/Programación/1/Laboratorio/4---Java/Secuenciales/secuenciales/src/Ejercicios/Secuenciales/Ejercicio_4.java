package Ejercicios.Secuenciales;

/*
Ejercicio 4: Generador de Listas de Reproducción
Escribe un programa que pida al usuario su estado de ánimo (feliz, triste, enérgico, relajado) y luego
genere una lista de reproducción con canciones sugeridas para ese estado de ánimo.
*/

import javax.swing.*;

public class Ejercicio_4 {
    public void ej4() {
        System.out.println("Ejercicio 4");
        String[] estados = {
                "feliz", "triste", "enérgico", "relajado"
        };
        String estado = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione su estado de ánimo para recomendarle canciones:",
                "Generador de Listas de Reproducción",
                JOptionPane.QUESTION_MESSAGE,
                null,
                estados,
                null
        );
        String lista;

        switch (estado) {
            case "feliz":
                lista = "Lista de canciones para cuando está feliz :)\n" +
                        "\"Don't Stop Me Now\" – Queen\n" +
                        "\"Here Comes the Sun\" – The Beatles\n" +
                        "\"Dancing in the Moonlight\" – Thin Lizzy";
                break;
            case "triste":
                lista = "Lista de canciones para cuando esté triste :(\n" +
                        "\"Wish You Were Here\" – Pink Floyd\n" +
                        "\"Yesterday\" – The Beatles\n" +
                        "\"Tears in Heaven\" – Eric Clapton";
                break;
            case "enérgico":
                lista = "Lista de canciones para cuando tenga mucha energía :D\n" +
                        "\"Back in Black\" – AC/DC\n" +
                        "\"Smells Like Teen Spirit\" – Nirvana\n" +
                        "\"Born to Be Wild\" – Steppenwolf";
                break;
            case "relajado":
                lista = "Lista de canciones para cuando esté relajado\n" +
                        "\"The Sound of Silence\" – Simon & Garfunkel\n" +
                        "\"Behind Blue Eyes\" – The Who\n" +
                        "\"Hotel California\" – Eagles";
                break;
            default:
                lista = "Estado de ánimo inválido";
        }
        JOptionPane.showMessageDialog(null, lista, "Lista de canciones para el estado de ánimo " + estado, JOptionPane.INFORMATION_MESSAGE);
    }
}
