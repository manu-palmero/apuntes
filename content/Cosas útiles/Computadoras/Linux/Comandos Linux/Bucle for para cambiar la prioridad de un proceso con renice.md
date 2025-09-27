
```
for pid in $(pgrep proceso); do
    sudo renice -n -núm -p $pid
done
```
Donde:   
- `proceso` es el nombre del programa.   
- `núm` es un número del -20 al 19 siguiendo la convención:   
    - **Prioridad negativa (-20 a -1)**: Estas prioridades son reservadas para procesos con alta prioridad. Cuanto menor sea el número, mayor será la prioridad. Por ejemplo, un proceso con prioridad -20 tiene la máxima prioridad posible.   
    - **Prioridad 0**: Esta es la prioridad de ejecución normal para la mayoría de los procesos. Los procesos con esta prioridad no tienen preferencias especiales en cuanto a la asignación de tiempo de CPU.   
    - **Prioridad positiva (1 a 19)**: Estas prioridades son para procesos con baja prioridad. Cuanto mayor sea el número, menor será la prioridad. Un proceso con prioridad 19 tiene la prioridad más baja posible.   
   
   
