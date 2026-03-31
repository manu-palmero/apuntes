#!/usr/bin/env pwsh

$ErrorActionPreference = "Stop"
$PSNativeCommandUseErrorActionPreference = $true

function Exit-WithError {
  param([string]$Message)
  Write-Host $Message
  exit 1
}

# Carga de variables desde .env
if (Test-Path ".env") {
  Get-Content ".env" | ForEach-Object {
    if ($_ -match '^\s*#' -or $_ -match '^\s*$') {
      return
    }

    $parts = $_ -split '=', 2
    if ($parts.Count -eq 2) {
      $name = $parts[0].Trim()
      $value = $parts[1].Trim().Trim('"')
      [System.Environment]::SetEnvironmentVariable($name, $value)
    }
  }
} else {
  Exit-WithError "Error: archivo .env no encontrado"
}

$NOTES_DIR = [System.Environment]::GetEnvironmentVariable("NOTES_DIR")
$CONTENT_DIR = [System.Environment]::GetEnvironmentVariable("CONTENT_DIR")
$COMMIT_MSG = [System.Environment]::GetEnvironmentVariable("COMMIT_MSG")

if ([string]::IsNullOrWhiteSpace($NOTES_DIR) -or [string]::IsNullOrWhiteSpace($CONTENT_DIR) -or [string]::IsNullOrWhiteSpace($COMMIT_MSG)) {
  Exit-WithError "Error: faltan variables requeridas en .env (NOTES_DIR, CONTENT_DIR, COMMIT_MSG)"
}

# Verificación de existencia de la carpeta de notas
if (-not (Test-Path -Path $NOTES_DIR -PathType Container)) {
  Exit-WithError "Error: $NOTES_DIR no existe"
}

# Verificación de ejecución dentro de un repositorio git
try {
  git rev-parse --git-dir | Out-Null
} catch {
  Exit-WithError "Error: No estamos en un repositorio git"
}

# Creación de la carpeta .content en caso de ausencia
New-Item -ItemType Directory -Force -Path $CONTENT_DIR | Out-Null

# Definición de carpeta objetivo para operaciones de git
$PUBLIC_DIR = "public"

# Sincronización con rsync (solo cambios necesarios)
Write-Host "📂 Sincronizando contenido..."
try {
  & rsync -a --delete "$NOTES_DIR/" "$CONTENT_DIR/" 2>&1 | Where-Object { $_ } > $null
} catch {
  Exit-WithError "Error: rsync falló"
}

# Compilación con Quartz
Write-Host "🔨 Compilando con Quartz..."
try {
  if ([System.Environment]::GetEnvironmentVariable("DEBUG_BUILD") -eq "1") {
    npx quartz build
  } else {
    npx quartz build 2>&1 | Where-Object { $_ } > $null
  }
} catch {
  Exit-WithError "Error: Quartz build falló"
}

# Agregado al staging solo de cambios en public
Write-Host "📝 Agregando cambios de $PUBLIC_DIR..."
git add "$PUBLIC_DIR" 2>&1 | Where-Object { $_ } > $null

# Verificación de cambios únicamente en public
& git diff --cached --quiet -- "$PUBLIC_DIR"
$cachedPublicStatus = $LASTEXITCODE

if ($cachedPublicStatus -eq 0) {
  Write-Host "✓ Sin cambios en $PUBLIC_DIR para sincronizar"
  exit 0
}

# Commit limitado únicamente a public
Write-Host "💾 Haciendo commit..."
try {
  git commit -m "$COMMIT_MSG" -- "$PUBLIC_DIR" 2>&1 | Where-Object { $_ } > $null
} catch {
  Exit-WithError "Error: commit falló"
}

# Envío de cambios a GitHub
Write-Host "🚀 Subiendo a GitHub..."
try {
  git push 2>&1 | Where-Object { $_ } > $null
} catch {
  Exit-WithError "Error: push falló"
}

Write-Host "✓ Sincronización completada exitosamente"
