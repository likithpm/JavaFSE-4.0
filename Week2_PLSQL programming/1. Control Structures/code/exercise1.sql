-- STEP 1: Create required tables
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE loans CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE customers CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE customers (
  customer_id NUMBER PRIMARY KEY,
  name VARCHAR2(100),
  age NUMBER,
  interest_rate NUMBER,
  balance NUMBER,
  isvip VARCHAR2(5)
);

CREATE TABLE loans (
  loan_id NUMBER PRIMARY KEY,
  customer_id NUMBER REFERENCES customers(customer_id),
  due_date DATE
);

-- STEP 2: Insert sample data
INSERT INTO customers VALUES (1, 'Alice', 65, 5.5, 12000, 'FALSE');
INSERT INTO customers VALUES (2, 'Bob', 45, 6.2, 8000, 'FALSE');
INSERT INTO customers VALUES (3, 'Charlie', 70, 7.0, 15000, 'FALSE');

INSERT INTO loans VALUES (101, 1, SYSDATE + 10);
INSERT INTO loans VALUES (102, 2, SYSDATE + 40);
INSERT INTO loans VALUES (103, 3, SYSDATE + 5);

COMMIT;

-- SCENARIO 1: Apply 1% discount to interest rate if age > 60
BEGIN
  FOR rec IN (SELECT * FROM customers WHERE age > 60) LOOP
    UPDATE customers
    SET interest_rate = interest_rate - 1
    WHERE customer_id = rec.customer_id;
  END LOOP;
  COMMIT;
END;
/

-- SCENARIO 2: Set VIP flag if balance > 10000
BEGIN
  FOR rec IN (SELECT * FROM customers WHERE balance > 10000) LOOP
    UPDATE customers
    SET isvip = 'TRUE'
    WHERE customer_id = rec.customer_id;
  END LOOP;
  COMMIT;
END;
/

-- SCENARIO 3: Print reminders for loans due in next 30 days
SET SERVEROUTPUT ON;
BEGIN
  FOR rec IN (
    SELECT c.name, l.due_date
    FROM customers c
    JOIN loans l ON c.customer_id = l.customer_id
    WHERE l.due_date <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: ' || rec.name || ', your loan is due on ' || TO_CHAR(rec.due_date, 'DD-Mon-YYYY'));
  END LOOP;
END;
/
