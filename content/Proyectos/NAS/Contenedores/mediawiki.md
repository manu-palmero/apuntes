``` yaml
# MediaWiki with MariaDB
#
# Access via "http://localhost:8080"
#   (or "http://$(docker-machine ip):8080" if using docker-machine)
# MediaWiki with MariaDB
#
# Access via "http://localhost:8080"
#   (or "http://$(docker-machine ip):8080" if using docker-machine)
version: '3'
services:
  mediawiki:
    image: mediawiki
    restart: always
    ports:
      - 8090:80
    links:
      - database
    networks:
      - mediawiki
    volumes:
      - /srv/dev-disk-by-uuid-ea4c605b-e97d-48cf-af60-dc79c83afe51/docker/config/data/wiki/images:/var/www/html/images
      # After initial setup, download LocalSettings.php to the same directory as
      # this yaml and uncomment the following line and use compose to restart
      # the mediawiki service
      - /srv/dev-disk-by-uuid-ea4c605b-e97d-48cf-af60-dc79c83afe51/docker/config/data/wiki/LocalSettings.php:/var/www/html/LocalSettings.php
  # This key also defines the name of the database host used during setup instead of the default "localhost"
  database:
    image: mariadb
    restart: always
    networks:
      - mediawiki
    environment:
      # @see https://phabricator.wikimedia.org/source/mediawiki/browse/master/includes/DefaultSettings.php
      MYSQL_DATABASE: my_wiki
      MYSQL_USER: manu
      MYSQL_PASSWORD: Mipm2006
      MYSQL_ROOT_PASSWORD: "25794613"
    volumes:
      - /srv/dev-disk-by-uuid-ea4c605b-e97d-48cf-af60-dc79c83afe51/docker/config/data/wiki/db:/var/lib/mysql
  phpmyadmin:
    depends_on:
      - database
    image: phpmyadmin/phpmyadmin
    restart: always
    ports:
      - 8091:80
    environment:
      PMA_HOST: database
      MYSQL_ROOT_PASSWORD: "25794613"
      UPLOAD_LIMIT: 64M
    networks:
      - mediawiki
networks:
  mediawiki:
    driver: bridge
```