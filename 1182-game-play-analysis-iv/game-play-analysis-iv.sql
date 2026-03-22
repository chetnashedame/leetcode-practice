# Write your MySQL query statement below
select round(count(distinct a1.player_id )/(select count(distinct player_id) from Activity) ,2) as fraction
from Activity a1
join (select player_id, MIN(event_date) as first_date
from Activity
group by player_id
) a2
on a1.player_id=a2.player_id
and a1.event_date=DATE_ADD(a2.first_date, INTERVAL 1 DAY);