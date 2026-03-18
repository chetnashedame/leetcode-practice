# Write your MySQL query statement below
SELECT e.name FROM employee e JOIN employee m ON e.Id= m.managerId GROUP BY e.Id, e.name HAVING COUNT(m.Id)>=5;