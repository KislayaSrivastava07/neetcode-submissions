# Write your MySQL query statement below
SELECT activity_date as day, 
COUNT(DISTINCT user_id) AS active_users
FROM Activity
WHERE activity_date BETWEEN '2019-6-28' AND '2019-7-27'
GROUP BY activity_date;