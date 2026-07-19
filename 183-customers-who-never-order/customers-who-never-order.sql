# Write your MySQL query statement below
Select c.name AS Customers From Customers c
Left Join orders o on c.id= o.customerid
where o.customerId is NULL;