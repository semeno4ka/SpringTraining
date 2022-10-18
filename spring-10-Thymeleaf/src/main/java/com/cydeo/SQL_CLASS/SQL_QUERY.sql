select*from employees where job_id='IT_PROG';
--how many people work as programmer?
select count(*) from employees where job_id='IT_PROG';
select count(*) from employees where salary>=8000;
select count(distinct first_name)  from employees;--unique names number
select*from employees order by salary asc;-- ascending order
select*from employees order by first_name;--order asc by first name
select*from employees order by salary;--ascending order
select*from employees order by salary DESC;--descending order
select count(*) from employees;--returns number of employees
--get all employees who's first name starts with C
select*from employees where first_name like'C%';--starts with C, can have any number of char
select*from employees where first_name like'C_____';--starts with C and contains 6 char
select*from employees where first_name like'_____';--contains only 5 character
select*from employees where first_name like'_u%';-- second letter is U
select*from employees where first_name like'%u%';-- contains U anywhere in the name
--get all names where it contains C - LIKE / ILIKE
select*from employees where first_name like '%c%';-- is case sensitive and will not count names which contain Capital C
select*from employees where first_name like '%C%';
select*from employees where first_name ilike '%c%';-- I LIKE avoids case sensitivity
-- how to find minimum and maximum if we are dealing with number- AGGREGATE FUNCTIONS
select MIN(salary) from employees;-- return the min number
select MAX(salary) from employees;--returns max number
select SUM(salary) from employees;--returns total
select AVG(salary) from employees;--average among all
select ROUND(AVG(salary)) from employees; --will round it up
select ROUND(AVG(salary),3) from employees; -- you can specify how many digits after. will contain decimal result

--how to find who is making highest salary?
select MAX(salary) from employees;--get max is first step
select*from employees where salary=24000;-- put max salary and get employee is second step
select*from employees where salary=(select max(salary) from employees);-- do it all in a single step (One query inside another query)
-- a query inside another query- subQuery. Result of one query is an input of another query
-- inner query gets executed first, since it is gonna be our input


-- how to find who is making second highest salary?
select MAX(salary) from employees;--get highest
select MAX(salary) from employees where salary<24000;--the second highest will be shown
select MAX(salary) from employees where salary<(select MAX(salary) from employees);-- combine both to do in one step

select*from employees where salary =17000;
select*from employees where salary= (select MAX(salary) from employees where salary<(select MAX(salary) from employees));

-- find the name of the employees who's salary is second from maximum
select*from employees order by salary Desc;-- from high to low
select*from employees order by salary Desc limit 10;-- get the highest 10
select*from employees order by salary Desc OFFSET 2 limit 10;-- skip 2 first and show the following highest 10
select*from employees order by salary Desc OFFSET 1 limit 1;-- skip the first highest get the second highest (doesnt consider same salaries)

-- remove dups. who is making 14th highest salary?
select distinct salary from employees order by salary desc;---- get salary without dups, get it in desc order
select distinct salary from employees order by salary desc offset 13 limit 1;--skip 13, get 14th limit to just one
select*from employees where salary =(select distinct salary from employees order by salary desc offset 13 limit 1);
-- select from employees an employee who is making 14th highest salary

--who is making nth highest salary?
select*from employees where salary =(select distinct salary from employees order by salary desc offset 15 limit 1);
--what is average salary for IT Progs?
select AVG(salary) from employees;--average for employees
select AVG(salary) from employees where job_id='IT_PROG';--average for IT
select MAX(salary) from employees  where job_id='IT_PROG';-- max salary for IT
-- get the averagesalary for each job id
select distinct job_id from employees;-- get all job id
select count(*) from employees where job_id='IT_PROG';-- number of people who work as IT
select job_id, avg(salary), count(*),sum(salary) from employees group by job_id;
-- give result based on the groups job_id,avg salary etc and select how will you group it
--in group by function you cannot get individual results of employees, access only to group based data


