
``` yaml
---
services:
  transmission:
    image: lscr.io/linuxserver/transmission:latest
    container_name: transmission
    environment:
      - PUID=1000
      - PGID=1000
      - TZ=America/Argentina/Mendoza
      - USER=casa
      - PASS=casa
    volumes:
      - /home/manu/docker/docker-data/transmission:/config
      - /home/manu/300gb/descargas:/downloads
      - /home/manu/300gb/tv:/downloads/complete/tv
      - /home/manu/300gb/peliculas:/downloads/complete/movies
      - /home/manu/300gb/anime:/downloads/complete/anime
      - /home/manu/300gb/music:/downloads/complete/music
      - /home/manu/300gb/descargas/watch:/watch
    ports:
      - 9091:9091
      - 51413:51413
      - 51413:51413/udp
    restart: unless-stopped

```
