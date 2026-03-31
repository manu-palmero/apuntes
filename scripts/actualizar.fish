#!/usr/bin/env fish

# Carga de variables desde .env
if test -f .env
	while read -l line
		set line (string trim -- "$line")

		if test -z "$line"
			continue
		end

		if string match -qr '^#' -- "$line"
			continue
		end

		set -l parts (string split -m 1 '=' -- "$line")
		if test (count $parts) -ne 2
			continue
		end

		set -l key (string trim -- "$parts[1]")
		set -l value (string trim -- "$parts[2]")

		if string match -qr '^".*"$' -- "$value"
			set value (string sub -s 2 -e -1 -- "$value")
		else if string match -qr "^'.*'\$" -- "$value"
			set value (string sub -s 2 -e -1 -- "$value")
		end

		set -gx $key "$value"
	end < .env
else
	echo "Error: archivo .env no encontrado"
	exit 1
end

# Verificación de variables requeridas
if test -z "$NOTES_DIR"; or test -z "$CONTENT_DIR"; or test -z "$COMMIT_MSG"
	echo "Error: faltan variables requeridas en .env (NOTES_DIR, CONTENT_DIR, COMMIT_MSG)"
	exit 1
end

# Verificación de existencia de la carpeta de notas
if not test -d "$NOTES_DIR"
	echo "Error: $NOTES_DIR no existe"
	exit 1
end

# Verificación de ejecución dentro de un repositorio git
if not git rev-parse --git-dir &>/dev/null
	echo "Error: No se está en un repositorio git"
	exit 1
end

# Creación de la carpeta .content en caso de ausencia
mkdir -p "$CONTENT_DIR"

# Definición de carpeta objetivo para operaciones de git
set -l PUBLIC_DIR "public"
set -l WORKFLOW_MARKER "[quartz-sync]"

# Sincronización con rsync (solo cambios necesarios)
echo "📂 Sincronizando contenido..."
rsync -a --delete "$NOTES_DIR/" "$CONTENT_DIR/" >/dev/null
if test $status -ne 0
	echo "Error: rsync falló"
	exit 1
end

# Compilación con Quartz
echo "🔨 Compilando con Quartz..."
if set -q DEBUG_BUILD; and test "$DEBUG_BUILD" = "1"
        npx quartz build
else
        npx quartz build >/dev/null
end
if test $status -ne 0
	echo "Error: Quartz build falló"
	exit 1
end

# Agregado al staging solo de cambios en public
echo "📝 Agregando cambios de $PUBLIC_DIR..."
git add "$PUBLIC_DIR" >/dev/null 2>/dev/null

# Verificación de cambios únicamente en public
if git diff --cached --quiet -- "$PUBLIC_DIR"
	echo "✓ Sin cambios en $PUBLIC_DIR para sincronizar"
	exit 0
end

# Commit limitado únicamente a public
echo "💾 Haciendo commit..."
set -l commit_message "$COMMIT_MSG"
if not string match -q "*$WORKFLOW_MARKER*" -- "$commit_message"
	set commit_message "$WORKFLOW_MARKER $commit_message"
end

git commit -m "$commit_message" -- "$PUBLIC_DIR" >/dev/null 2>/dev/null
if test $status -ne 0
	echo "Error: commit falló"
	exit 1
end

# Envío de cambios a GitHub
echo "🚀 Subiendo a GitHub..."
git push >/dev/null 2>/dev/null
if test $status -ne 0
	echo "Error: push falló"
	exit 1
end

echo "✓ Sincronización completada exitosamente"