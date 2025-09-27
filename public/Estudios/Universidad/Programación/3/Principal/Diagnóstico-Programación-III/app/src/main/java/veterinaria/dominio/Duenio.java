package veterinaria.dominio;

public class Duenio {
    private String nombre;

    private Telefono telefono;

    public Duenio(String telefono) {
        this.telefono = new Telefono(telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroTelefono() {
        return telefono.getNumero();
    }
}
