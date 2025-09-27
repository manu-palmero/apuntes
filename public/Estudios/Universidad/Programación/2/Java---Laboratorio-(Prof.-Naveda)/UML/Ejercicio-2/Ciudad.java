public class Ciudad {
    String nombre;
    boolean capital;

    public Ciudad(String nombre, boolean capital) {
        this.nombre = nombre;
        this.capital = capital;
    }

    public Ciudad(String nombre) {
        this.nombre = nombre;
        this.capital = false;
    }

}
