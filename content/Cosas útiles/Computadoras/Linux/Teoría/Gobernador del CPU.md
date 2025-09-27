# Gobernador del CPU

Es un componente del núcleo de Linux que decide a qué frecuencia debe funcionar el procesador en cada momento en función de diferentes criterios como: el uso actual de la CPU, el consumo de energía, la temperatura, etc.

## Gobernadores comunes en Linux

### performance

Siempre usa la frecuencia máxima posible.
Ideal para tareas que requieren mucho rendimiento.
Aumenta el consumo de energía.

### powersave

Siempre usa la frecuencia mínima posible.
Ahorra energía, pero sacrifica rendimiento.

### ondemand (ya casi obsoleto)

Cambia dinámicamente la frecuencia según la carga.
Responde rápido al aumentar la frecuencia.

### conservative

Similar a ondemand, pero cambia la frecuencia más suavemente.

### schedutil

Es el gobernador moderno y predeterminado en muchos sistemas.
Integra la decisión con el planificador del kernel (scheduler).
Balancea rendimiento y consumo.

---

## Ver y cambiar el gobernador

### Ver el gobernador actual

```zsh
cat /sys/devices/system/cpu/cpu0/cpufreq/scaling_governor
```


Cambiar temporalmente (por ejemplo, a performance):

```zsh
echo performance | sudo tee /sys/devices/system/cpu/cpu*/cpufreq/scaling_governor`
```

O con cpupower (requiere instalarlo):

```zsh
sudo cpupower frequency-set -g performance
```

---



