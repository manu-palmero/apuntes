/* 
 Escribe una consulta SQL que actualice 
 el precio de todos los productos
 de la categoría 'Electrónica' que 
 fueron lanzados después del 1 de enero
 de 2020, incrementando su precio en un 10%.
 */
update
    productos
set
    precio = precio * 1.10
where
    fecha_lanzamiento > '2020-01-01'
    and categoria = 'Electrónica';