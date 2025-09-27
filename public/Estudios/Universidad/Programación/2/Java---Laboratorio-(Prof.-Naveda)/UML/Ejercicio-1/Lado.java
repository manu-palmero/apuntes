public class Lado {
    private Punto p1;
    private Punto p2;

    public Lado(double x, double y) {
        this.p1 = new Punto(x, y);
        this.p2 = new Punto(x, y);
    }

    public Punto[] getLados() {
        return new Punto[] { p1, p2 };
    }

}
