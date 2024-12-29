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


-- #20 https://leetcode.com/problems/monthly-transactions-i/?envType=study-plan-v2&envId=top-sql-50

SELECT
    DATE_FORMAT(trans_date, '%Y-%m') AS month,
    country,
    COUNT(*) as trans_count,
    SUM(CASE WHEN state = 'approved' THEN 1 ELSE 0 END) as approved_count,
    SUM(amount) as trans_total_amount,
    SUM(CASE WHEN state = 'approved' THEN amount ELSE 0 END) as approved_total_amount
FROM Transactions
GROUP BY DATE_FORMAT(trans_date, '%Y-%m'), country

-- #21 https://leetcode.com/problems/immediate-food-delivery-ii/description/?envType=study-plan-v2&envId=top-sql-50

WITH Orderings AS(

    SELECT
        customer_id,
        (CASE WHEN MIN(order_date) = MIN(customer_pref_delivery_date) THEN 1 ELSE 0 END) as immediate

    FROM Delivery
    GROUP BY customer_id

)
SELECT ROUND(SUM(immediate) / COUNT(*) * 100, 2) as immediate_percentage
FROM Orderings


-- #22 https://leetcode.com/problems/game-play-analysis-iv/description/?envType=study-plan-v2&envId=top-sql-50

WITH PlayerStats AS(

    SELECT
        A1.player_id, 
        (CASE 
            WHEN MIN(event_date) + INTERVAL 1 DAY IN (SELECT event_date FROM Activity A2 WHERE A2.player_id = A1.player_id) THEN 1
            ELSE 0
            END
        ) AS next_day
    FROM Activity A1
    GROUP BY A1.player_id

)
SELECT ROUND(SUM(next_day) / COUNT(*), 2) as fraction
FROM PlayerStats

-- #23 https://leetcode.com/problems/number-of-unique-subjects-taught-by-each-teacher/description/?envType=study-plan-v2&envId=top-sql-50

SELECT
    teacher_id,
    COUNT(DISTINCT subject_id) as cnt
FROM Teacher
GROUP BY teacher_id

-- #24 https://leetcode.com/problems/user-activity-for-the-past-30-days-i/description/?envType=study-plan-v2&envId=top-sql-50


SELECT
    activity_date as day, 
    COUNT(DISTINCT user_id) as active_users
FROM Activity 
WHERE activity_date BETWEEN '2019-06-28' AND '2019-07-27'
GROUP BY activity_date

-- #25 https://leetcode.com/problems/product-sales-analysis-iii/description/?envType=study-plan-v2&envId=top-sql-50

WITH Stats AS(
    SELECT
        product_id, 
        MIN(year) as first_year
    FROM Sales
    GROUP BY product_id
)
SELECT
    Sales.product_id as product_id, 
    Stats.first_year as first_year,
    Sales.quantity as quantity,
    Sales.price as price
FROM Sales
INNER JOIN Stats ON Sales.product_id = Stats.product_id AND Sales.year = Stats.first_year


-- #26 https://leetcode.com/problems/classes-more-than-5-students/description/?envType=study-plan-v2&envId=top-sql-50

SELECT
    class
FROM Courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5

-- #27 https://leetcode.com/problems/find-followers-count/description/?envType=study-plan-v2&envId=top-sql-50

SELECT
    user_id,
    COUNT(DISTINCT follower_id) as followers_count
FROM Followers
GROUP BY user_id

-- #28 https://leetcode.com/problems/biggest-single-number/description/?envType=study-plan-v2&envId=top-sql-50

WITH Nums AS(
    SELECT MAX(num) as number
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(*) = 1
)
SELECT 
    CASE WHEN EXISTS (SELECT number FROM Nums) THEN (SELECT MAX(number) FROM Nums)
    ELSE NULL
    END AS num



-- LMAOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
/*
select max(num) as num
from (
    select num from MyNumbers
    group by num
    having count(num)=1
) as a
*/

