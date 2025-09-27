/* 
 Escribe una consulta SQL que elimine todos los productos de la categoría
 'Libros' que fueron lanzados antes del 1 de enero de 2020.
 */
delete from
    productos
where
    fecha_lanzamiento < '2020-01-01'
    and categoria = 'Libros';