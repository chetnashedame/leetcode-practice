# Write your MySQL query statement below
select d.name AS Department, e.name AS Employee, e.salary as Salary
from 
(select name, departmentId, salary,
dense_rank() over(
   partition by departmentId
   order by salary desc) as rnk 
from Employee ) 
e join Department d on e.departmentId=d.id
where e.rnk<=3;