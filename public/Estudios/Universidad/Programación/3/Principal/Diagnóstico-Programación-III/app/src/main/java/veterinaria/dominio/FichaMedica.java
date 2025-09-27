package veterinaria.dominio;

import java.util.List;

public class FichaMedica {
    private List<Diagnostico> diagnisticos;
    private List<TratamientoRealizado> historial;

    public FichaMedica(List<TratamientoRealizado> historial) {
        this.historial = historial;
    }

    public FichaMedica() {
    }

    public void agregarDiagnostico(Diagnostico d) {
        diagnisticos.add(d);
    }

    public List<Diagnostico> getDiagnosticos() {
        return diagnisticos;
    }

    public List<TratamientoRealizado> getHistorialDeTratamientos() {
        return historial;
    }
}
