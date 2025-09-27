# Instalación manual de Nextcloud en Debian 12

## Instalación de paquetes y dependencias

1. Actualizar los paquetes:

```bash
sudo apt update && sudo apt upgrade
```

2. Instalar apache y el servidor de mysql:

```bash
sudo apt install apache2 mariadb-server
```

3. Instalar PHP y dependencias necesarias:

```bash
sudo apt install libapache2-mod-php php-bz2 php-gd php-mysql php-curl php-mbstring php-imagick php-zip php-ctype php-curl php-dom php-json php-posix php-bcmath php-xml php-intl php-gmp zip unzip wget
```

4. Habilitar módulos de apache:

```bash
sudo a2enmod rewrite dir mime env headers
sudo systemctl restart apache2
```

## Configurar el servidor MySQL
Entrar a MySQL:
```bash
sudo mysql
```
Y luego ejecutar:
```sql
CREATE USER 'nextcloud'@'localhost' IDENTIFIED BY 'password';
CREATE DATABASE IF NOT EXISTS nextcloud CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
GRANT ALL PRIVILEGES ON nextcloud.* TO 'nextcloud'@'localhost';
FLUSH PRIVILEGES;
quit;
```

>[!todo] Cambiar la contraseña del usuario nextloud por alguna segura.

## Descargar e instalar Nextcloud

```bash
cd /var/www/html
# Descargar el archivo
wget https://download.nextcloud.com/server/releases/latest.zip
# Descomprimir el archivo
unzip latest.zip

# En caso de que se quiera que Nextcloud sea la página principal y no se vaya a usar otra, hay que mover los archivos a la carpeta /var/www/html
cd /var/www/html/nextcloud
mv -- * .* ../
cd ..
rmdir /var/www/html/nextcloud

# Dar los permisos correspondientes
chown -R www-data:www-data /var/www/html
```

### Ejecutar script de instalación de Nextcloud

```bash
cd /var/www/html

sudo -u www-data php occ  maintenance:install --database "mysql" --database-name "nextcloud"  --database-user "nextcloud" --database-pass "password" --admin-user "admin" --admin-pass "password"
```

>[!todo] Cambiar la contraseña del usuario de la base de datos, --database-password, por la creada anteriormente.

Los parámetros `–admin-user` y `–admin-pass` hay que cambiarlos por el usuario y la contraseña de administrador que se usarán para ingresar a nextcloud, respectivamente.

## Corregir acceso denegado a la página

Editar el archivo `/var/www/html/config/config.php`
  
```php
<?php

$CONFIG = array (
  'passwordsalt' => '6xL/geSpIgrZVkhqChifihY9Iq3F9o',
  'secret' => 'FCa8xU4jvhkmGg7nW6DeQ596TWTU07yD/AR0oq3/XT9V27Kg',
  'trusted_domains' => // Hay que buscar esta línea
  array (
    0 => 'localhost',
    1 => '10.1.86.25', // Acá se añade
    2 => 'dominio.com' // Se pueden añadir tantos como sea necesario
  ),

…… // El resto del documento

```

El dominio que se añada debe ser con el que se va a acceder a Nextcloud, es decir, la IP o dominio del servidor.

- [ ] Terminar de pasar lo que esté en Google Docs acá ➕ 2025-03-02 📅 2025-03-03 🏁 keep 