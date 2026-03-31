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

# Sincronizar con rsync (solo cambios necesarios)
if ! rsync -a --delete "$NOTES_DIR/" "$CONTENT_DIR/" >/dev/null 2>&1; then
  echo "Error: rsync falló"
  exit 1
fi

# Compilar con Quartz
if ! npx quartz build >/dev/null 2>&1; then
  echo "Error: Quartz build falló"
  exit 1
fi

# Verificar si hay cambios
if git diff --quiet && git diff --cached --quiet; then
  exit 0
fi

# Agregar cambios al staging
git add "$CONTENT_DIR" >/dev/null 2>&1

# Hacer commit
if ! git commit -m "$COMMIT_MSG" >/dev/null 2>&1; then
  echo "Error: commit falló"
  exit 1
fi

# Subir a GitHub
if ! git push >/dev/null 2>&1; then
  echo "Error: push falló"
  exit 1
fi
