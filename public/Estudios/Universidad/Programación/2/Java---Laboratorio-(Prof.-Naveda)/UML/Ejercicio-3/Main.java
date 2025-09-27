public class Main {
    public static void main(String[] args) {
        Ciudad ciudad1 = new Ciudad("Ciudad1", 1000, 800, 300, 150, 100, 50);
        Ciudad ciudad2 = new Ciudad("Ciudad2", 800, 100, 200, 150, 50, 50);
        Ciudad ciudad3 = new Ciudad("Ciudad3", 1200, 300, 400, 200, 100, 50);
        Ciudad ciudad4 = new Ciudad("Ciudad4", 900, 200, 300, 150, 100, 50);
        Ciudad ciudad5 = new Ciudad("Ciudad5", 1100, 250, 350, 200, 150, 50);
        Ciudad ciudad6 = new Ciudad("Ciudad6", 80, 200, 300, 150, 100, 50);
        Ciudad ciudad7 = new Ciudad("Ciudad7", 30, 400, 500, 250, 150, 50);
        Ciudad ciudad8 = new Ciudad("Ciudad8", 20, 150, 250, 150, 100, 50);

        Provincia provincia1 = new Provincia("Provincia1");
        provincia1.agregarCiudad(ciudad1);
        provincia1.agregarCiudad(ciudad2);
        provincia1.agregarCiudad(ciudad3);
        provincia1.agregarCiudad(ciudad4);

        Provincia provincia2 = new Provincia("Provincia2");
        provincia2.agregarCiudad(ciudad5);
        provincia2.agregarCiudad(ciudad6);
        provincia2.agregarCiudad(ciudad7);
        provincia2.agregarCiudad(ciudad8);

        Pais pais = new Pais("Pais1");
        pais.agregarProvincia(provincia1);
        pais.agregarProvincia(provincia2);

        pais.obtenerProvinciasEnDeficit();
        pais.mostrarProvinciasDeficitarias();
        pais.mostrarProvinciasNoDeficitarias();
    }
}