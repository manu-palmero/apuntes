Tareas sin completar: 
```dataview
TASK
WHERE !completed AND text != ""
GROUP BY file.name
SORT file.mtime ASC
```
