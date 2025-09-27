
``` yaml
---
services:
  speedtest-tracker:
    image: lscr.io/linuxserver/speedtest-tracker:latest
    container_name: speedtest-tracker
    environment:
      - PUID=1000
      - PGID=1000
      - TZ=America/Argentina/Mendoza
      - DB_CONNECTION=sqlite
      - TELEGRAM_BOT_TOKEN=7189730505:AAEVPW3bPhstVGHLL-DLai7YyhyZYrFkVxo
      - APP_KEY="base64:GsayYi3tBjbpGGJ2HDc7xol71UXK0JWEilEUCuW5ies=" # Clave obtenida de https://speedtest-tracker.dev/
      - SPEEDTEST_SCHEDULE=*/15 * * * * * # Cada 15 minutos (cron)
      - SPEEDTEST_SERVERS=60319 # Servidor de redes del oeste, Mendoza
      #- APP_KEY= #optional
      #- DB_HOST= #optional
      #- DB_PORT= #optional
      #- DB_DATABASE= #optional
      #- DB_USERNAME= #optional
      #- DB_PASSWORD= #optional
    volumes:
      - /home/manu/docker/docker-data/speedtest:/config
    ports:
      - 70:80
    restart: unless-stopped
```
