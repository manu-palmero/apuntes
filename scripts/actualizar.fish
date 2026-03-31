#!/usr/bin/env fish

# Cargar variables desde .env
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

# Verificar variables requeridas
if test -z "$NOTES_DIR"; or test -z "$CONTENT_DIR"; or test -z "$COMMIT_MSG"
	echo "Error: faltan variables requeridas en .env (NOTES_DIR, CONTENT_DIR, COMMIT_MSG)"
	exit 1
end

# Verificar que la carpeta de notas existe
if not test -d "$NOTES_DIR"
	echo "Error: $NOTES_DIR no existe"
	exit 1
end

# Verificar que estamos en un repositorio git
if not git rev-parse --git-dir &>/dev/null
	echo "Error: No estamos en un repositorio git"
	exit 1
end

# Crear la carpeta .content si no existe
mkdir -p "$CONTENT_DIR"

# Sincronizar con rsync (solo cambios necesarios)
echo "📂 Sincronizando contenido..."
rsync -a --delete "$NOTES_DIR/" "$CONTENT_DIR/" >/dev/null
if test $status -ne 0
	echo "Error: rsync falló"
	exit 1
end

# Compilar con Quartz
echo "🔨 Compilando con Quartz..."
npx quartz build >/dev/null
if test $status -ne 0
	echo "Error: Quartz build falló"
	exit 1
end

# Verificar si hay cambios
if git diff --quiet && git diff --cached --quiet
	echo "✓ Sin cambios para sincronizar"
	exit 0
end

# Agregar cambios al staging
echo "📝 Agregando cambios..."
git add "$CONTENT_DIR" >/dev/null 2>/dev/null

# Hacer commit
echo "💾 Haciendo commit..."
git commit -m "$COMMIT_MSG" >/dev/null 2>/dev/null
if test $status -ne 0
	echo "Error: commit falló"
	exit 1
end

# Subir a GitHub
echo "🚀 Subiendo a GitHub..."
git push >/dev/null 2>/dev/null
if test $status -ne 0
	echo "Error: push falló"
	exit 1
end

echo "✓ Sincronización completada exitosamente"