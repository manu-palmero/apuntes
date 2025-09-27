class Main {
    public static void main(String[] args) {
        System.out.println("Prueba!");
        new Hola();
        new Bonjour();
        new Hallo();
        new Ciao();
    }
}

final class Hola {
    public Hola() {
        this.hola();
    }
    public final void hola() {
        System.out.println("Hola, Mundo!");
    }
}

final class Bonjour {
    public Bonjour() {
        bonjour();
    }
    protected static final void bonjour() {
        System.out.println("Bonjour, le Monde!");
    }
}

final class Hallo {
    public Hallo() {
        hallo();
    }
    private static final void hallo() {
        System.out.println("Hallo, Welt!");
    }
}

final class Ciao {
    public Ciao() {
        ciao();
    }
    protected final static void ciao() {
        System.out.println("Ciao, Mondo!");
    }
}