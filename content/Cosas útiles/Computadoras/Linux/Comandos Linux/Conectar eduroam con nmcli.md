---
tags:
  - linux
  - redes
---

```shell
nmcli connection add type wifi con-name eduroam ifname wlp7s0 ssid eduroam

nmcli connection modify eduroam \
wifi-sec.key-mgmt wpa-eap \
802-1x.eap peap \
802-1x.identity "correo institucional" \
802-1x.password "contraseña de sysacad"
802-1x.phase2-auth mschapv2 \
802-1x.system-ca-certs no

nmcli connection up eduroam

```