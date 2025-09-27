---
tags:
  - nas
sticker: lucide//server-cog
proyecto: NAS
---
## Desde una instalación de Debian existente
   
``` shell
sudo wget -O - https://github.com/OpenMediaVault-Plugin-Developers/installScript/raw/master/install | sudo bash
```
Para instalar sin configuración de red:   
``` bash
wget https://github.com/OpenMediaVault-Plugin-Developers/installScript/raw/master/install

chmod +x install

sudo ./install -n
```

## Instalación desde ISO
Instalación normal como la de Debian.
>[!importante]
>La cuenta `openmediavault` no está habilitada para usar la terminal. Iniciar sesión en modo local, con un monitor conectado, desde una TTY con la cuenta de `root`, cuya contraseña fue establecida durante el asistente de instalación, y ejecutar el comando `omv-firstaid`. Dentro del menú seleccionar la opción para configurar la red, caso contrario, no habrá internet ni obtendrá IP mediante DHCP.

## Instalar OMV-Extras para usar y administrar docker 

Iniciar sesión por SSH como `root` y luego ejecutar el comando:
```bash
wget -O - https://github.com/OpenMediaVault-Plugin-Developers/packages/raw/master/install | bash
```
Si no usa la cuenta `root`, anteponer `sudo` al comando de la siguente forma:
```bash
sudo su -
wget -O - https://github.com/OpenMediaVault-Plugin-Developers/packages/raw/master/install | bash
```
Luego, en el panel de control de OMV, ir a Sistema > omv-extras, activar **Docker repo**, e instalar el plugin `openmediavault-compose` de la lista de plugins. Aparecerá el menú **Compose** en la lista de servicios.