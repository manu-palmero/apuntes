import Ejercicios.Ejercicio5;
import Ejercicios.Ejercicio6;

public class Main {
//    public static void main(String[] args) {
//        System.out.println("Ejercicio 5");
//
//        Ejercicio5.capturarExcepciones(1);
//        Ejercicio5.capturarExcepciones(4);
//
//        System.out.println("Ejercicio 6");
//        Ejercicio6.manejarErrores(1);
//        Ejercicio6.manejarErrores(2);
//        Ejercicio6.manejarErrores(4);
//
//        System.out.println("Ejercicio 7");
//        System.out.println(devuelveNumero(1));
//        System.out.println(devuelveNumero(2));

//    }

    public static int devuelveNumero(int num) {
        try {
            if (num % 2 == 0) {
                throw new Exception("Lanzando excepcion");
            }
            return 1;
        } catch (Exception ex) {
            return 2;
        } finally {
            return 3;
        }
    }

    public static void lanzarArithmeticException() {
        throw new ArithmeticException("Lanzando excepción AritmeticException");
    }

}
