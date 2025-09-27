
``` yaml
version: '3'
services:
  app:
    image: 'jc21/nginx-proxy-manager:latest'
    restart: unless-stopped
    ports:
      - '80:80'
      - '81:81'
      - '443:443'
    volumes:
      - /home/manu/docker/data/nginx-proxy-manager/data:/data
      - /home/manu/docker/data/nginx-proxy-manager/letsencrypt:/etc/letsencrypt
```
