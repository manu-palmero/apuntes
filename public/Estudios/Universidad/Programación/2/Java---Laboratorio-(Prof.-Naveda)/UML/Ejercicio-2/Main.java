import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Prueba del programa

        Ciudad GodoyCruz = new Ciudad("Godoy Cruz", false);
        Ciudad Mendoza = new Ciudad("Mendoza", true);
        Ciudad SanMartin = new Ciudad("San Martin", false);
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades.add(GodoyCruz);
        ciudades.add(Mendoza);
        ciudades.add(SanMartin);
        Provincia NeuquenProv = new Provincia("Neuquen", null, null, null);
        Provincia MendozaProv = new Provincia("Mendoza", ciudades, null, null);
        MendozaProv.agregarLimiteConProvincia(NeuquenProv);
        Pais argentina = new Pais("Argentina", null, null, null);
        MendozaProv.pais = argentina;
        NeuquenProv.pais = argentina;
        argentina.agregarProvincia(MendozaProv);
        argentina.agregarProvincia(NeuquenProv);
        ArrayList<Provincia> provincias = new ArrayList<Provincia>();
        provincias.add(MendozaProv);
        provincias.add(NeuquenProv);
        ArrayList<Pais> paises = new ArrayList<Pais>();
        paises.add(argentina);
        Continente america = new Continente("America", paises);
        Pais brasil = new Pais("Brasil", null, null, america);
        argentina.agregarLimiteConPais(brasil);

        System.out.println("El continente es: " + america.nombre);
        System.out.println("El pais es: " + argentina.nombre);
        System.out.println("La provincia es: " + MendozaProv.nombre);
        System.out.println("La capital de la provincia de Mendoza es: " + MendozaProv.capital.nombre);
        System.out.println("La provincia de Mendoza limita con: ");
        for (int i = 0; i < MendozaProv.limitaConProvincia.size(); i++) {
            System.out.println(" - " + MendozaProv.limitaConProvincia.get(i).nombre);
        }
        System.out.println("El pais limita con: ");
        for (int i = 0; i < argentina.limitaConPais.size(); i++) {
            System.out.println(" - " + argentina.limitaConPais.get(i).nombre);
        }
        System.out.println("La provincia de Mendoza tiene las siguientes ciudades: ");
        for (int i = 0; i < MendozaProv.ciudades.size(); i++) {
            System.out.println(" - " + MendozaProv.ciudades.get(i).nombre);
        }

    }
}