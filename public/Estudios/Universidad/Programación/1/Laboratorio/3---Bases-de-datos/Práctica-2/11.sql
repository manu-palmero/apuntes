/* 
 Escribe una consulta SQL 
 que seleccione el nombre 
 y el precio de los productos 
 cuyo precio sea mayor que el 
 promedio de precios de los
 productos de la misma categoría.
 */
select
    nombre,
    precio
    /* ,
     (
     select
     avg(precio)
     from
     productos pp
     where
     pp.categoria = p.categoria
     ) as promedio_dd_la_categoría 
     */
from
    productos p
where
    precio > (
        select
            avg(precio)
        from
            productos pp
        where
            pp.categoria = p.categoria
    );