Se puede editar el archivo de acceso directo `/usr/share/applications/steam.desktop` (o donde esté ubicado) y el archivo de autoinicio de aplicaciones `~/.config/autostart/steam.desktop` y agregar la opción `-silent` antes de `%U` para iniciar Steam minimizado
```sh
/usr/bin/steam -silent %U
```