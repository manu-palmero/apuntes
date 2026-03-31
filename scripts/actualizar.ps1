#!/usr/bin/env pwsh

$ErrorActionPreference = "Stop"
$PSNativeCommandUseErrorActionPreference = $true

function Exit-WithError {
  param([string]$Message)
  Write-Host $Message
  exit 1
}

# Cargar variables desde .env
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

# Verificar que la carpeta de notas existe
if (-not (Test-Path -Path $NOTES_DIR -PathType Container)) {
  Exit-WithError "Error: $NOTES_DIR no existe"
}

# Verificar que estamos en un repositorio git
try {
  git rev-parse --git-dir | Out-Null
} catch {
  Exit-WithError "Error: No estamos en un repositorio git"
}

# Crear la carpeta .content si no existe
New-Item -ItemType Directory -Force -Path $CONTENT_DIR | Out-Null

# Sincronizar con rsync (solo cambios necesarios)
Write-Host "📂 Sincronizando contenido..."
try {
  & rsync -a --delete "$NOTES_DIR/" "$CONTENT_DIR/" 2>&1 | Where-Object { $_ } > $null
} catch {
  Exit-WithError "Error: rsync falló"
}

# Compilar con Quartz
Write-Host "🔨 Compilando con Quartz..."
try {
  npx quartz build 2>&1 | Where-Object { $_ } > $null
} catch {
  Exit-WithError "Error: Quartz build falló"
}

# Verificar si hay cambios
& git diff --quiet
$diffStatus = $LASTEXITCODE
& git diff --cached --quiet
$cachedDiffStatus = $LASTEXITCODE

if ($diffStatus -eq 0 -and $cachedDiffStatus -eq 0) {
  Write-Host "✓ Sin cambios para sincronizar"
  exit 0
}

# Agregar cambios al staging
Write-Host "📝 Agregando cambios..."
git add "$CONTENT_DIR" 2>&1 | Where-Object { $_ } > $null

# Hacer commit
Write-Host "💾 Haciendo commit..."
try {
  git commit -m "$COMMIT_MSG" 2>&1 | Where-Object { $_ } > $null
} catch {
  Exit-WithError "Error: commit falló"
}

# Subir a GitHub
Write-Host "🚀 Subiendo a GitHub..."
try {
  git push 2>&1 | Where-Object { $_ } > $null
} catch {
  Exit-WithError "Error: push falló"
}

Write-Host "✓ Sincronización completada exitosamente"
