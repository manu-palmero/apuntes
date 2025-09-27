/* 
 Escribe una consulta SQL 
 que seleccione todos los 
 productos cuyo precio sea 
 mayor a 200.00 y pertenezcan 
 a la categoría 'Electrónica', 
 o cuyo precio sea menor a 50.00 
 y pertenezcan a la categoría 'Hogar'.
 */
select
    *
from
    productos
where
    (
        precio > 200.00
        and categoria = 'Electrónica'
    )
    or (
        precio < 50.00
        and categoria = 'Hogar'
    );