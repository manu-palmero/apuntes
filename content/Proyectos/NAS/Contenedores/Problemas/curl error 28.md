---
tags:
  - nextcloud
  - docker
  - nas
  - error
tipo: Error
proyecto: NAS
---
# cURL error 28: Operation timed out after XXXXXX milliseconds with XXXXXX out of XXXXXX bytes received (see http://curl.haxx.se/libcurl/c/libcurl-errors.html)
Si Nextcloud se está ejecutando desde un contenedor de Docker:
``` bash
sudo docker exec -ti nextcloud-app-1 bash
```

Cambiar dentro del archivo `/var/www/html/lib/private/Installer.php` en la línea 295
``` php
$ timeout = $ this→ isCLI? 0: 120; # Por ejemplo: 300
```

>[!TIP] Funcionó correctamente con valores entre 1500 y 2000 para conexión de 1,25 MBbs (10 Mbps)