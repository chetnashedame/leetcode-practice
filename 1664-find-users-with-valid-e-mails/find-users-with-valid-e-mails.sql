# Write your MySQL query statement below
# REGEXP starts with ^ and ends with $

SELECT *
FROM Users
WHERE mail REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\\.com$'
AND BINARY mail LIKE '%@leetcode.com';