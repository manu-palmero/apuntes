---
Proyecto: NAS
tags:
  - docker
  - nas
  - error
  - pi-hole
descripción: Puerto 53 está siendo utilizado por otro proceso
tipo: Error
---

El puerto 53 se está utilizando en la máquina host, es por eso que no se puede vincular 53 al host.   
Para saber qué está usando el puerto 53, puede hacer:    
``` bash
sudo lsof -i -P -n | grep LISTEN
```
Lo más probable es que sea systemd-resolved lo que está escuchando en el puerto 53. Para solucionarlo, hay que desactivarlo. Se puede hacer con estos 2 comandos:   
``` bash
sudo systemctl disable systemd-resolved.service
sudo systemctl stop systemd-resolved
```
Ahora el puerto 53 está abierto, pero no hay ningún DNS configurado para el host. Para solucionarlo, hay que editar `/etc/resolv.conf` y agregar la dirección DNS. Este es un ejemplo con una dirección DNS común:   
``` conf
nameserver 1.1.1.1
```
Si se tiene otro servidor de nombres (nameserver) en ese archivo, es mejor comentarlo para evitar problemas.   
Una vez que el contenedor de docker pihole se ejecuta, se puede cambiar el servidor DNS de su host a localhost, ya que está vinculando el puerto 53 a la máquina host. Para eso hay que cambiar nuevamente '/etc/resolv.conf' así:
``` conf
nameserver 127.0.0.1
```
