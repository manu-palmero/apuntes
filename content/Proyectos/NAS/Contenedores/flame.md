---
tags:
  - docker
  - contenedor
puerto: "5005"
proyecto: NAS
tipo: Página de inicio
---

Docker Compose:
``` yaml
version: '2.1'
services:
  flame:
    image: pawelmalak/flame:latest
    container_name: flame
    volumes:
      - /home/manu/docker/docker-data/flame:/app/data
      - /var/run/docker.sock:/var/run/docker.sock # optional but required for Docker integration feature
    ports:
      - 5005:5005
    environment:
      - PASSWORD=2579
    restart: unless-stopped
```
   
