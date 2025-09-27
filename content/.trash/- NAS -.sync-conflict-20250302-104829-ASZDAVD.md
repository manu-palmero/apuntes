---
proyecto: NAS
tags:
  - nas
  - proyecto
---
# NAS doméstico

### Tareas
![[Tareas]]

## NAS con Docker
![Contenedores de Docker](Contenedores%20de%20Docker.md)    

![OpenMediaVault](Instalación%20de%20OpenMediaVault.md)    

### TODO:   
- [ ] Nginx proxy manager con dns pública
- [ ] DNS local con subdominios
- [ ] Probar `sudo rtcwake -m mem -t $(date +%s -d 'tomorrow 23:00')` en una tarea de cron dentro de OMV
- [ ] Crear una vista de tareas mejor para esto

## NAS con VMs y Contenedores LXC
![[Direcciones IP reservadas (Contenedores y VMs)]]
### Servicios
- Base de datos (MySQL)
- Archivos (NFS)
- VPN
- DNS (pi-hole)
- Web (apache)

