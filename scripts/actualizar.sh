#!/usr/bin/env bash

set -euo pipefail

# Carga de variables desde .env
if [[ -f .env ]]; then
  set -a
  # shellcheck disable=SC1091
  source .env
  set +a
else
  echo "Error: archivo .env no encontrado"
  exit 1
fi

# Verificación de existencia de la carpeta de notas
if [[ ! -d "$NOTES_DIR" ]]; then
  echo "Error: $NOTES_DIR no existe"
  exit 1
fi

# Verificación de ejecución dentro de un repositorio git
if ! git rev-parse --git-dir >/dev/null 2>&1; then
  echo "Error: No estamos en un repositorio git"
  exit 1
fi

# Creación de la carpeta .content en caso de ausencia
mkdir -p "$CONTENT_DIR"

# Definición de carpeta objetivo para operaciones de git
PUBLIC_DIR="public"
WORKFLOW_MARKER="[quartz-sync]"

# Sincronización con rsync (solo cambios necesarios)
echo "📂 Sincronizando contenido..."
if ! rsync -a --delete "$NOTES_DIR/" "$CONTENT_DIR/" >/dev/null; then
  echo "Error: rsync falló"
  exit 1
fi

# Compilación con Quartz
echo "🔨 Compilando con Quartz..."
if [[ "${DEBUG_BUILD:-0}" == "1" ]]; then
  npx quartz build
  build_status=$?
else
  npx quartz build >/dev/null
  build_status=$?
fi

if [[ $build_status -ne 0 ]]; then
  echo "Error: Quartz build falló"
  exit 1
fi

# Agregado al staging solo de cambios en public
echo "📝 Agregando cambios de $PUBLIC_DIR..."
git add "$PUBLIC_DIR" >/dev/null

# Verificación de cambios únicamente en public
if git diff --cached --quiet -- "$PUBLIC_DIR"; then
  echo "✓ Sin cambios en $PUBLIC_DIR para sincronizar"
  exit 0
fi

# Commit limitado únicamente a public
echo "💾 Haciendo commit..."
commit_message="$COMMIT_MSG"
if [[ "$commit_message" != *"$WORKFLOW_MARKER"* ]]; then
  commit_message="$WORKFLOW_MARKER $commit_message"
fi

if ! git commit -m "$commit_message" -- "$PUBLIC_DIR" >/dev/null; then
  echo "Error: commit falló"
  exit 1
fi

# Envío de cambios a GitHub
echo "🚀 Subiendo a GitHub..."
if ! git push >/dev/null; then
  echo "Error: push falló"
  exit 1
fi

echo "✓ Sincronización completada exitosamente"