-- #29 https://leetcode.com/problems/customers-who-bought-all-products/description/?envType=study-plan-v2&envId=top-sql-50

SELECT
    customer_id 
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key) = (SELECT COUNT(*) FROM Product)

-- #30 https://leetcode.com/problems/the-number-of-employees-which-report-to-each-employee/description/?envType=study-plan-v2&envId=top-sql-50

SELECT
    E1.employee_id as employee_id,
    E1.name as name,
    E2.reports_count as reports_count,
    E2.age as average_age

FROM Employees E1
INNER JOIN (
    SELECT
        reports_to as global_id,
        COUNT(DISTINCT employee_id) as reports_count,
        ROUND(AVG(age)) as age
    FROM Employees
    GROUP BY reports_to 
    HAVING COUNT(DISTINCT employee_id) > 0 
) AS E2 ON E1.employee_id = E2.global_id
ORDER BY E1.employee_id

-- #31 https://leetcode.com/problems/primary-department-for-each-employee/description/?envType=study-plan-v2&envId=top-sql-50

SELECT
    E1.employee_id as employee_id, 
    (
    CASE
        WHEN COUNT(DISTINCT E1.department_id) > 1 THEN (SELECT E2.department_id FROM Employee E2 WHERE E2.employee_id = E1.employee_id AND E2.primary_flag = 'Y')
        ELSE E1.department_id
        END
    ) as department_id
FROM Employee E1
GROUP BY E1.employee_id


-- #32 https://leetcode.com/problems/triangle-judgement/description/?envType=study-plan-v2&envId=top-sql-50

SELECT
    x, y, z, 
    CASE WHEN (x + y > z AND y + z > x AND x + z > y) THEN 'Yes'
    ELSE 'No'
    END as triangle 
FROM Triangle

-- #33 https://leetcode.com/problems/consecutive-numbers/description/?envType=study-plan-v2&envId=top-sql-50

SELECT DISTINCT num AS ConsecutiveNums
FROM (
    SELECT 
        num,
        LAG(num) OVER (ORDER BY id) AS prev_num,
        LEAD(num) OVER (ORDER BY id) AS next_num
    FROM Logs
) Sub
WHERE num = prev_num AND num = next_num;

-- #34 https://leetcode.com/problems/product-price-at-a-given-date/?envType=study-plan-v2&envId=top-sql-50

WITH MostRecentUpdate AS (
    SELECT
        product_id, 
        MAX(change_date) AS change_date
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
)
SELECT 
    DISTINCT P1.product_id AS product_id,
    CASE
        WHEN P1.product_id IN (SELECT product_id FROM MostRecentUpdate) THEN (
            SELECT P2.new_price
            FROM Products P2
            INNER JOIN MostRecentUpdate MRU
            ON P2.change_date = MRU.change_date 
            AND P2.product_id = MRU.product_id
            WHERE MRU.product_id = P1.product_id
            LIMIT 1
        )
        ELSE 10
    END AS price
FROM Products P1;

-- #35 https://leetcode.com/problems/last-person-to-fit-in-the-bus/?envType=study-plan-v2&envId=top-sql-50

WITH RunningSum AS(

    SELECT 
        person_name,
        SUM(weight) OVER (ORDER BY turn) as cumulative_weight
    FROM Queue
)
SELECT person_name
FROM RunningSum
WHERE cumulative_weight <= 1000
ORDER BY cumulative_weight DESC
LIMIT 1


-- #36 https://leetcode.com/problems/count-salary-categories/description/?envType=study-plan-v2&envId=top-sql-50

SELECT 'Low Salary' AS category, COUNT(*) as accounts_count FROM Accounts WHERE income < 20000
UNION
SELECT 'Average Salary' AS category, COUNT(*) as accounts_count FROM Accounts WHERE income >= 20000 AND income <= 50000
UNION
SELECT 'High Salary' AS category, COUNT(*) as accounts_count FROM Accounts WHERE income > 50000


