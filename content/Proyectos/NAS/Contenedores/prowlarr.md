
``` yaml
services:
  prowlarr:
    image: lscr.io/linuxserver/prowlarr:latest
    container_name: prowlarr
    environment:
      - PUID=1000
      - PGID=1000
      - TZ=America/Argentina/Mendoza
    volumes:
      - /srv/dev-disk-by-uuid-4a517de5-047f-47cf-93cf-b0d1ac4e79aa/docker-data/prowlarr:/config
    ports:
      - 9696:9696
    restart: unless-stopped
```