--get job_id where average salary more than 5 k
select job_id,avg(salary)> 5000 from employees group by job_id;-- shows us wrong logic and changes average
-- in this example we eliminated people first, our new average changed
select*from employees where salary>5000;-- all making less than 5
--HAVING keyword
select job_id,avg(salary) from employees group by job_id having avg(salary)>5000;
-- we 1st group by id where there is average salary of all 107, then proceed further
-- you do not eliminate employees first.Filter needs to come after grouping HAVING condition
--how to find dups name?
select first_name from employees group by first_name;--each name is a separate group
select first_name, count(*) from employees group by first_name;-- found how many of EACH name is there
select first_name, count(first_name) from employees group by first_name having count(first_name)>1;
select first_name, count(*) from employees group by first_name having count(*)>1;-- found dups in names and how many times they are repeated
-- the filtering from groups happens after grouping
select*from employees;-- get columns as they saved in DB
-- if you need to change temporarily change data which you display on the screen
select first_name AS "given_name" from employees;-- you change HOW it will be DISPLAYED on the screen, not actual change
select last_name AS "surname" from employees;
-- what if you want to combine both columns? without permanent change, display purpose
select first_name||' '||last_name as"full_name" from employees;-- | | means concatenation
select email||'@cydeo.com' as "full_email" from employees;-- just add what you need using || and show how to name the column via AS
select lower(email||'@cydeo.com') as "full_email" from employees;-- lower(), upper() will display in lowerCase
select first_name,length(first_name) as "length" from employees;-- display the length of employee forst name
--subSTR(colName,begIndex,numberOFchar to be displayed)
select substr(first_name,1,1)||'.'||substr(last_name,1,1) as "initials" from employees;-- substring, index starts from 1

--initials, fullname, email(cydeo table)

CREATE VIEW emaillist AS select substr(first_name,1,1)||'.'|| substr(last_name,1,1) as "initials", first_name||' '||last_name as "full_name",lower(email||'@cydeo.com') as "email" from employees;
-- how to save this table to use it later without changing DB (will be saved in a view package next to tables)
Select* from emaillist;-- will bring you the saved email list
--how to drop? rightclick the view and drop or
DROP VIEW emaillist;

select*from employees;
select*from departments;
select*from locations;
--display firstname, lastname, departmentname
select first_name,last_name,department_id from employees;

SELECT first_name,last_name,department_name FROM employees e JOIN departments d ON e.department_id=d.department_id;-- gives only those who have departmetn
SELECT first_name,last_name,department_name FROM employees e LEFT OUTER JOIN departments d ON e.department_id=d.department_id;-- gives all, no matter have or have not department assigned
SELECT first_name,last_name,department_name FROM employees e LEFT OUTER JOIN departments d ON e.department_id=d.department_id WHERE d.department_id is Null;-- will bring those without assigned dep
--get names, depName,city for all
select first_name,last_name,department_name,city from employees e JOIN departments d on e.department_id=d.department_id
                                                                  JOIN locations l on d.location_id = l.location_id;-- just add JOIN and continue to work with multiple tables

select first_name,last_name,department_name,city, country_name from employees e JOIN departments d on e.department_id=d.department_id
                                                                                JOIN locations l on d.location_id = l.location_id JOIN countries c on l.country_id = c.country_id;

