-- STEP 1: Drop if exists
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE accounts CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE employees CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN NULL;
END;
/

-- STEP 2: Create tables
CREATE TABLE accounts (
  account_id NUMBER PRIMARY KEY,
  customer_name VARCHAR2(100),
  balance NUMBER,
  account_type VARCHAR2(20)
);

CREATE TABLE employees (
  emp_id NUMBER PRIMARY KEY,
  name VARCHAR2(100),
  department VARCHAR2(50),
  salary NUMBER
);

-- STEP 3: Insert data
INSERT INTO accounts VALUES (1, 'Alice', 10000, 'savings');
INSERT INTO accounts VALUES (2, 'Bob', 5000, 'savings');
INSERT INTO accounts VALUES (3, 'Charlie', 7000, 'checking');

INSERT INTO employees VALUES (101, 'John', 'HR', 40000);
INSERT INTO employees VALUES (102, 'Jane', 'IT', 45000);
INSERT INTO employees VALUES (103, 'Doe', 'IT', 42000);

COMMIT;

-- SCENARIO 1: ProcessMonthlyInterest
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  FOR rec IN (SELECT account_id, customer_name, balance FROM accounts WHERE account_type = 'savings') LOOP
    DBMS_OUTPUT.PUT_LINE('Before Interest - Account ' || rec.account_id || ' (' || rec.customer_name || '): ' || rec.balance);
  END LOOP;

  UPDATE accounts
  SET balance = balance + (balance * 0.01)
  WHERE account_type = 'savings';

  DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all savings accounts.');

  FOR rec IN (SELECT account_id, customer_name, balance FROM accounts WHERE account_type = 'savings') LOOP
    DBMS_OUTPUT.PUT_LINE('After Interest - Account ' || rec.account_id || ' (' || rec.customer_name || '): ' || rec.balance);
  END LOOP;

  COMMIT;
END;
/

-- SCENARIO 2: UpdateEmployeeBonus
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  dept IN VARCHAR2,
  bonus_percent IN NUMBER
) IS
BEGIN
  FOR rec IN (SELECT emp_id, name, salary FROM employees WHERE department = dept) LOOP
    DBMS_OUTPUT.PUT_LINE('Before Bonus - ' || rec.name || ': ' || rec.salary);
  END LOOP;

  UPDATE employees
  SET salary = salary + (salary * bonus_percent / 100)
  WHERE department = dept;

  DBMS_OUTPUT.PUT_LINE('Bonus of ' || bonus_percent || '% applied to ' || dept || ' department.');

  FOR rec IN (SELECT emp_id, name, salary FROM employees WHERE department = dept) LOOP
    DBMS_OUTPUT.PUT_LINE('After Bonus - ' || rec.name || ': ' || rec.salary);
  END LOOP;

  COMMIT;
END;
/

-- SCENARIO 3: TransferFunds
CREATE OR REPLACE PROCEDURE TransferFunds(
  from_account_id IN NUMBER,
  to_account_id IN NUMBER,
  amount IN NUMBER
) IS
  from_balance NUMBER;
  to_balance NUMBER;
BEGIN
  SELECT balance INTO from_balance FROM accounts WHERE account_id = from_account_id;
  SELECT balance INTO to_balance FROM accounts WHERE account_id = to_account_id;

  DBMS_OUTPUT.PUT_LINE('Before Transfer - From Account ' || from_account_id || ': ' || from_balance);
  DBMS_OUTPUT.PUT_LINE('Before Transfer - To Account ' || to_account_id || ': ' || to_balance);

  IF from_balance < amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
  END IF;

  UPDATE accounts SET balance = balance - amount WHERE account_id = from_account_id;
  UPDATE accounts SET balance = balance + amount WHERE account_id = to_account_id;

  SELECT balance INTO from_balance FROM accounts WHERE account_id = from_account_id;
  SELECT balance INTO to_balance FROM accounts WHERE account_id = to_account_id;

  DBMS_OUTPUT.PUT_LINE(amount || ' transferred from Account ' || from_account_id || ' to Account ' || to_account_id);
  DBMS_OUTPUT.PUT_LINE('After Transfer - From Account ' || from_account_id || ': ' || from_balance);
  DBMS_OUTPUT.PUT_LINE('After Transfer - To Account ' || to_account_id || ': ' || to_balance);

  COMMIT;
END;
/

-- ENABLE OUTPUT
SET SERVEROUTPUT ON;

-- SCENARIO 1 EXECUTION
BEGIN
  ProcessMonthlyInterest;
END;
/

-- SCENARIO 2 EXECUTION
BEGIN
  UpdateEmployeeBonus('IT', 10);
END;
/

-- SCENARIO 3 EXECUTION
BEGIN
  TransferFunds(1, 3, 2000);
END;
/
