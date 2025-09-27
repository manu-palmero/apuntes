import java.util.ArrayList;

public abstract class Cereal {
    String nombre;
    ArrayList<Mineral> mineralesRequeridos;

    // Constructor
    public Cereal(String nombre, ArrayList<Mineral> mineralesRequeridos) {
        this.nombre = nombre;
        this.mineralesRequeridos = new ArrayList<>(mineralesRequeridos);
    }

    public void agregarMineral(Mineral mineral) {
        this.mineralesRequeridos.add(mineral);
    }

    public void mostrarMinerales() {
        System.out.println("Minerales requeridos para " + nombre + ":");
        for (Mineral mineral : this.mineralesRequeridos) {
            System.out.println("- " + mineral.getNombre());
        }
    }

}
