---
tags:
  - linux
  - personalizacion
---

Instalar `plymouth` con los temas básicos:
```shell
sudo apt install plymouth plymouth-themes firmware-linux
```

Editar [el archivo de configuración de GRUB](Configurar%20GRUB.md) en `/etc/default/grub`:
```shell
sudo nano /etc/default/grub
```

Dentro del archivo añadir la opción `splash` a los comandos por defecto del arranque de la siguiente forma:
```bash
GRUB_CMDLINE_LINUX_DEFAULT="quiet splash"
```

También se puede configurar la resolución:
```shell
GRUB_GFXMODE=1920x1080x32
```
El formato es `ANCHOxALTOxPROFUNDIDAD`, la profundidad es opcional.

Para listar los temas disponibles se usa el comando `plymouth-set-default-theme -l` y se obtiene una salida como la siguiente:
```shell
plymouth-set-default-theme -l

details
fade-in
glow
script
solar
spinfinity
spinner
text
tribar
```

Para seleccionar una tema de la lista anterior, se usa el comando `plymouth-set-default-theme -R THEME`.

Para descargar temas se puede usar la página de [Gnome-look](https://www.gnome-look.org/browse?cat=108&ord=rating) y se debe mover la carpeta que contiene el archivo `nombre_del_tema.plymouth` a la carpeta `/usr/share/plymouth/themes/`. Cuando se copia ya aparece en la salida del comando `plymouth-set-default-theme -l` automáticamente y se puede seleccionar.

Luego, actualizar los cambios con `sudo update-grub2`.
