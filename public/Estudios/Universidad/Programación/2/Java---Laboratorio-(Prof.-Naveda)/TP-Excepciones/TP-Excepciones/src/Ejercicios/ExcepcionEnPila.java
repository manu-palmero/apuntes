package Ejercicios;

// Cree un programa que lance una excepción
// a través de una pila de llamada de métodos
// de longitud cuatro.
// El último método debe manejar la excepción.

public class ExcepcionEnPila {
    public static void main(String[] args) { metodo1(); }
    static void metodo1() { metodo2(); }
    static void metodo2() { metodo3(); }
    static void metodo3() { metodo4(); }
    static void metodo4() {
        try { lanzarExcepcion(); } catch (Exception e) {
            System.out.println("Excepción capturada en metodo4: " + e.getMessage());
            e.printStackTrace(); // Muestra la pila de llamadas
        }
    }
    static void lanzarExcepcion() { throw new RuntimeException("¡Algo salió mal!"); }
}
