package com.ejerciciolombok1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Clase Domicilio
@ToString(exclude = "residente")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Domicilio {
    @Getter
    @NonNull
    private String calle;
    @Getter
    private final int numero;
    // No necesitamos una referencia a Persona para el propósito del toString()
    // Aunque la tuviéramos para otra lógica, no la usaríamos en este método
    @Getter
    @Setter
    private Persona residente;
}
