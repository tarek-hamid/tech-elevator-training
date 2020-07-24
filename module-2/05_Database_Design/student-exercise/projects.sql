BEGIN TRANSACTION;

CREATE TABLE department
(
	department_number serial,
	department_name varchar(64) not null,

	constraint pk_department primary key (department_number)
);

CREATE TABLE project
(
	project_number serial,
	project_name varchar(64) not null,
	start_date varchar(64) not null,

	constraint pk_project primary key (project_number)
);

CREATE TABLE employee
(
	employee_ID serial,
	job_title varchar(64) not null,
	last_name varchar(64) not null,
	first_name varchar(64) not null,
	gender varchar(64) not null,
	date_of_birth varchar(64) not null,
	date_of_hire varchar(64) not null,
	
	department_number serial,
	project_number serial,

	constraint pk_customers primary key (employee_ID),
	constraint fk_employee_department foreign key(department_number) references department (department_number),
	constraint fk_employee_project foreign key(project_number) references project(project_number)
);

COMMIT TRANSACTION;

INSERT INTO department(department_name)
VALUES
('Engineering'),
('IT'),
('Marketing'),

INSERT INTO project(project_name, start_date)
VALUES
('Polaris', '01 OCT 2020'),
('Jupiter', '01 JUL 2020'),
('Colgate', '01 JAN 2020'),
('Aurora', '01 FEB 2020');

INSERT INTO employee(job_title, last_name, first_name,
	gender,	date_of_birth, date_of_hire, department_number, project_number)
VALUES
('Electrical Engineer', 'James', 'Lebron', 'M', '02 MAR 1986', '13 JUN 2010', 1, 1),
('Mechanical Engineer', 'Caruso', 'Anthony', 'M', '12 MAR 1988', '23 DEC 2015', 1, 2),
('Project Manager', 'Davis', 'Anthony', 'M', '27 FEB 1990', '21 OCT 2015', 2, 1),
('Software Engineer', 'Bryant', 'Kobe', 'M', '22 SEP 1982', '11 NOV 2003', 2, 3),
('Marketing Manager', 'Gasol', 'Pau', 'M', '25 OCT 1989', '18 JAN 2014', 3, 4),
('Marketing Associate', 'Artest', 'Ron', 'M', '1 JUL 1994', '14 MAY 2018', 3, 4),
('HR Associate', 'Odom', 'Lamar', 'M', '20 DEC 1980', '11 AUG 2011', 1, 1),
('Research Scientist', 'Jackson', 'Phil', 'M', '17 APR 1986', '22 JAN 2019', 2, 4);
