package Ejercicios;

public class Ejercicio5 {

    // Método que lanza intencionalmente tres tipos distintos de excepciones
    public static void lanzarExcepciones(int tipo) throws ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException {
        if (tipo == 1) {
            throw new ArithmeticException("División por cero");
        } else if (tipo == 2) {
            throw new NullPointerException("Referencia nula");
        } else if (tipo == 3) {
            throw new ArrayIndexOutOfBoundsException("Índice fuera de rango");
        }
    }

    // Método que captura las excepciones de forma anidada
    public static void capturarExcepciones(int tipo) {
        try {
            lanzarExcepciones(tipo);
        } catch (ArithmeticException e) {
            System.out.println("Se capturó ArithmeticException: " + e.getMessage());

            try {
                lanzarExcepciones(2); // Intenta provocar otra excepción
            } catch (NullPointerException e2) {
                System.out.println("Se capturó NullPointerException: " + e2.getMessage());

                try {
                    lanzarExcepciones(3); // Intenta provocar otra excepción
                } catch (ArrayIndexOutOfBoundsException e3) {
                    System.out.println("Se capturó ArrayIndexOutOfBoundsException: " + e3.getMessage());
                }

            }
        }
    }
}
