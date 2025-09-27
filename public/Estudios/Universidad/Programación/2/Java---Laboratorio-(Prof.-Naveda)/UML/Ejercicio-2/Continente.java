import java.util.ArrayList;

public class Continente {
    String nombre;
    ArrayList<Pais> paises;

    public Continente() {
        // Constructor de la clase Continente
    }

    public Continente(String nombre, ArrayList<Pais> paises) {
        this.nombre = nombre;
        this.paises = paises;
    }

    public Continente(String nombre) {
        this.nombre = nombre;
    }

    public void agregarPais(Pais pais) {
        // Constructor para subclases
        this.paises = new ArrayList<Pais>();
        this.paises.add(pais);

    }
}
