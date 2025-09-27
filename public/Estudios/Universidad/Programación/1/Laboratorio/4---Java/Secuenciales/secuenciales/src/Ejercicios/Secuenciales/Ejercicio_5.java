package Ejercicios.Secuenciales;

/*
Ejercicio 5: Calculadora de Costo de Viaje
Escribe un programa que pida al usuario la distancia del viaje en kilómetros, el consumo de
combustible del vehículo en litros por kilómetro y el precio del combustible por litro, y luego
calcule e imprima el costo total del viaje.
*/

import javax.swing.*;

public class Ejercicio_5 {
    public void ej5() {
        System.out.println("Ejercicio 5");
        double costoTotal, respuesta;
        boolean vacio;

        JPanel ventana = new JPanel();
        ventana.setLayout(new BoxLayout(ventana, BoxLayout.Y_AXIS));

        JTextField precioCombustible = new JTextField();
        JTextField kilometrosRecorridos = new JTextField();
        JTextField consumoCombustible = new JTextField();

        ventana.add(new JLabel("Ingrese el precio por kilómetro:"));
        ventana.add(precioCombustible);
        ventana.add(new JLabel("Ingrese la cantidad de kilómetros a recorrer:"));
        ventana.add(kilometrosRecorridos);
        ventana.add(new JLabel("Ingrese el consumo del vehículo en litros por kilómetro:"));
        ventana.add(consumoCombustible);

        do {
            respuesta = JOptionPane.showConfirmDialog(null, ventana, "", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);


            if (precioCombustible.getText().isEmpty()) {
                vacio = true;
            } else if (kilometrosRecorridos.getText().isEmpty()) {
                vacio = true;
            } else if (consumoCombustible.getText().isEmpty()) {
                vacio = true;
            } else {
                vacio = false;
            }

        } while (respuesta == JOptionPane.CANCEL_OPTION || vacio);

        double km = Double.parseDouble(kilometrosRecorridos.getText());
        double cc = Double.parseDouble(consumoCombustible.getText()); // Litro por kilómetro
        double pc = Double.parseDouble(precioCombustible.getText()); // Precio por Km

        costoTotal = (km * cc) * pc;

        JOptionPane.showMessageDialog(null, "Su viaje costará $" + costoTotal, "Costo total del viaje", JOptionPane.INFORMATION_MESSAGE);
    }
}
