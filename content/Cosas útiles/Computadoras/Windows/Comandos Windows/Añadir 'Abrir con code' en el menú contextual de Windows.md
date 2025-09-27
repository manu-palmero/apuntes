Crear `vsCodeOpenFolder.reg` con el siguiente contenido:
```
Windows Registry Editor Version 5.00

; Open files
[HKEY_CLASSES_ROOT\*\\shell\\Open with VS Code]
@="Editar con VS Code"
"Icon"="C:\\Program Files\\Microsoft VS Code\\Code.exe,0"

[HKEY_CLASSES_ROOT\*\\shell\\Open with VS Code\\command]
@="\"C:\\Program Files\\Microsoft VS Code\\Code.exe\" \"%1\""

; Open folders
[HKEY_CLASSES_ROOT\Directory\\shell\\vscode]
@="Abrir carpeta como proyecto en VS Code"
"Icon"="C:\\Program Files\\Microsoft VS Code\\Code.exe,0"

[HKEY_CLASSES_ROOT\Directory\\shell\\vscode\\command]
@="\"C:\\Program Files\\Microsoft VS Code\\Code.exe\" \"%1\""

; Open folders (background)
[HKEY_CLASSES_ROOT\Directory\\Background\\shell\\vscode]
@="Abrir carpeta como proyecto en VS Code"
"Icon"="C:\\Program Files\\Microsoft VS Code\\Code.exe,0"

[HKEY_CLASSES_ROOT\Directory\\Background\\shell\\vscode\\command]
@="\"C:\\Program Files\\Microsoft VS Code\\Code.exe\" \"%V\""
```
%% CORREGIR %%
%% CAMBIAR RUTA POR LA INSTALACIÓN DE USUARIO EN APPDATA %%