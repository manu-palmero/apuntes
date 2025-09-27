# Pre-instalación
## Requisitos
- Conexión a Internet
- Unidad USB Arrancable
- Imagen de Arch Linux
## 1. Preparar la Unidad USB
```sh
sudo dd if=/ruta/a/archlinux.iso of=/dev/sdX bs=4M status=progress
```
Donde:
- `if=...`: Ruta a la imagen de Arch Linux.
- `of=/dev/sdX`: Ruta al dispositivo USB.
- `bs=4M`: Establece el tamaño del bloque a 4 MB para una transferencia más rápida.
- `status=progress`: Muestra una barra de progreso.
## 2. Iniciar la computadora desde la unidad USB
## 3. Configuración Inicial
### Configurar el teclado
`loadkeys es` para teclados españoles.
`loadkeys la-latin1` para teclados latinoamericanos.
`loadkeys us` para teclados estadounidenses.
### Conectarse a Internet
`ip link` para asegurarse de que la interfaz de red esté activada.
#### Para conectarse a Wi-Fi
`iwctl` para abrir la consola de iwd.
```sh
device list
device wlan0 set-propertry Powered on

station wlan0 scan
station wlan0 get-networks
station wlan0 connect SSID
```
Donde:
- `wlan0`: Nombre de la interfaz de red.
- `SSID`: Nombre de la red inalámbrica a conectarse.
##### Activar DHCP en IWD (opcional durante la instalación)
Modificar `/etc/iwd/main.conf`:
```conf
[General]
EnableNetworkConfiguration=true

[Network]
RoutePriorityOffset=300
```
##### Activar auto-conectado a una red (opcional)
Modificar el archivo de la red recordada en `/var/lib/iwd/network.type`
- `.../network.type`: Nombre de la red y tipo de seguridad, por ejemplo: `TP_Link_1234.psk`
```conf
[Settings]
AutoConnect=true
```
##### Configurar IP fija (opcional)
Modificar `/var/lib/iwd/network.type`:
```conf
[IPv4]
Address=192.168.X.X
Netmask=255.255.255.0
Gateway=192.168.X.X
Broadcast=192.168.X.255
DNS=192.168.X.1
```
##### Seleccionar administrador de DNS (opcional)
Modificar `/etc/iwd/main.conf`:
Para `systemd-resolved`:
```conf
[Network]
NameResolvingService=systemd
```
Para `resolvconf`:
```conf
[Network]
NameResolvingService=resolvconf
```

### Actualizar el reloj
Utilizar `timedatectl`.

### Particionar el disco
Identificar el disco con `fdisk -l` o `lsblk`.
Luego usar `fdisk /dev/unidad_a_particionar`

#### Tipos de partición en `fdisk`
```
Alias:
   linux          - 83
   swap           - 82
   extended       - 05
   uefi           - EF
   raid           - FD
   lvm            - 8E
   linuxex        - 85
```
#### Esquemas de particionado de ejemplo

- UEFI con GPT:

| Punto <br>de <br>montaje |       Partición       |    Tipo    |                  Tamaño                  |
| :----------------------: | :-------------------: | :--------: | :--------------------------------------: |
|         `/boot`          |  `/dev/patición_efi`  |    EFI     |                  1 GiB                   |
|         `[SWAP]`         | `/dev/partición_swap` | Linux Swap |               4 GiB Mínimo               |
|           `/`            | `/dev/partición_raíz` |   Linux    | Resto del dispositivo<br>Al menos 32 GiB |
- BIOS con MBR:

| Punto <br>de <br>montaje |       Partición       |    Tipo    |                  Tamaño                  |
| :----------------------: | :-------------------: | :--------: | :--------------------------------------: |
|         `[SWAP]`         | `/dev/partición_swap` | Linux Swap |               4 GiB Mínimo               |
|           `/`            | `/dev/partición_raíz` |   Linux    | Resto del dispositivo<br>Al menos 32 GiB |
#### Formatear las particiones
Para la partición raíz: `mkfs.ext4 /dev/partición_raíz`
Para la partición SWAP: `mkswap /dev/partición_swap`
Para la partición EFI, si hubiera: `mkfs.fat -F 32 /dev/partición_efi`

#### Montar las particiones
```sh
mount /dev/partición_raíz /mnt
mount --mkdir /dev/partición_efi /mnt/boot
swapon /dev/partición_swap
```
# Instalación
## Instalar paquetes esenciales
Comando normal:
```sh
pacstrap /mnt base linux linux-headers linux-firmware grub
```

Con el núcleo `linux-zen`:
```sh
pacstrap /mnt base linux-zen linux-zen-headers linux-firmware grub
```

>El paquete del núcleo puede ser omitido en instalaciones dentro de un contenedor o una máquina virtual
## Instalación de paquetes adicionales
El paquete `base` no incluye todas las herramientas que se encuentran en el instalador, por ende, es recomendable instalar algunos paquetes adicionales para que el sistema funcione correctamente. Dichas herramientas pueden ser instaladas mediante `pacman` luego de instalar el sistema o desde el mismo `pacstrap`. Éstas herramientas pueden ser:
- Actualizaciones para el microcódigo de la CPU: `amd-ucode` o `intel-ucode`;
- Firmware específico para otros dispositivos no incluidos en `linux-firmware` (por ejemplo, `sof-firmware` para el [audio integrado](https://wiki.archlinux.org/title/Advanced_Linux_Sound_Architecture#ALSA_firmware "Advanced Linux Sound Architecture"), `linux-firmware-marvell` para los controladores de red inalámbrica Marvell o cualquier otro paquete de firmware para los [controladores inalámbricos Broadcom](https://wiki.archlinux.org/index.php?title=Broadcom_wireless_(Espa%C3%B1ol)&action=edit&redlink=1 "Broadcom wireless (Español) (page does not exist)"));
- Software necesario para la conexión a redes (por ejemplo, un administrador de red o cliente DHCP, autenticador para redes Wi-Fi como `NetworkManager`);
- Editor de texto (por ejemplo, `nano`) para editar los archivos de configuración desde la consola;
- Paquetes para acceder a la documentación en las páginas *man* e *info*: `man-db`, `man-pages` y `texinfo`.
# Configurar el sistema
## Fstab
```sh
genfstab -U /mnt >> /mnt/etc/fstab
```

## Chroot
```sh
arch-chroot /mnt
```

## Zona horaria
```sh
ln -sf /usr/share/zoneinfo/Región/Ciudad /etc/localtime
```
`Región` y `Ciudad` deben ser modificados. Por ejemplo: `/usr/share/zoneinfo/America/Argentina/Mendoza`