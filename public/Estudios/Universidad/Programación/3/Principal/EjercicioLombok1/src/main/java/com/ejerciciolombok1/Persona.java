package com.ejerciciolombok1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

// Clase Persona
@Builder
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Persona {
    @Getter
    @NonNull
    private String nombre;
    @Getter
    private final int edad;
    @Getter
    private Domicilio domicilio;

    // Método personalizado para establecer la referencia en Domicilio
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
        if (domicilio != null) {
            domicilio.setResidente(this);
        }
    }
}