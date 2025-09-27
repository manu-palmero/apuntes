---
tags:
  - linux
---


Crear un archivo dentro de `/etc/sudoers.d/` con el [formato del orden de ejecución](Orden%20de%20ejecución%20para%20archivos%20de%20configuración.md) para reglas, por ejemplo `10-manu`, que contenga:   
```
usuario ALL=(ALL) NOPASSWD: ALL
```
   
  