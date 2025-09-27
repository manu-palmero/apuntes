import java.util.ArrayList;

public class Provincia {
    String nombre;
    ArrayList<Ciudad> ciudades;
    ArrayList<Ciudad> ciudadesEnDeficit;

    public Provincia(String nombre) {
        this.nombre = nombre;
        this.ciudades = new ArrayList<>();
        this.ciudadesEnDeficit = new ArrayList<>();
    }

    public void agregarCiudad(Ciudad ciudad) {
        ciudades.add(ciudad);
    }

    public boolean estaEnDeficit() {
        System.out.println("Calculando déficit para la provincia " + nombre + ":");
        for (Ciudad ciudad : ciudades) {
            if (ciudad.deficit()) {
                ciudadesEnDeficit.add(ciudad);
            }
        }
        int cantidadCiudades = ciudades.size();
        int cantidadDeficitarias = ciudadesEnDeficit.size();

        if (cantidadDeficitarias > (cantidadCiudades / 2)) {
            System.out.println("La provincia " + nombre + " tiene más de la mitad de sus ciudades en déficit.");
            return true;
        } else {
            System.out.println("La provincia " + nombre + " tiene menos de la mitad de sus ciudades en déficit.");
            return false;
        }
    }

}