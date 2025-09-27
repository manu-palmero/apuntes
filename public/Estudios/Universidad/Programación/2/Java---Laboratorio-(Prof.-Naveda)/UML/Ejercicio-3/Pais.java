import java.util.ArrayList;

public class Pais {
    String nombre;
    ArrayList<Provincia> provincias;
    ArrayList<Provincia> provinciasDeficitarias;
    ArrayList<Provincia> provinciasNoDeficitarias;
    ArrayList<Ciudad> deficitariasCiudades;

    public Pais(String nombre) {
        this.nombre = nombre;
        this.provincias = new ArrayList<>();
        this.provinciasDeficitarias = new ArrayList<>();
        this.provinciasNoDeficitarias = new ArrayList<>();
        this.deficitariasCiudades = new ArrayList<>();
    }

    public void agregarProvincia(Provincia provincia) {
        provincias.add(provincia);
    }

    public void obtenerProvinciasEnDeficit() {
        for (Provincia provincia : provincias) {
            if (provincia.estaEnDeficit()) {
                provinciasDeficitarias.add(provincia);
                System.out.println("La provincia " + provincia.nombre + " es deficitaria.");
            } else {
                provinciasNoDeficitarias.add(provincia);
                System.out.println("La provincia " + provincia.nombre + " no es deficitaria.");
            }
        }
        System.out
                .println("El país " + nombre + " tiene " + provinciasDeficitarias.size() + " provincias deficitarias y "
                        + provinciasNoDeficitarias.size() + " provincias no deficitarias.");
    }

    public void agregarCiudadDeficitarias() {
        for (Provincia provincia : provinciasDeficitarias) {
            for (Ciudad ciudad : provincia.ciudades) {
                if (ciudad.deficit()) {
                    deficitariasCiudades.add(ciudad);
                }
            }
        }
        System.out.println("El país " + nombre + " tiene " + deficitariasCiudades.size() + " ciudades deficitarias.");
    }

    public void mostrarProvinciasDeficitarias() {
        System.out.println("Provincias deficitarias:");
        for (Provincia provincia : provinciasDeficitarias) {
            System.out.println(" - " + provincia.nombre);
        }
    }

    public void mostrarProvinciasNoDeficitarias() {
        System.out.println("Provincias no deficitarias:");
        for (Provincia provincia : provinciasNoDeficitarias) {
            System.out.println(" - " + provincia.nombre);
        }
    }

    public void mostrarProvincias() {
        System.out.println("Provincias del país " + nombre + ":");
        for (Provincia provincia : provincias) {
            System.out.println(" - " + provincia.nombre);
        }
    }

    public void mostrarProvinciasDeficitariasYNoDeficitarias() {
        System.out.println("Provincias deficitarias:");
        for (Provincia provincia : provinciasDeficitarias) {
            System.out.println(" - " + provincia.nombre);
        }
        System.out.println("Provincias no deficitarias:");
        for (Provincia provincia : provinciasNoDeficitarias) {
            System.out.println(" - " + provincia.nombre);
        }
    }

}
