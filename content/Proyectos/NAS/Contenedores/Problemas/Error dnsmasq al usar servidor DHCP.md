---
tags:
  - docker
  - error
  - pi-hole
  - nas
descripción: " Warning in dnsmasq core: no address range available for DHCP request via eth0"
tipo: Error
proyecto: NAS
---
# \[Docker] Warning in dnsmasq core: no address range available for DHCP request via eth0
 --- 
Reemplazar:   
``` yaml
services:
  pihole:
    ports:
      - "53:53/tcp"
      - "53:53/udp"
      - "67:67/udp"
      - "81:80/tcp"
```
Por:   
``` yaml
services:
  pihole:
    network_mode: host
```
 --- 
### Fuente:   
[Docker DHCP and Network Modes - Pi-hole documentation](https://docs.pi-hole.net/docker/dhcp/#docker-pi-hole-with-host-networking-mode)    
