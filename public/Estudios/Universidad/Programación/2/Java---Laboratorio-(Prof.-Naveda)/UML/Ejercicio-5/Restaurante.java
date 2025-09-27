import java.util.ArrayList;

public class Restaurante {
    String nombre;
    ArrayList<Sucursal> sucursales;
    ArrayList<Plato> platos = new ArrayList<>(20);

    public Restaurante(String nombre) {
        this.nombre = nombre;
    }

    public void agregarSusursal(Sucursal sucursal) {
        this.sucursales.add(sucursal);
    }

    public void agregarPlato(Plato plato) {
        this.platos.add(plato);
    }

    public void mostrarPlatos() {
        for (Plato plato : platos) {
            System.out.println(plato);
        }
    }

    public void mostrarSusursales() {
        for (Sucursal susursal : sucursales) {
            System.out.println(susursal);
        }
    }
}
