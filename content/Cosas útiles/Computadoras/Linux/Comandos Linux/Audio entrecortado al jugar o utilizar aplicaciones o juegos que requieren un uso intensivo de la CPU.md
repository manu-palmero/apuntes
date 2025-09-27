---
tags:
  - audio
  - linux
---

Aumentar `default.clock.min-quantum` dentro del archivo `/usr/share/pipewire/pipewire.conf` a 1024 o al menos más del valor por defecto.

Quedaría así: 
```bash
context.properties = {
    # ...
    #default.clock.allowed-rates = [ 48000 ]
    #default.clock.quantum       = 1024
    default.clock.min-quantum   = 1024
    #default.clock.max-quantum   = 2048
    #default.clock.quantum-limit = 8192
```

El *quantum* es la cantidad de cuadros (frames) de audio que se procesan por ciclo, es decir:
- A menor quantum: menor latencia
- A mayor quantum: mayor latencia, pero más estabilidad

> [!glosario] 
**Quantum**: número de frames que se procesan por ciclo.
**Ciclo**: unidad de tiempo en la que el sistema procesa un bloque de audio (un quantum).
**Frame**: muestra de audio por cada canal.



