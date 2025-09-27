package Ejercicios;

// Clase base
class ExcepcionBase extends Exception {
    public ExcepcionBase(String mensaje) {
        super(mensaje);
    }
}

// Subclase 1
class ExcepcionNivel1A extends ExcepcionBase {
    public ExcepcionNivel1A(String mensaje) {
        super(mensaje);
    }
}

// Subclase 2
class ExcepcionNivel1B extends ExcepcionBase {
    public ExcepcionNivel1B(String mensaje) {
        super(mensaje);
    }
}

public class Ejercicio6 {
    public static void lanzarExcepcion(int codigo) throws ExcepcionBase {
        if (codigo == 1) {
            throw new ExcepcionNivel1A("Error tipo A");
        } else if (codigo == 2) {
            throw new ExcepcionNivel1B("Error tipo B");
        } else {
            throw new ExcepcionBase("Error general");
        }

    }

    public static void manejarErrores(int codigo) {
        try {
            lanzarExcepcion(codigo);
        } catch (ExcepcionNivel1A e) {
            System.out.println("Manejando ExcepcionNivel1A: " + e.getMessage());
        } catch (ExcepcionNivel1B e) {
            System.out.println("Manejando ExcepcionNivel1B: " + e.getMessage());
        } catch (ExcepcionBase e) {
            System.out.println("Manejando ExcepcionBase: " + e.getMessage());
        }
    }
}
