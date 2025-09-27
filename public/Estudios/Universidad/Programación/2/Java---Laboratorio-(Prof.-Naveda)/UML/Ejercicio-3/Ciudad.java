public class Ciudad {
    String nombre;
    double gastoPublico;
    double imp1;
    double imp2;
    double imp3;
    double imp4;
    double imp5;

    public Ciudad(String nombre, double gastoPublico, double imp1, double imp2, double imp3, double imp4, double imp5) {
        this.nombre = nombre;
        this.gastoPublico = gastoPublico;
        this.imp1 = imp1;
        this.imp2 = imp2;
        this.imp3 = imp3;
        this.imp4 = imp4;
        this.imp5 = imp5;
    }

    public boolean deficit() {
        double totalImpuestos = imp1 + imp2 + imp3 + imp4 + imp5;
        if (gastoPublico < totalImpuestos) {
            System.out.println(" - " + "La ciudad " + nombre + " no está en déficit.");
            return false;
        } else {
            System.out.println(" - " + "La ciudad " + nombre + " está en déficit.");
            return true;
        }
        // Código de ejemplo

    }

}
