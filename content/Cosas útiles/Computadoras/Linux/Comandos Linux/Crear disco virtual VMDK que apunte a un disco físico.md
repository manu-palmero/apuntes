---
tags:
  - vm
  - linux
---

Asegurarse de que el usuario está dentro del grupo _disk_:
```sh
sudo usermod -aG disk usuario
```

Identificar el disco duro físico al que se quiere hacer referencia con el virtual:
```sh
sudo fisk -l
```

Crear el disco VMDK:
```sh
VBoxManage internalcommands createrawvmdk -filename ./nombredeldiscovirtual.vmdk -rawdisk /dev/sda
```

Cambiar la propiedad del disco virtual:
```sh
sudo chown usuario:usuario ./nombredeldiscovirtual.vmdk
chmod 600 ./nombredeldiscovirtual.vmdk
```
