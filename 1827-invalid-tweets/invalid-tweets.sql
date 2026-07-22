# Write your MySQL query statement below
Select tweet_id from Tweets 
Where (Select length(content)>15);