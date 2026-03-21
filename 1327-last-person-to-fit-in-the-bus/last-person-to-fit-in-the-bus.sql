# Write your MySQL query statement below
select person_name
from
(select person_name,
       sum(weight) over (order by turn ) as Total_weight
from Queue)
q
where Total_weight<=1000
order by Total_weight desc
limit 1;