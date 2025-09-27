
```
ffmpeg -i input.mp4 -vf "scale=1280:-2" -c:v libx264 -crf 28 -preset ultrafast -c:a aac -b:a 64k output.mp4

```
