---
created: <% tp.date.now("YYYY-MM-DD HH:mm") %>
tags:
  - diario
---

# 📅 <% tp.date.now("YYYY-MM-DD") %> (Día <% tp.date.now("dddd") %>)

## 🌅 **Mañana**
- [ ] Lavar los dientes (Mañana)
- [ ] 

## 🏗️ **Tarde**
- [ ] Lavar los dientes (Tarde)
- [ ] 

## 🌙 **Noche**
- [ ] Lavar los dientes (Noche)
- [ ] 

---

## 📋 **Tareas Pendientes**

```dataview
TASK
FROM "Personal/Notas diarias" AND #diario 
WHERE !completed AND text != ""
GROUP BY file.name
SORT file.mtime ASC
```

## 📝 **Notas del Día**
- 

## 🎯 **Objetivos para Mañana**
- 

---

**Navegación entre días:**
[🠔 Día Anterior](<% tp.date.now("YYYY-MM-DD", -1) %>) | [🠖 Día Siguiente](<% tp.date.now("YYYY-MM-DD", 1) %>)

---

**Fin del día:** <% tp.date.now("YYYY-MMMM-DDDD DD") %>