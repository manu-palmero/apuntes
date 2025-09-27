public class Poligono extends Figura {
    private int numLados;
    private Lado[] lados;

    public Poligono(int numLados, Lado[] lados) {
        super(); // Llama al constructor de la superclase Figura
        this.numLados = numLados;
        if (lados.length != numLados) {
            throw new IllegalArgumentException("El número de lados no coincide con el número de lados del polígono.");
        } else {
            for (int i = 0; i < numLados; i++) {
                if (lados[i] == null) {
                    throw new IllegalArgumentException("Lado " + (i + 1) + " no puede ser nulo.");
                }
            }
            this.lados = lados;
        }
    }

    public int getNumLados() { // Getters para que no molesten las advertencias de que no se usan las variables
        return numLados;
    }

    public Lado[] getLados() {
        return lados;
    }
}