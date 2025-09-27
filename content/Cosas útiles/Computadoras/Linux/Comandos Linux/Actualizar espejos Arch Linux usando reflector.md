---
tags:
  - archlinux
  - linux
---

```sh
sudo cp -vf /etc/pacman.d/mirrorlist /etc/pacman.d/mirrorlist.backup

sudo reflector --verbose -l 10 --sort rate --save /etc/pacman.d/mirrorlist
```
