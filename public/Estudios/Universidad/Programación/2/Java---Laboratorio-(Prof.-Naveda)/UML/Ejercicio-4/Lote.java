import java.util.ArrayList;

public class Lote {
    int idLote;
    ArrayList<Mineral> minerales;
    boolean especial;

    public Lote(int idLote, ArrayList<Mineral> minerales) {
        this.idLote = idLote;
        this.minerales = minerales;
    }

    public void aptoParaSembrar() {
        // Implementación de la lógica para determinar si el lote es apto para sembrar
        System.out.println("Función en desarrollo...");
    }
}
