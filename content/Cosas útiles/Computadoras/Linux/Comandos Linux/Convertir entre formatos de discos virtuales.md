---
tags:
  - linux
  - vm
---
# Convertir entre formatos de discos virtuales

## Comando principal
Se hace todo con el comando `qemu-img` con las siguientes opciones:

- `convert`: Convierte una imagen de disco de un formato a otro.
- `info`: Muestra información sobre una imagen de disco, como el formato, el tamaño virtual y el tamaño real.
- `create`: Crea una nueva imagen de disco en un formato específico.

### Opción `convert`
Sintaxis:
```bash
qemu-img convert -f <formato_origen> -O <formato_destino> <archivo_origen> <archivo_destino>
```

#### Argumentos
- **`-f <formato_origen>`**: Especifica el formato de la imagen de disco de origen. No siempre es necesario si QEMU puede detectarlo automáticamente, pero es una buena práctica para evitar errores. Ejemplos de formatos: **`qcow2`**, **`vmdk`**, **`vdi`**, **`raw`**. Más abajo se especifican los formatos.
- **`-O <formato_destino>`**: Especifica el formato de la imagen de disco de destino. Es un argumento obligatorio.
- **`<archivo_origen>`**: La ruta de la imagen de disco que se desea convertir.
- **`<archivo_destino>`**: La ruta y el nombre del nuevo archivo de imagen de disco.

##### Formatos admitidos
Los formatos que se pueden especificar en los argumentos **`-f`** y **`-O`** son:
- `raw`: Sin acrónimo, significa formato crudo o sin procesar.
- `qcow2`: **QEMU Copy-On-Write**. 
- `qcow`: **QEMU Copy-On-Write**.
- `cow`: **Copy-On-Write**.
- `vmdk`: **Virtual Machine Disk**.
- `vdi`: **Virtual Disk Image**.
- `vpc`: **Virtual PC**. 
- `vhdx`: **Virtual Hard Disk**.
- `cloop`: **Compressed Loop**.
- `qed`: **QEMU Enhanced Disk**.

Las extensiones para cada tipo de disco son:
- **raw**: `.img`, `.raw`
- **qcow2**: `.qcow2`
- **qcow**: `.qcow`
- **cow**: `.cow`
- **vmdk**: `.vmdk`
- **vdi**: `.vdi`
- **vpc**: `.vhd`
- **vhdx**: `.vhdx`
- **cloop**: `.cloop`
- **qed**: `.qed`
#### Argumentos opcionales útiles
- **`-c`**: Habilita la compresión en el formato de destino. Esto solo funciona con formatos que soportan compresión, como **`qcow2`**. Por ejemplo, para crear una imagen QCOW2 comprimida:
  ```bash
  qemu-img convert -c -O qcow2 disco_virtual.vmdk disco_comprimido.qcow2
    ```
- **`-p`**: Muestra una barra de progreso durante la conversión. Es útil para archivos grandes.
  ```bash
  qemu-img convert -p -f raw -O qcow2 disco_virtual.img disco_qcow2.qcow2
  ```