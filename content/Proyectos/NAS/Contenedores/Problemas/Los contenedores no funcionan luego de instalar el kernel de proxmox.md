El error se ve así: `s6-ipcserver-socketbinder: fatal: unable to create socket: Permission denied`

Hay que desactivar apparmor:
```bash
apt remove apparmor -y # Opcional
sudo mkdir -p /etc/default/grub.d
echo 'GRUB_CMDLINE_LINUX_DEFAULT="$GRUB_CMDLINE_LINUX_DEFAULT apparmor=0"' | sudo tee /etc/default/grub.d/apparmor.cfg
sudo update-grub
sudo rebbot
```
