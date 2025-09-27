/* 
 Escribe una consulta SQL 
 que seleccione el nombre 
 y el precio de los productos 
 y les asigne un ranking basado 
 en el precio en orden descendente.
 */
select
    nombre,
    precio,
    rank() over (
        order by
            precio desc
    ) as rango
from
    productos;