--SELF JOIN INTERVIEW QUESTION
select e1.employee_id, e1.first_name,e1.last_name,e1.manager_id,e2.employee_id,e2.first_name,e2.last_name FROM employees e1 JOIN employees e2 ON e1.manager_id=e2.employee_id;--only those who has managers (Steven King doesn't)
select e1.employee_id, e1.first_name,e1.last_name,e1.manager_id,e2.employee_id,e2.first_name,e2.last_name FROM employees e1 LEFT JOIN employees e2 ON e1.manager_id=e2.employee_id;--all employees

select*from customer;
select*from address;

select first_name, last_name, address, phone from customer JOIN address ON customer.address_id = address.address_id;
select first_name, last_name, address, phone from customer LEFT OUTER JOIN address ON customer.address_id = address.address_id;select first_name, last_name, address, phone from customer RIGHT OUTER JOIN address ON customer.address_id = address.address_id;
select first_name, last_name, address, phone from customer FULL OUTER JOIN address ON customer.address_id = address.address_id;
select first_name, last_name, address, phone from customer FULL OUTER JOIN address ON customer.address_id = address.address_id where customer.address_id IS NULL or address.address_id IS NULL;-- excludes intersection results
-- you can put tableName + space + the first letter of the table to use a short version of table name it will be read as tableName as 'any letter'
select first_name, last_name, customer.address_id,address.address_id, phone from customer FULL OUTER JOIN address ON customer.address_id = address.address_id;
select first_name, last_name, c.address_id,a.address_id, phone from customer c FULL OUTER JOIN address a ON c.address_id = a.address_id;

--creating our own tables. Commands work just one time
-- create tableName ( colN1 DataType Constraints, cilN2 DataType Constraints(optional), colN3 DataType Constraints)

CREATE TABLE ScrumTeam(
                          empl_id Integer PRIMARY KEY,-- first column
                          first_name varchar (30) Not NULL,-- (30)- how many characters can be accepted
                          last_name varchar(30),
                          job_title varchar(20)
);
Select*from scrumTeam;
--insert information
-- INSERT INTO tableName(colN1,colN2..) VALUES (value1,value2)
INSERT INTO ScrumTeam(empl_id, first_name, last_name, job_title) -- mandatory are those, which have Not Null and PrimaryKey constraints
VALUES(1,'Severus','Snape','Tester');-- in order to check whether the input was successful, you have to select*from
INSERT INTO ScrumTeam VALUES(2,'Harry','Potter','Developer');-- if you do not specify columns, it will understand that you fill out all of them
INSERT INTO ScrumTeam VALUES (3,'Phoebe','Buffay','ScrumMaster');
insert into ScrumTeam VALUES (4,'Michael','Jackson','PO');

--How to UPDATE tables?
--UPDATE tableName SET colN1 = value1, colN2 = value2,... WHERE condition...;
UPDATE ScrumTeam SET job_title='DevOps' where empl_id=4;-- to check changes, select*from


--How to DELETE
-- DELETE FROM tableName  WHERE condition;
DELETE FROM ScrumTeam WHERE empl_id=3;

commit;-- to save data after changes, checkpoint
Select*from scrumTeam;
--How to add a column or change existing column name?
--ALTER TABLE tableName action;
--Add
ALTER TABLE scrumteam ADD salary Integer;-- add column, value null
UPDATE ScrumTeam SET salary=12000 WHERE empl_id=1;
UPDATE ScrumTeam SET salary=10000 WHERE empl_id=2;
UPDATE ScrumTeam SET salary=11000 WHERE empl_id=4;
--Change column name
ALTER TABLE scrumteam RENAME COLUMN salary TO annual_salary;

--Delete/drop the full column
ALTER TABLE scrumteam DROP COLUMN annual_salary;
--Rename table
ALTER TABLE scrumteam RENAME TO agileTeam;-- all the precious commands will give error, because it is no longer existing table
select*from agileTeam;
--How to delete all the data? TRUNCATE and DROP
TRUNCATE TABLE agileTeam;--table exists, no data inside
DROP TABLE agileTeam;-- the entire table is deleted

--creating our own tables. Commands work just one time
-- create tableName ( colN1 DataType Constraints, cilN2 DataType Constraints(optional), colN3 DataType Constraints)

CREATE TABLE ScrumTeam(
                          empl_id Integer PRIMARY KEY,-- first column
                          first_name varchar (30) Not NULL,-- (30)- how many characters can be accepted
                          last_name varchar(30),
                          job_title varchar(20)
);
Select*from scrumTeam;
--insert information
-- INSERT INTO tableName(colN1,colN2..) VALUES (value1,value2)
INSERT INTO ScrumTeam(empl_id, first_name, last_name, job_title) -- mandatory are those, which have Not Null and PrimaryKey constraints
VALUES(1,'Severus','Snape','Tester');-- in order to check whether the input was successful, you have to select*from
INSERT INTO ScrumTeam VALUES(2,'Harry','Potter','Developer');-- if you do not specify columns, it will understand that you fill out all of them
INSERT INTO ScrumTeam VALUES (3,'Phoebe','Buffay','ScrumMaster');
insert into ScrumTeam VALUES (4,'Michael','Jackson','PO');

--How to UPDATE tables?
--UPDATE tableName SET colN1 = value1, colN2 = value2,... WHERE condition...;
UPDATE ScrumTeam SET job_title='DevOps' where empl_id=4;-- to check changes, select*from


--How to DELETE
-- DELETE FROM tableName  WHERE condition;
DELETE FROM ScrumTeam WHERE empl_id=3;

commit;-- to save data after changes, checkpoint
Select*from scrumTeam;
--How to add a column or change existing column name?
--ALTER TABLE tableName action;
--Add
ALTER TABLE scrumteam ADD salary Integer;-- add column, value null
UPDATE ScrumTeam SET salary=12000 WHERE empl_id=1;
UPDATE ScrumTeam SET salary=10000 WHERE empl_id=2;
UPDATE ScrumTeam SET salary=11000 WHERE empl_id=4;
--Change column name
ALTER TABLE scrumteam RENAME COLUMN salary TO annual_salary;

--Delete/drop the full column
ALTER TABLE scrumteam DROP COLUMN annual_salary;
--Rename table
ALTER TABLE scrumteam RENAME TO agileTeam;-- all the precious commands will give error, because it is no longer existing table
select*from agileTeam;
--How to delete all the data? TRUNCATE and DROP
TRUNCATE TABLE agileTeam;--table exists, no data inside
DROP TABLE agileTeam;-- the entire table is deleted

-- SET OPERATORS UNION, UNION ALL, EXCEPT, INTERSECTIONS

select*from testers
UNION --removes duplicate rows and sorts
select*from developers;

select*from testers
UNION ALL --places data as is
select*from developers;

select names from developers
EXCEPT-- will return what is NOT common from 1st compared to second
select names from testers;

select names from developers
INTERSECT-- return common from both(whatever columns you input, all selected should match)
select names from testers;

--INDEX
EXPLAIN ANALYSE  select*from towns where name='f0f4c9ac8812aea93a791710464a45dc';--get all the info about particular town
--execution time 43 ms
EXPLAIN ANALYSE select*from towns where id='7';
--execution time 0.2 ms

CREATE INDEX idx_towns_name ON towns(name);-- will increase the search result based on name column

--how to drop index?
DROP INDEX IF EXISTS idx_towns_name;

--how to check available indexes in DB?
SELECT
    tablename,
    indexname,
    indexdef
FROM
    pg_indexes
WHERE
        schemaname = 'public'
ORDER BY
    tablename,
    indexname;

--FUNCTIONS

--how to write a function?
create or replace function get_jobId_count_by_name(job_name varchar)
returns int
language plpgsql
as $$DECLARE
     jobId_count integer;
Begin
select count(*) into jobId_count from employees where job_id=job_name;
return jobId_count;
END
$$;

select get_jobId_count_by_name('IT_PROG');

-- can also be dropped
Drop function get_jobId_count_by_name(job_name varchar);

--return employees managed by specific manager -return table
create or replace function get_employees_managed_by_id(mngr_id integer)
    returns table
    (
        employee_firstname varchar,
        employee_lastname varchar
    )
    language plpgsql
as $$
Begin
Return query
select first_name,last_name from employees  where manager_id=mngr_id;

END
$$;

select*from get_employees_managed_by_id(100);


--write a procedure that will accept 2 params, emp_id, job_title , it will update that employee job title
--based on what we provide

CREATE OR REPLACE PROCEDURE update_jobTitle_by_id(empId integer, job_title varchar)
    language plpgsql
AS
$$
BEGIN
UPDATE scrumteam
SET jobtitle = job_title
WHERE emp_id = empId;

END
$$;
call update_jobTitle_by_id(4,'Spring Developer');
DROP PROCEDURE update_jobTitle_by_id(empId integer, job_title varchar);
CREATE OR REPLACE PROCEDURE update_jobTitle_by_id(empId integer, job_title varchar)
    language plpgsql
AS
$$
BEGIN
UPDATE scrumteam
SET jobtitle = job_title
WHERE emp_id = empId;

END
$$;
call update_jobTitle_by_id(4,'Spring Developer');
select*from scrumteam;

--TRIGGER
DROP TABLE IF EXISTS mentors;
CREATE TABLE mentors(
                        id INT GENERATED ALWAYS AS IDENTITY,
                        first_name varchar(40) not null,
                        last_name varchar(40) not null ,
                        primary key(id)
);

DROP TABLE IF EXISTS mentor_audit;
CREATE TABLE mentor_audit(
                             id INT GENERATED ALWAYS AS IDENTITY,
                             mentor_id INT not null,
                             last_name varchar(40) not null ,
                             changed_on timestamp(6) not null,
                             primary key(id)
);


insert into mentors(first_name, last_name) values ('Harold','Finch');
insert into mentors(first_name, last_name) values ('Severus','Snape');

SELECT * FROM mentors;
SELECT * FROM mentor_audit;

CREATE OR REPLACE FUNCTION log_last_name_changes()
    returns trigger
    language plpgsql
AS
$$
BEGIN
    IF NEW.last_name <> OLD.last_name THEN
        INSERT INTO mentor_audit (mentor_id, last_name, changed_on) VALUES
            (OLD.id,OLD.last_name,now());
end if;
RETURN NEW;
end
$$;

CREATE TRIGGER last_name_change
    BEFORE UPDATE
    ON mentors
    FOR EACH ROW
    EXECUTE FUNCTION log_last_name_changes();

UPDATE mentors
SET last_name = 'XYZ'
WHERE id = 2;


--PRACTICE TASKS
select*from employees;
--1. List all the employees' first and last name with their salary in employees table
select first_name, last_name, salary from employees;
--2. how many employees have salary less than 5000?
select count(*) from employees where salary<5000;
--3. how many employees have salary between 6000 and 7000?
select count(*) from employees where salary>=6000 and salary<=7000;
select count(*) from employees where salary BETWEEN 6000 AND 7000;
--4. List all the different region_ids in countries table
select distinct region_id from countries;
--5. display the salary of the employee Grant Douglas (lastName: Grant,  firstName: Douglas)
select salary from employees where first_name='Douglas' and last_name='Grant';
--6. display the maximum salary in employees table
select max(salary) from employees;
--7. display all informations of the employee who has the highest salary in employees table
select*from employees where salary=(select Max(salary) from employees);
--8. display the the second maximum salary from the employees table
select max(salary) from employees where salary<(select max(salary) from employees);
--9. display all informations of the employee who has the second highest salary
select*from employees where salary=(select max(salary) from employees where salary <(select max(salary) from employees));
--10
select min(salary) from employees;
--11. display all informations of the employee who has the minimum salary in employees table
select*from employees where salary=(select min(salary) from employees);
--12
select min(salary) from employees where salary>(select min(salary) from employees);
--13. display all informations of the employee who has the second minimum salary
select*from employees where salary=(select min(salary) from employees where salary>(select min(salary) from employees));
--14. display the average salary of the employees;
select avg(salary) from employees;
--15. list all the employees who are making above the average salary;
select*from employees where salary>(select avg(salary) from employees);
--16. list all the employees who are making less than the average salary
select*from employees where salary<(select avg(salary) from employees);
--17. count the total numbers of the departments in departs table
select count(*) from departments;
--18. sort the start_date in ascending order in job_history's table
select*from job_history ORDER BY start_date;
--19. sort the start_date in descending order in job_history's table
select*from job_history ORDER BY start_date DESC;
--20. list all the employees whose first name starts with 'A'
select*from employees where first_name like 'A%';
--21. list all the employees whose job_ID contains 'IT'
select*from employees where job_id like '%IT%';
--22. list all the employees whose department id in 50, 80, 100
select*from  employees where department_id IN(50,80,100);

--Assignment 2
--1. Show all job_id and average salary who work as any of these jobs IT_PROG, SA_REP, FI_ACCOUNT, AD_VP
select job_id, avg(salary) from employees group by job_id having job_id IN  ('IT_PROG','SA_REP' ,'FI_ACCOUNT' ,'AD_VP');
--2. Show all records whose last name contains 2 lowercase 'a's
select*from employees where last_name like '%a%a%';
--3. Display max salary  for each department
select max(salary), department_id from employees group by department_id;
--4. Display total salary for each department except department_id 50, and where total salary >30000
SELECT department_id, SUM(salary)
FROM employees
GROUP BY department_id
HAVING SUM(salary) > 30000 AND department_id != 50;
--5. Write a SQL query that returns first and last name any employees who started job between 1-JAN-2000 and 3-SEP-2007 from the hr database
select first_name, last_name from employees where hire_date BETWEEN '1-JAN-2000 ' AND '3-SEP-2007';
--6. Display country_id, country name, region id, region name from hr database
SELECT country_id, country_name,c.region_id,region_name FROM countries c JOIN regions r ON c.region_id = r.region_id;
--7. Display All cities, country names from hr database
select city, country_name from countries c join locations l on c.country_id = l.country_id;
--8. display the first name, last name, department number, and department name,  for all employees for departments 80 or 40.
select first_name, last_name, e.department_id,department_name from employees e join departments d on e.department_id = d.department_id where d.department_id in(80,40);
--9. Display employees' first name, Lastname department id and all departments including those where do not have any employee.
select first_name, last_name, d.department_id from employees e right outer join departments d on e.department_id = d.department_id;
--10. Display the first name, last name, department number, and name, for all employees who have or have not any department
select first_name, last_name,e.department_id,department_name from employees e left join departments d on e.department_id = d.department_id;
--11. Display all employee and their manager's names
select e1.first_name||' '||e1.last_name as employee_name, e2.first_name||' '||e2.last_name as manager_name
from employees e1 left join employees e2 on e1.manager_id = e2.employee_id;
