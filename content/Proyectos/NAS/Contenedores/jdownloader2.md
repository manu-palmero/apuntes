
``` yaml
services:
   jdownloader:
    image: jaymoulin/jdownloader
    container_name: jdownloader
    restart: always
    user: 1000:100
    volumes:
        - /home/manu/docker/docker-data/jd/config:/opt/JDownloader/app/cfg
        - /srv/dev-disk-by-uuid-ea4c605b-e97d-48cf-af60-dc79c83afe51/descargas:/opt/JDownloader/Downloads
        - /srv/dev-disk-by-uuid-ea4c605b-e97d-48cf-af60-dc79c83afe51/docker/config/data/jd/logs:/opt/JDownloader/app/logs #optional
        - /srv/dev-disk-by-uuid-ea4c605b-e97d-48cf-af60-dc79c83afe51/docker/config/data/jd/extensions:/opt/JDownloader/app/extensions #optional
        - /etc/localtime:/etc/localtime:ro #optional
    environment: 
            # FILE_MYJD_USER: myjd-user #optional (see [Identify](https://github.com/jaymoulin/docker-jdownloader#identify))
            # FILE_MYJD_PASSWORD: myjd-password #optional (see [Identify](https://github.com/jaymoulin/docker-jdownloader#identify))
            MYJD_USER: manueligna06@gmail.com #optional (see [Identify](https://github.com/jaymoulin/docker-jdownloader#identify))
            MYJD_PASSWORD: DX6R8xbHv5sTjKT #optional (see [Identify](https://github.com/jaymoulin/docker-jdownloader#identify))
            MYJD_DEVICE_NAME: manuserver #optional
            XDG_DOWNLOAD_DIR: /opt/JDownloader/Downloads #optional
    ports:
        - 3129:3129 
    #secrets:
        #- myjd-user #optional (see [Identify](https://github.com/jaymoulin/docker-jdownloader#identify))
        #- myjd-password #optional (see [Identify](https://github.com/jaymoulin/docker-jdownloader#identify))

secrets:
  myjd-user: #optional (see [Identify](https://github.com/jaymoulin/docker-jdownloader#identify))
    file: ~/jdownloader/secrets/myjd_user.txt
  myjd-password: #optional (see [Identify](https://github.com/jaymoulin/docker-jdownloader#identify))
    file: ~/jdownloader/secrets/myjd_password.txt
```
