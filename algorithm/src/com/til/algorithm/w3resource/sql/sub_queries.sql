# https://www.w3resource.com/mysql-exercises/subquery-exercises/#PracticeOnline

# 1. Write a query to find the name (first_name, last_name) and the salary of the employees who have a higher salary than the employee whose last_name='Bull'.

SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (
    SELECT SALARY
    FROM EMPLOYEES
    WHERE LAST_NAME = 'Bull'
)

# 2. Write a query to find the name (first_name, last_name) of all employees who works in the IT department.

SELECT FIRST_NAME, LAST_NAME
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (
    SELECT DEPARTMENT_ID
    FROM DEPARTMENTS
    WHERE DEPARTMENT_NAME = 'IT'
)

# 3. Write a query to find the name (first_name, last_name) of the employees who have a manager and worked in a USA based department.

SELECT FIRST_NAME, LAST_NAME
FROM EMPLOYEES
WHERE MANAGER_ID IN (
    SELECT EMPLOYEE_ID
    FROM EMPLOYEES
    WHERE DEPARTMENT_ID IN (
        SELECT DEPARTMENT_ID
        FROM DEPARTMENTS
        WHERE LOCATION_ID IN (
            SELECT LOCATION_ID
            FROM LOCATIONS
            WHERE COUNTRY_ID = 'US'
        )
    )
)

# 4. Write a query to find the name (first_name, last_name) of the employees who are managers.
SELECT FIRST_NAME, LAST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN (
    SELECT MANAGER_ID
    FROM EMPLOYEES
)

# 5. Write a query to find the name (first_name, last_name), and salary of the employees whose salary is greater than the average salary.
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (
    SELECT AVG(SALARY)
    FROM EMPLOYEES
)

# 6. Write a query to find the name (first_name, last_name), and salary of the employees whose salary is equal to the minimum salary for their job grade.
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES E
WHERE SALARY = (
    SELECT MIN_SALARY
    FROM JOBS J
    WHERE E.JOB_ID = J.JOB_ID
)

# 7. Write a query to find the name (first_name, last_name), and salary of the employees who earns more than the average salary and works in any of the IT departments.
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (
    SELECT DEPARTMENT_ID
    FROM DEPARTMENTS
    WHERE DEPARTMENT_NAME REGEXP 'IT'
)
AND SALARY > (
    SELECT AVG(SALARY)
    FROM EMPLOYEES
)

# 8. Write a query to find the name (first_name, last_name), and salary of the employees who earns more than the earning of Mr. Bell.
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (
    SELECT SALARY
    FROM EMPLOYEES
    WHERE LAST_NAME = 'Bell'
)
ORDER BY FIRST_NAME

# 9. Write a query to find the name (first_name, last_name), and salary of the employees who earn the same salary as the minimum salary for all departments.
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY = (
    SELECT MIN(SALARY)
    FROM EMPLOYEES
)

# 10. Write a query to find the name (first_name, last_name), and salary of the employees whose salary is greater than the average salary of all departments.
# 비교 연산자와 ALL
# > ALL : 최댓값보다 크면
# < ALL : 최솟값보다 작으면

SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (
    ALL(SELECT AVG(SALARY)
    FROM EMPLOYEES
    GROUP BY DEPARTMENT_ID)
)

# 11. Write a query to find the name (first_name, last_name) and salary of the employees who earn a salary that is higher than the salary of all the Shipping Clerk (JOB_ID = 'SH_CLERK'). Sort the results of the salary of the lowest to highest.

SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (
    ALL(SELECT SALARY
    FROM EMPLOYEES
    WHERE JOB_ID = 'SH_CLERK')
)
ORDER BY SALARY

# 12. Write a query to find the name (first_name, last_name) of the employees who are not supervisors.
# 13. Write a query to display the employee ID, first name, last name, and department names of all employees.
# 14. Write a query to display the employee ID, first name, last name, salary of all employees whose salary is above average for their departments.
# 15. Write a query to fetch even numbered records from employees table.
# 16. Write a query to find the 5th maximum salary in the employees table.
# 17. Write a query to find the 4th minimum salary in the employees table.
# 18. Write a query to select last 10 records from a table.
# 19. Write a query to list the department ID and name of all the departments where no employee is working.
# 20. Write a query to get 3 maximum salaries.
# 21. Write a query to get 3 minimum salaries.
# 22. Write a query to get nth max salaries of employees.