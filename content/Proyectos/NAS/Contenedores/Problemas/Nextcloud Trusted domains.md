---
tags:
  - nextcloud
  - docker
  - nas
  - error
---

``` bash
sudo docker exec -ti nextcloud-app-1 bash
```
/var/www/html/config/config.php     
  ``` php
'trusted_domains' =>
array (
0 => '192.168.0.29',
1 => 'cloud.example.com',
),
```
   
El dominio que se añada debe ser con el que se va a acceder a Nextcloud, es decir, la IP o dominio del servidor.