package veterinaria.dominio;

public class Gato extends Animal {
    private String color;

    public Gato(){}
    public Gato(String color){
        this.color = color;
    }

    @Override
    public boolean necesitaVacunaAnual() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getDieta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String emitirSonido() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
