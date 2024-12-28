-- # 1 https://leetcode.com/problems/recyclable-and-low-fat-products/?envType=study-plan-v2&envId=top-sql-50
SELECT product_id
FROM Products
WHERE low_fats = 'Y' AND recyclable = 'Y';

-- # 2 https://leetcode.com/problems/find-customer-referee/description/?envType=study-plan-v2&envId=top-sql-50
SELECT name
FROM Customer
WHERE referee_id <> 2 OR referee_id IS NULL

-- # 3 https://leetcode.com/problems/big-countries/?envType=study-plan-v2&envId=top-sql-50
SELECT name, population, area 
FROM World
WHERE area >= 3000000 OR population >= 25000000;

-- # 4 https://leetcode.com/problems/article-views-i/description/?envType=study-plan-v2&envId=top-sql-50
SELECT DISTINCT author_id as id
FROM Views
WHERE author_id = viewer_id
ORDER BY author_id ASC;

-- # 5 https://leetcode.com/problems/invalid-tweets/?envType=study-plan-v2&envId=top-sql-50
SELECT tweet_id
FROM Tweets
WHERE LENGTH(content) > 15 

-- # 6 https://leetcode.com/problems/invalid-tweets/submissions/1490170616/?envType=study-plan-v2&envId=top-sql-50
SELECT U.unique_id, E.name
FROM Employees E
LEFT OUTER JOIN EmployeeUNI U ON E.id = U.id

-- # 7 https://leetcode.com/problems/product-sales-analysis-i/description/?envType=study-plan-v2&envId=top-sql-50
SELECT P.product_name, S.year, S.price
FROM Sales S 
INNER JOIN Product P ON S.product_id = P.product_id

-- # 8 https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/description/?envType=study-plan-v2&envId=top-sql-50
SELECT V.customer_id, COUNT(V.visit_id) AS count_no_trans
FROM Visits V
LEFT JOIN Transactions T ON V.visit_id = T.visit_id
WHERE T.transaction_id IS NULL
GROUP BY V.customer_id;

-- # 9 https://leetcode.com/problems/rising-temperature/description/?envType=study-plan-v2&envId=top-sql-50
SELECT W2.id
FROM Weather W1, Weather W2
WHERE W1.recordDate = (SELECT W2.recordDate - INTERVAL 1 DAY) AND W2.temperature > W1.temperature;

-- # 10 https://leetcode.com/problems/average-time-of-process-per-machine/description/?envType=study-plan-v2&envId=top-sql-50
SELECT A1.machine_id as machine_id, ROUND(AVG(A2.timestamp - A1.timestamp), 3) as processing_time
FROM(
    SELECT *
    FROM Activity
    WHERE activity_type = 'start'
) as A1
INNER JOIN(
    SELECT *
    FROM Activity
    WHERE activity_type = 'end'
) AS A2
ON A1.machine_id = A2.machine_id AND A1.process_id = A2.process_id 
GROUP BY A1.machine_id

-- # 11 https://leetcode.com/problems/employee-bonus/description/?envType=study-plan-v2&envId=top-sql-50

SELECT E.name, B.bonus
FROM Employee E
LEFT JOIN Bonus B on E.empId = B.empId
WHERE B.bonus < 1000 OR B.bonus IS NULL;

-- # 12 https://leetcode.com/problems/students-and-examinations/?envType=study-plan-v2&envId=top-sql-50

SELECT S.student_id, S.student_name, Sub.subject_name, COUNT(E.subject_name) as attended_exams
FROM Students S
CROSS JOIN Subjects Sub
LEFT JOIN Examinations E ON (S.student_id = E.student_id AND Sub.subject_name = E.subject_name)
GROUP BY S.student_id, S.student_name, Sub.subject_name
ORDER BY S.student_id

-- # 13 https://leetcode.com/problems/managers-with-at-least-5-direct-reports/?envType=study-plan-v2&envId=top-sql-50

SELECT E2.name
FROM(
    SELECT E.managerId
    FROM Employee E
    GROUP BY E.managerId
    HAVING COUNT(E.id) >= 5
) AS E1
INNER JOIN Employee E2 on E1.managerId = E2.id


-- #14 https://leetcode.com/problems/confirmation-rate/description/?envType=study-plan-v2&envId=top-sql-50

WITH UserRates AS (
    SELECT U1.user_id, ROUND(U2.successful_confirmations / U1.total_confirmations, 2) as rate
    FROM(

        SELECT S.user_id, COUNT(*) AS total_confirmations
        FROM Signups S
        INNER JOIN Confirmations C ON S.user_id = C.user_id
        GROUP BY S.user_id
    ) AS U1
    INNER JOIN(

        SELECT S.user_id, COUNT(*) AS successful_confirmations
        FROM Signups S
        INNER JOIN Confirmations C ON S.user_id = C.user_id
        WHERE C.action = 'confirmed'
        GROUP BY S.user_id

    ) AS U2 ON U1.user_id = U2.user_id
)
SELECT 
    Sig.user_id,
    CASE
        WHEN UserRates.user_id IS NULL THEN 0
        ELSE UserRates.rate
    END AS confirmation_rate
FROM Signups Sig
LEFT JOIN UserRates ON Sig.user_id = UserRates.user_id


-- #15 https://leetcode.com/problems/not-boring-movies/description/?envType=study-plan-v2&envId=top-sql-50

SELECT id, movie, description, rating 
FROM Cinema
WHERE id % 2 = 1 AND description <> 'boring'
ORDER BY rating DESC

-- #16 https://leetcode.com/problems/average-selling-price/description/?envType=study-plan-v2&envId=top-sql-50

SELECT P.product_id, 
    ROUND(
        CASE 
            WHEN SUM(U.units) = 0 OR SUM(U.units) IS NULL THEN 0 
            ELSE SUM(P.price * U.units) / SUM(U.units)
        END, 
        2
    ) AS average_price
FROM Prices P
INNER JOIN UnitsSold U ON P.product_id = U.product_id
WHERE U.purchase_date BETWEEN P.start_date AND P.end_date
GROUP BY P.product_id


-- #17 https://leetcode.com/problems/project-employees-i/description/?envType=study-plan-v2&envId=top-sql-50

SELECT P.project_id, ROUND(AVG(E.experience_years),2) as average_years
FROM Project P
INNER JOIN Employee E ON P.employee_id = E.employee_id
GROUP BY P.project_id

-- #18 https://leetcode.com/problems/percentage-of-users-attended-a-contest/description/?envType=study-plan-v2&envId=top-sql-50

SELECT 
    R.contest_id,
    ROUND(COUNT(U.user_id) / (SELECT COUNT(*) FROM Users) * 100, 2) as percentage
FROM Users U
INNER JOIN Register R ON U.user_id = R.user_id
GROUP BY R.contest_id
ORDER BY percentage DESC, contest_id ASC

-- #19 https://leetcode.com/problems/queries-quality-and-percentage/?envType=study-plan-v2&envId=top-sql-50

SELECT
    query_name,
    ROUND(AVG(rating / position),2) as quality,
    ROUND( (SELECT COUNT(*) FROM Queries Q3 WHERE Q3.query_name = Q1.query_name AND Q3.rating < 3) / (SELECT COUNT(*) FROM Queries Q2 WHERE Q2.query_name = Q1.query_name) * 100 , 2) as poor_query_percentage
FROM Queries Q1
GROUP BY query_name