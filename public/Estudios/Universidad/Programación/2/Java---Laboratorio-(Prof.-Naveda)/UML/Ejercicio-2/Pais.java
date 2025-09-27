import java.util.ArrayList;

public class Pais {
    ArrayList<Pais> limitaConPais;
    Continente continente;
    String nombre;
    Provincia capital;
    ArrayList<Provincia> provincias;

    public Pais(String nombre, ArrayList<Provincia> provincias, Provincia capital, Continente continente) {
        this.nombre = nombre;
        this.capital = capital;
        this.continente = continente;
        this.provincias = provincias;
    }

    public Pais(String nombre, ArrayList<Provincia> provincias, Provincia capital, Continente continente,
            ArrayList<Pais> limitaConPais) {
        this.nombre = nombre;
        this.capital = capital;
        this.continente = continente;
        if (limitaConPais != null) {
            this.limitaConPais = limitaConPais;
        } else {
            this.limitaConPais = new ArrayList<Pais>();
        }
        this.provincias = provincias;
    }

    public void agregarProvincia(Provincia provincia) {
        this.provincias = new ArrayList<Provincia>();
        this.provincias.add(provincia);
    }

    public void agregarLimiteConPais(Pais pais) {
        if (this.limitaConPais == null) {
            this.limitaConPais = new ArrayList<Pais>();
        }
        this.limitaConPais.add(pais);
    }
}
