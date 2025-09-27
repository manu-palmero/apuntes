/* 
 Escribe una consulta SQL que seleccione 
 el nombre y el precio de los
 productos cuyo precio sea mayor que el 
 promedio de precios de todos los productos.
 */
select
    p.nombre,
    p.precio
from
    productos p
where
    p.precio > (
        select
            avg(precio)
        from
            productos
    )