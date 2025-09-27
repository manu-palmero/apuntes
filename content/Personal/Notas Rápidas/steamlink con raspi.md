/etc/systemd/system/plymouth-delay.service

```systemd
[Unit]
Description=Delay system boot to show Plymouth longer
DefaultDependencies=no
After=plymouth-start.service
Before=plymouth-quit.service

[Service]
Type=oneshot
ExecStart=/bin/sleep 6

[Install]
WantedBy=multi-user.target
```

/etc/systemd/system/fake-wait.service
```systemd
[Unit]
Description=Fake boot delay
After=plymouth-start.service
Before=plymouth-quit.service

[Service]
Type=oneshot
ExecStart=/usr/bin/plymouth display-message --text="Cargando SteamLink..."
ExecStart=/bin/sleep 5

[Install]
WantedBy=multi-user.target
```
