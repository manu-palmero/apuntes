---
tags:
  - docker
  - contenedor
proyecto: NAS
tipo: Bloqueador de anuncios
puerto: "85"
---

``` yaml
services:
  pihole:
    image: pihole/pihole:latest
    # network_mode: host # Para usar como servidor DHCP usar esta línea y borrar los puertos abajo abajo.
    ports:
      - "53:53/tcp"
      - "53:53/udp"
      # - "67:67/udp" # Opcional. Necesario si se usa como servidor DHCP.
      - "85:80/tcp"
    environment:
      WEBPASSWORD: '25794613'
      ServerIP: '192.168.0.108'
    volumes:
       - '/home/manu/docker/docker-data/pihole/etc/pihole/:/etc/pihole/'
       - '/home/manu/docker/docker-data/pihole/etc/dnsmasq.d/:/etc/dnsmasq.d/'
       - '/home/manu/docker/docker-data/pihole/etc/lighttpd/:/etc/lighttpd/'
    dns:
      - 127.0.0.1
      - 1.1.1.1
    cap_add:
      - NET_ADMIN
    restart: always
```

**Problemas comunes con Pi-hole:**   
  ```dataview
TABLE descripción
FROM #pi-hole and #error 
WHERE tipo = "Error"
```
**Cosas útiles**:
  Bloqueador de anuncios de YouTube para Pi-hole:   
  [GitHub - deividgdt/ytadsblocker: YTadsblocker is a script to block all the Youtube&#39;s advertisement in Pi-Hole](https://github.com/deividgdt/ytadsblocker)    
**Listas de bloqueo:** https://firebog.net/

