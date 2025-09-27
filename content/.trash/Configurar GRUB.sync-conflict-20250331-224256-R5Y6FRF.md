La configuración por defecto de GRUB se encuentra en `/etc/default/grub`.

Algunas de las opciones que se pueden cambiar son:

- `GRUB_TIMEOUT`: Tiempo de espera en segundos antes de arrancar el sistema por defecto.
- `GRUB_TIMEOUT_STYLE`: Puede tomar por valor `menu`, `countdown` o `hidden`, siendo `menu` el valor por defecto cuando a esta variable no se le asigna valor.
  - **Si está en `menu`**: Se muestra el menú y se espera el tiempo asignado en `GRUB_TIMEOUT`.
  - **Si está en `countdown` o `hidden`**: Se esperará a que expire el tiempo de espera establecido en `GRUB_TIMEOUT` antes de mostrar el menú. Si se pulsan *\<ESC>* o *\<F4>*, o se mantiene pulsada *\<SHIFT>* durante ese tiempo, mostrará el menú y esperará la entrada. Si se pulsa una tecla de acceso rápido asociada a una entrada de menú, GRUB iniciará dicha entrada inmediatamente. Si el tiempo de espera expira antes de que ocurra cualquiera de estas dos opciones, GRUB iniciará la entrada predeterminada. En el caso de la "cuenta regresiva", GRUB mostrará una línea con el tiempo restante.
- `GRUB_CMDLINE_LINUX`: Argumentos de línea de comandos para agregar a las entradas del menú del núcleo de Linux.
- `GRUB_CMDLINE_LINUX_DEFAULT`: Argumentos de línea de comandos para agregar a las entradas del menú del núcleo de Linux **solamente en la entrada de menú por defecto de linux, no en las otras**. Se añadirán luego de los argumentos listados en `GRUB_CMDLINE_LINUX`.
- `GRUB_DISABLE_RECOVERY`: Deshabilita la generación de entradas de modo de recuperación.

^actualizar-grub
Luego de realizar cualquier configuración a este archivo, se debe actualizar GRUB con el comando:

```shell
sudo update-grub2
```
