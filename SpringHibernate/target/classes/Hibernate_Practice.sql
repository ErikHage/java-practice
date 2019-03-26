DROP TABLE employee CASCADE CONSTRAINTS;
DROP SEQUENCE emp_id_seq;

CREATE TABLE employee (
    employee_id NUMBER NOT NULL, 
    name VARCHAR(50) NOT NULL,
    joining_date DATE NOT NULL,
    salary NUMBER NOT NULL,
    ssn VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY (employee_id)
);

CREATE SEQUENCE emp_id_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
 
 select * from employee;