---
tags:
  - audio
  - linux
---


Para convertir de OPUS a MP3
```shell
ffmpeg -i archivo.opus archivo.mp3
```

Para especificar la tasa de bits
```shell
ffmpeg -i archivo.opus -b:a 192k archivo.mp3
```

Para convertir todos los archivos OPUS de la carpeta actual a MP3
```shell
for archivo in *.opus; do 
	ffmpeg -i "$archivo" "${archivo%.opus}.mp3" 
done
```
