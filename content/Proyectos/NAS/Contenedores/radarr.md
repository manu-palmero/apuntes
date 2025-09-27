
``` yaml
---
services:
  radarr:
    image: lscr.io/linuxserver/radarr:latest
    container_name: radarr
    environment:
      - PUID=1000
      - PGID=1000
      - TZ=America/Argentina/Mendoza
    volumes:
      - /srv/dev-disk-by-uuid-ea4c605b-e97d-48cf-af60-dc79c83afe51/docker/config/data/radarr/config:/config
      - /srv/dev-disk-by-uuid-ea4c605b-e97d-48cf-af60-dc79c83afe51/peliculas:/movies
      - /srv/dev-disk-by-uuid-ea4c605b-e97d-48cf-af60-dc79c83afe51/anime:/anime
      - /srv/dev-disk-by-uuid-ea4c605b-e97d-48cf-af60-dc79c83afe51/descargas:/downloads
    ports:
      - 7878:7878
    restart: unless-stopped
```
