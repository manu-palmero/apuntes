package veterinaria.dominio;

import java.util.List;

public class TratamientoRealizado {
    private List<Medicamento> medicamentos;

    public void addMedicamento(Medicamento m) {
        medicamentos.add(m);
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }
}