-- #37 https://leetcode.com/problems/employees-whose-manager-left-the-company/description/?envType=study-plan-v2&envId=top-sql-50

SELECT employee_id
FROM Employees E
WHERE E.manager_id NOT IN (SELECT employee_id FROM Employees) AND E.salary < 30000
ORDER BY employee_id

-- #38 https://leetcode.com/problems/exchange-seats/description/?envType=study-plan-v2&envId=top-sql-50

SELECT
    (CASE
        WHEN id % 2 = 0 THEN id - 1
        WHEN id = (SELECT COUNT(*) FROM Seat) THEN id
        ELSE id + 1
    END
    ) AS id,
    student

FROM Seat
ORDER BY id

-- #39 https://leetcode.com/problems/movie-rating/description/?envType=study-plan-v2&envId=top-sql-50


(
    SELECT U.name AS results
    FROM Users U
    INNER JOIN MovieRating MR ON U.user_id = MR.user_id
    GROUP BY U.user_id, U.name
    ORDER BY COUNT(*) DESC, U.name ASC
    LIMIT 1
)
UNION ALL
(
    SELECT M.title AS results
    FROM MovieRating MR
    INNER JOIN Movies M ON MR.movie_id = M.movie_id
    WHERE YEAR(MR.created_at) = 2020 and MONTH(MR.created_at) = 2
    GROUP BY M.movie_id, M.title
    ORDER BY AVG(MR.rating) DESC, M.title ASC
    LIMIT 1
);

-- #40 https://leetcode.com/problems/restaurant-growth/description/?envType=study-plan-v2&envId=top-sql-50


-- couldn't solve this bs lmaooo, maybe later 


-- #41 https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends/?envType=study-plan-v2&envId=top-sql-50

-- WITH RequesterStats AS(    
--     SELECT 
--     requester_id as id,
--     COUNT(*) as count
--     FROM RequestAccepted
--     GROUP BY requester_id
-- ),
-- AccepterStats AS(
--     SELECT 
--     accepter_id as id,
--     COUNT(*) as count
--     FROM RequestAccepted
--     GROUP BY accepter_id
-- )
SELECT
    id,
    SUM(count) as num
FROM(

    SELECT 
    requester_id as id,
    COUNT(*) as count
    FROM RequestAccepted
    GROUP BY requester_id

    UNION ALL

    SELECT 
    accepter_id as id,
    COUNT(*) as count
    FROM RequestAccepted
    GROUP BY accepter_id
    
) As Stats
GROUP BY id
ORDER BY num DESC
LIMIT 1

-- #42 https://leetcode.com/problems/investments-in-2016/description/?envType=study-plan-v2&envId=top-sql-50


SELECT ROUND(SUM(I1.tiv_2016),2) as tiv_2016
FROM Insurance I1
WHERE
    (I1.lat, I1.lon) NOT IN (SELECT I2.lat, I2.lon FROM Insurance I2 WHERE I2.pid <> I1.pid)
    AND I1.tiv_2015 IN (SELECT I4.tiv_2015 FROM Insurance I4 WHERE I4.pid <> I1.pid)

-- #43 https://leetcode.com/problems/department-top-three-salaries/description/?envType=study-plan-v2&envId=top-sql-50


WITH RankedSalaries AS(

    SELECT
        Employee.id as e_id,
        Employee.name as e_name,
        salary,
        Employee.departmentId as d_id,
        Department.name as d_name,
        DENSE_RANK() OVER (
            PARTITION BY departmentId 
            ORDER BY salary DESC
            ) as salary_rank
    FROM Employee
    INNER JOIN Department ON Employee.departmentId = Department.id

)
SELECT
    d_name as Department,
    e_name as Employee,
    salary as Salary
FROM RankedSalaries
WHERE salary_rank <= 3

