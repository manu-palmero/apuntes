#!/usr/bin/env bash

set -euo pipefail

# Cargar variables desde .env
if [[ -f .env ]]; then
  set -a
  # shellcheck disable=SC1091
  source .env
  set +a
else
  echo "Error: archivo .env no encontrado"
  exit 1
fi

# Verificar que la carpeta de notas existe
if [[ ! -d "$NOTES_DIR" ]]; then
  echo "Error: $NOTES_DIR no existe"
  exit 1
fi

# Verificar que estamos en un repositorio git
if ! git rev-parse --git-dir >/dev/null 2>&1; then
  echo "Error: No estamos en un repositorio git"
  exit 1
fi

# Crear la carpeta .content si no existe
mkdir -p "$CONTENT_DIR"

# Carpeta objetivo para operaciones de git
PUBLIC_DIR="public"

# Sincronizar con rsync (solo cambios necesarios)
echo "📂 Sincronizando contenido..."
if ! rsync -a --delete "$NOTES_DIR/" "$CONTENT_DIR/" >/dev/null; then
  echo "Error: rsync falló"
  exit 1
fi

# Compilar con Quartz
echo "🔨 Compilando con Quartz..."
if ! npx quartz build >/dev/null; then
  echo "Error: Quartz build falló"
  exit 1
fi

# Agregar solo cambios de public al staging
echo "📝 Agregando cambios de $PUBLIC_DIR..."
git add "$PUBLIC_DIR" >/dev/null

# Verificar si hay cambios solo en public
if git diff --cached --quiet -- "$PUBLIC_DIR"; then
  echo "✓ Sin cambios en $PUBLIC_DIR para sincronizar"
  exit 0
fi

# Hacer commit solo de public
echo "💾 Haciendo commit..."
if ! git commit -m "$COMMIT_MSG" -- "$PUBLIC_DIR" >/dev/null; then
  echo "Error: commit falló"
  exit 1
fi

# Subir a GitHub
echo "🚀 Subiendo a GitHub..."
if ! git push >/dev/null; then
  echo "Error: push falló"
  exit 1
fi

echo "✓ Sincronización completada exitosamente"
