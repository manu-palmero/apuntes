import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Example usage
        ArrayList<Mineral> mineralesRequeridos = new ArrayList<>();
        mineralesRequeridos.add(new Mineral("Nitrógeno"));
        mineralesRequeridos.add(new Mineral("Fósforo"));

        Lote lote1 = new Lote(23, mineralesRequeridos);

        Cereal cocechaFina = new Cocecha_Fina("Cocecha Fina", mineralesRequeridos);
        Cereal cocechaGruesa = new Cocecha_Gruesa("Cocecha Gruesa", mineralesRequeridos);
        Cereal pastura = new Pastura("Pastura", mineralesRequeridos);

        cocechaFina.agregarMineral(new Mineral("Potasio"));
        cocechaGruesa.agregarMineral(new Mineral("Calcio"));
        pastura.agregarMineral(new Mineral("Magnesio"));

        cocechaFina.mostrarMinerales();
        cocechaGruesa.mostrarMinerales();
        pastura.mostrarMinerales();

        lote1.aptoParaSembrar();

    }
}