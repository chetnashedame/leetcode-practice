# Write your MySQL query statement below
select t.request_at as Day, 
    round(sum(case
        when t.status != 'completed' then 1 else 0
        end)/ count(*),2) as `Cancellation Rate`
from Trips t
join Users u on t.client_id=u.users_id 
join Users u2 on t.driver_id=u2.users_id
where u.banned='No' and u2.banned='No' and t.request_at BETWEEN "2013-10-01" AND "2013-10-03"
group by t.request_at;
