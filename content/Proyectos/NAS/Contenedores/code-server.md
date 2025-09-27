
``` yaml
version: "2.1"
services:
  code-server:
    image: lscr.io/linuxserver/code-server:latest
    container_name: code-server
    environment:
      - PUID=1000
      - PGID=1000
      - TZ=Etc/UTC
      - PASSWORD=2579
      #- HASHED_PASSWORD= #optional
      - SUDO_PASSWORD=25794613 #optional
      #- SUDO_PASSWORD_HASH= #optional
      #- PROXY_DOMAIN=code-server.my.domain #optional
      #- DEFAULT_WORKSPACE=/config/workspace #optional
    volumes:
      - /home/manu/docker/docker-data/code-server/config:/config
    ports:
      - 8443:8443
    restart: unless-stopped
```
