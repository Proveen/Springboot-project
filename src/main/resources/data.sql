-- Inserting data into the SALARY table
INSERT INTO SALARY (SALARY_AMOUNT, CURRENCY, TAX_AMOUNT, BONUS_AMOUNT) VALUES
(60000.00, 'USD', 5000.00, 2000.00),
(80000.00, 'EUR', 6000.00, 2500.00),
(70000.00, 'GBP', 4500.00, 1800.00),
(90000.00, 'USD', 7000.00, 3000.00),
(75000.00, 'JPY', 5500.00, 2200.00);


-- Inserting data into the EMPLOYEE table
INSERT INTO EMPLOYEE (EMPLOYEE_NAME, EMPLOYEE_POSITION, EMAIL, JOIN_DATE, SALARY_ID) VALUES
('John Stewart', 'Developer', 'john.stewart@example.com', '2022-01-01', 1),
('Jane Doe', 'Manager', 'jane.doe@example.com', '2022-02-01', 2),
('Joe Bloggs', 'Analyst', 'joe.bloggs@example.com', '2022-03-01', 3),
('Mary Bloggs', 'Designer', 'mary.bloggs@example.com', '2022-04-01', 4),
('Alice Johnson', 'Engineer', 'alice.johnson@example.com', '2022-05-01', 5);