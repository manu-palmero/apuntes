
``` yaml
version: '2'

volumes:
  nextcloud:
  db:

services:
  db:
    image: mariadb:10.6
    restart: always
    command: --transaction-isolation=READ-COMMITTED --log-bin=binlog --binlog-format=ROW
    volumes:
      - /srv/dev-disk-by-uuid-95d22765-3cce-4b58-b9fd-7813bb282e68/apps/config/db:/var/lib/mysql
    environment:
      - MYSQL_ROOT_PASSWORD="Mipm::2006"
      - MYSQL_PASSWORD="25794613"
      - MYSQL_DATABASE=nextcloud
      - MYSQL_USER=nextcloud

  app:
    image: nextcloud
    restart: always
    ports:
      - 8080:80
    links:
      - db
    volumes:
      - /srv/dev-disk-by-uuid-95d22765-3cce-4b58-b9fd-7813bb282e68/apps/config/nextcloud:/var/www/html
    environment:
      - MYSQL_PASSWORD="25794613"
      - MYSQL_DATABASE=nextcloud
      - MYSQL_USER=nextcloud
      - MYSQL_HOST=db
```
Problemas comunes con Nextcloud:   
  [cURL error 28: Operation timed out after XXXXXX milliseconds with XXXXXX out of XXXXXX bytes received (see http://curl.haxx.se/libcurl/c/libcurl-errors.html)](curl%20error%2028.md)    
  [Trusted domains](Nextcloud%20Trusted%20domains.md)    
   
