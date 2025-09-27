
``` yaml
---
services:
  sonarr:
    image: lscr.io/linuxserver/sonarr:latest
    container_name: sonarr
    environment:
      - PUID=1000
      - PGID=1000
      - TZ=America/Argentina/Mendoza
    volumes:
      - /home/manu/docker/docker-data/sonarr/config:/config
      - /home/manu/300gb/tv:/tv
      - /home/manu/300gb/anime:/anime
      - /home/manu/300gb/descargas:/downloads
      - /home/manu/300gb/descargas/complete/tv:/downloads/complete/tv
      - /home/manu/300gb/descargas/complete/anime:/downloads/complete/anime
    ports:
      - 8989:8989
    restart: unless-stopped
```
