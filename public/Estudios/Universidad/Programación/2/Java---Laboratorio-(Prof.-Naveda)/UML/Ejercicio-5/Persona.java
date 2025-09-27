import java.util.ArrayList;

public class Persona {
    String nombre;
    ArrayList<Gusto> gustos = new ArrayList<>();

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void gustosPlato(Plato plato, Restaurante restaurante) {
        this.gustos.add(new Gusto(restaurante, plato));
    }

    public void visitas() {

    }
}
