package veterinaria.dominio;

import java.time.LocalDate;

public abstract class Animal {

    private String nombre;
    private int edad;
    private LocalDate fechaNacimiento;
    private EstadoAnimal estado;
    private Duenio duenio;
    private FichaMedica fichaMedica;

    public Animal(){}
    public Animal(String nombre){
        this.nombre=nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        // TODO Implementar
        return "";
    }

    // Comportamiento polmórfico
    public abstract String emitirSonido();

    public abstract String getDieta();

    public abstract boolean necesitaVacunaAnual();

}
