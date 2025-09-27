/* 
 Escribe una consulta SQL 
 que cree una vista llamada
 `productos_electronica` 
 que seleccione el nombre 
 y el precio de los productos 
 de la categoría 'Electrónica'.
 */
create view if not exists productos_electronica as
select
    nombre,
    precio
from
    productos
where
    categoria = 'Electrónica'