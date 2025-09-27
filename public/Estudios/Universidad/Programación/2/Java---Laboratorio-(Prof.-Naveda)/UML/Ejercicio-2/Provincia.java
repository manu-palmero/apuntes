import java.util.ArrayList;

public class Provincia {
    String nombre;
    Ciudad capital;
    ArrayList<Ciudad> ciudades;
    Pais pais;
    ArrayList<Provincia> limitaConProvincia;
    Pais[] limitaConPais;

    public Provincia(String nombre, ArrayList<Ciudad> ciudades, Pais pais, ArrayList<Provincia> limitaConProvincia) {
        this.nombre = nombre;
        if (ciudades != null) {
            this.ciudades = ciudades;
            for (Ciudad ciudad : ciudades) {
                if (ciudad.capital) {
                    this.capital = ciudad;
                    break;
                }
            }
        }
        this.pais = pais;
        this.limitaConProvincia = limitaConProvincia;
    }

    public Provincia(String nombre, ArrayList<Ciudad> ciudades, Pais pais, ArrayList<Provincia> limitaConProvincia,
            Pais[] limitaConPais) {
        this.nombre = nombre;
        this.ciudades = ciudades;
        this.pais = pais;
        this.limitaConProvincia = limitaConProvincia;
        this.limitaConPais = limitaConPais;
    }

    public void agregarLimiteConProvincia(Provincia provincia) {
        if (this.limitaConProvincia == null) {
            this.limitaConProvincia = new ArrayList<Provincia>();
        }
        this.limitaConProvincia.add(provincia);
    }
}
