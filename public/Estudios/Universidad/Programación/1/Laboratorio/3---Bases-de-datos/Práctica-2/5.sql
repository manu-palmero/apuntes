/* 
 Escribe una consulta SQL que seleccione todos los productos y los
 ordene en orden descendente por precio y en orden ascendente por
 nombre.
 */
select
    nombre,
    precio
from
    productos
order by
    precio desc,
    nombre asc;