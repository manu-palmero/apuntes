/* 
 Escribe una consulta SQL 
 que calcule el precio 
 promedio de los productos 
 agrupados por categoría y 
 que solo muestre las 
 categorías cuyo precio 
 promedio sea mayor a 100.00.
 */
select
    categoria,
    AVG(precio) as promedio
from
    productos
group by
    categoria
having
    promedio > 100.00;