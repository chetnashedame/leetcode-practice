# Write your MySQL query statement below
select visited_on,
       sum(amount)over (order by visited_on 
                        range between interval 6 day preceding and current row) as amount,
        round(sum(amount)over (order by visited_on
                               range between interval 6 day preceding and current row)/7,2) as average_amount
from(
    select visited_on, sum(amount) as amount
    from Customer
    group by visited_on
) as daily
order by visited_on
limit 9999999999999999999
offset 6;