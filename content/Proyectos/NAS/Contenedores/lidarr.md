```yaml
---
services:
  lidarr:
    image: lscr.io/linuxserver/lidarr:latest
    container_name: lidarr
    environment:
      - PUID=1000
      - PGID=1000
      - TZ=Etc/UTC
    volumes:
      - /home/manu/docker/docker-data/lidarr/config:/config
      - /srv/dev-disk-by-uuid-4a517de5-047f-47cf-93cf-b0d1ac4e79aa/music:/music # Opcional
      #- /path/to/downloads:/downloads # Optional
    ports:
      - 8686:8686
    restart: unless-stopped
```