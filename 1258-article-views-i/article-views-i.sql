# Write your MySQL query statement below
Select distinct author_id AS id from views 
Where author_id = viewer_id
Order BY author_id asc;