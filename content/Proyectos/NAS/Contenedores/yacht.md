``` yaml
# docker run -d -p 8000:8000 -v /var/run/docker.sock:/var/run/docker.sock -v yacht:/config selfhostedpro/yacht

services:
    yacht:
        image: selfhostedpro/yacht
        container_name: yacht
        volumes:
            - /var/run/docker.sock:/var/run/docker.sock
            - /srv/dev-disk-by-uuid-ea4c605b-e97d-48cf-af60-dc79c83afe51/docker/config/data/yacht:/config
        ports:
            - 8001:8000
        restart: unless-stopped
```

>Inicio de sesión por defecto:
>	Usuario: `admin@yacht.local`
>	Contraseña: `pass`