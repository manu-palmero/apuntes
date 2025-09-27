---
tags:
  - programación
  - linux
lenguaje: bash
---
# Funciones para agregar lineas luego de una línea especificada a un archivo en bash

## **Función `agregar_linea`**
Esta función de `bash` inserta una nueva línea de texto después de una línea que contenga una cadena específica dentro de un archivo.

### **Modo de uso**
```bash
agregar_linea <archivo> "<cadena_a_buscar>" "<linea_a_agregar>"
```

### **Argumentos**
- **`archivo`**: La ruta al archivo de texto a modificar.
- **`cadena_a_buscar`**: La subcadena que la función buscará en cada línea. La nueva línea se agregará debajo de la línea que contenga esta subcadena.
- **`linea_a_agregar`**: El texto de la nueva línea que se insertará.

### **Ejemplo**
Para agregar la línea "nueva_linea" debajo de la línea que contenga la palabra "ejemplo" en el archivo `mi_archivo.txt`:
```bash
agregar_linea mi_archivo.txt "ejemplo" "nueva_linea"
```

## Opción 1
```bash
function agregar_linea {
	# Modo de uso: agregar_linea archivo.txt "cadena a buscar" "línea a agregar"
	
	# Verificar si se proporcionaron los argumentos correctos
	if [ "$#" -ne 3 ]; then
		echo -e "Error: Se esperaban 3 argumentos, pero se recibieron $#."
		return 1
	else
		# Pasar los parámetros a variables
		local archivo="$1"
		local cadena_a_buscar="$2"
		local linea_a_agregar="$3"
	fi
	
	# Crear un archivo temporal para realizar las modificaciones
	tempfile=$(mktemp)
	
	# Iterar sobre cada línea del archivo
	while IFS= read -r linea; do
		# Agrega el contenido de la variable 'linea' al archivo temporal especificado por 'tempfile'.
		echo -e "$linea" >>"$tempfile"
		# Si la línea contiene la palabra a buscar, añadir la nueva línea debajo
		if [[ "$linea" == *"$cadena_a_buscar"* ]]; then # Cadena a buscar
		echo -e "$linea_a_agregar" >>"$tempfile" # Línea a agregar
		fi
	done <"$1" # Archivo de entrada
	
	# Reemplazar el archivo original con el archivo temporal modificado y eliminar el archivo temporal
	sudo mv "$tempfile" "$archivo"
	sudo rm -f "$tempfile"
}
```

Utiliza un bucle `while` para leer el archivo original. Por cada línea que lee:

1. Escribe la línea original en un archivo temporal.
2. Verifica si esa línea contiene la **cadena a buscar**.
3. Si la encuentra, escribe también la **línea a agregar** en el archivo temporal, justo después de la línea que encontró.

Al finalizar el bucle, el archivo temporal contiene el contenido original con la nueva línea insertada. Finalmente, reemplaza el archivo original con el temporal y lo borra para limpiar. Este método es útil si quieres un control muy granular sobre el proceso, pero puede ser más lento en archivos muy grandes debido a la lectura y escritura línea por línea.

## Opción 2
```bash
function agregar_linea {
	# Modo de uso: agregar_linea archivo.txt "cadena a buscar" "línea a agregar"

	# Verificar si se proporcionaron los argumentos correctos
	if [ "$#" -ne 3 ]; then
		echo -e "Error: Se esperaban 3 argumentos, pero se recibieron $#."
		return 1
	else
		local archivo="$1"
		local cadena_a_buscar="$2"
		local linea_a_agregar="$3"
	fi
	# Usar sed para agregar la línea después de la línea que contiene la cadena a buscar
	sudo sed -i "/$cadena_a_buscar/a $linea_a_agregar" "$archivo"
}
```

Esta función es mucho más corta y eficiente porque delega la tarea a una herramienta especializada: el comando **`sed`** (del inglés "stream editor").

- `sudo sed -i`: Invoca `sed` con la opción `-i` para editar el archivo **in-place** (es decir, lo modifica directamente en lugar de imprimir la salida en la terminal).
- `"/$cadena_a_buscar/a"`: Esta es la sintaxis de `sed` para buscar una cadena. Cuando encuentra una línea que coincide con la **cadena a buscar**, la acción `a` (del inglés "append") le indica que debe **añadir** una nueva línea.
- `$linea_a_agregar`: Es el texto que se insertará.
- `"$archivo"`: Es el archivo sobre el cual se ejecutará el comando.

Este enfoque es considerablemente más rápido y se considera la forma estándar y recomendada de realizar este tipo de edición en `bash`, ya que `sed` está optimizado para estas operaciones. 
En esencia, hace lo mismo que la versión con el bucle, pero de una manera mucho más directa y optimizada.

