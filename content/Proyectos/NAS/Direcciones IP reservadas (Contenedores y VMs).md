---
tags:
  - vm
  - contenedor
proyecto: NAS
---

| MAC               | Servicio  | IP            |
| ----------------- | --------- | ------------- |
| e0:cb:4e:ce:2c:11 | Servidor  | 192.168.1.200 |
| 52:54:00:05:4d:65 | pi-hole   | 192.168.1.201 |
| 52:54:00:5e:84:ca | Nextcloud | 192.168.1.202 |

Se configuran en `/etc/network/interfaces` de la siguiente forma:
```
auto eth0
iface eth0 inet static
    address 192.168.1.100
    netmask 255.255.255.0
    gateway 192.168.1.1
    dns-nameservers 192.168.1.201

```