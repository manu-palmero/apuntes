#!/bin/bash

# Copia de seguridad de archivos y directorios
MINECRAFT_DIR="/home/manu/minecraft/data"
BACKUP_DIR="/home/manu/minecraft/backup"
DATE=$(date +%Y-%m-%d_%H-%M)

# Crear el directorio de copia de seguridad si no existe
mkdir -p "$BACKUP_DIR"

# Crear la copia de seguridad
if tar -czf "$BACKUP_DIR/minecraft_backup_$DATE.tar.gz" "$MINECRAFT_DIR"; then
    echo "Copia de seguridad creada con éxito: $BACKUP_DIR/minecraft_backup_$DATE.tar.gz"
else
    echo "Error al crear la copia de seguridad."
fi

# Eliminar copias de seguridad más antiguas de 7 días
if find "$BACKUP_DIR" -type f -name "*.tar.gz" -mtime +7 -exec rm {} \;; then
    echo "Copias de seguridad antiguas eliminadas con éxito."
else
    echo "Error al eliminar copias de seguridad antiguas."
fi

# Fin del script