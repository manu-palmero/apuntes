package veterinaria.dominio;

public class Perro extends Animal {
    private String idChip;
    private Raza raza;

    public Perro(String nombre) {
        super(nombre);
    }

    public Perro(String nombre, Raza raza) {
        super(nombre);
        this.raza = raza;
    }

    public Perro(String nombre, Raza raza, String idChip) {
        super(nombre);
        this.idChip = idChip;
        this.raza = raza;
    }

    public void ladrar() {
        System.out.println("El perro hace guau.");
    }

    public Raza getRaza() {
        return raza;
    }

    @Override
    public String getDieta() {
        return "Dieta del perro " + this.getNombre();
    }

    @Override
    public String emitirSonido() {
        return "El perro me la ladra.";
    }

    @Override
    public String getIdentificacion() {
        return idChip;
    }

    @Override
    public boolean necesitaVacunaAnual() {
        return true;
    }

}
