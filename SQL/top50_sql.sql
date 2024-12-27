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
    