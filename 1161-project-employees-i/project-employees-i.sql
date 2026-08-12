# Write your MySQL query statement below
SELECT p.project_id, 
    ROUND(
        IFNULL(SUM(e.experience_years)/ COUNT(p.project_id) , 0), 2
    ) AS average_years
FROM Project p
LEFT JOIN Employee e ON 
p.employee_id= e.employee_id
GROUP BY p.project_id;
