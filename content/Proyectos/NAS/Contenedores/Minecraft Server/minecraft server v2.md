```yaml
services:
  mc:
    container_name: minecraft
    image: itzg/minecraft-server:java8
    tty: true
    stdin_open: true
    ports:
      - "70:25565"
      - "7092:7092"
    environment:
      DEBUG: false
      UID: 1000
      GID: 1000
      WHITELIST: |
        xjneuks
        krathoss_LG
        lordayuwoky1325
        ByMaury
        PMM4
        Codyhaiirowo
      ANNOUNCE_PLAYER_ACHIEVEMENTS: true
      VIEW_DISTANCE: 7
      EXEC_DIRECTLY: true
      ENABLE_RCON: true
      RCON_PASSWORD: ""
      RCON_PORT: "25575"
      ENABLE_JMX: true
      JMX_HOST: ${HOSTNAME}
      JMX_PORT: "7092"
      INIT_MEMORY: 3G
      MAX_MEMORY: 6G
      SERVER_NAME: El server jaja
      SERVER_PORT: 25565
      SNOOPER_ENABLED: false
      TYPE: "FORGE"
      VERSION: "1.16.5"
      EULA: "TRUE"
      FORCE_GAMEMODE: true
      MOTD: | 
        \u00a7r            El \u00a74server\u00a7r jaja \u00a7kXDLOLOSKIBIDI\u00a7r
        \u00a7l                     M\u00e1tensen
      ICON: "/data/server-icon.png"
      DIFFICULTY: hard
      MODE: survival
      ALLOW_FLIGHT: "TRUE"
      BROADCAST_CONSOLE_TO_OPS: true
      BROADCAST_RCON_TO_OPS: true
      SYNC_CHUNK_WRITES: false
      PVP: true
      ONLINE_MODE: true
    volumes:
      - /home/manu/minecraft/data:/data
```

