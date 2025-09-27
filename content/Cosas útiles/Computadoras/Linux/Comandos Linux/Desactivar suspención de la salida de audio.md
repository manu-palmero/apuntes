---
tags:
  - linux
  - audio
---


# Desactivar la suspención de la salida de audio (Pipewire, Wireplumber)

Por defecto, la salida de audio se suspende luego de cinco segundos de inactividad, lo que genera ruido blanco en los altavoces y un notable retraso de audio al habilitar de nuevo la salida después de haber sido suspendida.

Para desactivar esta característica hay que editar `/usr/share/wireplumber/wireplumber.conf` (en Debian se encuentrá ahí) comentando lo siguiente:
```ini
  ## Node configuration hooks
  {
    name = node/create-item.lua, type = script/lua
    provides = hooks.node.create-session-item
    requires = [ si.audio-adapter, si.node ]
  }
#  {
#    name = node/suspend-node.lua, type = script/lua
#    provides = hooks.node.suspend
#  }
  {
    name = node/state-stream.lua, type = script/lua
    provides = hooks.stream.state
  }
  {
    name = node/filter-forward-format.lua, type = script/lua
    provides = hooks.filter.forward-format
  }
  {
    type = virtual, provides = policy.node
    requires = [ hooks.node.create-session-item ]
#    wants = [ hooks.node.suspend
    wants = [ hooks.stream.state
              hooks.filter.forward-format ]
  }

  {
    name = node/software-dsp.lua, type = script/lua
    provides = node.software-dsp
  }

```

Luego reiniciar los servicios:
```shell
systemctl --user restart pipewire wireplumber
```
O simplemente reiniciar el ordenador:
```shell
systemctl reboot
```