
``` yaml
---
services:
  jellyfin:
    image: lscr.io/linuxserver/jellyfin:latest
    container_name: jellyfin
    environment:
      - PUID=1000
      - PGID=1000
      - TZ=America/Argentina/Mendoza
      - JELLYFIN_PublishedServerUrl=192.168.0.108
    volumes:
      - /home/manu/docker/docker-data/jellyfin/config:/config
      - /home/manu/300gb/tv:/tvshows
      - /home/manu/300gb/movies:/movies
      - /home/manu/300gb/anime:/anime
      - /home/manu/300gb/music:/music
    ports:
      - 8096:8096
      - 8920:8920
      - 7359:7359/udp
      - 1900:1900/udp
    restart: unless-stopped
```

## Errores y correcciones:
```dataview
list
from #jellyfin and #error 

```
